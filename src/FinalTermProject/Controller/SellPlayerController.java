package FinalTermProject.Controller;

import FinalTermProject.DTO.BuyRequest1;
import FinalTermProject.DTO.SellRequest;
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

public class SellPlayerController {

    private Main main;

    public boolean sellCheck = false;

    public void setSellCheck(boolean bool){
        this.sellCheck = bool;
    }

    public void setMain(Main main){
        this.main = main;
    }

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
    private TextField PlayerToBeSoldName;

    @FXML
    private TextField PlayerToBeSoldPrice;

    @FXML
    private Button SellButton;

    @FXML
    private Button SellResetButton;

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
    void sellButtonAction(ActionEvent event) {
        boolean foundException = false;
        String name = PlayerToBeSoldName.getText();
        double price = 0.0;
        try{
            price = Double.parseDouble(PlayerToBeSoldPrice.getText());
        } catch (Exception e){
            foundException = true;
        }
        if(!foundException){
            Player player = new Player();
            boolean found = false;
            for(Player p: ClubPlayerList){
                if(p.getName().equals(name)){
                    found = true;
                    player = p;
                    break;
                }
            }
            player.setPlayerValue(price);
            if(found){
                SellRequest sellRequest = new SellRequest();
                sellRequest.setPlayer(player);
                try{
                    main.getNetworkUtil().write(sellRequest);
                } catch (Exception e){
                    e.printStackTrace();
                }
                ClubPlayerList.remove(player);
                main.setClubPlayerList(this.ClubPlayerList);
                PlayerToBeSoldName.setText("");
                PlayerToBeSoldPrice.setText("");
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Invalid Player Name");
                alert.setContentText("Please input a player name belonging to the club");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Invalid Player Price");
            alert.setContentText("Please input a valid price for the player");
            alert.showAndWait();
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
    void sellResetButtonAction(ActionEvent event) {
        PlayerToBeSoldName.setText("");
        PlayerToBeSoldPrice.setText("");
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
