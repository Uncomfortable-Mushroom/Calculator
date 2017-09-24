package com.example.lenovo.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Main3Activity extends BaseActivity  {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main:
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.SC:
                Intent intent1 = new Intent("com.example.calculator.ACTION_START_ONE");
                startActivity(intent1);
                break;
            case R.id.help:
                Toast.makeText(this, "这是帮助", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                ActivityCollector.finishAll();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private List<String> list = new ArrayList<String>();
    private ArrayAdapter<String> adapter1,adapter2;
    private Spinner spinner1, spinner2;
    private EditText text1, text2;
    private String s1,s2,s3;
    private int i;
    private Button B;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        text1 = (EditText) findViewById(R.id.text1);
        text2 = (EditText) findViewById(R.id.text2);
        text2.setCursorVisible(false);
        text2.setEnabled(false);


        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        list.add("2进制");
        list.add("8进制");
        list.add("10进制");
        list.add("16进制");
        adapter1=new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);
        adapter1.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayAdapter<String> adapter =
                        (ArrayAdapter<String>) adapterView.getAdapter();
                s1=adapter.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        adapter2=new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);
        adapter2.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayAdapter<String> adapter =
                        (ArrayAdapter<String>) adapterView.getAdapter();
               s2=adapter.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        s3=text1.getText().toString();

        B=(Button)findViewById(R.id.button);
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setText(Tr(s1,s2,s3));
            }
        });
    }
    private String Tr(String s1,String s2,String s3){
        if(s1=="2进制"){
            i=Integer.valueOf(s3,2);
        }
        else if (s1=="8进制"){
            i=Integer.valueOf(s3,8);
        }
        else if (s1=="10进制"){
            i=Integer.valueOf(s3);
        }
        else if (s1=="16进制"){
            i=Integer.valueOf(s3,16);
        }

        if(s2=="2进制"){
            Integer.toBinaryString(i);
        }
        else if (s2=="8进制"){
            Integer.toOctalString(i);
        }
        else if (s2=="10进制"){
            i=i;
        }
        else if (s2=="16进制"){
            Integer.toHexString(i);
        }
        return String.valueOf(i);
    }
}
