package com.example.robinsuri.addapp.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robinsuri on 10/27/14.
 */
public interface IClock {

    public long currentTimeInMillis();

    public void addListener(Listener listener);

    public void removeListener(Listener listener);
    public void runEverySecond();

    public interface Listener {
        public void onTick();
    }
}
