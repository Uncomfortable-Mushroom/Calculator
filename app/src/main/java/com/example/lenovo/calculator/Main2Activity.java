package com.example.lenovo.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Main2Activity extends BaseActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.main:
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.SC:
                Intent intent1=new Intent("com.example.calculator.ACTION_START_ONE");
                startActivity(intent1);
                break;
            case R.id.TR:
                Intent intent2=new Intent("com.example.calculator.ACTION_START_TWO");
                startActivity(intent2);
                break;
            case R.id.help:
                Toast.makeText(this,"这是帮助",Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                ActivityCollector.finishAll();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
