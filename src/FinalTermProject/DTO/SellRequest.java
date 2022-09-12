package FinalTermProject.DTO;

import FinalTermProject.Player;

import java.io.Serializable;

public class SellRequest implements Serializable {
    Player player;

    public void setPlayer(Player player){
        this.player = player;
    }
    public Player getPlayer(){
        return this.player;
    }
}
