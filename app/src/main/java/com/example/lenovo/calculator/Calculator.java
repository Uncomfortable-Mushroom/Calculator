package com.example.lenovo.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

public class Calculator extends BaseActivity implements View.OnClickListener {

    private EditText display;
    private TextView show;
    private Stack<String> s=new Stack<String>();
    private Button zero,one,two,three,four,five,six
                  ,seven,eight,nine,plus,minus,precent
                  ,spot, CE,C,div,equal,multiplay,backspace;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.SC:
                Intent intent1=new Intent("com.example.calculator.ACTION_START_ONE");
                startActivity(intent1);
                break;
            case R.id.TR:
                Intent intent2=new Intent("com.example.calculator.ACTION_START_TWO");
                startActivity(intent2);
                break;
            case R.id.DW:
                Intent intent3 = new Intent("com.example.calculator.ACTION_START_THREE");
                startActivity(intent3);
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
        setContentView(R.layout.calculator);

        display=(EditText) findViewById(R.id.display);
        display.setCursorVisible(false);
        display.setEnabled(false);

        show=(TextView) findViewById(R.id.show);

         zero=(Button) findViewById(R.id.c_zero);
         one= (Button) findViewById(R.id.c_one);
         two= (Button) findViewById(R.id.c_two);
         three= (Button) findViewById(R.id.c_three);
         four= (Button) findViewById(R.id.c_four);
         five= (Button) findViewById(R.id.c_five);
         six= (Button) findViewById(R.id.c_six);
         seven= (Button) findViewById(R.id.c_seven);
         eight= (Button) findViewById(R.id.c_eight);
         nine= (Button) findViewById(R.id.c_nine);
         minus= (Button) findViewById(R.id.c_minus);
         plus= (Button) findViewById(R.id.c_plus);
         spot= (Button) findViewById(R.id.c_spot);
         CE= (Button) findViewById(R.id.c_ce);
         C= (Button) findViewById(R.id.c_c);
         div= (Button) findViewById(R.id.c_div);
         multiplay= (Button) findViewById(R.id.c_multiplay);
         equal=(Button)findViewById(R.id.c_equal);
         backspace=(Button) findViewById(R.id.c_x);
         precent=(Button) findViewById(R.id.c_precent);


        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        minus.setOnClickListener(this);
        plus.setOnClickListener(this);
        spot.setOnClickListener(this);
        CE.setOnClickListener(this);
        C.setOnClickListener(this);
        div.setOnClickListener(this);
        multiplay.setOnClickListener(this);
        equal.setOnClickListener(this);
        backspace.setOnClickListener(this);
        precent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.c_zero:
            case R.id.c_one:
            case R.id.c_two:
            case R.id.c_three:
            case R.id.c_four:
            case R.id.c_five:
            case R.id.c_six:
            case R.id.c_seven:
            case R.id.c_eight:
            case R.id.c_nine:
                String st=display.getText().toString();
                s.add(((Button) view).getText().toString());
                display.setText(st+((Button) view).getText());
                break;
            case R.id.c_spot:
                String s6=display.getText().toString();
                if(s6.equals("")
                        ||s.peek()==((Button) view).getText().toString()) {
                    s.add("0");
                    display.setText("0" + ((Button) view).getText().toString());
                }
                else
                    display.setText(s6+((Button) view).getText());
                s.add(((Button) view).getText().toString());
                break;
            case R.id.c_ce:
                display.setText("");
                break;
            case R.id.c_c:
                show.setHint("");
                if(s!=null)
                s.clear();
                show.setText("");
                display.setText("");
                break;
            case R.id.c_x:
                String s3=display.getText().toString();
                if(s3.length()>0&&!s.isEmpty())
                    s.pop();
                 if(s3.length()>0&&s3!=null)
                    s3 = s3.substring(0, s3.length() - 1);
                    if(s3.length()==0) {
                        if(show.getText().length()>0&&show.getText()!=null) {
                            s3 = show.getText().toString();
                            show.setText("");
                        }
                    }
                       display.setText(s3);
                break;
            case R.id.c_minus:
            case R.id.c_multiplay:
            case R.id.c_plus:
            case R.id.c_div:
                if(s.empty()){
                    s.add("0");
                    s.add(((Button) view).getText().toString());
                    show.setText(zero.getText().toString());
                    display.setText(((Button) view).getText());
                }else {
                    if (!s.peek().equals("÷")&&!s.peek().equals("×")&&
                            !s.peek().equals("+")&&!s.peek().equals("-")) {
                        String s1 = display.getText().toString();
                        String s2 = show.getText().toString();
                        show.setText(s2 + s1);
                        s.add(((Button) view).getText().toString());
                        display.setText(((Button) view).getText());
                    } else {
                        s.pop();
                        s.add(((Button) view).getText().toString());
                        display.setText(((Button) view).getText());
                    }
                }

