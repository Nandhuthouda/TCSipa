package bigcoding;

import java.util.HashMap;
import java.util.Scanner;

class AutonomousCar {
    private int carId;
    private String brand;
    private int nTests;
    private int nTestsP;
    private String env;
    String grade;

    public AutonomousCar(int carId, String brand, int nTests, int nTestsP, String env) {
        this.carId = carId;
        this.brand = brand;
        this.nTests = nTests;
        this.nTestsP = nTestsP;
        this.env = env;
    }

    public int getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public int getnTests() {
        return nTests;
    }

    public int getnTestsP() {
        return nTestsP;
    }

    public String getEnv() {
        return env;
    }
}
class AutonCarMain{
    public static int fingTestPassedByGEnv(AutonomousCar[] cars, String ienv){
        int sumtp = 0;
        for(AutonomousCar ac : cars){
            if(ac.getEnv().equalsIgnoreCase(ienv)){
                sumtp += ac.getnTestsP();
            }
        }
        return sumtp;
    }

    public static AutonomousCar findCarMatchesGivenBrand(AutonomousCar[] cars, String ibrand){
//        HashMap<AutonomousCar, String> map = new HashMap<>();

        for(AutonomousCar ac : cars){
            if(ac.getBrand().equalsIgnoreCase(ibrand)){
                int per = 0;
                per = (ac.getnTestsP()*100)/ac.getnTests();
                if(per>=80){
//                    map.put(ac, "A1");
                    ac.grade = "A1";
                    return ac;
                }

                else if(per>=55 && per<80){
//                    map.put(ac, "B2");
                    ac.grade = "B2";
                    return ac;
                }else{
//                    map.put(ac,"C3");
                    ac.grade = "c3";
                    return ac;
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        AutonomousCar[] cars = new AutonomousCar[4];
        for(int i=0;i<4;i++){
            int carId = Integer.parseInt(in.nextLine());
            String brand = in.nextLine();
            int nTests = Integer.parseInt(in.nextLine());
            int nTestsP = Integer.parseInt(in.nextLine());
            String env = in.nextLine();

            cars[i] = new AutonomousCar(carId, brand, nTests, nTestsP, env);
        }
        String ienv = in.nextLine();
        String ibrand = in.nextLine();
        System.out.println(fingTestPassedByGEnv(cars, ienv));

        AutonomousCar res =  findCarMatchesGivenBrand(cars, ibrand);
        if(res != null){
            System.out.println(res.getBrand()+":"+res.grade);
        }else{
            System.out.println("No Car Found");
        }
    }
}