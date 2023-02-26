package com.heshanthenura.filetomedia;

import com.heshanthenura.filetomedia.image.Encode;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;

public class MainController {

    public Encode encode=new Encode();

    @FXML
    private AnchorPane DranAndDropPane;

    @FXML
    private Button convertBtn;

    @FXML
    void Convert(MouseEvent event) {

    }

    @FXML
    void DragDropped(DragEvent event) throws IOException {
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            for (File file : db.getFiles()) {
                System.out.println(file.getAbsolutePath());
                encode.Encode(file.getAbsolutePath());
            }
        }
        event.setDropCompleted(success);
        event.consume();
    }

    @FXML
    void DragOver(DragEvent event) {
        if (event.getGestureSource() != DranAndDropPane && event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }
}