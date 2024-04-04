package iespoblenou.arc.dnigenerator.form_component;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class FormController  {
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField multiplicatorTextField;

    public String getNameTextField() {
        return nameTextField.getText();
    }

    public void setNameTextField(TextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public String getLastnameTextField() {
        return lastnameTextField.getText();
    }

    public void setLastnameTextField(TextField lastnameTextField) {
        this.lastnameTextField = lastnameTextField;
    }

    public String getMultiplicatorTextField() {
        return multiplicatorTextField.getText();
    }

    public void setMultiplicatorTextField(TextField multiplicatorTextField) {
        this.multiplicatorTextField = multiplicatorTextField;
    }

    public void initialize() {
        nameTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[a-zA-Z]*") && newText.length() <= 30) {
                return change;
            }
            return null;
        }));

        lastnameTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[a-zA-Z]*") && newText.length() <= 30) {
                return change;
            }
            return null;
        }));

        multiplicatorTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[1-9]*") && newText.length() <= 1) {
                return change;
            }
            return null;
        }));
    }
}
