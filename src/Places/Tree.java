package Places;

import FunctionEtSystem.*;
import java.io.IOException;
import java.util.Scanner;

import static FunctionEtSystem.loadStats.Money;

public class Tree extends InheritMethod {
    Scanner con = new Scanner(System.in);
    loadStats stats = new loadStats();
    loadText say = new loadText();
    Inventory inv = new Inventory();
    carryMission Miss = new carryMission();

    String[] Action = {"Nap", "Climb", "Dig", "Bury"};
    public Tree() throws InterruptedException {

    }

    @Override
    public void choicePicker(int Lvl) throws InterruptedException, IOException {
        image1();
        String choice = availAction(Lvl);

        switch (choice){
            case "NAP" -> {
                Choice1();
            }
            case "CLIMB" -> {
                Choice2();
            }
            case "DIG" -> {
                Choice3();
            }
            case "BURY" -> {
                Choice4();
            }

        }
    }

    @Override
    public String availAction(int lvl) {
        boolean redo;
        String fin="";
        do {
            redo = false;

            System.out.print("Option: ");
            if (lvl >= 0) {
                System.out.print("[" + Action[0] + "], ");

                if (lvl >= 1) {
                    System.out.print("[" + Action[1] + "], ");

                    if (inv.lookingForItem("Shovel")) {
                        System.out.print("[" + Action[2] + "], ");

                        if ("buryTheDead".equalsIgnoreCase(Miss.showMission())) {
                            System.out.print("[" + Action[3] + "], ");
                        }
                    }
                }

            }

            //SAY something
            System.out.println();
            System.out.println("[SELECT]");
            String choice = con.nextLine();


            if (choice.equalsIgnoreCase("nap") && lvl >= 0) {
                fin = "NAP";
            } else if (choice.equalsIgnoreCase("climb") && lvl >= 1) {
                fin = "CLIMB";
            } else if (choice.equalsIgnoreCase("dig") && lvl >= 1) {
                fin = "DIG";
            } else if (choice.equalsIgnoreCase("bury") && lvl >= 2) {
                fin = "BURY";
            } else {
                redo = true;
            }
        } while (redo);

        return fin;
    }

    private void image1(){
        System.out.println("      UUUUUU  UUU UUUU  UUUUU UUUUUUU  UUUUUU UUUUUUU       ");
        System.out.println("          UUUUUUUUUU UUUU UUUUUUUUUUU  UUUUUU              ");
        System.out.println("             UUUUU UUUUU UUUUU  UUUUUUUUUU                  ");
        System.out.println("                  \\    \\   \\    _/   /                      ");
        System.out.println("                   |       _-|-'   __/                    ");
        System.out.println("                   \\   \\      __/                           ");
        System.out.println("                   /     ((O) \\`                          ");
        System.out.println("                 __|   .      |                            ");
        System.out.println("                /   ,         \\                            ");
        System.out.println("               /   /     |     \\                            ");
        System.out.println("..............|....|.....|......\\..........................");
    }

    private void Lvl0() throws IOException, InterruptedException {

        System.out.println("Kelf staring at the tree in thought:");
        System.out.println("OPTION: [Nap]");
        System.out.print("Select: ");
        String act = con.next();


        if (act.equalsIgnoreCase("Nap")){
            stats.setTime(2,true);
        }
    }


    @Override
    protected void Choice1() throws IOException, InterruptedException {
        say.narrate("Kelf went to sleep", 500, true, false);
        say.narrate(".", 500,false, false);
        say.narrate(".", 500,false, false);
        say.narrate(".", 500,false, false);

        stats.setTime(3,true);
    }

    @Override
    protected void Choice2() throws InterruptedException, IOException {
        say.narrate("Kelf is Climbing the tree.....", 500, true, true);
        int happen = (int) ((Math.random()*10)+1);

        if (happen >=4 && happen <=6) {
            say.narrate("Kelf picked an apple.", true, true);
            System.out.println("[Click Enter]"); con.nextLine();

            inv.add("apple");

        } else if ( happen >=0 && happen <=1) {
            say.narrate("He got $2", true, true);
            System.out.println("[Click Enter]"); con.nextLine();

            Money += 2;

        } else {
            say.narrate("Kelf fell off the tree!", true, true);
            System.out.println("[Click Enter]"); con.nextLine();

        }

        stats.setTime(1,true);

    }

    @Override
    protected void Choice3() {

    }

    @Override
    void Choice4() {

    }
}
