package Characters;

import FunctionEtSystem.*;

import java.io.IOException;
import java.util.Scanner;

import static FunctionEtSystem.carryMission.MissionTitle;
import static FunctionEtSystem.carryMission.status;

public class Worker extends InheritMethod{
    boolean newbie=true;
    loadText say;
    Scanner con = new Scanner(System.in);
    Inventory inv;
    carryMission job;
    loadStats stats = new loadStats();

    String[] Action = {"Work", "Take Mission"};

    public Worker(){

    }

    @Override
    public void checkLvl(int lvl) throws IOException, InterruptedException {

        int choice = this.availAction(lvl);

        switch (choice) {
            case 0 -> this.Lvl0();
            case 1 -> this.Lvl1();
            case 2 -> this.Lvl2();
            case 3 -> this.Lvl3();
            default -> {
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

            System.out.print("Option: ");

            if (lvl!=0) {
                if (lvl >= 1) { //take work
                    System.out.print("[" + Action[0] + "] ");

                    if (lvl == 3) { //Mysterious Box Mission
                        System.out.print("[" + Action[1] + "] ");

                    } else if (lvl == 2) { //Untold Business
                        System.out.print("[" + Action[1] + "] ");


                    }
                }

                System.out.println();
                System.out.println("[SELECT]");
                choice = con.nextLine();
            }

            if (lvl == 0) {
                fin = 0;
            } else if (choice.equalsIgnoreCase("Work") && lvl >= 1) {
                fin = 1;
            } else if (choice.equalsIgnoreCase("Take Mission") && lvl == 2) {
                fin = 2;
            } else if (choice.equalsIgnoreCase("Take Mission") && lvl == 3) {
                fin = 3;
            } else {
                redo = true;
            }
        } while (redo);

        return fin;
    }

    // Need to make an optional to work or other Matters
    @Override
    void Lvl0() throws IOException, InterruptedException {
        say.narrate("Worker: HEY! stay back! Contruction is ongoing here.", true, true);
        System.out.println("[Click Enter]"); con.nextLine();

        say.narrate("Worker: If you want something to say, just come to me when we have taken our break.", true, true);
        System.out.println("[Click Enter]"); con.nextLine();
    }

    @Override
    void Lvl1() throws IOException, InterruptedException {
        say.narrate("Worker: Hey, what do you want?", true, true);
        System.out.println("[Click Enter]"); con.nextLine();

        if (newbie) {
            say.narrate("Worker: Oh, you were told by him.", true, true);
            System.out.println("[Click Enter]");
            con.nextLine();

            say.narrate("Worker: Sure! why not. Atleast more work forces to finish our construction", true, true);
            System.out.println("[Click Enter]");
            con.nextLine();

            this.newbie = false;
        }

        say.narrate("Worker: Lets get working then", true, true);
        System.out.println("[Click Enter]"); con.nextLine();

        for (int i=0; i <15; i++){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            if (i%2 == 0){
                workImage1();
                Thread.sleep(100);
            } else {
                workImage2();
                Thread.sleep(300);
            }
        }

        stats.setTime(3, true);
        job.afterWork("", 13);

    }

    private void workImage1(){
        System.out.println("  _______                            ");
        System.out.println("  \\_ [] _\\                         ");
        System.out.println("     \\  \\                                   ");
        System.out.println("      \\  \\                        ");
        System.out.println("       \\__\\                               ");
        System.out.println("       /   `'.                       ");
        System.out.println("       \\   \\__\\                              ");
        System.out.println("        \\_|, `.\\___                           ");
        System.out.println("        / _. '+ ; \" \\                   ");
    }

    private void workImage2(){
        System.out.println("     _____                          ");
        System.out.println("     \\_ [] \\                       ");
        System.out.println("        \\   \\                       ");
        System.out.println("           \\   \\                    ");
        System.out.println("              \\ _ \\._   .  '   .  ' ");
        System.out.println("              /      \\   ,     ;     ");
        System.out.println("          _____\\   \\  \\  . +   `   ");
        System.out.println("         _|, `.\\\\   \\ /   '   .    ");
        System.out.println("        / _. '+ ;`'._/                ");
    }

    @Override
    void Lvl2() throws IOException, InterruptedException { // Untold Business


        if (!MissionTitle.equalsIgnoreCase("Untold Business" ) && !inv.lookingForItem("Wrapped Box")){
            say.narrate("Worker: Right on time, i really need someone to pass this item to someone", true, true);
            System.out.println("[Click Enter]");
            con.nextLine();

            say.narrate("Worker: Well its not that difficult to finish unless you dont make any mess. ", true, true);
            System.out.println("[Click Enter]");
            con.nextLine();


            say.narrate("Worker: So? would you take it?[Y/N]", true, true);
            System.out.println("[Click Enter]");
            String pick = con.nextLine();

            if (pick.equalsIgnoreCase("Y")){

                say.narrate("Worker: Good, I'll give you this item. Its packed, do not open it.", true, true);
                System.out.println("[Click Enter]");
                con.nextLine();

                say.narrate("Worker: This is a surprise box for his anniversary as our boss.", true, true);
                System.out.println("[Click Enter]");
                con.nextLine();

                say.narrate("Worker: I couldn't attend to him right now because i have a meeting to attend with the higher ups.", true, true);
                System.out.println("[Click Enter]");
                con.nextLine();


                say.levelUp("Clubhouse", "Search Paul");
                inv.add("Wrapped Box");
                carryMission.setMission("Untold Business");

            } else {
                say.narrate("Worker: better come back", true, true);
                System.out.println("[Click Enter]");
                con.nextLine();
            }


        }else if (MissionTitle.equalsIgnoreCase("Untold Business") && inv.lookingForItem("Wrapped Box")) {
            say.narrate("Worker: Huh? You haven't gave it to B.Henry?", true, true);
            System.out.println("[Click Enter]");
            con.nextLine();

            say.narrate("Worker: He is in the club. You can find him there.", true, true);
            System.out.println("[Click Enter]");
            con.nextLine();


        } else if (MissionTitle.equalsIgnoreCase("Untold Business") && status){
            say.narrate("Worker: Did you gave it to B.Henry? ", true, true);
            System.out.println("[Click Enter]"); con.nextLine();

            say.narrate("Worker: Good work, take this ", true, true);
            System.out.println("[Click Enter]"); con.nextLine();

            job.missionComplete("", 20);


        } else {
            say.narrate("Worker: Your still busy dumb ass", true,true);
            System.out.println("[Click Enter]");
            con.nextLine();
        }
    }


    static int Timer;
    @Override
    void Lvl3() throws IOException, InterruptedException { //Mysterious Box Mission
        if(MissionTitle.isEmpty() && !inv.lookingForItem("Sealed Box")){
            say.narrate("Worker: I need you right now, I can assure that i can trust you in this job.", true, true);
            System.out.println("[Click Enter]");
            con.nextLine();

            say.narrate("Worker: I have this packed box, it needs to be delivered safely on time. if not your dead meat to me.", true, true);
            System.out.println("[Click Enter]");
            con.nextLine();

            say.narrate("Worker: What would you say? [Y/N]", true, true);
            System.out.println("[Click Enter]");
            String respond = con.nextLine();

            if (respond.equalsIgnoreCase("Y")){
                say.narrate("Worker: Good, have this and make sure this must be buried in the Garden and no one must see it", true, true);
                System.out.println("[Click Enter]");
                con.nextLine();

                say.narrate("Worker: And there is one that must know about this. The Gardener", true, true);
                System.out.println("[Click Enter]");
                con.nextLine();

                say.narrate("Worker: Dont ask any questions. Just do your job.", true, true);

                say.levelUp("Garden", "Dig");
                inv.add("Sealed Box");
                carryMission.setMission("Mysterious Box");

            } else {
                say.narrate("Worker: Sure, Sure, take your time and come back if you have the energy.", true, true);
                System.out.println("[Click Enter]");
                con.nextLine();

            }

        } else if (MissionTitle.equalsIgnoreCase("Mysterious Box") && status){
            say.narrate("Worker: Well done, that's what i expect from you", true, true);
            System.out.println("[Click Enter]");
            con.nextLine();

            job.missionComplete("", 20);

        } else if (MissionTitle.equalsIgnoreCase("Mysterious Box") && inv.lookingForItem("Sealed Box")) {
            say.narrate("Worker: As i said, hide it in the GARDEN.", true, true);
            System.out.println("[Click Enter]");
            con.nextLine();
        }
    }

    @Override
    void Lvl4() throws IOException, InterruptedException {

    }

    @Override
    void Lvl5() throws IOException, InterruptedException {

    }

    @Override
    void randomEvent() throws IOException, InterruptedException {

    }
}
