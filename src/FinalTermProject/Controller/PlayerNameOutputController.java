package FinalTermProject.Controller;

import FinalTermProject.DTO.BuyRequest1;
import FinalTermProject.FileOperations;
import FinalTermProject.Main;
import FinalTermProject.Player;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerNameOutputController {

    private Main main;

    public void setMain(Main main){
        this.main = main;
    }
    public String playerName;
    public void setName(String name){
        this.playerName = name;
    }
    public String passedClubName;
    public void setClubName(String name){
        this.passedClubName = name;
    }
    List<Player> ClubPlayerList = new ArrayList<>();

    public void setClubPlayerList(List<Player>list){
        this.ClubPlayerList = list;
    }
    boolean isEmpty = false;

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
    private Button ExitButton;

    @FXML
    private Button SellPlayers;

    @FXML
    private Button BuyPlayers;

    @FXML
    private Button DashboardButton;

    @FXML
    private TextField PlayerNameInput;

    @FXML
    private Button SearchButton;

    @FXML
    private Button ResetButton;

    @FXML
    private Label PlayerNameOutput;

    @FXML
    private Label PlayerCountryOutput;

    @FXML
    private Label PlayerAgeOutput;

    @FXML
    private Label PlayerHeightOutput;

    @FXML
    private Label PlayerClubOutput;

    @FXML
    private Label PlayerPositionOutput;

    @FXML
    private Label PlayerNumberOutput;

    @FXML
    private Label PlayerSalaryOutput;

    @FXML
    private ImageView image;

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
            main.showPlayerNameInput();
        } catch (Exception e){
            System.out.println(e);
        }
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
    void playerNameInput(ActionEvent event) {

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

    }

    public void init(){
        for(Player p: ClubPlayerList){
            if(p.getName().equals(playerName)){
                PlayerNameOutput.setText(p.getName());
                PlayerCountryOutput.setText(p.getCountry());
                PlayerAgeOutput.setText(String.valueOf(p.getAge()));
                PlayerHeightOutput.setText(String.valueOf(p.getHeight()));
                PlayerClubOutput.setText(p.getClubName());
                PlayerPositionOutput.setText(p.getPosition());
                PlayerNumberOutput.setText(String.valueOf(p.getJerseyNumber()));
                PlayerSalaryOutput.setText(String.valueOf(p.getWeeklySalary()));
                if(p.getName().equals("David de Gea")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//David_de_Gea.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Harry Maguire")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Harry_Maguire.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Paul Pogba")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Paul_Pogba.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Bruno Fernandes")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Bruno_Fernandes.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Edinson Cavani")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Edinson_Cavani.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Ederson")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Ederson.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Ruben Dias")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Ruben_Dias.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Kevin De Bruyne")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Kevin_De_Bruyne.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Ilkay Gundogan")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Ilkay_Gundogan.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Raheem Sterling")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Raheem_Sterling.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Edouard Mendy")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Edouard_Mendy.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Cesar Azpilicueta")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Cesar.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("N'Golo Kante")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Kante.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Jorginho")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Jorginho.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Timo Werner")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Timo_Werner.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Alisson")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Alisson.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Virgil van Dijk")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Virgil_van_Dijk.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Jordan Henderson")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Jordan_Henderson.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Thiago Alcantara")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Thiago_Alcantara.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Mohamed Salah")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Mohamed_Salah.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Bernd Leno")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Bernd_Leno.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Hector Bellerin")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Hector_Bellerin.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Granit Xhaka")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Granit_Xhaka.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Thomas Partey")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Thomas_Partey.png")));
                    image.setImage(img);
                }
                if(p.getName().equals("Pierre-Emerick Aubameyang")){
                    Image img = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("Pictures//Aubameyang.png")));
                    image.setImage(img);
                }
                break;
            }
        }
    }

}

