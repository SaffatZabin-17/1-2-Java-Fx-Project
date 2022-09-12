package FinalTermProject.DTO;

import FinalTermProject.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoginRespond implements Serializable {
    private String clubName;

    List<Player> ClubPlayerList;

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setClubPlayerList(List<Player> clubPlayerList) {
        ClubPlayerList = clubPlayerList;
    }

    public String getClubName() {
        return clubName;
    }

    public List<Player> getClubPlayerList() {
        return ClubPlayerList;
    }
}