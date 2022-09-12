package FinalTermProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    public final String INPUT_FILE_NAME = "players.txt";
    public final String OUTPUT_FILE_NAME = "players.txt";

    public List<Player> ReadFromFile() throws Exception{
        List<Player> PlayerList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        String line;
        while(true){
            line = br.readLine();
            if(line == null){
                break;
            }
            String[] tokens = line.split(",");
            Player p = new Player();
            p.setName(tokens[0]);
            p.setCountry(tokens[1]);
            p.setAge(Integer.parseInt(tokens[2]));
            p.setHeight(Double.parseDouble(tokens[3]));
            p.setClubName(tokens[4]);
            p.setPosition(tokens[5]);
            p.setJerseyNumber(Integer.parseInt(tokens[6]));
            p.setWeeklySalary(Double.parseDouble(tokens[7]));
            PlayerList.add(p);
        }
        br.close();
        return PlayerList;
    }

    public List<String> read() throws Exception{
        List<String> clubList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        String line;
        while(true){
            line = br.readLine();
            if(line==null){
                break;
            }
            String[] tokens = line.split(",");
            String club = tokens[4];
            clubList.add(club);
        }
        br.close();
        return clubList;
    }
    public void WriteToFile(List<Player> PlayerList) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for(Player p : PlayerList){
            bw.write(p.getName()+","+p.getCountry()+","+p.getAge()+","+p.getHeight()+","+p.getClubName()+","+p.getPosition()+","+p.getJerseyNumber()+","+p.getWeeklySalary());
            bw.write("\n");
        }
        bw.close();
    }
}
