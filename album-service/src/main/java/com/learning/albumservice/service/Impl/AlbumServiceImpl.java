package com.learning.albumservice.service.Impl;

import com.learning.albumservice.client.SongClient;
import com.learning.albumservice.entity.Album;
import com.learning.albumservice.model.AlbumWithSongs;
import com.learning.albumservice.entity.Image;
import com.learning.albumservice.repository.AlbumRepository;
import com.learning.albumservice.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final SongClient songClient;

    @Override
    public Album save(String name, Long views, MultipartFile file) throws IOException {
        Image image= Image.builder()
                .fileName(file.getName())
                .type(file.getContentType())
                .imageBytes(file.getBytes())
                .build();

        Album album= Album.builder()
                .name(name)
                .views(views)
                .image(image)
                .build();
        return albumRepository.save(album);

    }

    @Override
    public List<Album> getAll() {
        return albumRepository.findAll();
    }

    @Override
    public List<Album> getAllWithFilters(String filterName) {
        return albumRepository.findByNameContainingIgnoreCase(filterName);
    }

    @Override
    public AlbumWithSongs getAlbumWithSongs(Integer albumId) {
        var songs=songClient.getAllSongsByAlbumId(albumId);
        Album album=albumRepository.findById(albumId).orElse(Album.builder()
                        .name("NOT_FOUND")
                        .build());
        AlbumWithSongs albumWithSongs = AlbumWithSongs.builder()
                .name(album.getName())
                .views(album.getViews())
                .image(album.getImage())
                .songs(songs)
                .build();
        return albumWithSongs;
    }

    @Override
    public void delete(int id) {
        Album album= albumRepository.findById(id).orElse(null);
        if(album!=null){
            Integer albumId=id;
            String result=songClient.deleteAllSongsByAlbumId(albumId);
            albumRepository.delete(album);
            System.out.println(result);
        }

    }
}
