package com.learning.albumservice.model;


import com.learning.albumservice.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlbumWithSongs {

    private String name;
    private Long views;
    private Image image;
    private List<Song> songs;
}
