package safe.safeinsurance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import Support.Commonfunction;

public class MainActivity extends AppCompatActivity {
    LinearLayout ll1,ll2,ll3,ll_new,ll_services,ll_about;
    Commonfunction objcf;
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll1=findViewById(R.id.ll1);
        ll2=findViewById(R.id.ll2);
        ll3=findViewById(R.id.ll3);
        ll_about=findViewById(R.id.ll_about);
        ll_new=findViewById(R.id.ll_newinsurance);
        ll_services=findViewById(R.id.ll_services);
        objcf= new Commonfunction(this);

        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in= new Intent(MainActivity.this,Policy_list.class);
                in.putExtra("Pnumber","2");
               startActivity(in);

            }
        });

        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in= new Intent(MainActivity.this,Policy_list.class);
                int i=1;
                in.putExtra("Pnumber","1");
                startActivity(in);

            }
        });

        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in= new Intent(MainActivity.this,Policy_list.class);
                in.putExtra("Pnumber","3");
                startActivity(in);

            }
        });


        ll_services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,Services.class);
                startActivity(in);

            }
        });

        ll_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,New_Policy.class);
                startActivity(in);


            }
        });

        ll_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,About.class);
                startActivity(in);
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        objcf.show_toast("Click Back Again to Exit");

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 3000);
    }
}