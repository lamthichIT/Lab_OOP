package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Trỏ đúng đường dẫn tới file FXML trong thư mục resources
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("/MainView.fxml"));

        // Tạo Scene với kích thước mặc định như thiết kế (1050x650)
        Scene scene = new Scene(fxmlLoader.load(), 1050, 650);

        stage.setTitle("OOP Media Player");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}