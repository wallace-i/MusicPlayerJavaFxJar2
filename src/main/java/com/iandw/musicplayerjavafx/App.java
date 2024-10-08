/**
 *      Author: Ian Wallace copyright 2022 all rights reserved.
 *      Application: MusicPlayer
 *      Class: App.java
 *      Notes: Launch App java object - includes file input for App initialization
 */

package com.iandw.musicplayerjavafx;

import com.iandw.musicplayerjavafx.FileIO.ConsoleLogFileIO;
import com.iandw.musicplayerjavafx.FileIO.SettingsFileIO;
import com.iandw.musicplayerjavafx.Libraries.ListViewLibrary;
import com.iandw.musicplayerjavafx.Libraries.TableViewLibrary;
import com.iandw.musicplayerjavafx.Utilities.UserSettings;

import java.io.*;
import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.Objects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class App extends Application {
    private UserSettings userSettings;
    private ListViewLibrary listViewLibrary;
    private TableViewLibrary tableViewLibrary;

    @Override
    public void start(Stage stage) {
        try {
            // Initialize files and directories in user's Local AppData folder if non-existent
            initializeAppData();

            // Create UserSettings object to hold settings from JSON file for
            // file I/O on start up and exit
            userSettings = new UserSettings();

            // Create Library Objects to hold Track Metadata and Artist/Playlist data for
            // Table View and List View GUI
            listViewLibrary = new ListViewLibrary();
            tableViewLibrary = new TableViewLibrary();

            // Input music library files and settings via ExecutorService
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(userSettings);
            executorService.execute(listViewLibrary);
            executorService.execute(tableViewLibrary);
            executorService.shutdown();

            // Set console to output text for user to view via Help menu
            ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
            System.setOut(new PrintStream(consoleOutput));

            // HostServices for accessing developer GitHub page
            stage.getProperties().put("hostServices", this.getHostServices());

            // Pass top level objects to MusicPlayerController object via fxmlLoader
            FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("musicplayer.fxml")));
            fxmlLoader.setControllerFactory(musicPlayerController -> new MusicPlayerController(
                    stage, executorService, consoleOutput, userSettings, listViewLibrary, tableViewLibrary));

            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource(
                    userSettings.getThemeFileNameString())).toExternalForm());

            stage.setTitle("mpTea Player");
            stage.getIcons().add(new Image(ResourceFiles.getTeacupIconFile().getPath()));
            stage.setScene(scene);
            stage.setResizable(true);
            // Set Window size constraints
            stage.setMinWidth(675);
            stage.setMinHeight(452);
            stage.setHeight(600);
            stage.setWidth(900);
            stage.show();

            // Save user settings on close
            stage.setOnCloseRequest(event -> {
                event.consume();
                try {
                    saveAndExit(stage, consoleOutput);

                } catch (FileNotFoundException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     * saveAndExit()
     *
     * @param stage => Close App main GUI pane and exit the Application
     * @param consoleOutput => Write System.out... statements to file on close
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    private void saveAndExit(Stage stage, ByteArrayOutputStream consoleOutput) throws FileNotFoundException, InterruptedException {

        // Output to file on close if files data has been altered
        if (userSettings.getWriteOnClose()) {
            SettingsFileIO.jsonFileOutput(userSettings);
        }

        listViewLibrary.onClose();
        tableViewLibrary.onClose();

        // Write console log to file
        ConsoleLogFileIO.outputConsoleLog(consoleOutput.toString());

        stage.close();
    }

    /**
     * initializeAppData()
     *
     * @throws IOException
     */
    private void initializeAppData() throws IOException {
        if (!ResourceFiles.getMpTeaPlayerFolder().exists()) {
            Files.createDirectory(ResourceFiles.getMpTeaPlayerFolder().toPath());
            Files.createDirectory(ResourceFiles.getDataFolder().toPath());
            Files.createFile(ResourceFiles.getArtistListFile().toPath());
            Files.createFile(ResourceFiles.getPlaylistsFile().toPath());
            Files.createFile(ResourceFiles.getTrackListFile().toPath());
            Files.createFile(ResourceFiles.getSettingsFile().toPath());
            Files.createFile(ResourceFiles.getConsolelogFile().toPath());
            SettingsFileIO.settingsFileInitialize();
        }
    }

    public static void main(String[] args) { launch(args); }
}