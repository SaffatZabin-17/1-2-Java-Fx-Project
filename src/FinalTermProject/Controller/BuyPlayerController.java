package FinalTermProject.Controller;

import FinalTermProject.DTO.BuyRequest1;
import FinalTermProject.DTO.BuyRequest2;
import FinalTermProject.Main;
import FinalTermProject.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class BuyPlayerController {

    private Main main;
    public void setMain(Main main){
        this.main = main;
    }
    public String clubName;
    public void setClubName(String name){
        this.clubName = name;
    }
    public List<Player> BuyPlayerList = new ArrayList<>();
    public List<Player> ClubPlayerList = new ArrayList<>();
    public void setClubPlayerList(List<Player> list){
        this.ClubPlayerList = list;
    }
    public void setBuyPlayerList(List<Player> list){
        this.BuyPlayerList = list;
        System.out.println(BuyPlayerList.size());
        for(Player p: BuyPlayerList){
            System.out.println(p.getName());
        }
    }
    boolean init = true;
    private void initializeColumns(){
        TableColumn<Player, String> nameTableOutput = new TableColumn<>("Name");
        nameTableOutput.setMinWidth(160);
        nameTableOutput.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<Player, String> countryTableOutput = new TableColumn<>("Country");
        countryTableOutput.setMinWidth(50);
        countryTableOutput.setCellValueFactory(new PropertyValueFactory<>("Country"));

        TableColumn<Player, Integer> ageTableOutput = new TableColumn<>("Age");
        ageTableOutput.setMinWidth(50);
        ageTableOutput.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Player, Double> heightTableOutput = new TableColumn<>("Height");
        heightTableOutput.setMinWidth(50);
        heightTableOutput.setCellValueFactory(new PropertyValueFactory<>("height"));

        TableColumn<Player, String> positionTableOutput = new TableColumn<>("Position");
        positionTableOutput.setMinWidth(50);
        positionTableOutput.setCellValueFactory(new PropertyValueFactory<>("Position"));

        TableColumn<Player, Integer> numberTableOutput = new TableColumn<>("Jersey Number");
        numberTableOutput.setMinWidth(80);
        numberTableOutput.setCellValueFactory(new PropertyValueFactory<>("JerseyNumber"));

        TableColumn<Player, Double> salaryTableOutput = new TableColumn<>("Weekly Salary");
        salaryTableOutput.setMinWidth(80);
        salaryTableOutput.setCellValueFactory(new PropertyValueFactory<>("WeeklySalary"));

        TableColumn<Player, Double> priceTableOutput = new TableColumn<>("Price");
        priceTableOutput.setMinWidth(80);
        priceTableOutput.setCellValueFactory(new PropertyValueFactory<>("playerValue"));

        BuyPlayerTable.getColumns().addAll(nameTableOutput, countryTableOutput, ageTableOutput, heightTableOutput, positionTableOutput, numberTableOutput, salaryTableOutput, priceTableOutput);
    }

    public ObservableList<Player> getPlayers(){
        ObservableList<Player> players = FXCollections.observableArrayList();
        players.addAll(BuyPlayerList);
        return players;
    }

    public void load(){
        if(init){
            initializeColumns();
            init = false;
        }
        BuyPlayerTable.setEditable(true);
        BuyPlayerTable.setItems(getPlayers());
        for(Player p: BuyPlayerList){
            System.out.println(p.getName());
        }
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
    private TableView<Player> BuyPlayerTable;

    @FXML
    public Button BuyButton;

    @FXML
    public Button RefreshButton;

    @FXML
    void CountryWisePlayerCountAction(ActionEvent event) {
        try{
            main.showCountryWisePlayerCountOutput();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void ExitButtonAction(ActionEvent event) {
        try{
            ClubPlayerList.clear();
            main.showLoginPage();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void SearchByCountryAction(ActionEvent event) {
        try{
            main.showCountryInput();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void SearchByNameAction(ActionEvent event) {
        try{
            main.showPlayerNameInput();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void SearchByPositionAction(ActionEvent event) {
        try{
            main.showPositionInput();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void SearchBySalaryAction(ActionEvent event) {
        try{
            main.showSalaryInput();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void buyPlayersAction(ActionEvent event) {
        try{
            BuyRequest1 buyRequest1 = new BuyRequest1();
            buyRequest1.setClubName(clubName);
            main.getNetworkUtil().write(buyRequest1);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void dashboardButtonAction(ActionEvent event) {
        try{
            main.showMainMenu(clubName, ClubPlayerList);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void maxAgeAction(ActionEvent event) {
        try{
            main.showMaxAgeOutput();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void maxHeightAction(ActionEvent event) {
        try{
            main.showMaxHeightOutput();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void maxSalaryAction(ActionEvent event) {
        try{
            main.showMaxSalaryOutput();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void sellPlayersAction(ActionEvent event) {
        try{
            main.showSellPlayer();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void totalSalaryAction(ActionEvent event) {
        try{
            main.showYearlySalary();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void refreshButtonAction(ActionEvent actionEvent) {
        //BuyPlayerTable.refresh();
        try{
            BuyRequest1 buyRequest1 = new BuyRequest1();
            buyRequest1.setClubName(clubName);
            main.getNetworkUtil().write(buyRequest1);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void buyButtonAction(ActionEvent actionEvent) {
        Player player = new Player();
        player = BuyPlayerTable.getSelectionModel().getSelectedItem();
        BuyRequest2 buyRequest2 = new BuyRequest2();
        buyRequest2.setPlayer(player);
        try{
            main.getNetworkUtil().write(buyRequest2);
        } catch (Exception e){
            e.printStackTrace();
        }
        player.setClubName(clubName);
        this.ClubPlayerList.add(player);
        main.setClubPlayerList(this.ClubPlayerList);
        BuyPlayerTable.getItems().removeAll(BuyPlayerTable.getSelectionModel().getSelectedItem());
    }
}
