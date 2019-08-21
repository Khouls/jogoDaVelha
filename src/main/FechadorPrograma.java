package main;

import java.util.Timer;
import java.util.TimerTask;

public class FechadorPrograma {
    Timer timer;

    public FechadorPrograma(int seconds) {
        timer = new Timer();
        timer.schedule(new FecharPrograma(), seconds*1000);
    }

    class FecharPrograma extends TimerTask {
        public void run() {
            System.exit(0);
            timer.cancel(); //Para a thread do timer
        }
    }
}
