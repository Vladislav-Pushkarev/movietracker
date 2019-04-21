package com.push.movietracker.service;

import com.push.movietracker.model.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImageService {
    void addImage(Image image);

    Image getImage(int imageId);

    void deleteImage(int imageId);

    List<Image> listOfImages();

}
