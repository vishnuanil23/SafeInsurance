package safe.safeinsurance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Support.Commonfunction;

public class Login extends AppCompatActivity {
EditText edt_username,edt_password;
TextView txt_switchtype,txt_forgot,txt_signup,txt_expiry;
Button btn_signin;
Commonfunction objcf;
int flag=0;
Date date1,date2;
String str_username,str_password,CurrentDate,Expirydate="01-08-2020";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        objcf = new Commonfunction(this);
        btn_signin=findViewById(R.id.btn_login);
        txt_switchtype=findViewById(R.id.txt_switch);
        txt_forgot=findViewById(R.id.txt_forget);
        txt_signup=findViewById(R.id.txt_newuser);
        txt_expiry=findViewById(R.id.txt_expiry);
        edt_username=findViewById(R.id.edt_username);
        edt_password=findViewById(R.id.edt_password);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        CurrentDate = df.format(c.getTime());
        try {
            date1=df.parse(CurrentDate);
            date2=df.parse(Expirydate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (date1.before(date2)){

                if(!edt_username.getText().toString().equals("")&&!edt_password.getText().toString().equals("")){

                    if (edt_username.getText().toString().equals("new")&&edt_password.getText().toString().equals("123456")){
                        Intent in =new Intent(Login.this,New_Policy.class);
                        startActivity(in);
                        edt_username.setText("");
                        edt_password.setText("");
                    }
                    else{
                        Intent in =new Intent(Login.this,MainActivity.class);
                        startActivity(in);
                        edt_username.setText("");
                        edt_password.setText("");
                    }

                }
                else{
                            objcf.show_toast("Please Enter Valid Details to Sign in");
                }
                }
                else
                {
                        txt_expiry.setVisibility(View.VISIBLE);
                        objcf.show_toast("Trail Version Expired");
                }

            }
        });
        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Login.this,Register.class);
                startActivity(in);
            }
        });

        txt_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent in = new Intent(Login.this,ForgetPassword.class);
//                startActivity(in);
            }
        });

        txt_switchtype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0){
                    edt_username.setHint("Phone Number");
                    edt_username.setText("");
                    edt_username.setFilters(new InputFilter[] { new InputFilter.LengthFilter(10) });
                    edt_username.setInputType(InputType.TYPE_CLASS_PHONE);
                    txt_switchtype.setText("Use Email Instead");
                    flag=1;
                }
                else if(flag==1)
                {
                    edt_username.setText("");
                    edt_username.setHint("Email");
                    edt_username.setFilters(new InputFilter[] { new InputFilter.LengthFilter(100) });
                    edt_username.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                    txt_switchtype.setText("Use PhoneNumber Instead");
                    flag=0;
                }

            }
        });


    }
}