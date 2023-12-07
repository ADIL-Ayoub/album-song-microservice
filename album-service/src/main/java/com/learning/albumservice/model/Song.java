package com.learning.albumservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Song {
    private String name;
    private Long views;
    private String duration;
    private String type;
    private String path;
}
