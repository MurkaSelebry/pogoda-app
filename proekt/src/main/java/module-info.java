module com.example.proekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;


    opens com.example.proekt to javafx.fxml;
    exports com.example.proekt;
}