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

public class PlayerSalaryInputController {

    private Main main;

    public String clubName;

    public void setClubName(String name){
        this.clubName = name;
    }

    public void setMain(Main main){
        this.main = main;
    }

    List<Player> ClubPlayerList = new ArrayList<>();

    public void setClubPlayerList(List<Player> list){
        this.ClubPlayerList = list;
    }

    public double min_Salary, max_Salary;

    @FXML
    private Button ExitButton;

    @FXML
    private MenuItem SearchByName;

    @FXML
    private MenuItem SearchByCountry;

    @FXML
    private MenuItem SearchByPosition;

    @FXML
    private MenuItem SearchBySalary;

    @FXML
    private MenuItem CountryWisePlayerCount;

    @FXML
    private MenuItem MaxSalary;

    @FXML
    private MenuItem MaxAge;

    @FXML
    private MenuItem MaxHeight;

    @FXML
    private MenuItem TotalSalary;

    @FXML
    private Button DashboardButton;

    @FXML
    private Button BuyPlayers;

    @FXML
    private Button SellPlayers;

    @FXML
    private TextField PlayerMinSalaryInput;

    @FXML
    private Button SearchButton;

    @FXML
    private Button ResetButton;

    @FXML
    private TextField PlayerMaxSalaryInput;

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
            ClubPlayerList.clear();
            main.showLoginPage();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void ResetButtonAction(ActionEvent event) {
        try{
            main.showSalaryInput();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void SearchButtonAction(ActionEvent event) {
        boolean caught_exception = false;
        try{
            min_Salary = Double.parseDouble(PlayerMinSalaryInput.getText());
            max_Salary = Double.parseDouble(PlayerMaxSalaryInput.getText());
        } catch (Exception e){
            caught_exception = true;
        }
        if(caught_exception){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Invalid Input Format");
            alert.setContentText("Please input a valid format");
            alert.showAndWait();
        }
        else{
            boolean found = false;
            for(Player p : ClubPlayerList){
                if(p.getWeeklySalary()>=min_Salary && p.getWeeklySalary()<=max_Salary){
                    found = true;
                    break;
                }
            }
            if(found){
                try{
                    main.pl_minSalary = min_Salary;
                    main.pl_maxSalary = max_Salary;
                    main.showSalaryOutput();
                } catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("No Player Found");
                alert.setContentText("No Such Player in the given range");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void SearchByCountryAction(ActionEvent event) {
        try{
            main.showCountryInput();
        } catch (Exception e){
            System.out.println(e);
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
    void buyPlayersAction(ActionEvent event) {
        try{
            BuyRequest1 buyRequest1 = new BuyRequest1();
            buyRequest1.setClubName(clubName);
            main.getNetworkUtil().write(buyRequest1);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void dashboardButtonAction(ActionEvent event) {
        try{
            //ClubPlayerList.clear();
            main.showMainMenu(clubName, ClubPlayerList);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void maxAgeAction(ActionEvent event) {
        try{
            main.showMaxAgeOutput();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void maxHeightAction(ActionEvent event) {
        try{
            main.showMaxHeightOutput();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void maxSalaryAction(ActionEvent event) {
        try{
            main.showMaxSalaryOutput();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void playerMaxSalaryInput(ActionEvent event) {

    }

    @FXML
    void playerMinSalaryInput(ActionEvent event) {

    }

    @FXML
    void sellPlayersAction(ActionEvent event) {
        try{
            main.showSellPlayer();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void totalSalaryAction(ActionEvent event) {
        try{
            main.showYearlySalary();
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
