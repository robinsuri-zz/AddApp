package com.example.robinsuri.addapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void getParity(View v)
    {
        EditText e1 = (EditText) findViewById(R.id.parity);
        int n1 = Integer.parseInt(e1.getText().toString());
        String output="";
        if(n1%2==0)
            output = "even";
        else
            output = "odd";
        Intent resultIntent = new Intent();
        resultIntent.putExtra("parity", output);
        setResult(Activity.RESULT_OK, resultIntent);
//        finish();



    }


//    public static void generatedNumber(int i)
//    {
//        Intent resultIntent = new Intent();
//        resultIntent.putExtra("number", i);
//        setResult(Activity.RESULT_OK, resultIntent);
//        finish();
//    }
}
