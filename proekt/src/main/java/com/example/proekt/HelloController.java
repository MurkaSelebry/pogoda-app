package com.example.proekt;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class HelloController {
    private Parser parser;
    @FXML
    private Text gorod;
    @FXML
    private Text vlaga;
    @FXML
    private Text wet;
    @FXML
    private Text tempa;
    @FXML
    private AnchorPane background_img;
    @FXML
    private Text real_time;
    @FXML
    private TextField search_str;
    @FXML
    private ImageView tempaView;


    @FXML
    protected void onHelloButtonClick() throws IOException {
        if(parser==null){
            parser = new Parser();
            search_str.setText("Москва");
            onSearch();
        }

        Date date = new Date();
        if(date.getHours()<10){
            if ((date.getMinutes()<10)){
                real_time.setText("0" + String.valueOf(date.getHours()) + " : 0" + String.valueOf(date.getMinutes()));
            } else if (date.getMinutes()>=10) {
                real_time.setText("0" + String.valueOf(date.getHours()) + " : " + String.valueOf(date.getMinutes()));
            }
        }
        else if (date.getMinutes()<10) {
            real_time.setText(String.valueOf(date.getHours()) + " : 0" + String.valueOf(date.getMinutes()));
        }
        else {
            real_time.setText(String.valueOf(date.getHours()) + " : " + String.valueOf(date.getMinutes()));
        }
        real_time.setStyle("-fx-font-size: 18px;");
        if (date.getHours()>5 && date.getHours()<18){
            background_img.setStyle("-fx-background: black');");
        } else if (date.getHours()>=18) {
            background_img.setStyle("-fx-background: black;");
        }
        else {
            background_img.setStyle("-fx-background: black;");
        }
    }

    public void onSearch() throws IOException {
        String searchText = search_str.getText(); //ВОЗВРАТ ВВЕДЕННОГО ГОРОДА
        onHelloButtonClick();
        CityInfo ci = parser.getInfo(searchText);
        if(ci!=null) {
            gorod.setText(ci.getCity());
            int hum = ci.getHumidity();
            int win = ci.getWind();
            int temp = ci.getTemperature();
            String res;
            vlaga.setText(String.valueOf(hum)+"%");
            wet.setText(String.valueOf(win)+" м/c");
            tempa.setText(String.valueOf(temp)+"°");
            if(temp>10){
                res="sun";
                if(hum>50)
                    res="cloudsun";
            }
            else
                res="cloud";
            if(hum>70 || temp<-10)
                res="rain";
            tempaView.setImage(new Image("C:/Users/selebry/IdeaProjects/pogoda-app/proekt/src/main/java/com/example/proekt/images/"+res+".png"));
        }

    }
}