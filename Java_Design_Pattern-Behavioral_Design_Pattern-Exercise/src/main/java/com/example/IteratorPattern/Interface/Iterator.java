package com.example.IteratorPattern.Interface;

import com.example.IteratorPattern.Song;

public interface Iterator<Song> {
    boolean hasNext();
    Song next();
}
