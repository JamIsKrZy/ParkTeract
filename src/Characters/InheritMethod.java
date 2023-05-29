package Characters;

import java.io.IOException;

public abstract class InheritMethod {

    public void checkLvl(int lvl) throws IOException, InterruptedException {

        switch (lvl) {
            case 0 -> this.Lvl0();
            case 1 -> this.Lvl1();
            case 2 -> this.Lvl2();
            case 3 -> this.Lvl3();
            case 4 -> this.Lvl4();
            case 5 -> this.Lvl5();

            default -> {
            }
        }
    }

    abstract int availAction(int lvl) throws IOException, InterruptedException;

    abstract void Lvl0() throws IOException, InterruptedException;
    abstract void Lvl1() throws IOException, InterruptedException;
    abstract void Lvl2() throws IOException, InterruptedException;
    abstract void Lvl3() throws IOException, InterruptedException;
    abstract void Lvl4() throws IOException, InterruptedException;
    abstract void Lvl5() throws IOException, InterruptedException;
    abstract void randomEvent() throws  IOException, InterruptedException;
}
