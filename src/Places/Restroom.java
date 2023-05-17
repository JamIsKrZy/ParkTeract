package Places;

import java.io.IOException;
public class Restroom extends InheritMethod{
    
    public Restroom(){

    }

    @Override
    public void choicePicker(int Lvl){
        String choice = availAction(Lvl);

        switch (choice){

        }
    }

    private void image(){
        System.out.println("                     __                __                _______             ");
        System.out.println("                    |  |              |  |              |              ");
        System.out.println("                    |  |--------------|  |--------------| []                  ");
        System.out.println("   ________________ |  |              |  |              |                 ");
        System.out.println("  |    /       /   ||  |              |  |              | []            ");
        System.out.println("  |   /       /    ||  |              |  |              |              ");
        System.out.println("  |  /       /  /  ||  |            O |  |            O | []             ");
        System.out.println("  |_/_______/__/___||  |              |  |              |                ");
        System.out.println(" ,_______r_________,|  |              |  |              | []             ");
        System.out.println(" |=================||  |              |  |              |                 ");
        System.out.println("                    |  |--------------|  |--------------| []                        ");
        System.out.println("____________________|__|______________|__|______________|_______         ");
    }


    @Override
    public String availAction(int lvl) {

        return null;
    }

    @Override
    void Choice1() {

    }

    @Override
    void Choice2() {

    }

    @Override
    void Choice3() {

    }

    @Override
    void Choice4() {

    }
}
