package com.example.javafxpractise.TikTacToe;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameEndScreen
{
    Stage stage;
    public void gameOver(String Victory_Banner)
    {
        Game game;
        Scene scene;
        VBox box;
        HBox Choices;
        Font BannerFont;
        Text Banner, choiceTitle;
        Button yes_Button , no_Button ;

        BannerFont = new Font(40);
        Banner = new Text(Victory_Banner);
        Banner.setFont(BannerFont);

        choiceTitle = new Text("Do you want to play again?");
        choiceTitle.setFont(new Font(30));

        game = new Game();
        yes_Button = new Button("yes");
        yes_Button.setOnAction(e->
        {
            try
            {
                game.stop();
                game.start(stage);
            }
            catch (Exception ex)
            {
                throw new RuntimeException(ex);
            }
        });

        no_Button = new Button("no");
        no_Button.setOnAction(e->stage.close());

        Choices = new HBox(20);
        Choices.getChildren().addAll(yes_Button,no_Button);
        Choices.setAlignment(Pos.CENTER);

        box = new VBox(50);
        box.getChildren().addAll(Banner,choiceTitle,Choices);
        box.setAlignment(Pos.CENTER);




        scene = new Scene(box,500,500);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
}
