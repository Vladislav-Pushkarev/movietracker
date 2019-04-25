package com.push.movietracker.controller;

import com.push.movietracker.model.Image;

import com.push.movietracker.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(method = RequestMethod.POST, value = "/addImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile multipartFile) throws IOException {
        Image image = new Image();
        image.setName(multipartFile.getOriginalFilename());
        image.setExtension(multipartFile.getContentType());
        image.setData(multipartFile.getBytes());

        imageService.addImage(image);
        return  "redirect:/movieList";
    }

}
