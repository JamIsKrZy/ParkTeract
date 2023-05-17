package FunctionEtSystem;

public class Inventory {

    static String[] pocket = {"","","","",""};


    public String[] showInv(){
        return pocket;
    }

    public boolean lookingForItem(String Item){
        boolean value = false;
        for (String s : pocket) {
            if (Item.equalsIgnoreCase(s)) {
                value = true;
                break;
            }
        }
        return value;
    }

    public void add(String Item) throws InterruptedException {
        boolean filled = false;
        for(int i = 0; i < pocket.length; i++){
            if (pocket[i].isEmpty()){
                pocket[i] = Item;

            } else if ( i == pocket.length-1) {
                filled = true;
            }
        }
        if (filled){
            System.out.println("Inventory is Full!");
            Thread.sleep(1000);
        }
    }
}
