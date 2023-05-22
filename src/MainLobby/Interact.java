package MainLobby;

import java.io.IOException;
import java.util.*;
import FunctionEtSystem.*;

import static FunctionEtSystem.carryMission.*;


public class Interact {
    int section = 1;
    loadText say = new loadText();
    MapLocate render = new MapLocate();
    loadStats stats = new loadStats();
    ContactPlayers talk = new ContactPlayers();
    carryMission Miss = new carryMission();
    Inventory inv = new Inventory();

    

    public Interact(String data) throws InterruptedException, IOException{ // load data save
        stats.LoadSave(data);
        stats.setTime(7, false);
    }

    public void nowWhat1() throws InterruptedException, IOException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        try (Scanner con = new Scanner(System.in)) {

            String action = " "; String[] Sec = new String[5]; int[] giveLvl = new int[5];

            //TRIGGER EVENT

            stats.DisplayStats(true, true, false);
            System.out.println("[Mission: " + Miss.showMission()+ " - " + From + " ]");
            System.out.println("[Details: " + to_Do + " ]");

            switch (section) {
                case 1:
                    render.Section1();
                    say.LineBLine("Inventory: " +Arrays.toString(inv.showInv()));
                    System.out.println("Available: " + Arrays.toString(talk.S1));
                    break;
                case 2:
                    render.Section2();
                    say.LineBLine("Inventory: " +Arrays.toString(inv.showInv()));
                    System.out.println("Available: " + Arrays.toString(talk.S2));
                    break;
                case 3:
                    render.Section3();
                    say.LineBLine("Inventory: " +Arrays.toString(inv.showInv()));
                    System.out.println("Available: " + Arrays.toString(talk.S3));
                    break;
                case 4:
                    render.Section4();
                    say.LineBLine("Inventory: " +Arrays.toString(inv.showInv()));
                    System.out.println("Available: " + Arrays.toString(talk.S4));
                    break;
            }


            say.LineBLine("([GoTo] - go to other section in the park)");
            say.LineBLine("([MENU] - Setting)");
            say.narrate("Select: ", false, false);
            action = con.next();
            action = action.toUpperCase();

            switch (section) {
                case 1:
                    Sec = talk.S1;
                    giveLvl = loadStats.Section1Rel;
                    break;
                case 2:
                    Sec = talk.S2;
                    giveLvl = loadStats.Section2Rel;
                    break;
                case 3:
                    Sec = talk.S3;
                    giveLvl = loadStats.Section3Rel;
                    break;
                case 4:
                    Sec = talk.S4;
                    giveLvl = loadStats.Section4Rel;
                    break;
                default:
                    break;
            }

            int p=0;
            for (String check : Sec) {
                if ( action.equals(check)){
                    talk.Contact(check, section, giveLvl[p]);
                }
                p++;
            }
        

            if (action.equals("GOTO")){
                
                GoTo();
            } else if (action.equals("MENU")){
                MENU();
            } else {
                nowWhat1();
            }
        }
    }

    private void GoTo() throws InterruptedException, IOException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        try (Scanner con = new Scanner(System.in)) {
            int action1 = 0;

            switch (section) {
                case 1: render.Section1(); break;
                case 2: render.Section2(); break;
                case 3: render.Section3(); break;
                case 4: render.Section4(); break;
            }


            say.narrate("What section in the park would you visit? ", false, false);
            action1 = con.nextInt();


            switch (action1 > 0 && action1 < 5 ? 1 : 2) {
                case 1:
                    section = action1;
                    stats.setTime(1, true);
                    nowWhat1();
                break;
                case 2: Problem1(2); break;
            }
        }
        
    }

    private void Problem1(int whereMethod) throws InterruptedException, IOException {
        System.out.println("Input the correct option");
        Thread.sleep(300);

        if (whereMethod == 4){ //special for getting code 
            MENU();
        }

        switch (whereMethod) {
            case 1: nowWhat1(); break;
            case 2: GoTo(); break;
            case 3: MENU(); break;
        }
    }

    private void Reset(int whereMethod) throws InterruptedException, IOException{
        switch (whereMethod) {
            case 1: nowWhat1(); break;
            case 2: GoTo(); break;
            case 3: MENU(); break;
        }
    }

    private void MENU() throws InterruptedException, IOException{
        String respond;
        Scanner con = new Scanner(System.in);
            
            
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            say.LineBLine("X=======================X");
            say.LineBLine("\\          MENU         /");
            say.LineBLine("/                       \\");
            say.LineBLine("\\        [RESUME]       /");
            say.LineBLine("/     [Set LoadTick]    \\");
            say.LineBLine("\\     [Change Stats]    /");
            say.LineBLine("/ [Manipulate Mission]  \\");
            say.LineBLine("\\     [Set Inventory]   /");
            say.LineBLine("/                       \\");
            say.LineBLine("\\     [Get SaveCode]    /");
            say.LineBLine("/         [QUIT]        \\");
            say.LineBLine("\\                       /");
            say.LineBLine("X=======================X");
            say.narrate("Select: ", false, false);
            respond = con.nextLine();

            respond = respond.toUpperCase();
        switch (respond) {
            case "RESUME": nowWhat1(); break;
            case "SET LOADTICK":
                try {
                    say.currentTick();

                    say.narrate("What Tick speed you want to change: ", 0, false, false);
                    int tick = con.nextInt();
                    say.changeTick(tick);

                    Reset(3);
                } catch (Exception inputMismatException) {
                    Problem1(3);
                }
            break;

            case "CHANGE STATS":
                stats.showStats();
                say.narrate("Character: ", 0, false, false);
                String room = con.next();
                say.narrate("Change Level to: ", 0, false, false);
                int area = con.nextInt();
                stats.changeStats(room, area);
                Reset(3);
            break;

            case "MANIPULATE MISSION":
                //SetMission to
                //ClearMission
                String reply; boolean pass1=true; String done; String select;


                do {
                    do {
                        //For making boolean into a message
                        if (status){
                            done = "Finish";
                        } else {
                            done = "Unfinished";
                        }

                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                        say.LineBLine("X=======================X");
                        say.LineBLine("\\      Set Mission      /");
                        say.LineBLine("/                       \\");
                        say.LineBLine("\\     [Pick Mission]    /");
                        say.LineBLine("/     [Clear Mission]   \\");
                        say.LineBLine("\\       [Set Status]    /");
                        say.LineBLine("/                       \\");
                        say.LineBLine("\\                       /");
                        say.LineBLine("/         {BACK}        \\");
                        say.LineBLine("X=======================X");
                        System.out.println("[Mission: " + Miss.showMission()+ " - " + From + " ]");
                        System.out.println("[Details: " + to_Do + " ]");


                        System.out.println("[Status: " + done + "]");


                        System.out.print("\nSelect: ");
                        reply = con.nextLine();

                        reply = reply.toUpperCase();

                        if (reply.equalsIgnoreCase("Pick Mission")) {
                            pass1 = false;
                        } else if (reply.equalsIgnoreCase("Clear Mission")) {
                            pass1 = false;
                        } else if (reply.equalsIgnoreCase("Set status")) {
                            pass1 = false;
                        } else if (reply.equalsIgnoreCase("Back")) {
                            pass1 = false;
                        }

                    } while (pass1);

                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                    // Display all Mission list +++
                    if (reply.equalsIgnoreCase("Back")){
                        break;
                    }

                    System.out.println("    " + ListofMission[0][0] + "\t\t     " + ListofMission[0][1]);
                    System.out.println(ListofMission[1][0] + "\t\t" + ListofMission[1][1]);
                    System.out.println(ListofMission[2][0] + "\t\t" + ListofMission[2][1]);
                    System.out.println(ListofMission[3][0] + "\t\t" + ListofMission[3][1]);
                    System.out.println(ListofMission[4][0] + "\t\t" + ListofMission[4][1]);
                    System.out.println(ListofMission[5][0] + "\t\t" + ListofMission[5][1]);

                    System.out.println();

                    System.out.println("     " + ListofMission[0][2] + "\t\t     " + ListofMission[0][3]);
                    System.out.println(ListofMission[1][2] + "\t\t" + ListofMission[1][3]);
                    System.out.println(ListofMission[2][2] + "\t\t" + ListofMission[2][3]);
                    System.out.println(ListofMission[3][2] + "\t\t" + ListofMission[3][3]);
                    System.out.println(ListofMission[4][2] + "\t\t\t" + ListofMission[4][3]);
                    System.out.println(ListofMission[5][2] + "\t\t" + ListofMission[5][3]);

                    System.out.println();

                    System.out.println("     " + ListofMission[0][4] + "\t\t     " + ListofMission[0][5]);
                    System.out.println(ListofMission[1][4] + "\t\t" + ListofMission[1][5]);
                    System.out.println(ListofMission[2][4] + "\t\t" + ListofMission[2][5]);
                    System.out.println(ListofMission[3][4] + "\t\t" + ListofMission[3][5]);
                    System.out.println(ListofMission[4][4] + "\t\t" + ListofMission[4][5]);
                    System.out.println(ListofMission[5][4] + "\t\t" + ListofMission[5][5]);

                    System.out.println();

                    System.out.println("     " + ListofMission[0][6] );
                    System.out.println(ListofMission[1][6] );
                    System.out.println(ListofMission[2][6] );
                    System.out.println(ListofMission[3][6] );
                    System.out.println(ListofMission[4][6] );
                    System.out.println(ListofMission[5][6] );


                    System.out.println("[Mission: " + Miss.showMission()+ " - " + From + " ]");
                    System.out.println("[Details: " + to_Do + " ]");
                    System.out.println("[Status: " + done);



                    if (reply.equalsIgnoreCase("Pick Mission")) {

                        System.out.println();
                        System.out.print("Pick Mission: ");
                        select = con.nextLine();

                        setMission(select);


                    } else if (reply.equalsIgnoreCase("Clear Mission")) {

                        System.out.println();
                        System.out.print("Do you wish to clear the Mission? [Y/N] ");
                        select = con.nextLine();

                        if (select.equalsIgnoreCase("y")) {
                            clearMission();
                        }


                    } else if (reply.equalsIgnoreCase("Set Status")) {

                        System.out.println();

                        boolean error=true;
                        do {
                            System.out.print("Set Finish or Unfinished Status: ");
                            select = con.nextLine();

                            if (select.equalsIgnoreCase("Finish")) {
                                error = false;
                                status = true;
                            } else if (select.equalsIgnoreCase("Unfinished")) {
                                error = false;
                                status = false;
                            }

                        } while(error);
                    }


                } while (!reply.equalsIgnoreCase("Back"));

                Reset(3);
            break;


            case "SET INVENTORY":
                String reply1; boolean pass = true;
                do {
                    do {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                        say.LineBLine("X=======================X");
                        say.LineBLine("\\     Set Inventory     /");
                        say.LineBLine("/                       \\");
                        say.LineBLine("\\       [Add Item]      /");
                        say.LineBLine("/      [Remove Item]    \\");
                        say.LineBLine("\\                       /");
                        say.LineBLine("/         {BACK}        \\");
                        say.LineBLine("X=======================X");
                        System.out.println(Arrays.toString(inv.showInv()));


                        System.out.print("Select: ");
                        reply1 = con.nextLine();

                        reply1 = reply1.toUpperCase();

                        if (reply1.equalsIgnoreCase("add item")) {
                            pass = false;
                        } else if (reply1.equalsIgnoreCase("remove item")) {
                            pass = false;
                        } else if (reply1.equalsIgnoreCase("back")) {
                            pass = false;
                        }

                    } while (pass);

                    String Item;
                    if (reply1.equalsIgnoreCase("add item")) {

                        System.out.print("Enter name of Item to add: ");
                        Item = con.nextLine();

                        inv.add(Item);
                    } else if (reply1.equalsIgnoreCase("remove item")) {

                        System.out.print("Enter Name of Item to remove: ");
                        Item = con.nextLine();

                        inv.remove(Item, true);
                    }
                } while (!reply1.equalsIgnoreCase("BACK"));

                Reset(3);

            break;



            case "GET SAVECODE":
                String ingon = stats.SaveCode();
                say.narrate("[ " + ingon + " ]", false, false);
                System.out.println("[Click Enter]");
                con.nextLine();

                Problem1(4);
            break;

            case "QUIT": System.exit(0); break;
            default: Problem1(3); break;
        }
            
        con.close();
    }
}
