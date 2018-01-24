package com.example.android.sl_1200;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        ScrollView scrollView = findViewById(R.id.svl);
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putIntArray("SCROLLPOS",
                new int[]{scrollView.getScrollX(), scrollView.getScrollY()});
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        final ScrollView scrollView = findViewById(R.id.svl);
        super.onRestoreInstanceState(savedInstanceState);
        final int[] position = savedInstanceState.getIntArray("SCROLLPOS");
        if (position != null)
            scrollView.post(new Runnable() {
                public void run() {
                    scrollView.scrollTo(position[0], position[1]);
                }
            });
    }
}
