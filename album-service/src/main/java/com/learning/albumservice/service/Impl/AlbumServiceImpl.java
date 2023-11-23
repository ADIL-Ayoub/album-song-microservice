package com.learning.albumservice.service.Impl;

import com.learning.albumservice.client.SongClient;
import com.learning.albumservice.model.Album;
import com.learning.albumservice.model.AlbumWithSongs;
import com.learning.albumservice.repository.AlbumRepository;
import com.learning.albumservice.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final SongClient songClient;
    @Override
    public void save(Album song) {
        albumRepository.save(song);
    }

    @Override
    public List<Album> getAll() {
        return albumRepository.findAll();
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
                .songs(songs)
                .build();
        return albumWithSongs;
    }

    @Override
    public void delete(int id) {
        Album album= albumRepository.findById(id).orElse(null);
        if(album!=null){
            albumRepository.delete(album);
        }
    }
}
