////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//
import java.sql.SQLOutput;
import java.util.Scanner;

class TravelAgencies{
    private int reNo;
    private String agentName;
    private String pacType;
    private int price;
    private boolean flight;

    public TravelAgencies(int reNo, String agentName, String pacType, int price, boolean flight) {
        this.reNo = reNo;
        this.agentName = agentName;
        this.pacType = pacType;
        this.price = price;
        this.flight = flight;
    }

    public int getReNo() {
        return reNo;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getPacType() {
        return pacType;
    }

    public int getPrice() {
        return price;
    }
    public boolean isFlight() {
        return flight;
    }

}
public class Main {

    public static int FindAgHPp(TravelAgencies[] agents) {
        int max = agents[0].getPrice();
        for(TravelAgencies agent : agents){
            if(agent.getPrice() > max){
                max = agent.getPrice();
            }
        }
        return max;
    }

    public static TravelAgencies ADFGAT(TravelAgencies[] agencies, int regNo, String packType){

        for(TravelAgencies agent : agencies){
            if( agent.getReNo()==regNo && agent.getPacType().equalsIgnoreCase(packType) && agent.isFlight()){
                return agent;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TravelAgencies[] agencies = new TravelAgencies[4];

        for(int i=0;i<4;i++){
            int reNo = Integer.parseInt(in.nextLine());
            String aName = in.nextLine();
            String pType = in.nextLine();
            int price = Integer.parseInt(in.nextLine());
            boolean isFiy = Boolean.parseBoolean(in.nextLine());
            agencies[i] = new TravelAgencies(reNo, aName, pType, price,isFiy);
        }

        int regNo = Integer.parseInt(in.nextLine());
        String packType = in.nextLine();

        System.out.println(FindAgHPp(agencies));
        TravelAgencies agent =  ADFGAT(agencies,regNo,packType);
        if(agent != null)
            System.out.println(agent.getAgentName()+" : "+agent.getPrice());
        else
            System.out.println("No");



    }
}

