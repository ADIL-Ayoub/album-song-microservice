package com.learning.albumservice.controller;

import com.learning.albumservice.entity.Image;
import com.learning.albumservice.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
@RefreshScope
public class ImageController {

    private final ImageRepository imageRepository;

    @PostMapping
    public ResponseEntity<?> addImage(@RequestParam("image") MultipartFile file) throws IOException {
        Image image= Image.builder()
                .fileName(file.getName())
                .type(file.getContentType())
                .imageBytes(file.getBytes())
                .build();

        return new ResponseEntity<>(imageRepository.save(image), HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getImage(@PathVariable int id){
        Image image= imageRepository.findById(id).get();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(image.getType()))
                .body(image.getImageBytes());
    }
}
