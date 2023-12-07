package com.learning.songservice.controller;

import com.learning.songservice.entity.Song;
import com.learning.songservice.service.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/songs")
@RequiredArgsConstructor
@Slf4j
public class SongController {
    private final SongService songService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Song song){
        songService.save(song);
    }

    /*@PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody List<Song> songs){
        songService.saveAll(songs);
    }*/
    @PostMapping("/all")
    public ResponseEntity<?> addSongs(@RequestParam("albumName") String albumName,@RequestParam("albumId") Integer albumId ,@RequestPart("songs") List<MultipartFile> songs) throws IOException {
        songService.saveAll(songs,albumId,albumName);
        log.info("[Song Controller] adding songs to the album : "+albumName+" ...");
        return new ResponseEntity<>("done", HttpStatus.OK );
    }

    @GetMapping
    public ResponseEntity<?> getAllSongs(){
        log.info("[Song Controller] getting all songs ...");
        return new ResponseEntity<>(songService.getAll(),HttpStatus.OK );
    }

    @GetMapping("/album/{albumId}")
    public List<Song> getAllSongsByAlbumId(@PathVariable Integer albumId){
        log.info("[Song Controller] getting all songs with albumId="+albumId+" ...");
        List<Song> songs=songService.getSongsByAlbumId(albumId);

        return songs;
    }
    @DeleteMapping("/album/{albumId}")
    public String deleteAllSongsByAlbumId(@PathVariable Integer albumId){
        log.info("[Song Controller] deleting songs with albumId="+albumId+" ...");
        songService.deleteSongsByAlbumId(albumId);

        return "Deleted seccussfully";
    }

}
