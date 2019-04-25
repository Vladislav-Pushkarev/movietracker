package com.push.movietracker.service;

import com.push.movietracker.model.Image;
import com.push.movietracker.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public ImageRepository getImageRepository() {
        return imageRepository;
    }

    public void setImageRepository(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public void addImage(Image image){
        imageRepository.save(image);
    }

    @Override
    public Image getImage(int imageId) {
        return null;
    }

    @Override
    public void deleteImage(int imageId) {

    }

    @Override
    public List<Image> listOfImages() {
        return null;
    }
}
