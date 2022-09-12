package FinalTermProject.Controller;

import FinalTermProject.DTO.LoginRequest;
import FinalTermProject.FileOperations;
import FinalTermProject.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

public class LoginController {
    private Main main;
    public void setMain(Main main){
        this.main = main;
    }
    public String clubName;

    List<String> Clubs = new ArrayList<>();
    FileOperations fp = new FileOperations();

    @FXML
    private TextField LoginNameInput;

    @FXML
    private TextField PasswordInput;

    @FXML
    private Button LoginButton;

    @FXML
    private Button ResetButton;

    @FXML
    void LoginButtonAction(ActionEvent event) {
        boolean isPresent = false;
        try{
            Clubs = fp.read();
        } catch (Exception e){
            System.out.println(e);
        }
        for(String s: Clubs){
            if(LoginNameInput.getText().equals(s)){
                isPresent = true;
                clubName = LoginNameInput.getText();
                break;
            }
        }
        if(isPresent){
            try{
                LoginRequest request = new LoginRequest();
                request.setClubName(clubName);
                main.getNetworkUtil().write(request);
            } catch (Exception e){
                System.out.println(e);
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Credentials.");
            alert.setHeaderText("Incorrect Credentials.");
            alert.setContentText("Username or Password is invalid.");
            alert.showAndWait();
        }
    }

    @FXML
    void ResetButtonAction(ActionEvent event) {
        PasswordInput.setText("");
        LoginNameInput.setText("");
    }
}
