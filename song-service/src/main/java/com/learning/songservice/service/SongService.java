package com.learning.songservice.service;

import com.learning.songservice.model.Song;

import java.util.List;

public interface SongService {

    void save(Song song);
    List<Song> getAll();

    List<Song> getSongsByAlbumId(Integer albumId);
}
