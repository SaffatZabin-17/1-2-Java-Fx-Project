package FinalTermProject.DTO;

import FinalTermProject.Player;

import java.io.Serializable;

public class BuyRequest2 implements Serializable {
    Player player;
    String clubName;

    public void setClubName(String name){
        this.clubName = name;
    }
    public String getClubName(){
        return this.clubName;
    }
    public void setPlayer(Player player){
        this.player = player;
    }
    public Player getPlayer(){
        return this.player;
    }
}
