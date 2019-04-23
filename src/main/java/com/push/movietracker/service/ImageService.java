package com.push.movietracker.service;

import com.push.movietracker.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    void addImage(MultipartFile image);

    Image getImage(int imageId);

    void deleteImage(int imageId);

    List<Image> listOfImages();

}
