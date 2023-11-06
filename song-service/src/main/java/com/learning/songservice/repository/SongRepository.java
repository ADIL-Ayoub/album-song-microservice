package com.learning.songservice.repository;

import com.learning.songservice.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Integer> {
    List<Song> findAllByAlbumId(Integer albumId);
}