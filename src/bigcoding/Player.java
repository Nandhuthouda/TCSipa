package bigcoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player {
    private int player;
    private String skill;
    private String level;
    private int points;

    public Player(int player, String skill, String level, int points){
        this.player = player;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }

    public int getPlayer(){
        return player;
    }

    public String getSkill(){
        return skill;
    }

    public String getLevel(){
        return level;
    }

    public int getPoints(){
        return points;
    }
}

class PlayerMain{
    public static Player[] findPWS(Player[] play, String skill){

        ArrayList<Player> li = new ArrayList<>();
        for(Player p : play){
            if(p.getSkill().equalsIgnoreCase(skill) && p.getPoints()>=20){
                li.add(p);
            }
        }
        Collections.sort(li,(p1,p2)->p1.getPoints()-p2.getPoints());
        return li.toArray(new Player[0]);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        Player[] play = new Player[4];
        for(int i=0;i<4;i++){
            int player = Integer.parseInt(in.nextLine());
            String skill = in.nextLine();
            String level = in.nextLine();
            int points = Integer.parseInt(in.nextLine());

            play[i] = new Player(player, skill, level, points);
        }

        String skill = in.nextLine();

        Player[] result = findPWS(play, skill);

        if(result != null){
            for(Player p : result){
                System.out.println(p.getPlayer());
                System.out.println(p.getPoints());
            }
        }
        else{
            System.out.println("No Player Found");
        }
    }
}
