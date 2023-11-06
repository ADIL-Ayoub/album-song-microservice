package com.learning.albumservice.client;

import com.learning.albumservice.model.Song;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "song-service", url = "${application.config.song-url}")
public interface SongClient {

    @GetMapping("/album/{albumId}")
    public List<Song> getAllSongsByAlbumId(@PathVariable("albumId") Integer albumId);
}
