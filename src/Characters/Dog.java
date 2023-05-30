package Characters;

import FunctionEtSystem.Inventory;
import FunctionEtSystem.loadStats;
import FunctionEtSystem.loadText;
import MainLobby.GoHome;

import java.io.IOException;
import java.util.Scanner;

import static FunctionEtSystem.loadStats.Section1Rel;

public class Dog extends InheritMethod{
    private static volatile boolean running = true;
    loadText say = new loadText();
    GoHome home = new GoHome();
    loadStats stats = new loadStats();
    Scanner con = new Scanner(System.in);
    Inventory inv = new Inventory();
    String[] Action = {"Pet", "Give Bone", "Fetch", "Track Home"};
    static int exp = 0; static int max;
    public Dog() {
    }

    @Override
    public void checkLvl(int lvl) throws IOException, InterruptedException {
        if (lvl == 1){
            max = 50;
        } else if (lvl == 2){
            max = 70;
        } else if (lvl == 3){
            max = 100;
        } else if (lvl == 4){
            max = exp;
        }

        lvl = availAction(lvl);

        switch (lvl) {
            case 0 -> this.Lvl0();
            case 1 -> this.Lvl1();
            case 2 -> this.Lvl2();
            case 3 -> this.Lvl3();
            case 4 -> this.Lvl4();
            case 5 -> this.Lvl5();

            default -> {
            }
        }

        levelUpCheck();
    }

    private void levelUpCheck() throws IOException, InterruptedException {
        if (Section1Rel[3] == 1){
            if (exp >= max){
                Section1Rel[3] += 1;
                exp = 0;

                if (Section1Rel[3] == 2){
                    say.levelUp("Dog", "Give Bone");
                }
            }
        } else if (Section1Rel[3] == 2){
            if (exp >= max){
                Section1Rel[3] += 1;
                exp = 0;

                if (Section1Rel[3] == 3){
                    say.levelUp("Dog", "Fetch");
                }
            }
        } else if (Section1Rel[3] == 3){
            if (exp >= max){
                Section1Rel[3] += 1;
                exp = 0;

                if (Section1Rel[3] == 4){
                    say.levelUp("Dog", "Track Home");
                }
            }
        }
    }


    @Override
    int availAction(int lvl) throws IOException, InterruptedException {

        boolean redo; String choice= "";
        int fin=0;
        do {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            redo = false;

            say.expBar(exp, max);

            System.out.print("Option: ");

            if (lvl >= 0) { //Pet
                    System.out.print("[" + Action[0] + "] ");
            }
            if (lvl >= 2 && inv.lookingForItem("Bone")) { //Tame
                System.out.print("[" + Action[1] + "] ");

            }
            if (lvl >= 3 && inv.lookingForItem("Boomerang")) { //Fetch
                System.out.print("[" + Action[2] + "] ");

            }
            if (lvl >= 4) { //Track Home
                System.out.print("[" + Action[3] + "] ");

            }

            System.out.println();
            if (lvl ==4){
                System.out.print("Note:   ");
                if (!inv.lookingForItem("Bone")){System.out.print("You can feed the Dog with a Bone" + "\n\t");}
                if (!inv.lookingForItem("Boomerang")){System.out.print("You can play fetch the Dog with a Boomerang" + "\n\t");}
                System.out.print("You can go Home if you still have your pen from Home" + "\n\t");

            } else if (lvl == 3){
                System.out.print("Note:   ");
                if (!inv.lookingForItem("Bone")){System.out.print("You can feed the Dog with a Bone" + "\n\t");}
                if (!inv.lookingForItem("Boomerang")){System.out.print("You can play fetch the Dog with a Boomerang" + "\n\t");}

            } else if (lvl == 2) {
                System.out.print("Note:   ");
                if (!inv.lookingForItem("Bone")){System.out.print("You can feed the Dog with a Bone" + "\n\t");}
            }

            System.out.println();
                System.out.println("[SELECT]");
                choice = con.nextLine();

            if (choice.equalsIgnoreCase("Pet") && lvl >= 1) {
                fin = 1;
            } else if (choice.equalsIgnoreCase("Pet") && lvl == 0) {
                fin = 0;
            }else if (choice.equalsIgnoreCase("Give Bone") && lvl >= 2) {
                if (inv.lookingForItem("Bone")) {
                    fin = 2;
                } else {
                    System.out.println("You Need A Bone ");
                    Thread.sleep(1000);
                    redo = true;
                }
            } else if (choice.equalsIgnoreCase("Fetch") && lvl >= 3) {
                fin = 3;
            } else if (choice.equalsIgnoreCase("Track Home") && lvl >=4) {
                fin = 4;
            } else {
                redo = true;
            }
        } while (redo);


        return fin;
    }

