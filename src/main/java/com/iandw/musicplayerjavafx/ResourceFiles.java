/**
 *      Author: Ian Wallace copyright 2022 all rights reserved.
 *      Application: MusicPlayer
 *      Class: ResourceURLs.java
 *      Notes: Holds static String objects for quick file location anywhere in the Application
 */

package com.iandw.musicplayerjavafx;

import com.iandw.musicplayerjavafx.Utilities.Utils;

import java.io.File;

public class ResourceFiles {
    /**
     *
     *  Files from Application executable directory
     *
     */

    private static final File dataFolder = new File(Utils.getExeDirPath() + File.separator + "data");
    private static final File imagesFolder = new File(Utils.getExeDirPath() + File.separator + "images");
    private static final File settingsFile = new File(Utils.getExeDirPath(), "settings.json");
    private static final File artistListFile = new File(dataFolder, "artistlist.ser");
    private static final File tracklistFile = new File(dataFolder, "tracklist.ser");
    private static final File playlistsFile = new File(dataFolder, "playlists.ser");
    private static final File consolelogFile = new File(Utils.getExeDirPath(), "consolelog.txt");

//    private static final String autoplayiconURL = Objects.requireNonNull(App.class.getResource(
//                    "autoplay2.png")).toString().substring(10);


    /*
     *                      DEFAULT ALBUM ART FILES
     */

    private static final File musicnoteslightFile = new File(imagesFolder, "musicnotes-light");

    private static final File musicnotesdarkFile = new File(imagesFolder, "musicnotes-dark.png");

    private static final File musicnotesgreenFile = new File(imagesFolder, "musicnotes-green.png");

    private static final File musicnotesblueFile = new File(imagesFolder, "musicnotes-blue.png");

    private static final File musicnotesredFile = new File(imagesFolder, "musicnotes-red.png");

    private static final File musicnotespinkFile = new File(imagesFolder,"musicnotes-pink.png");

    private static final File musicnotesconsoleFile = new File(imagesFolder, "musicnotes-console.png");


    /**
     *
     *                      GETTERS
     *
     */

    public static File getSettingsFile() { return settingsFile; }
    public static File getArtistListFile() { return artistListFile; }
    public static File getTrackListFile() { return tracklistFile; }
    public static File getPlaylistsFile() { return playlistsFile; }
    public static File getConsolelogFile() { return consolelogFile; }
    // Image urls
//    public static String getAutoplayiconURL() { return autoplayiconURL; }
    public static File getMusicnotesLightFile() { return musicnoteslightFile; }
    public static File getMusicnotesDarkFile() { return musicnotesdarkFile; }
    public static File getMusicnotesGreenFile() { return musicnotesgreenFile; }
    public static File getMusicnotesBlueFile() { return musicnotesblueFile; }
    public static File getMusicnotesRedFile() { return musicnotesredFile; }
    public static File getMusicnotesPinkFile() { return musicnotespinkFile; }
    public static File getMusicnotesConsoleFile() { return musicnotesconsoleFile; }

}
