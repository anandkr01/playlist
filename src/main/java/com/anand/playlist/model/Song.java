package com.anand.playlist.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String singer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    public Song(String name, String singer, Playlist playlists) {
        this.name = name;
        this.singer = singer;
        this.playlist = playlists;
    }

    public Song() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Playlist getPlaylist() {

        return playlist;
    }



    public void setPlaylist(Playlist playlist) {

        this.playlist = playlist;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(name, song.name) && Objects.equals(singer, song.singer) && Objects.equals(playlist, song.playlist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, singer, playlist);
    }
}
