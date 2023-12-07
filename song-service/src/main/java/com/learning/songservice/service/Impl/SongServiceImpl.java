package com.learning.songservice.service.Impl;

import com.learning.songservice.entity.Song;
import com.learning.songservice.repository.SongRepository;
import com.learning.songservice.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final String FOLDER_PATH="E:\\Projects\\Angular\\album-song-front-end\\src\\assets\\music\\";
    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void saveAll(List<MultipartFile> songs, Integer albumId, String albumName) throws IOException {
        for(MultipartFile file:songs){
            String songPath=FOLDER_PATH+albumName+"\\"+file.getOriginalFilename();
            Song song= songRepository.save(Song.builder()
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .path(songPath)
                    .albumId(albumId)
                    .views(0L)
                    .build());

            if(song!=null){
                Path path= Paths.get(songPath);
                if(!Files.exists(path)){
                    Files.createDirectories(path);
                }
                file.transferTo(new File(songPath));
            }
        }
    }


    @Override
    public List<Song> getAll() {
        return songRepository.findAll();
    }

    @Override
    public List<Song> getSongsByAlbumId(Integer albumId) {
        return songRepository.findAllByAlbumId(albumId);
    }

    @Override
    public void deleteSongsByAlbumId(Integer albumId) {
        List<Song> songs= songRepository.findAllByAlbumId(albumId);
        if(songs!=null){
            for(Song song:songs){
                songRepository.deleteById(song.getId());
            }
        }

    }
}
