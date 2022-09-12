package FinalTermProject;

import java.awt.*;
import java.io.Serializable;
import java.util.*;

public class Player implements Serializable {
    private String Name;
    private String Country;
    private int age;
    private double height;
    private String ClubName;
    private String Position;
    private int JerseyNumber;
    private double WeeklySalary;
    private double playerValue;
    //private Button button;

    public Player(){
        this.Name = " ";
        this.Country = " ";
        this.age = 0;
        this.height = 0.0;
        this.ClubName = " ";
        this.Position = " ";
        this.JerseyNumber = 0;
        this.WeeklySalary = 0.0;
        this.playerValue = 0.0;
    }
    public Player(String Name, String Country, int age, double height, String ClubName, String Position, int JerseyNumber, double WeeklySalary){
        this.Name = Name;
        this.Country = Country;
        this.age = age;
        this.height = height;
        this.ClubName = ClubName;
        this.Position = Position;
        this.JerseyNumber = JerseyNumber;
        this.WeeklySalary = WeeklySalary;
    }
    public Player(String Name, String Country, int age, double height, String ClubName, String Position, int JerseyNumber, double WeeklySalary, double playerValue){
        this.Name = Name;
        this.Country = Country;
        this.age = age;
        this.height = height;
        this.ClubName = ClubName;
        this.Position = Position;
        this.JerseyNumber = JerseyNumber;
        this.WeeklySalary = WeeklySalary;
        this.playerValue = playerValue;
        //this.button = new Button("Buy");
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getName(){
        return this.Name;
    }
    public void setCountry(String Country){
        this.Country = Country;
    }
    public String getCountry(){
        return this.Country;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public double getHeight(){
        return this.height;
    }
    public void setClubName(String ClubName){
        this.ClubName = ClubName;
    }
    public String getClubName(){
        return this.ClubName;
    }
    public void setPosition(String Position){
        this.Position = Position;
    }
    public String getPosition(){
        return this.Position;
    }
    public void setJerseyNumber(int JerseyNumber){
        this.JerseyNumber = JerseyNumber;
    }
    public int getJerseyNumber(){
        return this.JerseyNumber;
    }
    public void setWeeklySalary(double WeeklySalary){
        this.WeeklySalary = WeeklySalary;
    }
    public double getWeeklySalary(){
        return this.WeeklySalary;
    }
    public void setPlayerValue(double playerValue){
        this.playerValue = playerValue;
    }
    public double getPlayerValue(){
        return this.playerValue;
    }

    public static Comparator<Player> PlayerSalary = new Comparator<Player>() {

        public int compare(Player s1, Player s2) {

            double sal1 = s1.getWeeklySalary();

            double sal2 = s2.getWeeklySalary();

            return (int) (sal2-sal1);
        }
    };

    public static Comparator<Player> PlayerAge = new Comparator<Player>() {

        public int compare(Player s1, Player s2) {

            int sal1 = s1.getAge();

            int sal2 = s2.getAge();

            return  (sal2-sal1);
        }
    };
}

