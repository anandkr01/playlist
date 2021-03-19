package com.anand.playlist.repository;

import com.anand.playlist.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListRepo extends JpaRepository<Playlist,Long> {

}
