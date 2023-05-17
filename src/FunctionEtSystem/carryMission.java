package FunctionEtSystem;


import java.io.IOException;

import static FunctionEtSystem.loadStats.Money;

public class carryMission {
    static loadText say = new loadText();
    static Inventory inv = new Inventory();

    public static String MissionTitle = ""; public static String From;
    public static String to_Do="";
                                            //0                1                  2
    private 
    static String[][] ListofMission = {{"Kelf[Me]",        "Oldman",           "Boys",            "Woman", "Guard", "Worker", "Cat"},
                                        {"buryTheDead",   "Oldman's Apple",   "beTheMeanest" },
                                        {"CatchTheCulprit","Water my Babies",   "" },
                                        {}};
    
    private 
    static String[][] Details =   {{"Kelf", 
                                    "Oldman",
                                    "Boys",
                                    "Woman",
                                    "Guard",
                                    "Worker",
                                    "Cat"},
                                    
                                    //2nd Row
                                    {"Find a place to Cover the dead body, you need a shovel to dig and shove the dead body.",
                                    "The Oldman wants a apple. Go to the tree and climb to get an apple.",
                                    "Go to the playground and set some traps and trolls."},         
                                    
                                    //3rd Row
                                    {"Someone stole your stuff. Find him in the park.",
                                    "The oldman's flowers need some bath. Water them with your watering can.",
                                    ""}};

    public String showMission(){

        if(MissionTitle.isEmpty()){
            return "Nothing";
        } else {
            return MissionTitle;
        }

    }

    public static void setMission(int column, int row) throws InterruptedException, IOException {
        if (MissionTitle.isEmpty()){
            MissionTitle = ListofMission[column][row];
            From = ListofMission[0][row];
            to_Do = Details[column][row];
        } else {
            say.narrate("You are in a Mission right now!\nFinish what you started.",true,true);
            Thread.sleep(500);
        }

    }

    public static void missionComplete(String reward, int moneyh) throws InterruptedException, IOException {
        Money += moneyh;
        inv.add(reward);
        String Item="";
        
        if (!reward.equalsIgnoreCase("") && moneyh!=0){
            Item = "$" + moneyh + " and "+ reward;
        } else if (!reward.equalsIgnoreCase("") && moneyh==0){
            Item = "$" + moneyh;
        } else if (reward.equalsIgnoreCase("") && moneyh!=0) {
            Item = reward;
        } else if (reward.equalsIgnoreCase("") && moneyh==0) {
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
        Thread.sleep(500);
    }

}

