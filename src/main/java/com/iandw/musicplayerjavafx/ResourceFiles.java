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
     *                      APPLICATION DATA AND SETTINGS FILES
     *
     */
    private static final String userLocalAppDataFolder = System.getenv("LOCALAPPDATA");
    private static final File mpTeaPlayerFolder = new File(userLocalAppDataFolder + File.separator + "mpTeaPlayer");
    private static final File appFolder = new File(Utils.getExeDirPath() + File.separator + "app");
    private static final File dataFolder = new File(mpTeaPlayerFolder + File.separator + "data");
    private static final File imagesFolder = new File(appFolder + File.separator + "images");
    private static final File settingsFile = new File(mpTeaPlayerFolder, "settings.json");
    private static final File artistListFile = new File(dataFolder, "artistlist.ser");
    private static final File tracklistFile = new File(dataFolder, "tracklist.ser");
    private static final File playlistsFile = new File(dataFolder, "playlists.ser");
    private static final File consolelogFile = new File(mpTeaPlayerFolder, "consolelog.txt");

    /**
     *                      ICON FILES
     */

    private static final File autoplayIconFile = new File(imagesFolder, "autoplay.png");
    private static final File shuffleIconFile = new File(imagesFolder, "shuffle.png");
    private static final File repeatIconFile = new File(imagesFolder, "repeat.png");
    private static final File skipforwardsIconFile = new File(imagesFolder, "skipforwards.png");
    private static final File skipbackwardsIconFile = new File(imagesFolder, "skipbackwards.png");
    private static final File playIconFile = new File(imagesFolder, "play.png");
    private static final File pauseIconFile = new File(imagesFolder, "pause.png");
    private static final File stopIconFile = new File(imagesFolder, "stop.png");
    private static final File volumeUpFile = new File(imagesFolder, "volumeup.png");
    private static final File volumeDownFile = new File(imagesFolder, "volumedown.png");
    private static final File volumeOffFile = new File(imagesFolder, "volumeoff.png");
    private static final File volumeMuteFile = new File(imagesFolder, "volumemute.png");
    private static final File personFile = new File(imagesFolder, "person.png");
    private static final File discFile = new File(imagesFolder, "disc.png");
    private static final File notesFile = new File(imagesFolder, "notes.png");


    /**
     *                      DEFAULT ALBUM ART FILES
     */

    private static final File musicnoteslightFile = new File(imagesFolder, "musicnotes-light.png");

    private static final File musicnotesdarkFile = new File(imagesFolder, "musicnotes-dark.png");

    private static final File musicnotesgreenFile = new File(imagesFolder, "musicnotes-green.png");

    private static final File musicnotesblueFile = new File(imagesFolder, "musicnotes-blue.png");

    private static final File musicnotesredFile = new File(imagesFolder, "musicnotes-red.png");

    private static final File musicnotespinkFile = new File(imagesFolder,"musicnotes-pink.png");

    private static final File musicnotesconsoleFile = new File(imagesFolder, "musicnotes-console.png");

    private static final File searchFile = new File(imagesFolder, "search.png");

    private static final File xFile = new File(imagesFolder, "x.png");

    private static final File teacupIconFile = new File(imagesFolder, "teacupicon.png");

    /**
     *
     *                      GETTERS
     *
     */

    public static File getDataFolder() { return dataFolder; }
    public static File getMpTeaPlayerFolder() { return mpTeaPlayerFolder; }
    public static File getSettingsFile() { return settingsFile; }
    public static File getArtistListFile() { return artistListFile; }
    public static File getTrackListFile() { return tracklistFile; }
    public static File getPlaylistsFile() { return playlistsFile; }
    public static File getConsolelogFile() { return consolelogFile; }

    // Icon Files
    public static File getAutoplayIconFile() { return autoplayIconFile; }
    public static File getShuffleIconFile() { return shuffleIconFile; }
    public static File getRepeatIconFile() { return repeatIconFile; }
    public static File getSkipforwardsIconFile() { return skipforwardsIconFile; }
    public static File getSkipbackwardsIconFile() { return skipbackwardsIconFile; }
    public static File getPlayIconFile() { return playIconFile; }
    public static File getPauseIconFile() { return pauseIconFile; }
    public static File getStopIconFile() { return stopIconFile; }
    public static File getVolumeUpFile() { return volumeUpFile; }
    public static File getVolumeDownFile() { return volumeDownFile; }
    public static File getVolumeOffFile() { return volumeOffFile; }
    public static File getVolumeMuteFile() { return volumeMuteFile; }
    public static File getPersonFile() { return personFile; }
    public static File getDiscFile() { return discFile; }
    public static File getNotesFile() { return notesFile; }
    public static File getSearchFile() { return searchFile; }
    public static File getxFile() { return xFile; }
    public static File getTeacupIconFile() { return teacupIconFile; }

    // Album Image Files
    public static File getMusicnotesLightFile() { return musicnoteslightFile; }
    public static File getMusicnotesDarkFile() { return musicnotesdarkFile; }
    public static File getMusicnotesGreenFile() { return musicnotesgreenFile; }
    public static File getMusicnotesBlueFile() { return musicnotesblueFile; }
    public static File getMusicnotesRedFile() { return musicnotesredFile; }
    public static File getMusicnotesPinkFile() { return musicnotespinkFile; }
    public static File getMusicnotesConsoleFile() { return musicnotesconsoleFile; }

}
