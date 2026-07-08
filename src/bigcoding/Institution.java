package bigcoding;

import java.util.Scanner;

class Institution {

    private int id;
    private String name;
    private int placed;
    private int cleared;
    private String loc;
    private String grade;

    public Institution(int id, String name, int placed, int cleared, String loc) {
        this.id = id;
        this.name = name;
        this.placed = placed;
        this.cleared = cleared;
        this.loc = loc;
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

    public int getPlaced() {
        return placed;
    }

    public void setPlaced(int placed) {
        this.placed = placed;
    }

    public int getCleared() {
        return cleared;
    }

    public void setCleared(int cleared) {
        this.cleared = cleared;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class InstitutionMain{
    public static int findNoClearedByLoc(Institution[] institute, String iloc){
        int sum = 0;
        for(Institution ins : institute){
            if(ins.getLoc().equalsIgnoreCase(iloc)){
                sum += ins.getCleared();
            }
        }
        return sum;
    }
    public static Institution updateGrade(Institution[] institute, String iname){
        int rating = 0;
        for(Institution ins : institute){
            if(iname.equalsIgnoreCase(ins.getName())){
                rating = (ins.getPlaced()*100)/ins.getCleared();
                if(rating >= 80){
                    ins.setGrade("A");
                    return ins;
                }
                else if(rating >= 60){
                    ins.setGrade("B");
                    return ins;
                }
                else{
                    ins.setGrade("C");
                    return ins;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Institution[] institute = new Institution[4];

        for(int i=0;i<4;i++){
            int id = Integer.parseInt(in.nextLine());
            String name = in.nextLine();
            int placed = Integer.parseInt(in.nextLine());
            int cleared = Integer.parseInt(in.nextLine());
            String loc = in.nextLine();

            institute[i] = new Institution(id, name, placed, cleared, loc);
        }
        String iloc = in.nextLine();
        String iname = in.nextLine();
        System.out.println(findNoClearedByLoc(institute,iloc));
        Institution res = updateGrade(institute, iname);
        if(res != null){
            System.out.println(res.getName()+":"+res.getGrade());
        }
        else{
            System.out.println("No Institution Found");
        }
    }
}











