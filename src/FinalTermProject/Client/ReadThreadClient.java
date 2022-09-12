package FinalTermProject.Client;

import FinalTermProject.Controller.MainMenuController;
import FinalTermProject.DTO.BuyRespond1;
import FinalTermProject.DTO.LoginRespond;
import FinalTermProject.Main;
import FinalTermProject.Player;
import FinalTermProject.util.NetworkUtil;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;

public class ReadThreadClient implements Runnable {

    private Thread thread;
    private Main main;

    public ReadThreadClient(Main main) {
        this.main = main;
        thread = new Thread(this);
        thread.start();
    }

    public List<Player> ClubPlayerList = new ArrayList<>();
    public List<Player> BuyPlayerList = new ArrayList<>();
    public String club_name;

    public void run() {
        try {
            while (true) {
                Object o = main.getNetworkUtil().read();
                if (o instanceof LoginRespond) {
                    ClubPlayerList = ((LoginRespond) o).getClubPlayerList();
                    club_name = ((LoginRespond) o).getClubName();
                    main.setClubPlayerList(ClubPlayerList);
                    main.Club = club_name;
                    System.out.println(club_name);
                    for(Player p: ClubPlayerList){
                        System.out.println(p.getName());
                    }
                    Platform.runLater(() -> {
                        try{
                            main.showMainMenu(club_name, ClubPlayerList);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    });
                }
                if(o instanceof BuyRespond1){
                    BuyPlayerList = ((BuyRespond1) o).getBuyPlayerList();
                    System.out.println(BuyPlayerList.size());
                    for(Player p: BuyPlayerList){
                        System.out.println(p.getName());
                    }
                    main.setBuyPlayerList(BuyPlayerList);
                    Platform.runLater(() -> {
                        try{
                            main.showBuyPlayer(BuyPlayerList);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                main.getNetworkUtil().closeConnection();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
