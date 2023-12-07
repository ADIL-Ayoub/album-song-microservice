package com.learning.albumservice.controller;

import com.learning.albumservice.service.AlbumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/albums")
@RequiredArgsConstructor
@RefreshScope
@Slf4j
public class AlbumController {
    private final AlbumService albumService;

    /*@PostMapping
    public ResponseEntity<?> save(@RequestBody  Album album){
        return ResponseEntity.ok(albumService.save(album));
    }*/

    @PostMapping
    public ResponseEntity<?> save(@RequestParam("name") String name,
                                  @RequestParam("views") Long views,
                                  @RequestParam("image")MultipartFile file
                                  ) throws IOException {

        log.info("[Album Controller] : Saving album with name= "+name+" ...");
        return ResponseEntity.ok(albumService.save(name,views,file));
    }

    @GetMapping
    public ResponseEntity<?> getAllAlbums(){
        log.info("[Album Controller] : Getting all albums ...");
        return new ResponseEntity<>(albumService.getAll(),HttpStatus.OK );
    }

    @GetMapping("/filter")
    public ResponseEntity<?> getAllAlbums(@RequestParam(name = "filterName", required = false) String filterName){
        log.info("[Album Controller] : Getting albums with filter="+filterName+" in their names ...");
        return new ResponseEntity<>(albumService.getAllWithFilters(filterName),HttpStatus.OK );
    }

    @GetMapping("/with-songs/{album-id}")
    public ResponseEntity<?> getalbumWithSongs(@PathVariable("album-id") Integer albumId){
        log.info("[Album Controller] : Getting album with albumId="+albumId+" and all its songs ...");
        return new ResponseEntity<>(albumService.getAlbumWithSongs(albumId),HttpStatus.OK );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void delete(@PathVariable("id") int id){
        log.info("[Album Controller] Deleting album with albumId="+id+" ...");
        albumService.delete(id);

    }

}
