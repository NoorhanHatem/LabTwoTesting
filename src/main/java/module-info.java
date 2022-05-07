module com.example.testinglab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testinglab2 to javafx.fxml;
    exports com.example.testinglab2;
}