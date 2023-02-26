module com.heshanthenura.filetomedia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.heshanthenura.filetomedia to javafx.fxml;
    exports com.heshanthenura.filetomedia;
}