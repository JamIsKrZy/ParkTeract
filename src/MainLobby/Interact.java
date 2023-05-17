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

    

    public Interact(String data) throws InterruptedException, IOException{ // load data save
        stats.LoadSave(data);
        stats.setTime(7, false);
    }

    public void nowWhat1() throws InterruptedException, IOException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        try (Scanner con = new Scanner(System.in)) {

            String action = " "; String[] Sec = new String[5]; int[] giveLvl = new int[5];

            stats.DisplayStats(true, true, false);
            System.out.println("[Mission: " + Miss.showMission()+ " - " + From + " ]");
            System.out.println("[Details: " + to_Do + " ]");

            switch (section) {
                case 1:
                    render.Section1();
                    System.out.println("Available: " + Arrays.toString(talk.S1));
                    break;
                case 2:
                    render.Section2();
                    System.out.println("Available: " + Arrays.toString(talk.S2));
                    break;
                case 3:
                    render.Section3();
                    System.out.println("Available: " + Arrays.toString(talk.S3));
                    break;
                case 4:
                    render.Section4();
                    System.out.println("Available: " + Arrays.toString(talk.S4));
                    break;
            }

            say.narrate("([GoTo] - go to other section in the park)", false, true);
            say.narrate("([MENU] - Setting)", false, true);
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
                say.LineBLine("X=======================X");
                say.LineBLine("\\      Set Mission      /");
                say.LineBLine("/                       \\");
                say.LineBLine("\\     [Pick Mission]    /");
                say.LineBLine("/     [Clear Mission]    \\");
                say.LineBLine("\\      Set Mission      /");
                say.LineBLine("/                       \\");

            break;

            case "SET INVENTORY":

            break;



            case "GET SAVECODE":
                String ingon = stats.SaveCode();
                say.narrate("[ " + ingon + " ]", false, false);
                say.narrate("5....", 750, false, false);
                say.narrate("4....", 750, false, false);
                say.narrate("3....", 750, false, false);
                say.narrate("2....", 750, false, false);
                say.narrate("1....", 750, false, false);
                Problem1(4);
            break;

            case "QUIT": System.exit(0); break;
            default: Problem1(3); break;
        }
            
        con.close();
        
        

    }
}
