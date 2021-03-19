package com.anand.playlist.repository;

import com.anand.playlist.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo  extends JpaRepository<Song,Long> {


}
