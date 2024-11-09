module com.mycompany.contactadministrator {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.contactadministrator to javafx.fxml;
    exports com.mycompany.contactadministrator;
}
