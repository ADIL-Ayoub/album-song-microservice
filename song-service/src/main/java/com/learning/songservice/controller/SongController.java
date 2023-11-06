package com.learning.songservice.controller;

import com.learning.songservice.model.Song;
import com.learning.songservice.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/songs")
@RequiredArgsConstructor
public class SongController {
    private final SongService songService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Song song){
        songService.save(song);
    }

    @GetMapping
    public ResponseEntity<?> getAllSongs(){
        return new ResponseEntity<>(songService.getAll(),HttpStatus.OK );
    }

    @GetMapping("/album/{albumId}")
    public List<Song> getAllSongsByAlbumId(@PathVariable Integer albumId){
        List<Song> songs=songService.getSongsByAlbumId(albumId);

        return songs;
    }

}
