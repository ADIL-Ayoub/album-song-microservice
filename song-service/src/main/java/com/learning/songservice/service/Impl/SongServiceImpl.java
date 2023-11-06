package com.learning.songservice.service.Impl;

import com.learning.songservice.model.Song;
import com.learning.songservice.repository.SongRepository;
import com.learning.songservice.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public List<Song> getAll() {
        return songRepository.findAll();
    }

    @Override
    public List<Song> getSongsByAlbumId(Integer albumId) {
        return songRepository.findAllByAlbumId(albumId);
    }
}
