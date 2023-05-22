package Places;

import java.io.IOException;

public abstract class InheritMethod {

    public void choicePicker(int Lvl) throws InterruptedException, IOException {

    }


    abstract String availAction(int lvl);

    abstract void Choice1() throws IOException, InterruptedException;
    abstract void Choice2() throws InterruptedException, IOException;
    abstract void Choice3() throws IOException, InterruptedException;
    abstract void Choice4();
}
