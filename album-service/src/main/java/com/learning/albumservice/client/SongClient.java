package com.learning.albumservice.client;

import com.learning.albumservice.model.Song;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "SONG-SERVICE")
public interface SongClient {
    @GetMapping("/api/v1/songs/album/{albumId}")
    @CircuitBreaker(name="song-client",fallbackMethod = "defaultgetAllSongsByAlbumId")
    public List<Song> getAllSongsByAlbumId(@PathVariable("albumId") Integer albumId);

    default List<Song> defaultgetAllSongsByAlbumId(Exception exception){
        return List.of();
    }

}
