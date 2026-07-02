package bigcoding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;


class HeadSet {

    private String headsetName;
    private String brand;
    private int price;
    private boolean available;

    public HeadSet(String headsetName, String brand, int price, boolean available) {
        this.headsetName = headsetName;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }

    public String getHeadsetName() {
        return headsetName;
    }

    public void setHeadsetName(String headsetName) {
        this.headsetName = headsetName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class HeadMain{
    public static int FTPFGB(HeadSet[] headset, String ibrand){
        int tprice = 0;
        for(HeadSet hs : headset){
            if(hs.getBrand().equalsIgnoreCase(ibrand)){
                tprice += hs.getPrice();
            }
        }
        return tprice;
    }
    public static HeadSet FAHWSMinP(HeadSet[] headset){

        ArrayList<HeadSet> list = new ArrayList<>();

        for(HeadSet hs : headset){
            if(hs.isAvailable()){
                list.add(hs);
            }
        }

        if(list.size() < 2){
            return null;
        }

        list.sort(Comparator.comparingInt(HeadSet::getPrice));

        return list.get(1);
    }
     public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        HeadSet[] headset = new HeadSet[4];

        for(int i=0;i<4;i++){
            String hsName = in.nextLine();
            String brand = in.nextLine();
            int price = Integer.parseInt(in.nextLine());
            boolean isAva = Boolean.parseBoolean(in.nextLine());

            headset[i] = new HeadSet(hsName, brand,price,isAva);
        }
        String ibrand = in.nextLine();

        System.out.println(FTPFGB(headset, ibrand));

        HeadSet res = FAHWSMinP(headset);
         if (res != null) {
             System.out.println(res.getHeadsetName());
             System.out.println(res.getPrice());

         }
         else{
             System.out.println(0);
         }

    }
}