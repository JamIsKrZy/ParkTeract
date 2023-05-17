package FunctionEtSystem;

import java.io.IOException;



public class loadText {
    int Tick;
    public loadText(){
        Tick = 50;
    }


    public void narrate(String line, boolean resetB4Text, boolean nextLine)throws InterruptedException, IOException{
        if (resetB4Text){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }

        String sayMe = line; char lett;

        int n=0;


        
        for (int i=0; i<sayMe.length(); i++) {
            
            Thread.sleep(Tick);
            lett = sayMe.charAt(i);
            System.out.print(lett);
            n++;
            
            if ( n >= 80 && lett == ' '){
                System.out.println();

                n=0;
            }
        }
        if (nextLine){
            System.out.println();
        }

    }



    
    public void narrate(String line, int StopMiliSecAfter, boolean ResetB4Text ,boolean nextLine)throws InterruptedException, IOException{
        if (ResetB4Text){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        char lett;

        int n=0;

        
        for (int i = 0; i< line.length(); i++) {
            
            Thread.sleep(Tick);
            lett = line.charAt(i);
            System.out.print(lett);
            n++;

            if ( n >= 80 && lett == ' '){
                System.out.println("");
                n=0;
            }
        }

        if (nextLine == true){
        System.out.println("");
        }


        Thread.sleep(StopMiliSecAfter);
        
    }

    public void LineBLine(String Line) throws InterruptedException{
        System.out.println(Line);

        Thread.sleep(Tick);
    }

    public void mapLoad(String line) throws InterruptedException{
        String sayMe = line; char lett;
        
        Thread.sleep(10);
        
        for (int i=0; i<sayMe.length(); i++) {
            
            Thread.sleep(1);
            lett = sayMe.charAt(i);
            System.out.print(lett);

        }

        System.out.println("");
    }

    public void currentTick() throws InterruptedException, IOException {

        narrate("O~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~O", 0, true, true);
        narrate("The Current tick or loading of text is " + Tick, 0, false, true);
        narrate("O~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~O", 0, false, true);
    }

    public void changeTick(int speed) throws InterruptedException, IOException{
        Tick = speed;
        System.out.println("");
        narrate("Loading", 50, false, false);
        narrate(".", 50, false, false);
        narrate(".", 50, false, false);
        narrate(".", 50, false, false);
    }

    public void levelUp(String Character,String Ability) throws InterruptedException, IOException {
        String line1="",line2="",line3="", line4="", line5="";
        line1 = "You Unlocked a Choice on " + Character;
        line3 = "["+Ability +"]";

        if (line1.length()>20){
            line2 = "     "+line1.substring(21);
            line1 = line1.substring(0,21);
        }
        while (line2.length()!=21){
            line2 = line2 + " ";
        }

        int leRi=0;
        while (line3.length()!=21){
            if (leRi == 0){
                line3 = " " + line3;
                leRi = 1;
            } else if (leRi == 1){
                line3 = line3 + " ";
                leRi = 0;
            }
        }
        for (int i=0; i<=10; i++) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("X-oO---oO---oO---oO---oO--X");
            System.out.println("|  " + line1 + "  |");
            System.out.println("|  " + line2 + "  o");
            System.out.println("O                         O");
            System.out.println("o         Unlocked:       |");
            System.out.println("|  " + line3 + "  |");
            System.out.println("X--Oo---Oo---Oo---Oo---Oo-X");

            Thread.sleep(25);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            System.out.println("X--oO---oO---oO---oO---oO-X");
            System.out.println("|  " + line1 + "  |");
            System.out.println("O  " + line2 + "  |");
            System.out.println("o                         o");
            System.out.println("|         Unlocked:       O");
            System.out.println("|  " + line3 + "  |");
            System.out.println("X-Oo---Oo---Oo---Oo---Oo--X");

            Thread.sleep(25);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            System.out.println("X---oO---oO---oO---oO---oOX");
            System.out.println("O  " + line1 + "  |");
            System.out.println("o  " + line2 + "  |");
            System.out.println("|                         |");
            System.out.println("|         Unlocked:       o");
            System.out.println("|  " + line3 + "  O");
            System.out.println("XOo---Oo---Oo---Oo---Oo---X");

            Thread.sleep(25);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            System.out.println("XO---oO---oO---oO---oO---oX");
            System.out.println("o  " + line1 + "  O");
            System.out.println("|  " + line2 + "  |");
            System.out.println("|                         |");
            System.out.println("|         Unlocked:       |");
            System.out.println("O  " + line3 + "  o");
            System.out.println("Xo---Oo---Oo---Oo---Oo---OX");

            Thread.sleep(25);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            System.out.println("XoO---oO---oO---oO---oO---X");
            System.out.println("|  " + line1 + "  o");
            System.out.println("|  " + line2 + "  O");
            System.out.println("|                         |");
            System.out.println("O         Unlocked:       |");
            System.out.println("o  " + line3 + "  |");
            System.out.println("X---Oo---Oo---Oo---Oo---OoX");

            Thread.sleep(25);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            System.out.println("X-oO---oO---oO---oO---oO--X");
            System.out.println("|  " + line1 + "  |");
            System.out.println("|  " + line2 + "  o");
            System.out.println("O                         O");
            System.out.println("o         Unlocked:       |");
            System.out.println("|  " + line3 + "  |");
            System.out.println("X--Oo---Oo---Oo---Oo---Oo-X");
        }

    }



}
