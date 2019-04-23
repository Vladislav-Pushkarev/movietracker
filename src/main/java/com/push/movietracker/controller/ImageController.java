package com.push.movietracker.controller;

import com.push.movietracker.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile){

        imageService.addImage(imageFile);
        return "redirect:/index";
    }

}