    @Override
    void Lvl0() throws IOException, InterruptedException {// Bite
        int chance = (int)((Math.random()*20)+1);

        if (chance >= 8 && chance <=13){
            say.narrate("You Have Tamed the Dog", true, true);
            System.out.println("[Click Enter]"); con.nextLine();

            Section1Rel[3] = 1;
            say.levelUp("Dog", "Pet with care");
        } else {
            say.narrate("You got Bitten", 1500, true, true);
            say.narrate("You immediately, fell off the ground.", 500, true, true);

            say.narrate("",1000,true,true);
            stats.setTime(3,true);

        }
    }

    @Override
    void Lvl1() throws IOException, InterruptedException {//Pet
        int chance = (int)((Math.random()*5)+1);

        switch (chance){
            case 1 -> say.narrate("Kelt Pet the Dog in the head", 1000, true, true);
            case 2 -> say.narrate("Kelt Pet the Dog in the Tummy", 1000, true, true);
            case 3 -> say.narrate("Kelt Pet the Dog in the Back", 1000, true, true);
            case 4 -> say.narrate("Kelt Shaking Hands with the Dog", 1000, true, true);
            case 5 -> say.narrate("Kelt lifts the Dog", 1000, true, true);
        }

        int woof = (int)((Math.random()*3)+1);
        if (woof == 2){
            System.out.println("Dog: Woof Woof (Tails Wagging)");
            System.out.println("[Click Enter]"); con.nextLine();
            exp += 10;
        } else {
            exp += (int)((Math.random()*8)+5);
        }

        stats.setTime(1, true);


    }

    @Override
    void Lvl2() throws IOException, InterruptedException {//Feed
        say.narrate("Kelt gave the Bone to the Dog", true,true);
        System.out.println("[Click Enter]"); con.nextLine();

        int chances = (int)(Math.pow(loadStats.Oclock, 7));

        if (chances % 3 == 0){
            say.narrate("The Dog is not on the mood to take the bone.", true, true);
            System.out.println("[Click Enter]"); con.nextLine();
        } else {
            say.narrate("The Dog jumped and grabbed the bone.",true,true);
            System.out.println("[Click Enter]"); con.nextLine();

            say.narrate("The Dog bit the bone in every side of the bone.", true, true);
            System.out.println("[Click Enter]"); con.nextLine();

            inv.remove("bone", false);

            exp += (int) ((Math.random()*15)+20);
        }

    }

