package com.example.yang.demomaterildesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTool();
    }

    private void initTool() {
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.option_1:
                Toast.makeText(MainActivity.this,"option_1",Toast.LENGTH_SHORT);

                break;
            case R.id.option_2:
                Toast.makeText(MainActivity.this,"option_2",Toast.LENGTH_SHORT);
                break;
            case R.id.option_3:
                Toast.makeText(MainActivity.this,"option_3",Toast.LENGTH_SHORT);
                break;

        }

        return true;
    }
}
