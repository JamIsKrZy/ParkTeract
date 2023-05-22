package MainLobby;

import java.io.IOException;
import Characters.*;
import FunctionEtSystem.*;
import Places.*;

public class ContactPlayers {
    loadText say = new loadText();
    loadStats stats = new loadStats();


    public String[] S1 = {"TREE", "OLDMAN", "BENCH", "DOG"};
    public String[] S2 = {"BOYS", "BENCH", "LUCKYBOX", "GARDEN"};
    public String[] S3 = {"PLAYGROUND", "WOMAN", "GUARD", "WORKER", "PICNIC"};
    public String[] S4 = {"VENDINGMACHINE", "CAT", "FOODSTALL", "CLUBHOUSE", "RESTROOM"};

    // Character availability to interact
    Boolean[] A1 = {true, true, false, false};
    Boolean[] A2 = {false, false, false, true};
    Boolean[] A3 = {false, false, false, true, false};
    Boolean[] A4 = {false, false, false, false, true};
    
    
    public ContactPlayers() throws InterruptedException {

    }    

    public void Contact(String Player, int Section, int lvl) throws InterruptedException, IOException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        switch (Section) {
            case 1:
                switch (Player) {
                    case "TREE":
                        if (A1[0] == false){
                            say.narrate("Kelf is looking at a tree", 1000, true, true);
                            break;
                        }
                        Tree puno = new Tree();
                        puno.choicePicker(lvl);
                    break;

                    case "OLDMAN":
                        if (A1[1] == false){
                            say.narrate(Player + " doesnt want to talk right now!", 1000, true, true);
                            break;
                        }

                        Oldman tiguwang = new Oldman();
                        tiguwang.checkLvl(lvl);

                    break;

                    case "BENCH":
                        if (A1[2] == false){
                            say.narrate("Kelf sat on the table.", 1000, true, true);
                            break;
                        }
                        Bench sit = new Bench();
                        sit.availAction(lvl);

                    break;

                    case "DOG":
                        if (A1[3] == false){
                            say.narrate("Kelf walked away from the Dog.", 1000, true, true);
                            break;
                        }
                        Dog aso = new Dog();
                        aso.checkLvl(lvl);

                    break;
                }
                break;
            case 2:
                switch (Player) {
                    case "BOYS":
                        if (A2[0] == false){
                            say.narrate("The Boys are not in the mood to talk.", 1000, true, true);
                            break;
                        }
                        Boys lalake = new Boys();
                        lalake.checkLvl(lvl);
                    break;

                    case "BENCH1":
                        if (A2[1] == false){
                            say.narrate("Kelf sat on the bench.", 1000, true, true);
                            break;
                        }
                        Bench sit = new Bench();
                        sit.choicePicker(lvl);
                    break;

                    case "LUCKYBOX":
                        if (A2[2] == false){
                            say.narrate("Its Locked!", 1000, true, true);
                            break;
                        }
                        LuckyBox box = new LuckyBox();
                        box.choicePicker(lvl);
                    break;

                    case "GARDEN":
                        if (A2[3] == false){
                            say.narrate("The Garden is not yet opened!", 1000, true, true);
                            break;
                        }
                        Garden flower = new Garden();
                        flower.choicePicker(lvl);
                    break;
                
                }
                break;

            case 3:
                switch (Player) {
                    case "PLAYGROUND":
                        if (A3[0] == false){
                            say.narrate("The playground is off limits!", 1000, true, true);
                            break;
                        }
                        PlayGround fun = new PlayGround();
                        fun.choicePicker(lvl);

                    break;

                    case "WOMAN":
                        if (A3[1] == false){
                            say.narrate(Player + " doesnt want to talk right now!", 1000, true, true);
                            break;
                        }
                        Woman girl = new Woman();
                        girl.checkLvl(lvl);

                    break;

                    case "GAURD":
                        if (A3[2] == false){
                            say.narrate(Player + " doesnt want to talk right now!", 1000, true, true);
                            break;
                        }
                        Guard police = new Guard();
                        police.checkLvl(lvl);

                    break;

                    case "WORKER":
                        if (A3[3] == false){
                            say.narrate(Player + " doesnt want to talk right now!", 1000, true, true);
                            break;
                        }
                        Worker work = new Worker();
                        work.checkLvl(lvl);

                    break;

                    case "PICNIC":
                        if (A3[4] == false){
                            say.narrate("The PICNIC is off limits!", 1000, true, true);
                            break;
                        }
                        Picnic chill = new Picnic();
                        chill.choicePicker(lvl);
                    break;
                
                }
                break;

            case 4:
                switch (Player) {
                    case "VENDINGMACHINE":
                        if (A4[0] == false){
                            say.narrate("The Machine is broken", 1000, true, true);
                            break;
                        }
                        VendingMachine palit = new VendingMachine();
                        palit.choicePicker(lvl);
                    
                    break;

                    case "CAT":
                        if (A4[1] == false){
                            say.narrate(Player + " doesnt want to pet right now!", 1000, true, true);
                            break;
                        }
                        Cat pusa = new Cat();
                        pusa.checkLvl(lvl);

                    break;

                    case "FOODSTALL":
                        if (A4[2] == false){
                            say.narrate("Its Closed!", 1000, true, true);
                            break;
                        }
                        FoodStall kaon = new FoodStall();
                        kaon.choicePicker(lvl);

                    break;

                    case "CLUBHOUSE":
                        if (A4[3] == false){
                            say.narrate("Its Locked!", 1000, true, true);
                            break;
                        }
                        ClubHouse club = new ClubHouse();
                        club.choicePicker(lvl);

                    break;

                    case "RESTROOM":
                        if (A4[4] == false){
                            say.narrate("Suck my Dingdong!", 1000, true, true);
                            break;
                        }
                        Restroom cr = new Restroom();
                        cr.choicePicker(lvl);

                    break;
            
                }

            break;    
        
        
        }
    }

}
