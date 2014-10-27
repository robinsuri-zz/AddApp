package com.example.robinsuri.addapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.robinsuri.addapp.util.Clock;
import com.example.robinsuri.addapp.util.IClock;
import com.example.robinsuri.addapp.util.SystemUiHider;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class FullscreenActivity2 extends Activity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;
    private Summation summation;
    private Summation.Listener sListener;
    private IClock.Listener clockListener;
    private IClock iclock ;
    private TextView countdown;
    private Timer timer;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * If set, will toggle the system UI visibility upon interaction. Otherwise,
     * will show the system UI visibility upon interaction.
     */
    private static final boolean TOGGLE_ON_CLICK = true;

    /**
     * The flags to pass to {@link SystemUiHider#getInstance}.
     */
    private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

    /**
     * The instance of the {@link SystemUiHider} for this activity.
     */
    private SystemUiHider mSystemUiHider;
    private TextView timeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

//        final View controlsView = findViewById(R.id.fullscreen_content_controls);
        final View contentView = findViewById(R.id.fullscreen_content);
        // Set up an instance of SystemUiHider to control the system UI for
        // this activity.
        mSystemUiHider = SystemUiHider.getInstance(this, contentView, HIDER_FLAGS);
        mSystemUiHider.setup();
        SystemUiHider.OnVisibilityChangeListener listener = new SystemUiHider.OnVisibilityChangeListener() {
            // Cached values.
            int mControlsHeight;
            int mShortAnimTime;

            @Override
            @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
            public void onVisibilityChange(boolean visible) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                    // If the ViewPropertyAnimator API is available
                    // (Honeycomb MR2 and later), use it to animate the
                    // in-layout UI controls at the bottom of the
                    // screen.
                    if (mControlsHeight == 0) {
//                        mControlsHeight = controlsView.getHeight();
                    }
                    doSomehting();
//                    controlsView.animate()
//                            .translationY(visible ? 0 : mControlsHeight)
//                            .setDuration(mShortAnimTime);
                } else {
                    // If the ViewPropertyAnimator APIs aren't
                    // available, simply show or hide the in-layout UI
                    // controls.
//                    controlsView.setVisibility(visible ? View.VISIBLE : View.GONE);
                }

                if (visible && AUTO_HIDE) {
                    // Schedule a hide().
                    delayedHide(AUTO_HIDE_DELAY_MILLIS);
                }
            }

            private void doSomehting() {
                if (mShortAnimTime == 0) {
                    mShortAnimTime = getResources().getInteger(
                            android.R.integer.config_shortAnimTime);
                }
            }
        };

        mSystemUiHider
                .setOnVisibilityChangeListener(listener);

        // Set up the user interaction to manually show or hide the system UI.
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TOGGLE_ON_CLICK) {
                    mSystemUiHider.toggle();
                } else {
                    mSystemUiHider.show();
                }
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
//        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
        sListener = new Summation.Listener() {
            @Override
            public void onSummation(int res) {

            }
        };
        iclock = new Clock();
        timeView = (TextView) findViewById(R.id.sum);
        clockListener = new IClock.Listener() {
            @Override
            public void onTick() {
                displayTime();

            }

        };
        summation = new Summation();
        countdown = (TextView) findViewById(R.id.sum);

    }

    private void displayTime() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                timeView.setText(Long.toString(iclock.currentTimeInMillis()));
            }
        });

    }

    public void onButtonClick(View v) {
//


//        final TextView t1 = (TextView) findViewById(R.id.sum);
//        Intent intent = new Intent(this, MyActivity.class);
//        EditText editText = (EditText) findViewById(R.id.num1);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//
//
//        startActivityForResult(intent, 1);
//        String parity = intent.getExtras().getString("parity");
//
//        t1.setText(parity);
//        final int n1, n2;
//
//        EditText e1 = (EditText) findViewById(R.id.num1);
//        EditText e2 = (EditText) findViewById(R.id.num2);
//
//        n1 = Integer.parseInt(e1.getText().toString());
//        n2 = Integer.parseInt(e2.getText().toString());
//        Executor executor = Executors.newSingleThreadExecutor();

//        Integer sum;
//        final int thesum;
//        Summation.SumCallBack sumCallBack = new Summation.SumCallBack() {
//            @Override
//            public void onSummationDone(final int res) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.d("FullScreenActivity", "on summation done" + res);
//                        t1.setText(Integer.toString(res));
//                    }
//                });
//            }
//
//
//        };
//        new Summation().extractedSum(n1, n2, sumCallBack);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("Inside onActivityResult");
        Log.d("logger Log.d", "Inside onActivityResult 2 " + resultCode + "  " + data);
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (1): {
                if (resultCode == Activity.RESULT_OK) {
                    String newText = data.getStringExtra("parity");
                    final TextView t1 = (TextView) findViewById(R.id.sum);
                    t1.setText(newText);
                }
                break;
            }
        }
    }

    public void onButtonClickDifference(View v) {
        final int n1, n2;

        EditText e1 = (EditText) findViewById(R.id.num1);
        EditText e2 = (EditText) findViewById(R.id.num2);
        final TextView t1 = (TextView) findViewById(R.id.sum);
        n1 = Integer.parseInt(e1.getText().toString());
        n2 = Integer.parseInt(e2.getText().toString());

        Summation.DiffCallBack callback = new Summation.DiffCallBack() {
            @Override
            public void onDifferenceDone(final int difference) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        t1.setText(Integer.toString(difference));
                    }
                });

            }
        };
        new Summation().extractedDifference(n1, n2, callback);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }


    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    Handler mHideHandler = new Handler();
    Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            mSystemUiHider.hide();
        }
    };

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("FullScreenActivity", "activity resumed");
//        long l = iclock.currentTimeInMillis();

//        summation.addSumListener(sListener);
//

        iclock.addListener(clockListener);
//        iclock.runEverySecond();
        displayTime();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("FullScreenActivity", "activity paused");
//        summation.removeSumListener(null);
        iclock.removeListener(clockListener);
    }

    protected void onStart() {
        super.onStart();
//        timer = new Timer("DigitalClock");
//        Calendar calendar = Calendar.getInstance();
//
//        // Get the Current Time
//        final Runnable updateTask = new Runnable() {
//            public void run() {
//                countdown.setText(getCurrentTimeString()); // shows the current time of the day
////                countdown.setText(getReminingTime()); // shows the remaining time of the day
//            }
//        };
//
//        // update the UI
//        int msec = 999 - calendar.get(Calendar.MILLISECOND);
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                runOnUiThread(updateTask);
//            }
//        }, msec, 1000);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        timer.cancel();
//        timer.purge();
//        timer = null;
    }

    private String getReminingTime() {
        Calendar calendar = Calendar.getInstance();
        int hour = 23 - calendar.get(Calendar.HOUR_OF_DAY);
        int minute = 59 - calendar.get(Calendar.MINUTE);
        int second = 59 - calendar.get(Calendar.SECOND);
        return hour + ":" + minute + ":" + second;
    }


    private String getCurrentTimeString() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        return hour + ":" + minute + ":" + second;
    }
}

