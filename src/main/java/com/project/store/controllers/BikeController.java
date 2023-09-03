package com.project.store.controllers;

import com.project.store.entities.BikeEntity;
import com.project.store.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Controller
public class BikeController {

    public BikeController() {
        System.out.println(getClass().getSimpleName() + " created");

    }

    @Autowired
    private BikeRepository bikeRepository;

    @GetMapping("/frontpage")
    public ModelAndView getFromPage(String keyword) {
        ModelAndView modelAndView = new ModelAndView("frontpage");
        if(keyword != null) {
            modelAndView.addObject("bikeList", bikeRepository.findByKeyword(keyword));
        }else{
            modelAndView.addObject("bikeList", bikeRepository.findAll());
            return modelAndView;
        }
        return modelAndView;
    }

    @GetMapping("/men")
    public ModelAndView getMenBikes() {
        ModelAndView modelAndView = new ModelAndView("bikes");
        modelAndView.addObject("bikeList", bikeRepository.findByMenBikes("keyword"));
        return modelAndView;
    }

    @GetMapping("/ladies")
    public ModelAndView getLadiesBikes() {
        ModelAndView modelAndView = new ModelAndView("bikes");
        modelAndView.addObject("bikeList", bikeRepository.findByLadiesBikes("keyword"));
        return modelAndView;
    }

    @GetMapping("/children")
    public ModelAndView getChildrenBikes() {
        ModelAndView modelAndView = new ModelAndView("bikes");
        modelAndView.addObject("bikeList", bikeRepository.findByChildrenBikes("keyword"));
        return modelAndView;
    }

    @GetMapping("/electric")
    public ModelAndView getElectricBikes() {
        ModelAndView modelAndView = new ModelAndView("bikes");
        modelAndView.addObject("bikeList", bikeRepository.findByElectricBikes("keyword"));
        return modelAndView;
    }

    @GetMapping("/sport")
    public ModelAndView getSportBikes() {
        ModelAndView modelAndView = new ModelAndView("bikes");
        modelAndView.addObject("bikeList", bikeRepository.findBySportBikes("keyword"));
        return modelAndView;
    }


    @GetMapping("/bike/add")
    public ModelAndView bikeAdd(){
        ModelAndView modelAndView = new ModelAndView("bikeEdit");
        modelAndView.addObject("bike", new BikeEntity());
        return modelAndView;
    }

    @PostMapping(value="/bike/save", consumes = {"multipart/form-data"})
    public ModelAndView bikeSave(@ModelAttribute("bike") BikeEntity bikeEntity, @RequestParam("file") MultipartFile file) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/frontpage");
        String path1 = "target/classes/static/imagines";
        String path2 = "src/main/resources/static/imagines";
        String filename = file.getOriginalFilename();
        if(filename != null && !filename.isEmpty()){
            saveFile(path1, filename, file);
            saveFile(path2, filename, file);
            bikeEntity.setImagineUrl("/imagines/" + filename);
        }
        bikeRepository.save(bikeEntity);
        return modelAndView;
    }

    public void saveFile(String path, String fileName, MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(path);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new IOException(ex.getMessage());
        }
    }

   @GetMapping("/bike/view/{id}")
   public ModelAndView bikeView(@PathVariable Integer id){
      ModelAndView modelAndView = new ModelAndView("bikeView");
      modelAndView.addObject("bike", bikeRepository.getById(id));
      return modelAndView;
   }

   @GetMapping("/bike/edit/{id}")
   public ModelAndView bikeEdit(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("bikeEdit");
        modelAndView.addObject("bike", bikeRepository.getById(id));
        return modelAndView;
   }



   @GetMapping("/bike/delete/{id}")
   public ModelAndView bikeDelete(@PathVariable Integer id){
       Optional<BikeEntity> bikeEntity = bikeRepository.findById(id);
       if(bikeEntity.isPresent()){
           bikeRepository.delete(bikeEntity.get());
           ModelAndView modelAndView = new ModelAndView("redirect:/frontpage");
           return modelAndView;
       }
       ModelAndView modelAndView = new ModelAndView("error");
       return modelAndView;
   }


}