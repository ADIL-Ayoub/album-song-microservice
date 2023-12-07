package com.learning.albumservice.service;


import com.learning.albumservice.entity.Album;
import com.learning.albumservice.model.AlbumWithSongs;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AlbumService {

    Album save(String name, Long views, MultipartFile file) throws IOException;
    List<Album> getAll();

    List<Album> getAllWithFilters(String filterName);

    AlbumWithSongs getAlbumWithSongs(Integer albumId);

    void delete(int id);
}
