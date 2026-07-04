package bigcoding;

import java.util.Scanner;

public class NavalVessel {

    private int id;
    private String name;
    private int nvp;
    private int nvc;
    private String pur;
    private String grade;

    public NavalVessel(int id, String name, int nvp, int nvc, String pur) {
        this.id = id;
        this.name = name;
        this.nvp = nvp;
        this.nvc = nvc;
        this.pur = pur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNvp() {
        return nvp;
    }

    public void setNvp(int nvp) {
        this.nvp = nvp;
    }

    public int getNvc() {
        return nvc;
    }

    public void setNvc(int nvc) {
        this.nvc = nvc;
    }

    public String getPur() {
        return pur;
    }

    public void setPur(String pur) {
        this.pur = pur;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class NavalMain{
    public static int findAvgVoyages(NavalVessel[] naval, int iper){
        int comp = 0;
        int sum = 0;
        int cnt = 0;
        for(NavalVessel nv :naval){
            comp = (nv.getNvc()*100)/nv.getNvp();
            if(comp >= iper){
                sum += nv.getNvc();
                cnt++;
            }
        }
        if (cnt == 0) {
            return cnt;
        }
        return sum/cnt;
    }
    public static NavalVessel findVesselByGrade(NavalVessel[] naval, String ipur){
        int comp = 0;
        for(NavalVessel nv : naval){
            if(nv.getPur().equalsIgnoreCase(ipur)){
                comp = (nv.getNvc()*100)/nv.getNvp();
                if(comp>=80) {
                    nv.setGrade("Star");
                    return nv;
                }
                else if(comp>=55){
                    nv.setGrade("Leader");
                    return nv;
                }
                else{
                    nv.setGrade("Striver");
                    return nv;
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        NavalVessel[] naval = new NavalVessel[4];

        for(int i=0;i<4;i++){
            int Id = Integer.parseInt(in.nextLine());
            String Name = in.nextLine();
            int nvp = Integer.parseInt(in.nextLine());
            int nvc = Integer.parseInt(in.nextLine());
            String pur =  in.nextLine();

            naval[i] = new NavalVessel(Id, Name, nvp, nvc, pur);
        }
        int iper = Integer.parseInt(in.nextLine());
        String ipur = in.nextLine();
        System.out.println(findAvgVoyages(naval, iper));

        NavalVessel res =  findVesselByGrade(naval,ipur);
        if(res != null){
            System.out.println(res.getName()+":"+res.getGrade());
        }else{
            System.out.println("No Vessel Found");
        }
    }
}


