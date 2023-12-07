package com.learning.albumservice.repository;

import com.learning.albumservice.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {


        List<Album> findByNameContainingIgnoreCase(String name);
}
