package com.gllm.pwllstemfx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    // Creating the Main Start UI
    public void start(Stage primaryStage) throws IOException {
        Alert startupInfo = new Alert(Alert.AlertType.INFORMATION);
        startupInfo.setTitle("What is this?");
        startupInfo.setHeaderText("What is this?");
        startupInfo.setContentText("This app is made to take recent COVID-19 data and display it for you to read! Alpha, Delta, and Omicron are variants of COVID-19 and then the rest should be fairly self explanatory.\nThank you for using this app.");
        startupInfo.showAndWait();
        StackPane root = new StackPane();
        Text Title = new Text("Covid Cases");
        Title.setTextAlignment(TextAlignment.CENTER);
        Title.setFont(Font.font("Courier New", FontWeight.BOLD, 48));
        ImageView aber = new ImageView("Images/aber.png");
        aber.setPickOnBounds(true);
        aber.setOnMouseClicked((MouseEvent e) -> {
            Alert aberInfo = new Alert(Alert.AlertType.INFORMATION);
            aberInfo.setTitle("Aberystwyth University");
            aberInfo.setHeaderText("Aberystwyth University");
            aberInfo.setContentText("Prifysgol Aberystwyth University is our company sponsor for this project and has been a massive help in our understanding of how genome sequencing and handling big data works.");
            aberInfo.show();
        });
        ImageView gllm = new ImageView("Images/gllm.png");
        gllm.setPickOnBounds(true);
        gllm.setOnMouseClicked((MouseEvent e) -> {
            Alert gllmInfo = new Alert(Alert.AlertType.INFORMATION);
            gllmInfo.setTitle("Grwp Llandrillo Menai");
            gllmInfo.setHeaderText("Grwp Llandrillo Menai");
            gllmInfo.setContentText("We are a group of students from Coleg Meirion-Dwyfor, who have been working on making this application to allow for easy-to-understand representation of data regarding the COVID genome. This application will allow for anyone to read and gain a deeper understanding of how COVID works at any level");
            gllmInfo.show();
        });
        ImageView eesw = new ImageView("Images/eesw.png");
        eesw.setPickOnBounds(true);
        root.getChildren().addAll(Title,aber,gllm,eesw);
        root.setAlignment(Title, Pos.TOP_CENTER);
        root.setAlignment(aber, Pos.TOP_LEFT);
        root.setAlignment(gllm, Pos.TOP_RIGHT);
        root.setAlignment(eesw, Pos.BOTTOM_LEFT);
        Scene scene = new Scene(root, 1280, 720);
        primaryStage.setTitle("Covid Cases!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}