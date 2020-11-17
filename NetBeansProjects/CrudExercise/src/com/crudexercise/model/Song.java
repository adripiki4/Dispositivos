/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudexercise.model;

/**
 *
 * @author adriba
 */
public class Song {
    private int Id_song;
    private String Name;
    private String Artist;
    private String Album;
    private String Genre;

    public Song(int Id_song, String Name, String Artist, String Album, String Genre) {
        this.Id_song = Id_song;
        this.Name = Name;
        this.Artist = Artist;
        this.Album = Album;
        this.Genre = Genre;
    }

    public Song() {
    }

    public Song(int Id_song) {
        this.Id_song = Id_song;
    }

    public int getId_song() {
        return Id_song;
    }

    public void setId_song(int Id_song) {
        this.Id_song = Id_song;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String Artist) {
        this.Artist = Artist;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String Album) {
        this.Album = Album;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    @Override
    public String toString() {
        return "Song{" + "Id_song=" + Id_song + ", Name=" + Name + ", Artist=" + Artist + ", Album=" + Album + ", Genre=" + Genre + '}';
    }
    
    
}
