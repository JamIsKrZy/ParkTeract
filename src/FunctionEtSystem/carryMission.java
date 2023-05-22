package FunctionEtSystem;


import java.io.IOException;

import static FunctionEtSystem.loadStats.Money;

public class carryMission {
    static loadText say = new loadText();
    static Inventory inv = new Inventory();

    public static String MissionTitle = ""; public static String From;
    public static String to_Do=""; public static boolean status;
                                            //0                1                     2                  3                     4                     5                   6
    public static
    final String[][] ListofMission = {{"Kelf[Me]",              "Oldman",          "Boys",           "Woman",              "Guard",             "Worker",             "Cat"},
                                        {"buryTheDead",     "Oldman's Apple",   "beTheMeanest",   "Golden Necklace",     "Kid Gone",       "Untold Business",   "Alien on the Spot" },
                                        {"CatchTheCulprit", "Water my Babies",  "Caty Shocky",      "Poor SoftPur",       "Greedy Dog",     "Mysterious Box",      "Spooky Truth?" },
                                        {"",                     "",         "Unexpected Impasse",   "Friendship",       "Stick Pass",            "Work",            "Born to Die"},
                                        {"",                     "",                "",               "Hufty",         "Smelly Culprit",            "",            "Cyber Realm?"},
                                        {"",                     "",                "",                 "",           "Job on the Hunt",            "",                 ""}};
    
    private 
    static
    final String[][] Details =   {{"Kelf",
                                    "Oldman",
                                    "Boys",
                                    "Woman",
                                    "Guard",
                                    "Worker",
                                    "Cat"},
                                    
                                    //1st Row
                                    {"Find a place to Cover the dead body, you need a shovel to dig and shove the dead body.",
                                    "The Oldman wants a apple. Go to the tree and climb to get an apple.",
                                    "Go to the playground and set some traps and trolls.",
                                    "Find the Necklace in Section 3 of the Park.",
                                    "Find Boy Timmy in the Park. He cant be found at night",
                                    "Pass the Packaged Box to B.Henry in the Clubhouse ",
                                    "aLiEN arE laer? oR Am I DrNK? Better find CTFoud."},
                                    
                                    //2nd Row
                                    {"Someone stole your stuff. Find him in the park.",
                                    "The oldman's flowers need some bath. Water them with your watering can.",
                                    "Tazer the Cat in Section 4.",
                                    "Give Cat Shelter and Food.",
                                    "Buy the Guard with 2 Ice Cream and a Coffee",
                                    "Hide the Item in the Garden and inform the Gardener.",
                                    "Crazy beast wants me a Ghost! how could i catch it? and WHERE?"},

                                    //3rd Row
                                    {"",
                                    "",
                                    "Help the Boys get our of the Park. Go to Section 4 and their Exit is at the back of the Restroom.",
                                    "Go to a place with her to bond each other.",
                                    "Give the Support Stick to the oldman in Section 1.",
                                    "",
                                    "Help kill the Assassins in the Park."},

                                    //4th Row
                                    {"",
                                    "",
                                    "",
                                    "Treat the cat with a fish in each 5 days.",
                                    "Find the Culprit/s who sells drugs. Once found, report when they will meet.",
                                    "",
                                    "Huh? Kuldurb? what is that Cat? from the Future? Better Find its missing Items."},
                                    //5th Row
                                    {"","","","","Go to each places in the Park and return to the Guard.", "", ""}};

    public String showMission(){

        if(MissionTitle.isEmpty()){
            return "Nothing";
        } else {
            return MissionTitle;
        }

    }

    public static void clearMission(){

        if (MissionTitle.isEmpty()){
            System.out.println("Mission is already empty!");

        } else{
            MissionTitle = "";
            From = "";
            to_Do = "";
            status = false;
        }
    }

    public static void setMission(String Title) throws InterruptedException, IOException {

        if (MissionTitle.isEmpty()){
            boolean done=false;

            for (int i=0; i <=5 ; i++){
                for (int j=0; j <= 6; j++){
                    if (Title.equalsIgnoreCase(ListofMission[i][j])){
                        MissionTitle = ListofMission[i][j];
                        From = ListofMission[0][j];
                        to_Do = Details[i][j];
                        status = false;
                        done = true;
                        break;
                    }
                }
                if (done){
                    break;
                }
            }
            if (!done){
                System.out.println(Title + " is not found in the Mission List");
                Thread.sleep(1000);
            }


        } else {
            say.narrate("You are in a Mission right now!\nFinish what you started.",true,true);
            Thread.sleep(500);
        }

    }

    public static void actionDone(String missionCheck, Boolean setStatus){

    }

    public void missionComplete(String reward, int moneyh) throws InterruptedException, IOException {
        Money += moneyh;
        inv.add(reward);
        String Item="";

        if (!reward.isEmpty() && moneyh!=0){
            Item = "$" + moneyh + " and "+ reward;
        } else if (!reward.isEmpty() && moneyh==0){
            Item = reward;
        } else if (reward.isEmpty() && moneyh!=0) {
            Item = "$" + moneyh;
        } else {
            Item = "Nothing";
        }

        String line = "[ "+"Congratulation for Finishing \"" +MissionTitle +"\" ]";
        String earn = "{You Earned " + Item+"}";
        String design = "X=";

        while (design.length()!=line.length()){
            if (design.length()==line.length()-1){
                design = design + "X";
            } else {
                design = design + "=";
            }
        }

        int leRi=0;
        while (earn.length() < line.length()-2){
            if (leRi == 0){
                earn = " " + earn;
                leRi = 1;
            }else if (leRi == 1){
                earn = earn + " ";
                leRi = 0;
            }
        }

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println(design);
        System.out.println(line);
        System.out.println("[" + earn + "]");
        System.out.println(design);
        Thread.sleep(2000);

        clearMission();
    }

    public void afterWork(String reward, int moneyS) throws InterruptedException, IOException {

        inv.add(reward);
        String Item="";
        int moneyh = (int)((Math.random()*5)+moneyS);
        Money += moneyh;

        if (!reward.isEmpty() && moneyh!=0){
            Item = "$" + moneyh + " and "+ reward;
        } else if (!reward.isEmpty() && moneyh==0){
            Item = reward;
        } else if (reward.isEmpty() && moneyh!=0) {
            Item = "$" + moneyh;
        } else {
            Item = "Nothing";
        }

        String line = "[ "+"Congratulation for Finishing on your work ]";
        String earn = "{You Earned " + Item+"}";
        String design = "X=";

        while (design.length()!=line.length()){
            if (design.length()==line.length()-1){
                design = design + "X";
            } else {
                design = design + "=";
            }
        }

        int leRi=0;
        while (earn.length() < line.length()-2){
            if (leRi == 0){
                earn = " " + earn;
                leRi = 1;
            }else if (leRi == 1){
                earn = earn + " ";
                leRi = 0;
            }
        }

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println(design);
        System.out.println(line);
        System.out.println("[" + earn + "]");
        System.out.println(design);
        Thread.sleep(2000);

    }





}

