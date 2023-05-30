package MainLobby;

import FunctionEtSystem.loadStats;
import FunctionEtSystem.loadText;

import java.io.IOException;
import java.util.Scanner;

public class GoHome {
    loadText say = new loadText();
    loadStats stats = new loadStats();
    Scanner con = new Scanner(System.in);

    public GoHome(){
    }

    private void gameOut() throws IOException, InterruptedException {
        say.narrate("", true, true);
        System.out.println("__/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\__/\\\\\\___________________________________/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\_______________________/\\\\\\__   ");
        System.out.println(" _\\///////\\\\\\/////__\\/\\\\\\__________________________________\\/\\\\\\///////////_______________________\\/\\\\\\__  ");
        System.out.println("  _______\\/\\\\\\_______\\/\\\\\\__________________________________\\/\\\\\\__________________________________\\/\\\\\\__ ");
        System.out.println("   _______\\/\\\\\\_______\\/\\\\\\_____________/\\\\\\\\\\\\\\\\____________\\/\\\\\\\\\\\\\\\\\\\\\\______/\\\\/\\\\\\\\\\\\__________\\/\\\\\\__ ");
        System.out.println("    _______\\/\\\\\\_______\\/\\\\\\\\\\\\\\\\\\\\____/\\\\\\/////\\\\\\___________\\/\\\\\\///////______\\/\\\\\\////\\\\\\____/\\\\\\\\\\\\\\\\\\__ ");
        System.out.println("     _______\\/\\\\\\_______\\/\\\\\\/////\\\\\\__/\\\\\\\\\\\\\\\\\\\\\\____________\\/\\\\\\_____________\\/\\\\\\__\\//\\\\\\__/\\\\\\////\\\\\\__ ");
        System.out.println("      _______\\/\\\\\\_______\\/\\\\\\___\\/\\\\\\_\\//\\\\///////_____________\\/\\\\\\_____________\\/\\\\\\___\\/\\\\\\_\\/\\\\\\__\\/\\\\\\__ ");
        System.out.println("       _______\\/\\\\\\_______\\/\\\\\\___\\/\\\\\\__\\//\\\\\\\\\\\\\\\\\\\\___________\\/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\_\\/\\\\\\___\\/\\\\\\_\\//\\\\\\\\\\\\\\/\\\\_");
        System.out.println("        _______\\///________\\///____\\///____\\//////////____________\\///////////////__\\///____\\///___\\///////\\//__");
        con.nextLine();

        System.exit(0);
    }

    public void dogEnding() throws IOException, InterruptedException {
        say.narrate("Kelt and the Dog walking by its side while the DOg is sniffing in the ground to track the source of scent of the pen. It took many hours of trial and error. Sometimes they got Lost, somethimes got distracted. In the End, they finally reached Kelt's Home", true, true);
        System.out.println("[Click Enter]"); con.nextLine();

        say.narrate("Kelt kept the Dog as a Pet Dog, named him Bard. ", true, true);
        System.out.println("[Click Enter]"); con.nextLine();

        gameOut();
    }
    public void taxiEnding(){

    }
    public void policeEnding(){

    }
    public void womanEnding(){

    }
    public void GPSending(){

    }
    public void riskEnding(){ //Walk Home through bribe

    }
}
