package com.anand.playlist.controller;

import com.anand.playlist.dto.SongDto;
import com.anand.playlist.model.Playlist;
import com.anand.playlist.model.Song;
import com.anand.playlist.services.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;


@Controller()
public class HomeController {
    @Autowired
    private PlayListService playListService;


    @GetMapping("/")
    public String homeController(Model model){

        model.addAttribute("playlists",playListService.showPlayList());

        return "home";

    }


    @GetMapping("/addplaylist")
    public String Addplaylistform(Model model){
        Playlist playlist= new Playlist();
        model.addAttribute("playlist",playlist);
        return "addplaylist";

    }
    @PostMapping("playlistadd")
    public String playlistAdd(@ModelAttribute("playlist") Playlist playlist){

        playListService.addPlayList(playlist);

        return "redirect:/";
    }

   @GetMapping("/addsongform/{id}")
    public String songAddform(@PathVariable(value = "id") Long id,Model model){

        SongDto songDto = new SongDto();

        songDto.setPlaylistid(id);

        model.addAttribute("songdto",songDto);

        return "addsong";

   }
   @PostMapping("/addsong")
   public String addsong(@ModelAttribute("songdto") SongDto songDto){


      Long playlistid= songDto.getPlaylistid();
      Song song= new Song();
      song.setName(songDto.getName());
      song.setSinger(songDto.getSinger());


      Playlist playlist=playListService.findplaylistById(playlistid);

       List<Song> snglst= playlist.getSongs();

       snglst.add(song);
        playlist.setSongs(snglst);

       playListService.updateplaylist(playlist);

        return "redirect:/";
   }

   @GetMapping("/deletesong/{id}")
   public String deletesong(@PathVariable(name = "id") Long id){

        playListService.deleteSong(id);

        return "redirect:/";
   }


    @GetMapping("/deleteplaylist/{id}")
   public String deletePlayList(@PathVariable(name = "id") Long id){

        playListService.deletePlayList(id);

        return "redirect:/";
   }

   @GetMapping("/reload")
    public String reload(Model model){

       model.addAttribute("playlists",playListService.showPlayList());

       return "redirect:/";
    }



}
