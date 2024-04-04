package iespoblenou.arc.dnigenerator;

import iespoblenou.arc.dnigenerator.form_component.FormController;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.Objects;

public class DniGeneratorController {
    @FXML
    private Label generateDniLabel;
    @FXML
    private  FormController formController;
    private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final static String DNI_CHAR = "TRWAGMYFPDXBNJZSQVHLCKE";

    public String getFirstSevenCharsName() {
        String name = formController.getNameTextField();
        String lastname = formController.getLastnameTextField();
        String completeName = name + lastname;

        while (completeName.length() < 7) {
            completeName += ALPHABET.charAt(completeName.length() % ALPHABET.length());
        }
        return completeName.substring(0, 7).toUpperCase();
    }


    public String generateNumbersDNI(){
        StringBuilder dniNumber = new StringBuilder();
        String name = getFirstSevenCharsName();

        for (int i = 0; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            int charIndex = ALPHABET.indexOf(currentChar);
             if(charIndex != -1){
                 dniNumber.append(charIndex % 10);
             }
        }
        return dniNumber.toString();
    }

    public int multiplicateDniNumbers(){
        int numbers = Integer.parseInt(generateNumbersDNI());
        int multiplicator = Integer.parseInt(formController.getMultiplicatorTextField());
        int dniNumbers = numbers * multiplicator;
        while (dniNumbers <= 10000000) {
            dniNumbers *= 10;
        }
        return dniNumbers;
    }

    public char getCharDni(int dniNumber){
        int dniRemainder = dniNumber % 23;
        return DNI_CHAR.charAt(dniRemainder);
    }

    public String createDni(){
        String completeDni = "";
        String numbersDni = String.valueOf(multiplicateDniNumbers());
        completeDni = numbersDni + getCharDni(Integer.parseInt(numbersDni));
        return completeDni;
    }

    @FXML
    protected void onGenerateDniButtonClick() {
        if (isAnyTextFieldEmpty()) {
            showError("Per generar el DNI, tots els camps han d'estar plens.");
            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(4));
            pauseTransition.setOnFinished(event -> clearError());

            pauseTransition.play();
        } else {
            String dni = createDni();
            generateDniLabel.setText(dni);
        }
    }

    @FXML
    protected void onEraseDniButtonClick() {
        generateDniLabel.setText("");
    }

    private void showError(String message){
        generateDniLabel.setText(message);
    }

    private void clearError(){
        generateDniLabel.setText("");
    }

    private boolean isMultiplicatorTextFieldEmpty(){
        return Objects.equals(formController.getMultiplicatorTextField(), "");
    }

    private boolean isNameTextFieldEmpty(){
        return Objects.equals(formController.getNameTextField(), "");
    }

    private boolean isLastnameTextFieldEmpty(){
        return Objects.equals(formController.getLastnameTextField(), "");
    }
    private boolean isAnyTextFieldEmpty() {
        return isNameTextFieldEmpty() || isLastnameTextFieldEmpty() || isMultiplicatorTextFieldEmpty();
    }
}