package FunctionEtSystem;

import MainLobby.ContactPlayers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class loadStats {
    loadText say = new loadText();
    Inventory inv = new Inventory();
    public static int Oclock; String morning = "am";
    static int Tick = 1;

    public static int Money = 0;

    // [Tree, Oldman, Bench, Dog]
    static public int[] Section1Rel = {0,0,0,3};

    // [Boys, Bench, LuckyBox, Garden]
    static public int[] Section2Rel = {0,0,0,0};

    // [PLayGround, Woman, Guard, Worker, Picnic]
    static public int[] Section3Rel = {0,0,0,0,0};

    // [VendingMachine, Cat, FoodStall, ClubHouse, Restroom]
    static public int[] Section4Rel = {0,0,0,0,0};

    

    public loadStats() {

    }

    public void LoadSave(String Code){ //turn string to int
        int codeIndex = 0;

        for (int i=0; i<4; i++){
            Section1Rel[i] = Character.getNumericValue(Code.charAt(codeIndex));
            codeIndex++;
        }
        for (int i=0; i<4; i++){
            Section2Rel[i] = Character.getNumericValue(Code.charAt(codeIndex));
            codeIndex++;
        }
        for (int i=0; i<5; i++){
            Section3Rel[i] = Character.getNumericValue(Code.charAt(codeIndex));
            codeIndex++;
        }
        for (int i=0; i<5; i++){
            Section4Rel[i] = Character.getNumericValue(Code.charAt(codeIndex));
            codeIndex++;
        }

    }

    public String SaveCode(){
        String bot = "", bit;
        bit = Integer.toString(Section1Rel[0]); bot = bot.concat(bit);
        bit = Integer.toString(Section1Rel[1]); bot = bot.concat(bit);
        bit = Integer.toString(Section1Rel[2]); bot = bot.concat(bit);
        bit = Integer.toString(Section1Rel[3]); bot = bot.concat(bit);
        bit = Integer.toString(Section2Rel[0]); bot = bot.concat(bit);
        bit = Integer.toString(Section2Rel[1]); bot = bot.concat(bit);
        bit = Integer.toString(Section2Rel[2]); bot = bot.concat(bit);
        bit = Integer.toString(Section2Rel[3]); bot = bot.concat(bit);
        bit = Integer.toString(Section3Rel[0]); bot = bot.concat(bit);
        bit = Integer.toString(Section3Rel[1]); bot = bot.concat(bit);
        bit = Integer.toString(Section3Rel[2]); bot = bot.concat(bit);
        bit = Integer.toString(Section3Rel[3]); bot = bot.concat(bit);
        bit = Integer.toString(Section3Rel[4]); bot = bot.concat(bit);
        bit = Integer.toString(Section3Rel[0]); bot = bot.concat(bit);
        bit = Integer.toString(Section4Rel[1]); bot = bot.concat(bit);
        bit = Integer.toString(Section4Rel[2]); bot = bot.concat(bit);
        bit = Integer.toString(Section4Rel[3]); bot = bot.concat(bit);
        bit = Integer.toString(Section4Rel[4]); bot = bot.concat(bit);


        return bot;
    }

    public void DisplayStats(boolean Money, boolean Time, Boolean Inventory) throws InterruptedException, IOException{


        int temptime = Oclock;
        if (Money){
            System.out.print("Money = " + loadStats.Money);
        }
        if (Time) {
            if (Oclock >= 12){
                if (Oclock == 12) {
                    morning = "nn";
                } { morning = "pm";}
                temptime = Oclock - 12;
                
            }
            System.out.println("\t\t\t\tTime : " + temptime +":00"+morning);

            morning = "am";
        }
        if (Inventory) {
            say.narrate("Inventory: " + Arrays.toString(inv.showInv()), false, true);
        }

        //testing to check
        System.out.println(Arrays.toString(Section1Rel));
        System.out.println(Arrays.toString(Section2Rel));
        System.out.println(Arrays.toString(Section3Rel));
        System.out.println(Arrays.toString(Section4Rel));

    }

    
    public void showStats() throws InterruptedException, IOException{
        ContactPlayers name = new ContactPlayers();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        
        System.out.println("\t\tList of Character stats");
        System.out.print("Section 1: " + name.S1[0] +" ["+ Section1Rel[0] +"] \t\t"); System.out.print(name.S1[1] +" ["+ Section1Rel[1]+"] \t"); 
        System.out.print(name.S1[2] +" ["+ Section1Rel[2]+"] \t"); System.out.println(name.S1[3] +" ["+ Section1Rel[3]+"] "); 

        System.out.print("Section 2: " +name.S2[0] +" ["+ Section2Rel[0]+"] \t\t"); System.out.print(name.S2[1] +" ["+ Section2Rel[1]+"] \t"); 
        System.out.print(name.S2[2] +" ["+ Section2Rel[2]+"] \t"); System.out.println(name.S2[3] +" ["+ Section2Rel[3]+"] "); 

        System.out.print("Section 3: " +name.S3[0] +" ["+ Section3Rel[0]+"] \t"); System.out.print(name.S3[1] +" ["+ Section3Rel[1]+"] \t"); 
        System.out.print(name.S3[2] +" ["+ Section3Rel[2]+"] \t"); System.out.print(name.S3[3] +" ["+ Section3Rel[3]+"] \t"); 
        System.out.println(name.S3[4] +" ["+ Section3Rel[4]+"] ");

        System.out.print("Section 4: " +name.S4[0] +" ["+ Section4Rel[0]+"] \t"); System.out.print(name.S4[1] +" ["+ Section4Rel[1]+"] \t"); 
        System.out.print(name.S4[2] +" ["+ Section4Rel[2]+"] \t"); System.out.print(name.S4[3] +" ["+ Section4Rel[3]+"] \t"); 
        System.out.println(name.S4[4] +" ["+ Section4Rel[4]+"] \n");

        
    }


    public void changeStats(String room, int area) throws InterruptedException, IOException{
        room = room.toUpperCase();


        //once the script or plan for the route, add a limiter to their level
        switch (room) {
            case "TREE" -> Section1Rel[0] = area;
            case "OLDMAN" -> Section1Rel[1] = area;
            case "BENCH" -> {
                Section1Rel[2] = area;
                Section2Rel[1] = area;
            }
            case "DOG" -> Section1Rel[3] = area;
            case "BOYS" -> Section2Rel[0] = area;
            case "LUCKYBOX" -> Section2Rel[2] = area;
            case "GARDEN" -> Section2Rel[3] = area;
            case "PLAYGROUND" -> Section3Rel[0] = area;
            case "WOMAN" -> Section3Rel[1] = area;
            case "GAURD" -> Section3Rel[2] = area;
            case "WORKER" -> Section3Rel[3] = area;
            case "PICNIC" -> Section3Rel[4] = area;
            case "VENDINGMACHINE" -> Section4Rel[0] = area;
            case "CAT" -> Section4Rel[1] = area;
            case "FOODSTALL" -> Section4Rel[2] = area;
            case "CLUBHOUSE" -> Section4Rel[3] = area;
            case "RESTROOM" -> Section4Rel[4] = area;
            default -> say.narrate("Character does not exist!", 1, false, false);
        }
        
    }

    public void setTime(int Time, boolean setToAddition) throws InterruptedException, IOException{
        if (setToAddition){
            Oclock += Time;
            if ( Oclock >= 24) {

                say.narrate("Kelt went to sleep on the ground. Waking up in the next morning.", 3000, true, true);

                Oclock = 6;
            }
        } else {
            Oclock = Time;
        }
    }





}
