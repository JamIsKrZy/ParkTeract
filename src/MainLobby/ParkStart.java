package MainLobby;
//import java.util.*;
import FunctionEtSystem.Inventory;
import FunctionEtSystem.loadText;

import java.io.IOException;

public class ParkStart {
    loadText say = new loadText();
    MapLocate render = new MapLocate();
    Inventory inv = new Inventory();
    
    
    public ParkStart(){

    }

    public void Intro() throws IOException, InterruptedException{
        say.narrate("Your name is Kelf", 1000, true, false);
        say.narrate("Kelf went on a walk outside to catch some fresh air. Until he came across a dog, which chased him and made him run swiftly because he is an athlete. He was able to flee and became lost in a park he had never visited before.", 3000, true, false);
        say.narrate("Explore the park and gather information to get home.", 2000, true, false);

        Interact start = new Interact("000000000000000000");

        inv.add("Pen");
        start.nowWhat1();

        //now proccess on things to do
    }
}
