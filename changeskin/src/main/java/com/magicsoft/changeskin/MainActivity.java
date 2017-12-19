package com.magicsoft.changeskin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.magicsoft.changeskin.activity.ListActivity;
import com.zhy.changeskin.SkinManager;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Toolbar mTb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SkinManager.getInstance().register(this);

        mTb = (Toolbar) findViewById(R.id.tb_main_toolbar);
        setSupportActionBar(mTb);
        String reg="^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
        Log.e("MMM", "onCreate: "+ Pattern.matches(reg,"15205622327") );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SkinManager.getInstance().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_red:
                Toast.makeText(this, "red", Toast.LENGTH_SHORT).show();
                SkinManager.getInstance().changeSkin("red");
                break;
            case R.id.action_green:
                SkinManager.getInstance().changeSkin("green");
                break;
            case R.id.action_reserve:
                SkinManager.getInstance().removeAnySkin();
                break;
            case R.id.action_next:
                startActivity(new Intent(this, ListActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
