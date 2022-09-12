package FinalTermProject.Controller;

import FinalTermProject.DTO.BuyRequest1;
import FinalTermProject.FileOperations;
import FinalTermProject.Main;
import FinalTermProject.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainMenuController {
    public TableView<Player> MainMenuTable;

    private boolean init = true;

    private Main main;
    public void setMain(Main main){
        this.main = main;
    }
    public String passedClubName;
    public void setPassedClubName(String name){
        this.passedClubName = name;
    }
    public List<Player>ClubPlayerList = new ArrayList<>();
    public List<Player> BuyPlayerList = new ArrayList<>();

    public void setClubPlayerList(List<Player>list){
        this.ClubPlayerList = list;
    }
    public void setBuyPlayerList(List<Player>list){
        this.BuyPlayerList = list;
    }

    private void initializeColumns(){
        TableColumn<Player, String> nameTableOutput = new TableColumn<>("Name");
        nameTableOutput.setMinWidth(160);
        nameTableOutput.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<Player, String> countryTableOutput = new TableColumn<>("Country");
        countryTableOutput.setMinWidth(80);
        countryTableOutput.setCellValueFactory(new PropertyValueFactory<>("Country"));

        TableColumn<Player, Integer> ageTableOutput = new TableColumn<>("Age");
        ageTableOutput.setMinWidth(60);
        ageTableOutput.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Player, Double> heightTableOutput = new TableColumn<>("Height");
        heightTableOutput.setMinWidth(80);
        heightTableOutput.setCellValueFactory(new PropertyValueFactory<>("height"));

        TableColumn<Player, String> positionTableOutput = new TableColumn<>("Position");
        positionTableOutput.setMinWidth(60);
        positionTableOutput.setCellValueFactory(new PropertyValueFactory<>("Position"));

        TableColumn<Player, Integer> numberTableOutput = new TableColumn<>("Jersey Number");
        numberTableOutput.setMinWidth(80);
        numberTableOutput.setCellValueFactory(new PropertyValueFactory<>("JerseyNumber"));

        TableColumn<Player, Double> salaryTableOutput = new TableColumn<>("Weekly Salary");
        salaryTableOutput.setMinWidth(80);
        salaryTableOutput.setCellValueFactory(new PropertyValueFactory<>("WeeklySalary"));

        MainMenuTable.getColumns().addAll(nameTableOutput, countryTableOutput, ageTableOutput, heightTableOutput, positionTableOutput, numberTableOutput, salaryTableOutput);
    }

    public ObservableList<Player>getPlayers(){
        ObservableList<Player> players = FXCollections.observableArrayList();
        players.addAll(ClubPlayerList);
        return players;
    }

    public void load(){
        if(init){
            initializeColumns();
            init = false;
        }

        MainMenuTable.setEditable(true);
        MainMenuTable.setItems(getPlayers());
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
    private ImageView image;

    @FXML
    private Label totalPlayerCount;

    @FXML
    private Label totalSalary;

    @FXML
    private Label ClubNameShow;

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
        double salary = 0;
        for(Player p: ClubPlayerList){
            salary+=p.getWeeklySalary();
        }
        ClubNameShow.setText(passedClubName);
        totalPlayerCount.setText(String.valueOf(ClubPlayerList.size()));
        totalSalary.setText(String.valueOf(salary));
        if(passedClubName.equals("Manchester United")){
            Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Manchester_United.png")));
            image.setImage(img);
        }
        if(passedClubName.equals("Manchester City")){
            Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Manchester_City.png")));
            image.setImage(img);
        }
        if(passedClubName.equals("Chelsea")){
            Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Chelsea.png")));
            image.setImage(img);
        }
        if(passedClubName.equals("Liverpool")){
            Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Liverpool.png")));
            image.setImage(img);
        }
        if(passedClubName.equals("Arsenal")){
            Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Arsenal.png")));
            image.setImage(img);
        }
    }
}
