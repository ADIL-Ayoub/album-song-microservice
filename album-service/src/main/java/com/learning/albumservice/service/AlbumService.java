package com.learning.albumservice.service;


import com.learning.albumservice.model.Album;
import com.learning.albumservice.model.AlbumWithSongs;

import java.util.List;

public interface AlbumService {

    void save(Album song);
    List<Album> getAll();

    AlbumWithSongs getAlbumWithSongs(Integer albumId);
}
