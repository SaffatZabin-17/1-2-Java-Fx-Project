package FinalTermProject.DTO;

import FinalTermProject.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BuyRespond1 implements Serializable {
    public List<Player> BuyPlayerList = new ArrayList<>();

    public void setBuyPlayerList(List<Player> list){
        this.BuyPlayerList = list;
    }
    public List<Player> getBuyPlayerList(){
        return this.BuyPlayerList;
    }
}
