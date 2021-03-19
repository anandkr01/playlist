package com.anand.playlist.dto;

public class SongDto {

    private Long playlistid;
    private String name;
    private String singer;


    public SongDto(Long playlistid, String name, String singer) {
        this.playlistid = playlistid;
        this.name = name;
        this.singer = singer;
    }

    public SongDto() {
    }

    public Long getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(Long playlistid) {
        this.playlistid = playlistid;
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
}
