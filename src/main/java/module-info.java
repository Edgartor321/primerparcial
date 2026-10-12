module com.example.primerparcial {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.primerparcial to javafx.fxml;
    exports com.example.primerparcial;
}