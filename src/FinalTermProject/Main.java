package FinalTermProject;

import FinalTermProject.Client.ReadThreadClient;
import FinalTermProject.Controller.*;
import FinalTermProject.util.NetworkUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    Stage stage;
    public String pl_name, pl_position, pl_country, Club;
    public double pl_minSalary, pl_maxSalary;
    boolean init = true;

    List<Player> PlayerList = new ArrayList<>();
    FileOperations fp = new FileOperations();
    List<Player> ClubPlayerList = new ArrayList<>();
    List<Player> BuyPlayerList = new ArrayList<>();
    private NetworkUtil networkUtil;
    private ReadThreadClient readThreadClient;

    public NetworkUtil getNetworkUtil(){
        return this.networkUtil;
    }
    public void setClubPlayerList(List<Player> list){
        this.ClubPlayerList = list;
    }
    public void setBuyPlayerList(List<Player> list){
        this.BuyPlayerList = list;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage = primaryStage;
        connectToServer();
        showLoginPage();
    }

    public void connectToServer() throws Exception{
        String serverAddress = "127.0.0.1";
        int serverPort = 44444;
        networkUtil = new NetworkUtil(serverAddress, serverPort);
        new ReadThreadClient(this);
    }

    public void showLoginPage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//LoginWindow.fxml"));
        Parent root = loader.load();

        LoginController loginController = loader.getController();
        loginController.setMain(this);

        stage.setTitle("Login");
        stage.setScene(new Scene(root,900.0,600.0));
        stage.show();
    }

    public void showMainMenu(String club, List<Player> list) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//MainMenu.fxml"));
        Parent root = loader.load();


        MainMenuController mainMenuController = loader.getController();
        mainMenuController.setMain(this);
        mainMenuController.setPassedClubName(club);
        mainMenuController.setClubPlayerList(list);
        mainMenuController.init();
        mainMenuController.load();

        stage.setTitle("Main Menu");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showPlayerNameInput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//PlayerNameInput.fxml"));
        Parent root = loader.load();

        PlayerNameInputController playerNameInputController = loader.getController();
        playerNameInputController.setMain(this);
        playerNameInputController.setClubPlayerList(ClubPlayerList);
        playerNameInputController.setPassedClubName(Club);

        stage.setTitle("Player Name Search");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showPlayerNameOutput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//PlayerNameOutput.fxml"));
        Parent root = loader.load();

        PlayerNameOutputController playerNameOutputController = loader.getController();
        playerNameOutputController.setMain(this);
        playerNameOutputController.setClubPlayerList(ClubPlayerList);
        playerNameOutputController.setName(pl_name);
        playerNameOutputController.setClubName(Club);
        playerNameOutputController.init();

        stage.setTitle("Player Name Output");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showCountryInput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//PlayerCountryInput.fxml"));
        Parent root = loader.load();

        PlayerCountryInputController playerCountryInputController = loader.getController();
        playerCountryInputController.setMain(this);
        playerCountryInputController.setClubPlayerList(ClubPlayerList);
        playerCountryInputController.setPassedClubName(Club);

        stage.setTitle("Player Country search");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showCountryOutput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//PlayerCountryOutput.fxml"));
        Parent root = loader.load();

        PlayerCountryOutputController playerCountryOutputController = loader.getController();
        playerCountryOutputController.setMain(this);
        playerCountryOutputController.setPassedClubName(Club);
        playerCountryOutputController.setClubPlayerList(ClubPlayerList);
        playerCountryOutputController.setPlayerCountry(pl_country);
        playerCountryOutputController.load();

        stage.setTitle("Player Country Output");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showPositionInput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//PlayerPositionInput.fxml"));
        Parent root = loader.load();

        PlayerPositionInputController playerPositionInputController = loader.getController();
        playerPositionInputController.setMain(this);
        playerPositionInputController.setClubPlayerList(ClubPlayerList);
        playerPositionInputController.setClubName(Club);

        stage.setTitle("Player Position Search");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showPositionOutput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//PlayerPositionOutput.fxml"));
        Parent root = loader.load();

        PlayerPositionOutputController playerPositionOutputController = loader.getController();
        playerPositionOutputController.setMain(this);
        playerPositionOutputController.setClubPlayerList(ClubPlayerList);
        playerPositionOutputController.setPlayerPosition(pl_position);
        playerPositionOutputController.setPassedClubName(Club);
        playerPositionOutputController.load();

        stage.setTitle("Player Position Output");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showSalaryInput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//PlayerSalaryInput.fxml"));
        Parent root = loader.load();

        PlayerSalaryInputController playerSalaryInputController = loader.getController();
        playerSalaryInputController.setMain(this);
        playerSalaryInputController.setClubPlayerList(ClubPlayerList);
        playerSalaryInputController.setClubName(Club);

        stage.setTitle("Player Salary Search");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showSalaryOutput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//PlayerSalaryOutput.fxml"));
        Parent root = loader.load();

        PlayerSalaryOutputController playerSalaryOutputController = loader.getController();
        playerSalaryOutputController.setMain(this);
        playerSalaryOutputController.setClubPlayerList(ClubPlayerList);
        playerSalaryOutputController.setSalary(pl_minSalary, pl_maxSalary);
        playerSalaryOutputController.setClubName(Club);
        playerSalaryOutputController.load();

        stage.setTitle("Player Salary Output");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showCountryWisePlayerCountOutput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//CountryWisePlayerCount.fxml"));
        Parent root = loader.load();

        CountryWiseCountOutputController countryWiseCountOutputController = loader.getController();
        countryWiseCountOutputController.setMain(this);
        countryWiseCountOutputController.setClub_name(Club);
        countryWiseCountOutputController.setClubPlayerList(ClubPlayerList);
        countryWiseCountOutputController.load();

        stage.setTitle("Country Wise Player Output");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showMaxSalaryOutput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//MaxSalaryOutput.fxml"));
        Parent root = loader.load();

        MaxSalaryOutputController maxSalaryOutputController = loader.getController();
        maxSalaryOutputController.setMain(this);
        maxSalaryOutputController.setClubPlayerList(ClubPlayerList);
        maxSalaryOutputController.setClubName(Club);
        maxSalaryOutputController.load();

        stage.setTitle("Max Salary Output");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showMaxAgeOutput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//MaxAgeOutput.fxml"));
        Parent root = loader.load();

        MaxAgeOutputController maxAgeOutputController = loader.getController();
        maxAgeOutputController.setMain(this);
        maxAgeOutputController.setClubPlayerList(ClubPlayerList);
        maxAgeOutputController.setClubName(Club);
        maxAgeOutputController.load();

        stage.setTitle("Max Age Output");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showMaxHeightOutput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//MaxHeightOutput.fxml"));
        Parent root = loader.load();

        MaxHeightOutputController maxHeightOutputController = loader.getController();
        maxHeightOutputController.setMain(this);
        maxHeightOutputController.setClubPlayerList(ClubPlayerList);
        maxHeightOutputController.setClubName(Club);
        maxHeightOutputController.load();

        stage.setTitle("Max Height Output");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showYearlySalary() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//TotalYearlySalary.fxml"));
        Parent root = loader.load();

        YearlySalaryOutputController yearlySalaryOutputController = loader.getController();
        yearlySalaryOutputController.setMain(this);
        yearlySalaryOutputController.setClubPlayerList(ClubPlayerList);
        yearlySalaryOutputController.setClubName(Club);
        yearlySalaryOutputController.init();

        stage.setTitle("Total Yearly Salary Output");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showBuyPlayer(List<Player> BuyPlayerList) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//BuyPlayer.fxml"));
        Parent root = loader.load();

        BuyPlayerController buyPlayerController = loader.getController();
        buyPlayerController.setMain(this);
        buyPlayerController.setClubName(Club);
        buyPlayerController.setClubPlayerList(ClubPlayerList);
        buyPlayerController.setBuyPlayerList(BuyPlayerList);
        buyPlayerController.load();

        stage.setTitle("Buy Player");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public void showSellPlayer() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML//SellPlayer.fxml"));
        Parent root = loader.load();

        SellPlayerController sellPlayerController = loader.getController();
        sellPlayerController.setMain(this);
        sellPlayerController.setClubPlayerList(ClubPlayerList);
        sellPlayerController.setClubName(Club);

        stage.setTitle("Sell Player");
        stage.setScene(new Scene(root, 900.0, 600.0));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
