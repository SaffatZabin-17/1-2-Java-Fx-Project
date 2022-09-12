package FinalTermProject.Server;

import FinalTermProject.Client.ReadThreadClient;
import FinalTermProject.FileOperations;
import FinalTermProject.Player;
import FinalTermProject.util.NetworkUtil;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket;
    List<Player> PlayerList = new ArrayList<>();
    FileOperations fp = new FileOperations();
    List<Player> SellPlayerList = new ArrayList<>();

    public Server(){
        try{
            PlayerList = fp.ReadFromFile();
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            serverSocket = new ServerSocket(44444);
            while(true){
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void serve(Socket clientSocket) throws Exception{
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        new ReadThreadServer(networkUtil, PlayerList, SellPlayerList);
    }
    public static void main(String[] args) {
        Server server = new Server();
    }
}
