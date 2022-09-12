package FinalTermProject.Server;

import FinalTermProject.DTO.*;
import FinalTermProject.Player;
import FinalTermProject.util.NetworkUtil;

import java.util.ArrayList;
import java.util.List;

public class ReadThreadServer implements Runnable {

    private Thread thread;
    private NetworkUtil networkUtil;
    List<Player> PlayerList;
    List<Player> SellPlayerList;

    public ReadThreadServer(NetworkUtil networkUtil, List<Player>PlayerList, List<Player> SellPlayerList){
        this.networkUtil = networkUtil;
        this.PlayerList = PlayerList;
        this.SellPlayerList = SellPlayerList;
        this.thread = new Thread(this);
        thread.start();
    }
    public void run(){
        try{
            while(true){
                Object o = networkUtil.read();
                if(o!=null){
                    if(o instanceof LoginRequest){
                        System.out.println(((LoginRequest) o).getClubName());
                        List<Player> ClubPlayerList = new ArrayList<>();
                        for(Player p: PlayerList){
                            if(p.getClubName().equals(((LoginRequest) o).getClubName())){
                                ClubPlayerList.add(p);
                            }
                        }
                        LoginRespond respond = new LoginRespond();
                        respond.setClubName(((LoginRequest) o).getClubName());
                        respond.setClubPlayerList(ClubPlayerList);
                        networkUtil.write(respond);
                    }
                    if(o instanceof SellRequest){
                        SellPlayerList.add(((SellRequest) o).getPlayer());
                    }
                    if(o instanceof BuyRequest1){
                        List<Player> SellPlayerListClub = new ArrayList<>();
                        for(Player p: SellPlayerList){
                            if(!p.getClubName().equals(((BuyRequest1) o).getClubName())){
                                SellPlayerListClub.add(p);
                            }
                        }
                        BuyRespond1 buyRespond1 = new BuyRespond1();
                        buyRespond1.setBuyPlayerList(SellPlayerListClub);
                        networkUtil.write(buyRespond1);
                    }
                    if(o instanceof BuyRequest2){
                        Player player = ((BuyRequest2) o).getPlayer();
                        String clubName = ((BuyRequest2) o).getClubName();
                        for(Player p: PlayerList){
                            if(p.getName().equals(player.getName())){
                                p.setClubName(clubName);
                            }
                        }
                        SellPlayerList.removeIf(p -> p.getName().equals(player.getName()));
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                networkUtil.closeConnection();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
