package com.push.movietracker.service;

import com.push.movietracker.model.Image;
import com.push.movietracker.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    ImageRepository imageRepository;

    @Override
    public void addImage(MultipartFile image){
        try {
            String name =  image.getOriginalFilename();
            String extension = image.getContentType();
            byte[] data = image.getBytes();

            Image imageToSave = new Image(name,extension,data);
            imageRepository.save(imageToSave);
        }
        catch (IOException e){
            e.printStackTrace();
        }
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
