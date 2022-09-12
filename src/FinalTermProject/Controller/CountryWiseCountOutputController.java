package FinalTermProject.Controller;

import FinalTermProject.DTO.BuyRequest1;
import FinalTermProject.FileOperations;
import FinalTermProject.Main;
import FinalTermProject.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;

import java.util.*;

public class CountryWiseCountOutputController {

    private Main main;

    public void setMain(Main main){
        this.main = main;
    }

    public String club_name;

    public void setClub_name(String name){
        this.club_name = name;
    }

    List<Player>ClubPlayerList = new ArrayList<>();

    public void setClubPlayerList(List<Player>list){
        this.ClubPlayerList = list;
    }

    FileOperations fp = new FileOperations();
    List<Player> PlayerList = new ArrayList<>();

    public void load(){
        int k =0;
        String[] country = new String[ClubPlayerList.size()];
        for(Player p: ClubPlayerList){
            country[k] = p.getCountry();
            k++;
        }
        Set<String> temp = new LinkedHashSet<String>(Arrays.asList(country));
        String[] st = temp.toArray(new String[temp.size()]);
        int[] a = new int[st.length];
        for(int i=0;i< country.length;i++){
            for(int j=0;j<st.length;j++){
                if(country[i].equalsIgnoreCase(st[j])){
                    a[j]++;
                }
            }
        }
        for(int i =0;i<a.length;i++){
            CountListOutput.getItems().add(a[i]);
        }
        for(int i =0;i<st.length;i++){
            CountryListOutput.getItems().add(st[i]);
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
    private ListView<String> CountryListOutput;

    @FXML
    private ListView<Integer> CountListOutput;

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
            buyRequest1.setClubName(club_name);
            main.getNetworkUtil().write(club_name);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void dashboardButtonAction(ActionEvent event) {
        try{
            //ClubPlayerList.clear();
            main.showMainMenu(club_name, ClubPlayerList);
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
}
