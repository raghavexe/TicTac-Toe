package com.example.javafxpractise.TikTacToe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;

public class Game extends Application
{

    boolean turn = true;
    Scene scene;
    Font font;
    EventHandler<ActionEvent>myEvent;
    Checker check;
    String[]charPosition = new String[9];
    public static void main(String[]args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Arrays.fill(charPosition, " ");
        myEvent = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                String printable = "";
                int tempCounter = 0;
                GameEndScreen screen = new GameEndScreen();
                Button tempButton = (Button)actionEvent.getSource();
                buttonPressed(tempButton); tempCounter++;

                    printable = checkForWin(tempButton.getText(), tempButton.getId());
                    if (!(printable.equals("")))
                    {
                        System.out.println(printable);
                        screen.gameOver(printable);
                        stage.close();

                    }
                    else
                    {
                        if (tempCounter == 9)
                        {
                            tempCounter = 0;
                            System.out.println("No one won");
                            screen.gameOver("No one won");
                            stage.close();
                        }
                    }
                }
        };

        stage.setScene(FactoryOutlet());
        stage.show();

    }
    public Scene FactoryOutlet()
    {
        ButtonFactory buttons;
        VBox ScreenBox;
        font = new Font(35);
        HBox mainBox;
        Text TitleText = new Text("TicTacToe");
        TitleText.setFont(font);
        buttons = new ButtonFactory();

        mainBox = new HBox(0);
        mainBox.getChildren().addAll(buttons.LEFT(myEvent),buttons.CENTRE(myEvent),buttons.RIGHT(myEvent));
        mainBox.setAlignment(Pos.CENTER);

        ScreenBox = new VBox(60);
        ScreenBox.getChildren().addAll(TitleText,mainBox);
        ScreenBox.setAlignment(Pos.CENTER);
        scene = new Scene(ScreenBox,500,500);
        return scene;
    }

    public void buttonPressed(Button button)
    {
        font = new Font(35);
        if(turn) {
            button.setText("X"); button.setFont(font); button.setDisable(true); button.setTextFill(Color.GREEN);
            turn = false;
        } else {
            button.setText("O"); button.setFont(font); button.setDisable(true);button.setTextFill(Color.RED);
            turn = true;
        }
    }
    public String  checkForWin(String Symbol , String ID)
    {
            check = new Checker();
            int tempNum = Integer.parseInt(ID);
            charPosition[tempNum] = Symbol;
            if (!(numDetective(tempNum).equals("")))
            {
                return Symbol + numDetective(tempNum);
            } else
            {
                return "";
            }
        }
    public boolean comparator(int mainID , int IDPos1 , int IDPos2)
    {
        if( (charPosition[mainID].equals(charPosition[IDPos1])) && (charPosition[mainID].equals(charPosition[IDPos2])))
        {
            return true;
        }
        return false;
    }
    public String numDetective(int num)
    {
        if(num == 0)
        {
            if(comparator(0,1,2)||comparator(0,3,6)||comparator(0,4,8))
            {
                return " won";
            }
        }
        else if(num == 1)
        {
            if(comparator(1,4,7)||comparator(1,0,2))
            {
                return " won";
            }
        }
        else if(num == 2)
        {
            if(comparator(2,1,0)||comparator(2,4,6)||comparator(2,5,8))
            {
                return " won";
            }
        }
        else if(num == 3)
        {
            if(comparator(3,4,5)||comparator(3,6,0))
            {
                return " won";
            }
        }
        else if(num == 4)
        {
            if(comparator(4,1,7)||comparator(4,3,5))
            {
                return " won";
            }
        }
        else if(num == 5)
        {
            if(comparator(5,2,8)||comparator(5,4,3))
            {
                return " won";
            }
        }
        else if(num == 6)
        {
            if(comparator(6,3,0)||comparator(6,7,8)||comparator(6,4,2))
            {
                return " won";
            }
        }
        else if(num == 7)
        {
            if(comparator(7,6,8)||comparator(7,4,1))
            {
                return " won";
            }
        }
        else if(num == 8)
        {
            if(comparator(8,5,2)||comparator(8,7,6)||comparator(8,4,0))
            {
                return " won";
            }
        }
        return "";
    }



}






