package com.example.javafxpractise.TikTacToe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class ButtonFactory extends Button
{
    public Button generateButtons(String ID, EventHandler<ActionEvent>buttonEvent)
    {
        int size = 80;
        Button button = new Button();
        button.setText("");
        button.setLayoutX(size);
        button.setLayoutY(size);
        button.setPrefSize(size,size);
        button.setId(ID);
        button.setOnAction(buttonEvent);
        return button;
    }
    public VBox LEFT(EventHandler<ActionEvent>buttonEvent)
    {
        VBox leftBox;
        Button ButtonTL = generateButtons("0",buttonEvent);
        Button ButtonCL = generateButtons("1",buttonEvent);
        Button ButtonBL = generateButtons("2",buttonEvent);

        leftBox = new VBox(0);
        leftBox.getChildren().addAll(ButtonTL,ButtonCL,ButtonBL);
        leftBox.setAlignment(Pos.CENTER);
        return leftBox;
    }
    public VBox CENTRE(EventHandler<ActionEvent>buttonEvent)
    {
        VBox centerBox;
        Button ButtonTC = generateButtons("3",buttonEvent);
        Button ButtonCC = generateButtons("4",buttonEvent);
        Button ButtonBC = generateButtons("5",buttonEvent);

        centerBox = new VBox(0);
        centerBox.getChildren().addAll(ButtonTC,ButtonCC,ButtonBC);
        centerBox.setAlignment(Pos.CENTER);
        return centerBox;
    }
    public VBox RIGHT(EventHandler<ActionEvent>buttonEvent)
    {
        VBox rightBox;
        Button ButtonTR = generateButtons("6",buttonEvent);
        Button ButtonCR = generateButtons("7",buttonEvent);
        Button ButtonBR = generateButtons("8",buttonEvent);

        rightBox = new VBox(0);
        rightBox.getChildren().addAll(ButtonTR,ButtonCR,ButtonBR);
        rightBox.setAlignment(Pos.CENTER);
        return rightBox;
    }



}
