package com.magicsoft.customviewone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.magicsoft.customviewone.activity.CustomActivity;
import com.magicsoft.customviewone.activity.canvas.CanvasTestActivity;
import com.magicsoft.customviewone.activity.canvas.CanvasTestActivity2;
import com.magicsoft.customviewone.expression.Test;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Client.fun();
        Test.component();
    }

    public void canvas(View view) {
        startActivity(new Intent(this, CanvasTestActivity.class));
    }

    public void canvas2(View view) {
        startActivity(new Intent(this, CanvasTestActivity2.class));
    }

    public void custom(View view) {
        startActivity(new Intent(this, CustomActivity.class));
    }
}