                break;
            case R.id.c_precent:
                    String s4=display.getText().toString();
                     if(s4.isEmpty())
                         s4=s4+"0";
                    if(s4.charAt(s4.length()-1)<48||s4.charAt(s4.length()-1)>57)
                        s4 = s4 + "0";
                    String s5=s4.substring(0,1);
                   if(s5.equals("÷")||s5.equals("×")
                           ||s5.equals("+")||s5.equals("-")){
                       s4=s4.substring(1);
                   }else
                      s5="";
                    double d = Double.parseDouble(s4);
                    d=d/100;
                    display.setText(s5+String.valueOf(d));
                break;
            case R.id.c_equal:
                String s0=show.getText().toString()+display.getText().toString();
                if(s0.isEmpty())
                    break;
                show.setText("");
                if(s.peek().equals("÷")||s.peek().equals("×")||
                        s.peek().equals("+")||s.peek().equals("-")) {
                    s0 = s0 + "0";
                    s.add("0");
                }
                show.setHint(s0);
                display.setText(result(s0));
                break;
            default:
                break;
        }
    }

    private String result(String s) {
        ArrayList<String> number=new  ArrayList<String>();
        ArrayList<String> sign=new ArrayList<String>();
        String key;
        String num="";
        for(int i=1;i<=s.length();i++) {
            key = s.substring(i - 1, i);
            if (isNum(key)) {
                num = num + key;
            } else {
                if(num!=null&&num.length()>0)
                     number.add(num);
                       num = "";
                      sign.add(key);
            }
              if(i==s.length())
                number.add(num);
        }
          for(int k=0;k<sign.size();k++){
               if (sign.get(k).equals("÷")) {
                   number.set(k,
                           String.valueOf(div(number.get(k), number.get(k+1))));
                   number.remove(k+1);
                   sign.remove(k);
                   k--;
               } else if (sign.get(k).equals("×")){
                   number.set(k,
                           String.valueOf(multiplay(number.get(k), number.get(k+1))));
                   number.remove(k+1);
                   sign.remove(k);
                   k--;
               }
           }
        while (!sign.isEmpty()) {
                    if(sign.get(0).equals("+")){
                        number.set(0,
                                String.valueOf(plus(number.get(0), number.get(1))));
                        number.remove(1);
                        sign.remove(0);
                    }else if(sign.get(0).equals("-")){
                        number.set(0,
                                String.valueOf(minus(number.get(0), number.get(1))));
                        number.remove(1);
                        sign.remove(0);
                    }
                }
        return number.get(0);
    }
    private boolean isNum(String key){
        if(key.equals("÷")||key.equals("×")
                ||key.equals("+")||key.equals("-"))
            return false;
        return true;
    }
    private double plus(String x,String y){
        double x1=Double.parseDouble(x);
        double x2=Double.parseDouble(y);
        return x1+x2;
    }
    private double minus(String x,String y){
        double x1=Double.parseDouble(x);
        double x2=Double.parseDouble(y);
        return x1-x2;
    }
    private double multiplay(String x,String y){
        double x1=Double.parseDouble(x);
        double x2=Double.parseDouble(y);
        return x1*x2;
    }
    private double div(String x,String y){
        double x1=Double.parseDouble(x);
        double x2=Double.parseDouble(y);
        return x1/x2;
    }
}
