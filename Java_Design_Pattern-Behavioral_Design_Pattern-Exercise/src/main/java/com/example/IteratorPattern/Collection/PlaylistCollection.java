package com.example.IteratorPattern.Collection;

import com.example.IteratorPattern.Interface.Iterator;
import com.example.IteratorPattern.Song;
import com.example.IteratorPattern.SongIterator;

import java.util.ArrayList;
import java.util.List;

public class PlaylistCollection {
    private List<Song> songs;

    public PlaylistCollection() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public int size() {
        return songs.size();
    }

    public Song getSongAt(int index) {
        return songs.get(index);
    }

    public Iterator<Song> getIterator() {
        return new SongIterator(this);
    }
}
