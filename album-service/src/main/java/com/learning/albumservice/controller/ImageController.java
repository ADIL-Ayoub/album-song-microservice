package com.learning.albumservice.controller;

import com.learning.albumservice.model.MyImage;
import com.learning.albumservice.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageRepository imageRepository;

    @PostMapping
    public ResponseEntity<?> addImage(@RequestParam("file") MultipartFile file) throws IOException {
        MyImage image= MyImage.builder()
                .file(file.getBytes())
                .build();

        return new ResponseEntity<>(imageRepository.save(image), HttpStatus.OK );
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getImage(@PathVariable int id){

        return new ResponseEntity<>(imageRepository.findById(id), HttpStatus.OK );
    }
}
