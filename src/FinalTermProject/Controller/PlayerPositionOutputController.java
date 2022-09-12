package FinalTermProject.Controller;

import FinalTermProject.DTO.BuyRequest1;
import FinalTermProject.Main;
import FinalTermProject.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class PlayerPositionOutputController {

    public TableView<Player> positionOutputTable;

    public String playerPosition;


    public void setPlayerPosition(String name){
        this.playerPosition = name;
    }

    private boolean init = true;

    private Main main;

    public void setMain(Main main){
        this.main = main;
    }
    public String passedClubName;

    public void setPassedClubName(String name){
        this.passedClubName = name;
    }

    public List<Player> ClubPlayerList = new ArrayList<>();

    public void setClubPlayerList(List<Player>list){
        this.ClubPlayerList = list;
    }

    private void initializeColumns(){
        TableColumn<Player, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(160);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<Player, String> countryColumn = new TableColumn<>("Country");
        countryColumn.setMinWidth(80);
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("Country"));

        TableColumn<Player, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setMinWidth(60);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Player, Double> heightColumn = new TableColumn<>("Height");
        heightColumn.setMinWidth(80);
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));

        TableColumn<Player, String> positionColumn = new TableColumn<>("Position");
        positionColumn.setMinWidth(60);
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("Position"));

        TableColumn<Player, Integer> numberColumn = new TableColumn<>("Jersey Number");
        numberColumn.setMinWidth(80);
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("JerseyNumber"));

        TableColumn<Player, Double> salaryColumn = new TableColumn<>("Weekly Salary");
        salaryColumn.setMinWidth(80);
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("WeeklySalary"));

        positionOutputTable.getColumns().addAll(nameColumn, countryColumn, ageColumn, heightColumn, positionColumn, numberColumn, salaryColumn);
    }

    public ObservableList<Player> getPlayers(){
        ObservableList<Player> players = FXCollections.observableArrayList();
        for(Player p : ClubPlayerList){
            if(p.getPosition().equals(playerPosition)){
                players.add(p);
            }
        }
        return players;
    }

    public void load(){
        if(init){
            initializeColumns();
            init = false;
        }

        positionOutputTable.setEditable(true);
        positionOutputTable.setItems(getPlayers());
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
    private TextField PlayerPositionInput;

    @FXML
    private Button SearchButton;

    @FXML
    private Button ResetButton;

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
            main.showPositionInput();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void SearchButtonAction(ActionEvent event) {
        boolean found = false;
        for(Player p: ClubPlayerList){
            if(PlayerPositionInput.getText().equals(p.getPosition())){
                found = true;
                playerPosition = PlayerPositionInput.getText();
                break;
            }
        }
        if(found){
            try{
                main.pl_position = playerPosition;
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
            buyRequest1.setClubName(passedClubName);
            main.getNetworkUtil().write(buyRequest1);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void dashboardButtonAction(ActionEvent event) {
        try{
            //ClubPlayerList.clear();
            main.showMainMenu(passedClubName, ClubPlayerList);
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
    void playerPositionInput(ActionEvent event) {
        try{
            main.showPositionInput();
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

}
