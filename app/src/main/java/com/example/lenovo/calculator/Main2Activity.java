package com.example.lenovo.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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
import java.util.StringTokenizer;

public class Main2Activity extends BaseActivity implements View.OnClickListener {
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

    private double π=Math.PI;
    private double e=Math.E;
    private TextView show,display;
    private Stack<String> s=new Stack<String>();
    private Button zero,one,two,three,four,five,six
            ,seven,eight,nine,plus,minus
            ,spot, C,div,equal,multiplay,backspace
            ,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        display=(TextView) findViewById(R.id.display);
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
        C= (Button) findViewById(R.id.c_c);
        div= (Button) findViewById(R.id.c_div);
        multiplay= (Button) findViewById(R.id.c_multiplay);
        equal=(Button)findViewById(R.id.c_equal);
        backspace=(Button) findViewById(R.id.c_x);
        b1=(Button) findViewById(R.id.c_sign1);
        b2=(Button) findViewById(R.id.c_sign2);
        b3=(Button) findViewById(R.id.c_sign3);
        b4=(Button) findViewById(R.id.c_sign4);
        b5=(Button) findViewById(R.id.c_sign5);
        b6=(Button) findViewById(R.id.c_sign6);
        b7=(Button) findViewById(R.id.c_sign7);
        b8=(Button) findViewById(R.id.c_sign8);
        b9=(Button) findViewById(R.id.c_sign9);
        b10=(Button) findViewById(R.id.c_sign10);


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
        C.setOnClickListener(this);
        div.setOnClickListener(this);
        multiplay.setOnClickListener(this);
        equal.setOnClickListener(this);
        backspace.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);

    }
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
            case R.id.c_sign4:
            case R.id.c_sign5:
            case R.id.c_sign6:
            case R.id.c_sign7:
            case R.id.c_sign8:
            case R.id.c_sign9:
            case R.id.c_sign10:
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
                if(s3.length()==0&&show.getText().length()>0&&show.getText()!=null) {
                        s3 = show.getText().toString();
                        show.setText("");
                }
                display.setText(s3);
                break;
            case R.id.c_minus:
            case R.id.c_multiplay:
            case R.id.c_plus:
            case R.id.c_div:
            case R.id.c_sign1:
            case R.id.c_sign2:
                if(s.empty()){
                    s.add("0");
                    s.add(((Button) view).getText().toString());
                    show.setText(zero.getText().toString());
                    display.setText(((Button) view).getText());
                }else {
                    if (!s.peek().equals("÷")&&!s.peek().equals("×")&&
                            !s.peek().equals("+")&&!s.peek().equals("-")
                            &&!s.peek().equals("^") &&!s.peek().equals("√")) {
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
            case R.id.c_sign3:
                if(s.empty()){
                    s.add(((Button) view).getText().toString());
                    display.setText(((Button) view).getText());
                }else {
                    String s9=display.getText().toString();
                    s.add(((Button) view).getText().toString());
                    display.setText(s9+((Button) view).getText());
                }
                break;
            case R.id.c_equal:
                String s0=show.getText().toString()+display.getText().toString();
                if(s0.isEmpty())
                    break;
                show.setText("");
                if(s.peek().equals("÷")||s.peek().equals("×")||
                        s.peek().equals("+")||s.peek().equals("-")
                        ||s.peek().equals("^") ||s.peek().equals("√")
                        ||s.peek().equals("s") ||s.peek().equals("c")
                        ||s.peek().equals("t")) {
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
        String s1;
        for(int h=0;h<s.length();h++){
            if(s.charAt(h)=='(') {
                s = kh(s);
                h=0;
            }
        }
          s1=calculate(s);
        return s1;
    }
    private String kh(String s){
        String v;
        int y=0,m=0;
        for(int h=0;h<s.length();h++){
            if(s.charAt(h)=='(')
                y=h;
            else if(s.charAt(h)==')')
                m=h;
            if(y!=0&&m!=0) {
                v = calculate(s.substring(y+1, m));
                s=s.substring(0,y)+v+s.substring(m+1,s.length());
                y=0;m=0;h=0;
            }
        }
        if(y!=0)
            s=s+")";
        return s;
    }
    private String calculate(String s){
        ArrayList<String> number=new  ArrayList<String>();
        ArrayList<String> sign=new ArrayList<String>();
        String key;
        String num="";
        s=Simplify(s);

        for(int i=1;i<=s.length();i++) {
            key = s.substring(i - 1, i);
            if (isNum(key)) {
                if(isPai(key)) {
                    if (!num.isEmpty())
                        num = String.valueOf(Double.parseDouble(num) * π);
                    else
                        num = String.valueOf(π);
                    key="";
                }
                else if (isE(key)){
                    if (!num.isEmpty())
                        num = String.valueOf(Double.parseDouble(num) * e);
                    else
                        num = String.valueOf(e);
                    key="";
                }
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
            if(sign.get(k).equals("!")){
                number.set(k,String.valueOf(JieCheng(number.get(k))));
                sign.remove(k);
                k--;
            }
            else if(sign.get(k).equals("^")){
                number.set(k,
                        String.valueOf(CiFang(number.get(k),number.get(k+1))));
                sign.remove(k);
                number.remove(k+1);
                k--;
            }
            else if(sign.get(k).equals("√")){
                number.set(k,String.valueOf(Sqrt(number.get(k))));
                sign.remove(k);
                k--;
            }
            else if(sign.get(k).equals("s")){
                number.set(k,String.valueOf(Sin(number.get(k))));
                sign.remove(k);
                k--;
            }
            else if(sign.get(k).equals("c")){
                number.set(k,String.valueOf(Cos(number.get(k))));
                sign.remove(k);
                k--;
            }
            else if(sign.get(k).equals("t")){
                number.set(k,String.valueOf(Tan(number.get(k))));
                sign.remove(k);
                k--;
            }
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
    private String Simplify(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='c'||s.charAt(i)=='t'||s.charAt(i)=='s'){
                s= s.substring(0,i+1)+s.substring(i+3,s.length());
            }
        }
        return s;
    }
    private boolean isPai(String s){
        if(s.equals("π"))
            return true;
        return false;
    }
    private boolean isE(String s){
        if(s.equals("e"))
            return true;
        return false;
    }
    private boolean isNum(String key){
        if(key.equals("÷")||key.equals("×")
                ||key.equals("+")||key.equals("-")
                ||key.equals("!")||key.equals("^")
                ||key.equals("√")||key.equals("s")
                ||key.equals("c")||key.equals("t")
                ||key.equals("(")||key.equals(")"))
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
    private double JieCheng(String x){
        double x1=Double.parseDouble(x);
        double y1=1;
        for(int i=1;i<=x1;i++){
            y1=i*y1;
        }
        return y1;
    }
    private double CiFang(String x,String y){
        double x1,y1;
        x1=Double.parseDouble(x);
        y1=Double.parseDouble(y);
        return Math.pow(x1,y1);
    }
    private double Sqrt(String x){
        double x1=Double.parseDouble(x);
        return Math.sqrt(x1);
    }
    private double Sin(String x){
        double x1=Double.parseDouble(x);
        return Math.sin(2*π/360*x1);
    }
    private double Cos(String x){
        double x1=Double.parseDouble(x);
        return Math.cos(2*π/360*x1);
    }
    private double Tan(String x){
        double x1=Double.parseDouble(x);
        return Math.tan(2*π/360*x1);
    }
}
