package com.heshanthenura.filetomedia;


import com.heshanthenura.filetomedia.image.Encode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    Encode encode = new Encode();
    String path = null;
    String name = null;

    int totalImgBits=0;
    int remainBits=0;
    int totalBit =0;
    int bitInExt =0;
    @FXML
    private Label RemainBits;

    @FXML
    private Button encodeBtn;

    @FXML
    private TextField imgH;

    @FXML
    private TextField imgW;

    @FXML
    private Label nameOfFile;

    @FXML
    private Label totalNoOfBits;

    @FXML
    private Label totalNoOfBitsInExt;

    @FXML
    private Label totalNoOfBitsInImage;

    @FXML
    private Label totalNumberOfBits;

    @FXML
    private Button selectFileBtn;

    @FXML
    void encode(MouseEvent event) throws IOException {
        encode.Encode(path,(imgH.getText()),(imgW.getText()));
    }

    @FXML
    void inpH(KeyEvent event) {
        if (!imgH.getText().matches("\\d*")) {
            imgH.setText(imgH.getText().replaceAll("[^\\d]", ""));
        }
        System.out.println(imgH.getText());
        try {
            System.out.println(Integer.parseInt(imgH.getText())*Integer.parseInt(imgW.getText()));
            totalImgBits=(Integer.parseInt(imgH.getText())*Integer.parseInt(imgW.getText()));
            totalNoOfBitsInImage.setText(String.valueOf(totalImgBits));
        }catch (Exception e){}


    }

    @FXML
    void inpW(KeyEvent event) {
        if (!imgW.getText().matches("\\d*")) {
            imgW.setText(imgW.getText().replaceAll("[^\\d]", ""));
        }
        System.out.println(imgW.getText());
        try {
            System.out.println(Integer.parseInt(imgH.getText())*Integer.parseInt(imgW.getText()));
            totalImgBits=(Integer.parseInt(imgH.getText())*Integer.parseInt(imgW.getText()));
            totalNoOfBitsInImage.setText(String.valueOf(totalImgBits));

        }catch (Exception e){}

    }

    @FXML
    void selectFile(MouseEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(selectFileBtn.getScene().getWindow());

            path=selectedFile.getAbsolutePath();
            name=selectedFile.getName();
            totalImgBits = Integer.parseInt(imgH.getText()) * Integer.parseInt(imgW.getText());
            totalBit =(encode.TotalBits(path));
            bitInExt =(encode.TotalBitsInExt(name));
            remainBits=totalImgBits-((totalBit)+(bitInExt));

            nameOfFile.setText(name);
            totalNoOfBits.setText(String.valueOf(totalBit));
            totalNoOfBitsInExt.setText(String.valueOf(bitInExt));
            RemainBits.setText(String.valueOf(remainBits));

            System.out.println("TotalImgBits = "+totalImgBits);
            System.out.println("TotalBits = "+totalBit);
            System.out.println("TotalBitsInExt = "+bitInExt);
            System.out.println("Remaining = "+String.valueOf(remainBits));
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}