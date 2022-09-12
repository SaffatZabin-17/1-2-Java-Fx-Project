package FinalTermProject.DTO;

import FinalTermProject.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BuyRequest1 implements Serializable {
    String clubName;

    public void setClubName(String name){
        this.clubName = name;
    }
    public String getClubName(){
        return this.clubName;
    }
}
