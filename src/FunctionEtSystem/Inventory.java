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
        boolean filled = false; boolean done= false;
        for(int i = 0; i < pocket.length; i++){
            if (pocket[i].isEmpty()){
                pocket[i] = Item;
                done = true;
                break;

            } else if ( i == pocket.length-1) {
                filled = true;
            }

            if (done){
                break;
            }
        }

        if (filled){
            System.out.println("Inventory is Full!");
            Thread.sleep(1000);
        }
    }
    
    public void remove(String Item, boolean showinfo) throws InterruptedException {
        boolean notify = true;
        boolean skip = false;
        for(int i = 0; i < pocket.length; i++){
            if (pocket[i].equalsIgnoreCase(Item)){
                pocket[i] = "";
                notify = false;
                skip = true;
                if (showinfo) {
                    System.out.println("Successfully removed " + Item + " in the Inventory");
                }

                break;
            }

            if (skip){
                break;
            }
        }
        
        if(notify){
            System.out.println("The Item \"" + Item + "\" is not in the inventory");
        }

        Thread.sleep(1000);
    }
}
