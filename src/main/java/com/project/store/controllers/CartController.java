package com.project.store.controllers;

import com.project.store.entities.BikeEntity;
import com.project.store.entities.CartEntity;
import com.project.store.entities.UserEntity;
import com.project.store.repositories.BikeRepository;
import com.project.store.repositories.CartRepository;
import com.project.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CartController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BikeRepository bikeRepository;

    public CartController() {
        System.out.println(this.getClass().getSimpleName() + " created");
    }


    public Optional<User> getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (null != auth && auth.getPrincipal() instanceof User) {
            User user = (User) auth.getPrincipal();
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @GetMapping("/get-cart")
    public ModelAndView getCart() {
        ModelAndView modelAndView = new ModelAndView("cart");
        Optional<User> user = getLoggedInUser();
        Integer totalCart = 0;
        if (user.isPresent()) {
            List<CartEntity> carts = cartRepository.findAllByUser_Username(user.get().getUsername());
            for (CartEntity cart:carts) {
                totalCart += cart.getTotal();
            }
            modelAndView.addObject("cart", cartRepository.findAllByUser_Username(user.get().getUsername()));
            modelAndView.addObject("total",totalCart);
        } else {
            modelAndView.addObject("cart", new ArrayList<>());
        }
        return modelAndView;
    }

    @GetMapping("/order")
    public ModelAndView orderPlaced(CartEntity cart) {
        ModelAndView modelAndView = new ModelAndView("redirect:/frontpage");
        Optional<User> user = getLoggedInUser();
        if (user.isPresent()) {
            List<CartEntity> carts = cartRepository.findAllByUser_Username(user.get().getUsername());
            if (!carts.isEmpty()) {
                for (CartEntity cartEntity : carts) {
                    Integer prodQuantityUntilOrder = bikeRepository.getById(cartEntity.getBikeId()).getQuantity();
                    BikeEntity product = bikeRepository.getById(cartEntity.getBikeId());
                    product.setQuantity(prodQuantityUntilOrder - cartEntity.getQuantity());
                    bikeRepository.save(product);
                    cartRepository.delete(cartEntity);
                }
            }
        }
        return modelAndView;
    }


    @GetMapping("/add-cart/{bikeId}")
    public ModelAndView addCart(@PathVariable("bikeId") Integer id, CartEntity cartEntity){
        ModelAndView modelAndView = new ModelAndView("redirect:/frontpage");
        Optional<User> user = getLoggedInUser();
        Integer quantity = 1;
        Integer total = 1;
        if(user.isPresent()){
            Integer userId = userRepository.findByUsername(user.get().getUsername()).getUserId();
            CartEntity dbCartEntity = cartRepository.findByBikeIdAndUserId(id, userId);
            if(dbCartEntity != null){
                int dbCartQuantity = dbCartEntity.getQuantity() + 1;
                dbCartEntity.setQuantity(dbCartQuantity);
                dbCartEntity.setTotal(dbCartQuantity * dbCartEntity.getBike().getPrice());
                cartRepository.save(dbCartEntity);
            }else{
                cartEntity.setQuantity(quantity);
                cartEntity.setBikeId(id);
                BikeEntity bikeEntity = bikeRepository.getById(id);
                cartEntity.setTotal(quantity * bikeEntity.getPrice());
                cartEntity.setUserId(userRepository.findByUsername(user.get().getUsername()).getUserId());
                cartRepository.save(cartEntity);
            }
        }
        return modelAndView;
    }

    @GetMapping("/delete-cart/{id}")
    public ModelAndView cartDelete(@PathVariable Integer id) {
        Optional<CartEntity> cartEntity = cartRepository.findById(id);
        if (cartEntity.isPresent()) {
            cartRepository.delete(cartEntity.get());
            ModelAndView modelAndView = new ModelAndView("redirect:/get-cart");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }

}