package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Web Browser");
        primaryStage.setScene("d");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);

        TextField addressBar = new TextField();
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        addressBar.setOnAction(event -> {
            String url = addressBar.getText();
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://" + url;
            }
            webEngine.load(url);
        });

        root.setTop(addressBar);
        root.setCenter(webView);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}