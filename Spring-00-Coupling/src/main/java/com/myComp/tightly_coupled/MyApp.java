package com.myComp.tightly_coupled;

public class MyApp {

    public static void main(String[] args) {
        FullTimeMentor fullTimeMentor=new FullTimeMentor();
        PartTimeMentor partTimeMentor=new PartTimeMentor();


        Mentor mentor=new Mentor(fullTimeMentor,partTimeMentor); //MI
        mentor.manageAccount();

    }
}
