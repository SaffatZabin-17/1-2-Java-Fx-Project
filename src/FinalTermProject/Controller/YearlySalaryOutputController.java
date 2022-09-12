package FinalTermProject.Controller;

import FinalTermProject.DTO.BuyRequest1;
import FinalTermProject.Main;
import FinalTermProject.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

public class YearlySalaryOutputController {

    private Main main;

    public void setMain(Main main){
        this.main = main;
    }

    public double total_salary;

    List<Player> ClubPlayerList = new ArrayList<>();

    public void setClubPlayerList(List<Player> list){
        this.ClubPlayerList = list;
    }

    public String clubName;
    public void setClubName(String name){
        this.clubName = name;
    }

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
    private Label YearlySalaryOutput;

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

    public void init(){
        for(Player p: ClubPlayerList){
            total_salary+= p.getWeeklySalary();
        }

        YearlySalaryOutput.setText(String.valueOf(total_salary));
    }
}

