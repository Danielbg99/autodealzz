package com.project.autodealz.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {

    String uploadImage(MultipartFile multipartFile) throws IOException;

    String deleteImage(String imageId);
}
