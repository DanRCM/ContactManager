package com.mycompany.contactadministrator;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        ContactAdministratorApp.setRoot("secondary");
    }
}
