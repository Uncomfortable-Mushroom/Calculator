package com.example.lenovo.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TR extends BaseActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main:
                Intent intent = new Intent(TR.this, Calculator.class);
                startActivity(intent);
                break;
            case R.id.SC:
                Intent intent1 = new Intent("com.example.calculator.ACTION_START_ONE");
                startActivity(intent1);
                break;
            case R.id.TR:
                Intent intent2 = new Intent("com.example.calculator.ACTION_START_TWO");
                startActivity(intent2);
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
    private List<String> list1 = new ArrayList<String>();
    private ArrayAdapter<String> adapter, adapter1, adapter2;
    private Spinner spinner, spinner1, spinner2;
    private EditText text1, text2;
    private String s, s1, s2, s3;
    private Button B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tr);
        text1 = (EditText) findViewById(R.id.text1);
        text2 = (EditText) findViewById(R.id.text2);
        text2.setCursorVisible(false);
        text2.setEnabled(false);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        list.add("米");
        list.add("分米");
        list.add("厘米");
        list.add("毫米");
        list.add("公里");
        list1.add("长度");
        list1.add("面积");
        list1.add("体积");
        list1.add("质量");
        adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, list1);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayAdapter<String> adapter =
                        (ArrayAdapter<String>) adapterView.getAdapter();
                s = adapter.getItem(i);
                NEW(s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        adapter1 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, list);
        adapter1.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayAdapter<String> adapter =
                        (ArrayAdapter<String>) adapterView.getAdapter();
                s1 = adapter.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        adapter2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, list);
        adapter2.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayAdapter<String> adapter =
                        (ArrayAdapter<String>) adapterView.getAdapter();
                s2 = adapter.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
////        s3 = text1.getText().toString();
////        TR(s, s1, s2, s3);
//        text1.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                s3 = text1.getText().toString();
//                TR(s, s1, s2, s3);
//            }
//        });
       B = (Button) findViewById(R.id.button);B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s3 = text1.getText().toString();
                TR(s, s1, s2, s3);
            }
        });

    }

    private void NEW(String s) {
        List<String> list3 = new ArrayList<String>();
        if (s == "长度") {
            list3.add("米");
            list3.add("分米");
            list3.add("厘米");
            list3.add("毫米");
            list3.add("公里");
        } else if (s == "面积") {
            list3.add("平方米");
            list3.add("平方分米");
            list3.add("平方厘米");
            list3.add("平方公里");
        } else if (s == "体积") {
            list3.add("立方米");
            list3.add("立方厘米");
            list3.add("升");
        } else if (s == "质量") {
            list3.add("克");
            list3.add("千克");
            list3.add("吨");
        }

        adapter1 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, list3);
        adapter1.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayAdapter<String> adapter =
                        (ArrayAdapter<String>) adapterView.getAdapter();
                s1 = adapter.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        adapter2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, list3);
        adapter2.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayAdapter<String> adapter =
                        (ArrayAdapter<String>) adapterView.getAdapter();
                s2 = adapter.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void TR(String s, String s1, String s2, String s3) {
        double i = Double.parseDouble(s3);
        if (s == "长度") {
            if (s1 == "米") {
                i = i * 100;
            } else if (s1 == "分米") {
                i = i * 10;
            } else if (s1 == "毫米") {
                i = i / 10;
            } else if (s1 == "公里") {
                i = i * 100000;
            }

            if (s2 == "米") {
                text2.setText(String.valueOf(i / 100));
            } else if (s2 == "分米") {
                text2.setText(String.valueOf(i / 10));
            } else if (s2 == "厘米") {
                text2.setText(String.valueOf(i));
            } else if (s2 == "毫米") {
                text2.setText(String.valueOf(i * 10));
            } else if (s2 == "公里") {
                text2.setText(String.valueOf(i / 100000));
            }
        } else if (s == "面积") {
            if (s1 == "平方米") {
                i = i * 100*100;
            } else if (s1 == "平方分米") {
                i = i * 10*10;
            } else if (s1 == "平方公里") {
                i = i * 100000*100000;
            }

            if (s2 == "平方米") {
                text2.setText(String.valueOf(i / 100/100));
            } else if (s2 == "平方分米") {
                text2.setText(String.valueOf(i / 10/10));
            } else if (s2 == "平方厘米") {
                text2.setText(String.valueOf(i));
            } else if (s2 == "平方公里") {
                text2.setText(String.valueOf(i / 100000/100000));
            }
        }else if (s == "体积") {
            if (s1 == "立方米") {
                i = i * 1000*1000;
            } else if (s1 == "升") {
                i = i * 1000;
            }

            if (s2 == "立方米") {
                text2.setText(String.valueOf(i / 1000/1000));
            } else if (s2 == "立方厘米") {
                text2.setText(String.valueOf(i));
            } else if (s2 == "升") {
                text2.setText(String.valueOf(i / 1000));
            }
        }else if (s == "质量") {
            if (s1 == "克") {
                i = i/1000;
            } else if (s1 == "吨") {
                i = i * 1000;
            }

            if (s2 == "克") {
                text2.setText(String.valueOf(i*1000));
            } else if (s2 == "千克") {
                text2.setText(String.valueOf(i));
            } else if (s2 == "吨") {
                text2.setText(String.valueOf(i / 1000));
            }
        }
    }
}
