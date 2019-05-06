package xin.hesperus.boot.ch2.lifecycle;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class MyLifeCycle implements SmartLifecycle {

    private boolean  running = false;

    @Override
    public void start() {
        running = true;
        System.out.println("------ my lifecycle bean start");
    }

    @Override
    public void stop() {
        running = false;
        System.out.println("------ my lifecycle bean stop ");

    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public int getPhase() {
        return 0;
    }

}
