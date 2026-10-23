module org.example.micatalogodemelodias {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.micatalogodemelodias to javafx.fxml;
    exports org.example.micatalogodemelodias;
}