package com.alevel;
import java.util.Random;



public class Main {

    static final String locomotiveClassTitle = "locomotive";
    static final String FirstClassTitle = "passenger class 1";
    static final String SecondClassTitle = "passenger class 2";
    static final String cargoTitle = "cargo";




    String fromCity;
    String toCity;
    Coach locomotive;
    Coach[] cargoCoach;
    Coach[] FirstClass;
    Coach[] SecondClass;
    public Main(
            int FirstClassNumber,
            int SecondClassNumber,
            int cargoCoachNumber) {
        this.locomotive = new Coach(Main.locomotiveClassTitle);
        this.cargoCoach = new Coach[cargoCoachNumber];
        this.FirstClass = new Coach[FirstClassNumber];
        this.SecondClass = new Coach[SecondClassNumber];


        this.addCoach(Main.FirstClassTitle, FirstClassNumber);;
        this.addCoach(Main.SecondClassTitle, SecondClassNumber);
        this.addCoach(Main.cargoTitle, cargoCoachNumber);
    }

    @Override
    public String toString(){
        return "Train is going from " + this.fromCity + " to " + this.toCity + "/n" +
                "Train scheme: " + this.TrainScheme();
    }


    public String TrainScheme() {
        String trainSchemeDescribe = this.locomotive + "=";


        for (Coach coach: this.SecondClass) {
            if (coach != null) {
                trainSchemeDescribe += coach + "=";
            }
        }

        for (Coach coach: this.FirstClass) {
            if (coach != null) {
                trainSchemeDescribe += coach + "=";
            }
        }
        for (Coach coach: this.cargoCoach) {
            if (coach != null) {
                trainSchemeDescribe += coach + "=";
            }
        }

        return trainSchemeDescribe;
    }

    public void addCoach(Coach coach, int index) {
        if (coach.type.equals(Main.FirstClassTitle)) {
            this.FirstClass[index] = coach;
        } else if (coach.type.equals(Main.SecondClassTitle)) {
            this.SecondClass[index] = coach;
        } else if (coach.type.equals(Main.cargoTitle)) {
            this.cargoCoach[index] = coach;
        }
    }

    public void addCoach(String type, int coachNumber) {
        if (coachNumber > 0) {
            for (int i = 0; i < coachNumber; i++) {
                this.addCoach(new Coach(type), i);
            }
        }
    }



    public void paveTheWay(String fromCity, String toCity) {
        this.fromCity = fromCity;
        this.toCity = toCity;
    }


    public static class Coach {
        int load;
        String type;

        public Coach(String type) {
            this.type = type;
            this.load = this.generateRandomLoad();
        }



        @Override
        public String toString() {
            String loadFormat = "";
            if (this.type.equals(Main.cargoTitle)) {
                loadFormat = this.load + " % ";
            } else if (this.type.equals(Main.FirstClassTitle) || this.type.equals(Main.SecondClassTitle)) {
                loadFormat = "1 : " + this.load;
            }
            return " [: " + this.type + " : " + loadFormat +  " ] ";
        }


        public int generateRandomLoad() {
            int count = 100;
            if (this.type == Main.cargoTitle) {
                count = 100;
            } else if (this.type.equals(Main.FirstClassTitle)) {
                count = 100;
            } else if (this.type.equals(Main.SecondClassTitle)) {
                count = 200;
            } else if (this.type.equals(Main.locomotiveClassTitle)) {
                count = 1;
            }
            return new Random().nextInt(count);
        }

    }



    public static void main(String[] args) {
        Main train = new Main(1, 1, 1);
        train.paveTheWay("Kharkiv", "Kyiv");
        System.out.println(train);

        /*Coach sampleCoach = new Coach("cargo");
        System.out.println(sampleCoach);*/
    }
}
