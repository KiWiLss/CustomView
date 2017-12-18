package com.magicsoft.changeskin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.magicsoft.changeskin.activity.ListActivity;
import com.zhy.changeskin.SkinManager;

public class MainActivity extends AppCompatActivity {

    private Toolbar mTb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SkinManager.getInstance().register(this);

        mTb = (Toolbar) findViewById(R.id.tb_main_toolbar);
        setSupportActionBar(mTb);

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
