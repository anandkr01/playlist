package com.anand.playlist.services;

import com.anand.playlist.model.Playlist;
import com.anand.playlist.model.Song;
import com.anand.playlist.repository.PlayListRepo;
import com.anand.playlist.repository.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayservicesImpl implements PlayListService{
    @Autowired
    private PlayListRepo playListRepo;
    @Autowired
    private SongRepo songRepo;

    @Override
    public Boolean  addPlayList(Playlist playlist) {
        playListRepo.save(playlist);
        return true;

    }

    @Override
    public void deletePlayList(Long id) {

        Playlist playlist=playListRepo.getOne(id);

        playListRepo.delete(playlist);


    }

    @Override
    public List<Playlist> showPlayList() {
        return playListRepo.findAll();


    }

    @Override
    public Playlist findplaylistById(Long id) {
        return playListRepo.getOne(id);
    }

    @Override
    public Playlist updateplaylist(Playlist playlist) {

        return playListRepo.save(playlist);
    }

    @Override
    public void deleteSong(Long id) {

        Song song=songRepo.getOne(id);

        songRepo.delete(song);


    }




}
