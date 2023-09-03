package com.project.store.repositories;


import com.project.store.entities.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository <CartEntity, Integer>{

    List<CartEntity> findAllByUser_Username(String username);
    CartEntity findByBikeIdAndUserId(Integer bikeId, Integer userId);

}
