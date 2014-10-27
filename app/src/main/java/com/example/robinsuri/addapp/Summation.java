package com.example.robinsuri.addapp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * Created by robinsuri on 10/21/14.
 */
public class Summation {
    Executor executor = Executors.newSingleThreadExecutor();
    private List<Listener> _listeners = new ArrayList<Listener>();


    private void inform(int i) {
//        MyActivity.generatedNumber(i);
    }


    public void addSumListener(Listener listener){
        _listeners.add(listener);
    }

    public void removeSumListener(Listener listener){
        _listeners.remove(listener);
    }

    public  void extractedSum(final  int n1, final int n2, final SumCallBack sumCallBack) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int thesum;
                thesum = n1 + n2;
                sumCallBack.onSummationDone(thesum);
            }
        });
      }

    private void fireListeners(int thesum) {
        for(Listener listener:_listeners){
            listener.onSummation(thesum);
        }
    }

    public void extractedDifference(final int n1,final int n2, final DiffCallBack callback)
    {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                int difference = n1-n2;
                callback.onDifferenceDone(difference);

            }
        });

    }
    public interface SumCallBack {

        public void onSummationDone(int res);


    }

    public interface DiffCallBack {
        void onDifferenceDone(int difference);
    }

    public interface Listener{
        void onSummation(int res);
    }

}
