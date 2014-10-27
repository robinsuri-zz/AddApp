package com.example.robinsuri.addapp.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by robinsuri on 10/27/14.
 */
public class Clock implements IClock {

    List<Listener> listeners = new ArrayList<Listener>();
    Executor executor = Executors.newSingleThreadExecutor();

    public Clock() {

        executor.execute(new Runnable() {
            @Override

            public void run() {
                for(;;) {
                    fireListeners(listeners);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void runEverySecond(){
        for (;;) {
            fireListeners(listeners);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    @Override
    public long currentTimeInMillis() {
        return System.currentTimeMillis();
    }

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    public void fireListeners(List<Listener> listener) {
        for (Listener listen : listeners) {
            listen.onTick();

        }
    }
}