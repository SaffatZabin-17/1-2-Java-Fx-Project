package FinalTermProject.DTO;

import java.io.Serializable;

public class LoginRequest implements Serializable {
    String clubName;

    public void setClubName(String name){
        this.clubName = name;
    }
    public String getClubName(){
        return this.clubName;
    }
}
