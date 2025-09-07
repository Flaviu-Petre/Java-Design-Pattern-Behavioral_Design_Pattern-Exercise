package com.example.IteratorPattern;

import com.example.IteratorPattern.Collection.PlaylistCollection;
import com.example.IteratorPattern.Interface.Iterator;

import java.util.NoSuchElementException;

public class SongIterator implements Iterator<Song> {
    private PlaylistCollection playlist;
    private int position = 0;

    public SongIterator(PlaylistCollection playlist) {
        this.playlist = playlist;
    }

    @Override
    public boolean hasNext() {
        return position < playlist.size();
    }

    @Override
    public Song next() {
        if (hasNext()) {
            Song song = playlist.getSongAt(position);
            position++;
            return song;
        } else {
            throw new NoSuchElementException("No more songs in the playlist");
        }
    }

    public void reset() {
        position = 0;
    }
}
