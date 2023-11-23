package com.learning.albumservice.repository;

import com.learning.albumservice.model.MyImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<MyImage,Integer> {
}
