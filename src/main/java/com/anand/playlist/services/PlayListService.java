package com.anand.playlist.services;

import com.anand.playlist.model.Playlist;
import com.anand.playlist.model.Song;

import java.util.List;

public interface PlayListService {

    public Boolean addPlayList(Playlist playlist);

    public void deletePlayList(Long id);

    public List<Playlist>  showPlayList();

    public Playlist findplaylistById(Long id);

    public Playlist updateplaylist(Playlist playlist);

    public void deletesong(Long id);


}
