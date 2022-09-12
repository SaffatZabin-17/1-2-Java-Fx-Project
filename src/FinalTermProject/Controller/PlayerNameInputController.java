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

public class PlayerNameInputController {

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    List<Player> ClubPlayerList = new ArrayList<>();

    public String passedClubName;

    public String playerName = "";

    public void setPassedClubName(String name) {
        this.passedClubName = name;
    }

    public void setClubPlayerList(List<Player>list){
        this.ClubPlayerList = list;
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
    private TextField PlayerNameInput;

    @FXML
    private Button SearchButton;

    @FXML
    private Button ResetButton;

    @FXML
    void CountryWisePlayerCountAction(ActionEvent event) {
        try {
            main.showCountryWisePlayerCountOutput();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void ExitButtonAction(ActionEvent event) {
        try {
            ClubPlayerList.clear();
            main.showLoginPage();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void ResetButtonAction(ActionEvent event) {
        PlayerNameInput.setText(null);
    }

    @FXML
    void SearchButtonAction(ActionEvent event) {
        boolean found = false;
        for (Player p : ClubPlayerList) {
            if (PlayerNameInput.getText().equals(p.getName())) {
                found = true;
                playerName = PlayerNameInput.getText();
                break;
            }
        }
        if (found) {
            try {
                main.pl_name = playerName;
                main.showPlayerNameOutput();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Invalid Player Name");
            alert.setContentText("Please input a player name belonging to the club");
            alert.showAndWait();
        }
    }

    @FXML
    void SearchByCountryAction(ActionEvent event) {
        try {
            main.showCountryInput();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void SearchByNameAction(ActionEvent event) {
        try {
            main.showPlayerNameInput();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void SearchByPositionAction(ActionEvent event) {
        try {
            main.showPositionInput();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void SearchBySalaryAction(ActionEvent event) {
        try {
            main.showSalaryInput();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void buyPlayersAction(ActionEvent event) {
        try {
            BuyRequest1 buyRequest1 = new BuyRequest1();
            buyRequest1.setClubName(passedClubName);
            main.getNetworkUtil().write(buyRequest1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void dashboardButtonAction(ActionEvent event) {
        try {
            //ClubPlayerList.clear();
            main.showMainMenu(passedClubName, ClubPlayerList);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void maxAgeAction(ActionEvent event) {
        try {
            main.showMaxAgeOutput();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void maxHeightAction(ActionEvent event) {
        try {
            main.showMaxHeightOutput();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void maxSalaryAction(ActionEvent event) {
        try {
            main.showMaxSalaryOutput();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void playerNameInput(ActionEvent event) {

    }

    @FXML
    void sellPlayersAction(ActionEvent event) {
        try {
            main.showSellPlayer();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void totalSalaryAction(ActionEvent event) {
        try {
            main.showYearlySalary();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

