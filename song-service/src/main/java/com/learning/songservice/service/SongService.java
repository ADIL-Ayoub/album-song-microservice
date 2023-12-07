package com.learning.songservice.service;

import com.learning.songservice.entity.Song;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SongService {

    void save(Song song);
    void saveAll(List<MultipartFile> songs,Integer albumId,String albumName) throws IOException;
    List<Song> getAll();

    List<Song> getSongsByAlbumId(Integer albumId);
    void deleteSongsByAlbumId(Integer albumId);
}
