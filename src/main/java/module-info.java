module com.iandw.musicplayerjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires java.desktop;
    requires json.simple;
    requires jaudiotagger;
    requires org.jsoup;

    opens com.iandw.musicplayerjavafx to javafx.fxml;
    exports com.iandw.musicplayerjavafx;
    exports com.iandw.musicplayerjavafx.Utilities;
    opens com.iandw.musicplayerjavafx.Utilities to javafx.fxml;
    exports com.iandw.musicplayerjavafx.FileIO;
    opens com.iandw.musicplayerjavafx.FileIO to javafx.fxml;
    exports com.iandw.musicplayerjavafx.ContextMenus;
    opens com.iandw.musicplayerjavafx.ContextMenus to javafx.fxml;
    exports com.iandw.musicplayerjavafx.Libraries;
    opens com.iandw.musicplayerjavafx.Libraries to javafx.fxml;
}