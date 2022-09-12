package FinalTermProject.Controller;

import FinalTermProject.DTO.BuyRequest1;
import FinalTermProject.Main;
import FinalTermProject.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerPositionInputController {
    private Main main;
    public void setMain(Main main){
        this.main = main;
    }
    public String position = "";
    public String clubName;

    public void setClubName(String name){
        this.clubName = name;
    }

    List<Player> ClubPlayerList = new ArrayList<>();

    public void setClubPlayerList(List<Player>list){
        this.ClubPlayerList = list;
    }


    @FXML
    private MenuItem SearchByName;

    @FXML
    private MenuItem SearchByClubAndCountry;

    @FXML
    private MenuItem SearchByPosition;

    @FXML
    private MenuItem SearchBySalary;

    @FXML
    private MenuItem CountryWisePlayerCount;

    @FXML
    private MenuItem MaximumSalary;

    @FXML
    private MenuItem MaximumAge;

    @FXML
    private MenuItem MaximumHeight;

    @FXML
    private MenuItem YearlySalary;

    @FXML
    private Button ExitButton;

    @FXML
    private TextField PlayerPosition;

    @FXML
    private Button SearchButton;

    @FXML
    private Button ResetButton;

    @FXML
    private TextField PlayerPositionInput;

    @FXML
    void CountryWisePlayerCountAction(ActionEvent event) {
        try{
            main.showCountryWisePlayerCountOutput();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void ExitButtonAction(ActionEvent event) {
        try{
            main.showLoginPage();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void ResetButtonAction(ActionEvent event) {
        PlayerPositionInput.setText("");
    }

    @FXML
    void SearchButtonAction(ActionEvent event) {
        boolean found = false;
        for(Player p: ClubPlayerList){
            if(PlayerPositionInput.getText().equals(p.getPosition())){
                found = true;
                position = PlayerPositionInput.getText();
                break;
            }
        }
        if(found){
            try{
                main.pl_position = position;
                main.showPositionOutput();
            } catch (Exception e){
                System.out.println(e);
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Invalid Player Position");
            alert.setContentText("No such player in this position in the club");
            alert.showAndWait();
        }
    }

    @FXML
    void SearchByNameAction(ActionEvent event) {
        try{
            main.showPlayerNameInput();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void SearchByPositionAction(ActionEvent event) {
        try{
            main.showPositionInput();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void SearchBySalaryAction(ActionEvent event) {
        try{
            main.showSalaryInput();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void playerPositionInput(ActionEvent event) {
        position = PlayerPosition.getText();
    }

    public void sellPlayersAction(ActionEvent actionEvent) {
        try{
            main.showSellPlayer();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void buyPlayersAction(ActionEvent actionEvent) {
        try{
            BuyRequest1 buyRequest1 = new BuyRequest1();
            buyRequest1.setClubName(clubName);
            main.getNetworkUtil().write(buyRequest1);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void dashboardButtonAction(ActionEvent actionEvent) {
        try{
            main.showMainMenu(clubName, ClubPlayerList);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void totalSalaryAction(ActionEvent actionEvent) {
        try{
            main.showYearlySalary();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void maxHeightAction(ActionEvent actionEvent) {
        try{
            main.showMaxHeightOutput();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void maxAgeAction(ActionEvent actionEvent) {
        try{
            main.showMaxAgeOutput();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void maxSalaryAction(ActionEvent actionEvent) {
        try{
            main.showMaxSalaryOutput();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void SearchByCountryAction(ActionEvent actionEvent) {
        try{
            main.showCountryInput();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
