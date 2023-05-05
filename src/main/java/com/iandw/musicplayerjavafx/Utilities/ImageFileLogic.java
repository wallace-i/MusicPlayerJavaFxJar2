/**
 *      Author: Ian Wallace, copyright 2022 all rights reserved.
 *      Application: MusicPlayer
 *      Class: ImageFileLogic.java
 *      Notes: Object has two functions:
 *              1. To color AutoPlay icon the correct shade based on current App Theme
 *              2. Load default album art .png file into ImageView in MusicPlayerController
 */

package com.iandw.musicplayerjavafx.Utilities;

import com.iandw.musicplayerjavafx.ResourceFiles;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;

public class ImageFileLogic {
    private final String userTheme;
    // CSS File Names
    private final String styleLightFileName = "style-light.css";
    private final String styleDarkFileName = "style-dark.css";
    private final String styleBlueFileName = "style-blue.css";
    private final String styleGreenFileName = "style-green.css";
    private final String styleRedFileName = "style-red.css";
    private final String stylePinkFileName = "style-pink.css";
    private final String styleConsoleFileName = "style-console.css";

    public ImageFileLogic(String userTheme) {
        this.userTheme = userTheme;
    }

    // For 'masking' autoplay icon to correct hue
    public Lighting getLighting() {
        Lighting lighting = null;

        switch (userTheme) {
            case styleLightFileName -> {
                lighting = new Lighting(new Light.Distant(45, 90, Color.rgb(105, 105, 105)));
                ColorAdjust bright = new ColorAdjust(0, 1, 1, 1);
                lighting.setContentInput(bright);
                lighting.setSurfaceScale(0.0);
            }

            case styleDarkFileName -> {
                lighting = new Lighting(new Light.Distant(45, 90, Color.rgb(130, 130, 130)));
                ColorAdjust bright = new ColorAdjust(0, 1, 1, 1);
                lighting.setContentInput(bright);
                lighting.setSurfaceScale(0.0);
            }

            case styleBlueFileName -> {
                lighting = new Lighting(new Light.Distant(45, 90, Color.rgb(45, 112, 134)));
                ColorAdjust bright = new ColorAdjust(0, 1, 1, 1);
                lighting.setContentInput(bright);
                lighting.setSurfaceScale(0.0);
            }

            case styleGreenFileName -> {
                lighting = new Lighting(new Light.Distant(45, 90, Color.rgb(61, 143, 82)));
                ColorAdjust bright = new ColorAdjust(0, 1, 1, 1);
                lighting.setContentInput(bright);
                lighting.setSurfaceScale(0.0);
            }

            case styleRedFileName -> {
                lighting = new Lighting(new Light.Distant(45, 90, Color.rgb(134, 67, 45)));
                ColorAdjust bright = new ColorAdjust(0, 1, 1, 1);
                lighting.setContentInput(bright);
                lighting.setSurfaceScale(0.0);
            }

            case stylePinkFileName -> {
                lighting = new Lighting(new Light.Distant(45, 90, Color.rgb(125, 54, 125)));
                ColorAdjust bright = new ColorAdjust(0, 1, 1, 1);
                lighting.setContentInput(bright);
                lighting.setSurfaceScale(0.0);
            }

            case styleConsoleFileName -> {
                lighting = new Lighting(new Light.Distant(45, 90, Color.rgb(58, 120, 58)));
                ColorAdjust bright = new ColorAdjust(0, 1, 1, 1);
                lighting.setContentInput(bright);
                lighting.setSurfaceScale(0.0);
            }
        }

        return lighting;
    }

    // Gets correct album image file depending on theme
    public String getAlbumImage() {
        String albumImageFile = null;

        switch (userTheme) {
            case styleLightFileName   -> albumImageFile = ResourceFiles.getMusicnotesLightFile().getPath();
            case styleDarkFileName    -> albumImageFile = ResourceFiles.getMusicnotesDarkFile().getPath();
            case styleBlueFileName    -> albumImageFile = ResourceFiles.getMusicnotesBlueFile().getPath();
            case styleGreenFileName   -> albumImageFile = ResourceFiles.getMusicnotesGreenFile().getPath();
            case styleRedFileName     -> albumImageFile = ResourceFiles.getMusicnotesRedFile().getPath();
            case stylePinkFileName    -> albumImageFile = ResourceFiles.getMusicnotesPinkFile().getPath();
            case styleConsoleFileName -> albumImageFile = ResourceFiles.getMusicnotesConsoleFile().getPath();

        }

        return albumImageFile;
    }
}
