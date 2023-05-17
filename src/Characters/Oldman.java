package Characters;

import FunctionEtSystem.*;
import java.io.IOException;
import java.util.Scanner;


import static FunctionEtSystem.carryMission.missionComplete;
import static FunctionEtSystem.carryMission.setMission;
import static FunctionEtSystem.loadStats.*;

public class Oldman extends InheritMethod{
    loadText say = new loadText();
    Scanner scan = new Scanner(System.in);
    Inventory inv = new Inventory();

    public Oldman(){

    }

    @Override
    void Lvl0() throws IOException, InterruptedException {

        say.narrate("Oldman: Oh boy, having a day huh?", true, true);
        System.out.println("[Click Enter]"); scan.nextLine();

        say.narrate("Oldman: Can you give me an apple? just climb the tree. Anyone is permitted to climb the tree.", true, true);
        System.out.println("[Click Enter]"); scan.nextLine();

        if (!inv.lookingForItem("apple")) {

            say.narrate("Do you want to take this favor? [Y/N]", true, true);
            System.out.print("[SELECT]"); scan.nextLine();String respond = scan.nextLine();

            if (respond.equalsIgnoreCase("y")) {
                if (Section1Rel[0] < 1) {
                    say.levelUp("Tree", "Climb");
                    Section1Rel[0] = 1;
                }
                setMission(1, 2);
            } else {
                say.narrate("Oldman: Well too bad, come back if you hae the feeling to take my request.", true, true);
                System.out.println("[Click Enter]"); scan.nextLine();
            }

        } else {
            say.narrate("Oldman: Oh my, You have it! Thank you. Take this reward for a favor", 500, true, false);
            missionComplete("", 10);
            Section1Rel[1] = 1;
            say.levelUp("Oldman", "Willing to Help");
        }
    }

    @Override
    void Lvl1() throws IOException, InterruptedException {
        if (Section3Rel[3] < 1) {
            say.narrate("Oldman: Hey, i just realized your new here. Where do you live?", true, true);
            System.out.println("[Click Enter]");
            scan.nextLine();

            say.narrate("Oldman: So you got lost? Poor boy", true, true);
            System.out.print("[Click Enter]");
            scan.nextLine();

            say.narrate("Oldman: If you want to earn money, i know someone " +
                    "who works here and is open to anyone to work. " +
                    "He even pays those who help him. Try asking him out.", true, true);
            System.out.println("[Click Enter]");
            scan.nextLine();

            if (Section3Rel[3] < 1) {
                say.levelUp("Worker", "Work");
                Section3Rel[3] = 1;
            }
        } else {
            say.narrate("Oldman: When i was a boy this plac was used to be mud and dirt.",true,true);
            System.out.print("[Click Enter]"); scan.nextLine();

            say.narrate("Oldman: There was boys and cheerful chilfren throwing mud.",true,true);
            System.out.print("[Click Enter]"); scan.nextLine();

            say.narrate("Oldman: Well the place was full of dirt, there was also trees and animals, they would roam around" +
                    " when theres no people left in the place. ",true,true);
            System.out.print("[Click Enter]"); scan.nextLine();

            say.narrate("Oldman: Then when the terrorist came, the place was blown to bits like a war zone. Well it was a war after all" +
                    ", i forgot how it started. ",true,true);
            System.out.print("[Click Enter]"); scan.nextLine();

            say.narrate("Oldman: Well the point is be careful, \"DEATH\" does come in this place. This place aint some place for gathering. This place was" +
                    " used for a covering to the public. This place is not goog as it seems  ",true,true);
            System.out.print("[Click Enter]"); scan.nextLine();
        }




    }

    @Override
    void Lvl2() throws IOException, InterruptedException {
        if (inv.lookingForItem("Watering Can")){
            say.narrate("Oldman: I would like to request a favor. Of course there's a reward.", true, true);
            System.out.print("[Click Enter]"); scan.nextLine();

            say.narrate("Do you want to take the Favor? [Y/N]", true, true);
            System.out.print("[SELECT]"); String respond = scan.nextLine();

            if(respond.equalsIgnoreCase("y")){

            }

        }
    }

    @Override
    void Lvl3() {

    }

    @Override
    void randomEvent() throws IOException, InterruptedException {

    }
}
