package com.anand.playlist.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(unique = true)
    private String name;


   @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
   @JoinColumn(name = "playlist_id", referencedColumnName = "id")
    private List<Song> songs = new ArrayList<>();

    public Playlist(){

    }

    public Playlist(String name) {
        this.name = name;
    }

    public Playlist(String name, List<Song> songs) {
        this.name = name;
        this.songs = songs;
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(id, playlist.id) && Objects.equals(name, playlist.name) && Objects.equals(songs, playlist.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, songs);
    }
}
