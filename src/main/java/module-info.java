module com.example.javafxpractise {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafxpractise to javafx.fxml;
    exports com.example.javafxpractise;
    exports com.example.javafxpractise.TikTacToe;
    opens com.example.javafxpractise.TikTacToe to javafx.fxml;
}