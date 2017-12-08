package com.magicsoft.customview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.magicsoft.customview.activity.Color;
import com.magicsoft.customview.activity.DispathActivity;
import com.magicsoft.customview.activity.LayerActivity;

import com.magicsoft.customview.activity.PaintActivity;
import com.magicsoft.customview.activity.ViewGroupActivity;
import com.magicsoft.customview.activity.VolumeActivity;
import com.magicsoft.customview.activity.listview.ListViewActivity;
import com.magicsoft.customview.widget.TopBar;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MMM";
    private TopBar mTp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTp = (TopBar) findViewById(R.id.tb_main_topbar);
        mTp.setOnTopBarClickListener(new TopBar.topBarClickListener() {
            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
            }
        });
        Log.e(TAG, "onCreate: " );

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: " );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }

    public void volume(View view) {
        startActivity(new Intent(this, VolumeActivity.class));
    }

    public void viewgroup(View view) {
        startActivity(new Intent(this, ViewGroupActivity.class));
    }

    public void dispatch(View view) {
        startActivity(new Intent(this, DispathActivity.class));
    }

    public void listview(View view) {
        startActivity(new Intent(this, ListViewActivity.class));
    }

    public void layer(View view) {
        startActivity(new Intent(this, LayerActivity.class));
    }

    public void shape(View view) {
        startActivity(new Intent(this, Color.class));
    }

    public void paint(View view) {
        startActivity(new Intent(this, PaintActivity.class));
    }
}
