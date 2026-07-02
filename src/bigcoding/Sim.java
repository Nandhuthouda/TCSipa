package bigcoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Sim {
    private int id;
    private String com;
    private int bal;
    private double rps;
    private String cir;

    public Sim(int id, String com, int bal, double rps, String cir){
        this.id = id;
        this.com = com;
        this.bal = bal;
        this.rps = rps;
        this.cir = cir;
    }
    public int getId(){
        return id;
    }
    public String getCom(){
        return com;
    }
    public int getBal(){
        return bal;
    }
    public double getRps(){
        return rps;
    }
    public String getCir(){
        return cir;
    }
}
class SimMain{
    public static Sim[] matchAS(Sim[] sim, String icir){
        ArrayList<Sim> li = new ArrayList<>();
        for(Sim s : sim){
            if(s.getCir().equalsIgnoreCase(icir) && s.getBal() < 100 ){
                li.add(s);
            }
        }
        Collections.sort(li, (s1,s2)-> Double.compare(s1.getRps(),s2.getRps()));
        return li.toArray(new Sim[0]);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        Sim[] sim = new Sim[4];
        for(int i=0;i<4;i++){
            int id = Integer.parseInt(in.nextLine());
            String com = in.nextLine();
            int bal = Integer.parseInt(in.nextLine());
            double rps = Double.parseDouble(in.nextLine());
            String cir = in.nextLine();

            sim[i] = new Sim(id, com, bal, rps, cir);
        }
        String icir = in.nextLine();

        Sim[] result = matchAS(sim,icir);

        if(result != null){
            for(Sim s : result){
                System.out.println(s.getId());
                System.out.println(s.getCom());
            }
        }
        else{
            System.out.println("No Sim Found");
        }
    }

}

