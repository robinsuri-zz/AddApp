package com.example.robinsuri.addapp.util;

import android.util.Log;

/**
 * Created by robinsuri on 10/21/14.
 */
public class Example implements IExample {

    private int a;
    private int b;

    public Example(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void dosomething() {

    }

    @Override
    public boolean equals(Object o) {
        Log.d("test","equals invoked");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Example example = (Example) o;

        if (a != example.a) return false;
        if (b != example.b) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        return result;
    }
}
