
import MainLobby.Interact;
import MainLobby.ParkStart;
import FunctionEtSystem.loadText;
import java.io.IOException;
import java.util.*;

public class Main {
    static loadText say = new loadText();
    String owner="";

    public Main() throws InterruptedException{

    }

    private void OwnerCred() throws InterruptedException, IOException{
        int setFrame = 1;


        for (int i=0; i<=50 ; i ++){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            if ( i%15 == 0){
                if (setFrame == 1){
                    setFrame =2;
                } else if (setFrame == 2){
                    setFrame =1;
                }
            }
            if (setFrame == 1){
                loadImage(1);
            } else if (setFrame  == 2){
                loadImage(2);
            }
            displaySamson(owner.length());
            System.out.println(owner);

            if (i >= 25){
                System.out.print("      Thank");
            }
            if (i > 31){
                System.out.print(" you");
            }
            if (i > 38){
                System.out.print(" for");
            }
            if (i > 44){
                System.out.print(" Testing");
            }
            if (i > 48){
                System.out.print(" :)");
            }

            Thread.sleep(100);
        }
    }

    private void newStart() throws InterruptedException, IOException{
        try (Scanner con = new Scanner(System.in)) {

        String reply; char answer;

        do{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("");
            System.out.println("");
            System.out.println("██████╗░░█████╗░██████╗░██╗░░██╗      /JOS");
            System.out.println("██╔══██╗██╔══██╗██╔══██╗██║░██╔╝    <><><><><>");
            System.out.println("██████╔╝███████║██████╔╝█████═╝░  ╭━━╮       ╭╮");
            System.out.println("██╔═══╝░██╔══██║██╔══██╗██╔═██╗░  ╰╮╭┻┳┳┳━╮╭━┫╰╮");
            System.out.println("██║░░░░░██║░░██║██║░░██║██║░╚██╗   ┃┃┻┫╭┫╋╰┫━┫╭┫");
            System.out.println("╚═╝░░░░░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚═╝   ╰┻━┻╯╰━━┻━┻━╯");

            say.LineBLine("Do You Want to Start from the Beginning? ");
            say.LineBLine("[Y] - Start Beginning");
            say.LineBLine("[N] - Begin with a loadCode\n");
            say.LineBLine("[Q] - Quit Game");
            System.out.print("Select: ");
        
            reply = con.nextLine(); reply = reply.toUpperCase();
            answer = reply.charAt(0);

        } while(answer != 'Y' && answer != 'N' && answer != 'Q');


        switch (answer) {
            case 'Y':
                ParkStart begin = new ParkStart();
                begin.Intro();
                break;

            case 'N':
                say.narrate("\t\t--Load Game Files--", true, true);
                say.narrate("Enter SaveCode: ", false, false);
                reply = con.nextLine();

                if (reply.length() == 18){

                    Interact start = new Interact(reply);
                    start.nowWhat1();
                } else { Error(); }
                break;

            case 'Q':
                System.exit(0);
                break;
            default:
                Error();
                break;
        }

        }
    }

    private void Error() throws InterruptedException, IOException{
        say.narrate("[Wrong SaveCode]", 2000, true, false);
        newStart();
    }



    public static void main(String[] args) throws IOException, InterruptedException {
        checkJavaVersion();

        Main own = new Main();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        own.OwnerCred();

        Thread.sleep(2000);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        own.newStart();
    }

    private void loadImage(int frame) throws IOException, InterruptedException {

        if (frame == 1){
            System.out.println("");
            System.out.println("");
            System.out.println("         |__          /\\_/\\");
            System.out.println("           |__________| o o| ");
            System.out.println("           |   J   S  |____| ");
            System.out.println("           |____________|    ");
            System.out.println("             |_|_    |_|_     ");
        } else if (frame == 2) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("          __          /\\_/\\");
            System.out.println("         | |__________| - -| ");
            System.out.println("           |   J   S  |____| ");
            System.out.println("           |____________|_   ");

        }
    }


    private void displaySamson(int chara) throws IOException, InterruptedException {


        switch (chara) {
            case 0:
                owner = owner.concat("Th");
            break;
            case 2:
                owner = owner.concat("is");
            break;
            case 4:
                owner = owner.concat(" P");
            break;
            case 6:
            owner = owner.concat("ro");
            break;
            case 8:
            owner = owner.concat("je");
            break;
            case 10:
            owner = owner.concat("ct");
            break;
            case 12:
            owner = owner.concat(" i");
            break;
            case 14:
            owner = owner.concat("s ");
            break;
            case 16:
            owner = owner.concat("ma");
            break;
            case 18:
            owner = owner.concat("de");
            break;
            case 20:
            owner = owner.concat(" b");
            break;
            case 22:
            owner = owner.concat("y ");
            break;
            case 24:
            owner = owner.concat("Ja");
            break;
            case 26:
            owner = owner.concat("me");
            break;
            case 28:
            owner = owner.concat("s ");
            break;
            case 30:
            owner = owner.concat("O.");
            break;
            case 32:
            owner = owner.concat(" S");
            break;
            case 34:
            owner = owner.concat("am");
            break;
            case 36:
            owner = owner.concat("so");
            break;
            case 38:
            owner = owner.concat("n");
            break;
        }
    }

    private static void checkJavaVersion() throws IOException, InterruptedException {
        String requiredVersion = "17.0.7"; // Minimum required version
        String installedVersion = System.getProperty("java.version");

        System.out.println("\nInstalled Java version: " + installedVersion);
        System.out.println("Required Java version: " + requiredVersion);

        if (installedVersion.compareTo(requiredVersion) < 0) {
            System.out.println("Your Java version is outdated. Please update to the latest version.");
            System.out.println("Download the latest Java version from: https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html");
            // You can also provide additional instructions or open a web page with the download link.
            System.exit(1); // Exit the application
        }

        System.out.println("Java version is up to date.");
        Thread.sleep(2500);
    }
}


