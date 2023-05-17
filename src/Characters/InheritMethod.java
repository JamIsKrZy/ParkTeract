package Characters;

import java.io.IOException;

public abstract class InheritMethod {

    public void checkLvl(int lvl) throws IOException, InterruptedException {

        switch (lvl) {
            case 0 -> this.Lvl0();
            case 1 -> this.Lvl1();
            case 2 -> this.Lvl2();
            case 3 -> this.Lvl3();
            default -> {
            }
        }
    }

    abstract void Lvl0() throws IOException, InterruptedException;
    abstract void Lvl1() throws IOException, InterruptedException;
    abstract void Lvl2() throws IOException, InterruptedException;
    abstract void Lvl3() throws IOException, InterruptedException;
    abstract void randomEvent() throws  IOException, InterruptedException;
}
