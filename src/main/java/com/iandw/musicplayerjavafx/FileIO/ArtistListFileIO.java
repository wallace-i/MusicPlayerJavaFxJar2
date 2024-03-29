/**
 *      Author: Ian Wallace, copyright 2022 all rights reserved.
 *      Application: MusicPlayer
 *      Class: ArtistListFileIO.java
 *      Notes: Handles all file input/output from artistlist.ser located in resources.
 *              Observable Lists do not serialize so all String objects are transferred to and
 *              from an ArrayList for serialization.
 */

package com.iandw.musicplayerjavafx.FileIO;

import com.iandw.musicplayerjavafx.ResourceFiles;

import java.io.*;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ArtistListFileIO {

    /**
     * inputArtistNameObservableList() - read Artist names from artistlist.ser
     * @return => ObservableList for artistListObservableList (ListViewLibrary) to handle.
     */
    public static ObservableList<String> inputArtistNameObservableList() {

        ArrayList<String> artistNameArrayList;
        ObservableList<String> artistNameObservableList = FXCollections.observableArrayList();

        try (FileInputStream in = new FileInputStream(ResourceFiles.getArtistListFile())) {
            // Read from file
            System.out.println("Reading from artistlist.ser");
            ObjectInputStream ois = new ObjectInputStream(in);
            artistNameArrayList = (ArrayList<String>) ois.readObject();
            ois.close();

            artistNameObservableList.addAll(artistNameArrayList);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return artistNameObservableList;
    }

    /**
     * outputArtistNameObservableList() - write ArtistName String objects to artistlist.ser
     * @param artistNameObservableList => Observable List to be output to file
     */
    public static void outputArtistNameObservableList(ObservableList<String> artistNameObservableList) {

        ArrayList<String> artistNameArrayList = new ArrayList<>(artistNameObservableList);

        try (FileOutputStream out = new FileOutputStream(ResourceFiles.getArtistListFile())){
            // Write track objects to file
            System.out.println("Writing to artistlist.ser");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(artistNameArrayList);
            oos.close();

        } catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
