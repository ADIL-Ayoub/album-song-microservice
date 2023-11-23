package com.learning.albumservice.controller;

import com.learning.albumservice.model.Album;
import com.learning.albumservice.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/albums")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Album album){
        albumService.save(album);
    }

    @GetMapping
    public ResponseEntity<?> getAllAlbums(){
        return new ResponseEntity<>(albumService.getAll(),HttpStatus.OK );
    }

    @GetMapping("/with-songs/{album-id}")
    public ResponseEntity<?> getAllAlbums(@PathVariable("album-id") Integer albumId){
        return new ResponseEntity<>(albumService.getAlbumWithSongs(albumId),HttpStatus.OK );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void delete(@PathVariable("id") int id){
        albumService.delete(id);
    }

}