    @Override
    void Lvl3() throws IOException, InterruptedException {//Fetch
        say.narrate("You pulled out your boomerang then the Dog immediately stand up wagging its tail.", true, true);
        System.out.println("[Click Enter]"); con.nextLine();

        say.narrate("", true, false);
        System.out.println("Click Enter to Play Game"); con.nextLine();

        int[] p = {0, 0, 0, 0, 0};

        // Create and start a separate thread for the loop
        Thread loopThread = new Thread(() -> {
            String[] areana = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ",};



            boolean forward = true;


            for (int i=0; i<=4; i++) {
                int chance = (int) (Math.random() * 9);

                areana[chance] = "█";
                try {
                    areana[chance + 1] = "█";
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }

                int placeIndicator = (int)(Math.random()*9);
                while (running) {

                    //Function
                    for (int j = 0; j <= 9; j++) {
                        if (j == chance || j == chance + 1) {
                            continue;
                        }
                        areana[j] = " ";
                    }


                    if (placeIndicator == chance || placeIndicator == chance + 1) {
                        areana[placeIndicator] = "_";
                    } else {
                        areana[placeIndicator] = "|";
                    }

                    //Display Output
                    try {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } catch (InterruptedException | IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("\t\t\t\t\tP1:" + p[0] + " | " + "P2:" + p[1] + " | " + "P3:" + p[2] + " | " + "P4:" + p[3] + " | " + "P5:" + p[4] + " | ");
                    System.out.println("\t\t\t\t\t\t    [" + areana[0] + areana[1] + areana[2] + areana[3] + areana[4] + areana[5] + areana[6] + areana[7] + areana[8] + areana[9] + "]");
                    System.out.println("\t\t\t\t\t\t[PRESS ENTER TO THROW]");

                    //Clean Up

                    try {
                        Thread.sleep(70);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (forward) {
                        placeIndicator++;
                    } else {
                        placeIndicator--;
                    }

                    areana[chance] = "█";
                    try {
                        areana[chance + 1] = "█";
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }

                    if (placeIndicator >= 10) {
                        forward = false;
                        if (running) {
                            placeIndicator = 8;
                        }
                    } else if (placeIndicator < 0) {
                        forward = true;
                        if (running) {
                            placeIndicator = 1;
                        }
                    }
                }


                if (placeIndicator == chance || placeIndicator == chance+1){
                    p[i] = 6;
                } else if (placeIndicator == chance-1 || placeIndicator == chance+2) {
                    p[i] = 5;
                } else if (placeIndicator == chance-2 || placeIndicator == chance+3) {
                    p[i] = 4;
                } else if (placeIndicator == chance-3 || placeIndicator == chance+4) {
                    p[i] = 3;
                } else if (placeIndicator == chance-4 || placeIndicator == chance+5) {
                    p[i] = 2;
                } else if (placeIndicator <= chance-5 || placeIndicator >= chance+6) {
                    p[i] = 1;
                }

                running = true;
            }
        });


        loopThread.start();
        Scanner scanner = new Scanner(System.in);
        // Wait for Enter key press to stop the loop

        for (int k=0; k <= 4; k++){
            scanner.nextLine();

            running = false;
        }

        // Set the running flag to false to stop the loop


        // Wait for the loop thread to complete
        try {
            loopThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int total = 0;

        for (int i=0; i<=4; i++){
            total += p[i];
        }

        System.out.println("\t\t\t\t\t           You Earned: " + total + "exp");

        exp +=total;

        int brokeChance = (int)((Math.random()*10)+1);
        if (brokeChance >= 2 && brokeChance <= 5){
            System.out.println("\t\t\t\t\t         The Boomerang Broke");
            inv.remove("boomerang", false);
        }
        Thread.sleep(1500);
    }

    @Override
    void Lvl4() throws IOException, InterruptedException { // Go Home
        say.narrate("Kelt: I have tamed this Dog. Maybe i can go home if i still have my pen and let him sniff it", true, true);
        System.out.println("[Click Enter]"); con.nextLine();

        if (!inv.lookingForItem("Pen")){
            say.narrate("Kelt: What! no! my pen is gone", true, true);
            System.out.println("[Click Enter]"); con.nextLine();

            say.narrate("Kelt: I think i threw it in the trash bin in this park somewhere.", true, true);
            System.out.println("[Click Enter]"); con.nextLine();
        } else {

            say.narrate("Kelt grabbed the pen from the pocket and letting the dog sniff the Pen.",true,true);
            System.out.println("[Click Enter]"); con.nextLine();

            say.narrate("The Dog barks many times and leading the path.", true, true);
            System.out.println("[Click Enter]"); con.nextLine();

            home.dogEnding();
        }



    }

    @Override
    void Lvl5() throws IOException, InterruptedException {

    }

    @Override
    void randomEvent() throws IOException, InterruptedException {

    }
}