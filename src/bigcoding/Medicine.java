package bigcoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Medicine {
    private String mName;
    private String batch;
    private String disease;
    private int price;

    public Medicine(String mName, String batch, String disease, int price){
        this.mName = mName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }

    public String getName(){
        return mName;
    }

    public String getBatch(){
        return batch;
    }

    public String getDisease(){
        return disease;
    }
    public int getPrice(){
        return price;
    }
}

class Main{
    public static ArrayList<Integer> getPByD(Medicine[] med, String idisease){

        ArrayList<Integer> li = new ArrayList<>();
        for(Medicine m : med){
            if(m.getDisease().equalsIgnoreCase(idisease)){
                li.add(m.getPrice());
            }
        }
        Collections.sort(li);
        return li;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        Medicine[] med = new Medicine[4];
        for(int i=0;i<4;i++){
            String mName = in.nextLine();
            String batch = in.nextLine();
            String disease = in.nextLine();
            int price = Integer.parseInt(in.nextLine());

            med[i] = new Medicine(mName, batch, disease, price);
        }

        String idisease = in.nextLine();

        ArrayList<Integer> res = new ArrayList<>();
        res = getPByD(med, idisease);
        for(Integer r : res){
            System.out.println(r);
        }
    }
}

