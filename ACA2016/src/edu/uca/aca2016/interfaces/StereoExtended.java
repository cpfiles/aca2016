package edu.uca.aca2016.interfaces;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author cpfiles
 */
public interface StereoExtended extends Stereo {

    /**
     * Loads a list of track names from the specified file.
     * 
     * The file is a plain text file that contains one track name per line. For
     * example:
     *  Song 1.mp3
     *  Song 2.mp3
     *  Song 4.mp3
     * 
     * @param trackListSource A file that contains a list of mp3 tracks. There
     * is one track per line.
     * @throws IOException Any IO exceptions are caught and re-thrown as this 
     * type of exception
     */
    public void loadTrackList(File trackListSource) throws IOException;

    /**
     * Restarts the playing process.
     */
    public void play();

    /**
     * Return a list of all the tracks that are loaded.
     * @return
     */
    public ArrayList<String> getTrackList();

    /**
     * Get the full file name of the current track
     * @return The current track's file name.
     */
    public String getCurrentTrackFileName();
}
