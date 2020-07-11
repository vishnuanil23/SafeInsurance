package safe.safeinsurance;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Calendar;
import java.util.TimeZone;

import Support.Commonfunction;

public class Register extends AppCompatActivity {
    EditText edt_countrcode, edt_mobile,edt_dob;
    Button btn_signup;
    Commonfunction objcf;
    String countryCode;
    int mYear,mMonth,mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edt_countrcode = findViewById(R.id.edt_countrycode);
        edt_mobile = findViewById(R.id.edt_mobile);
        edt_dob=findViewById(R.id.edt_dob);
        btn_signup=findViewById(R.id.btn_signup);
        objcf= new Commonfunction(this);
        countryCode = GetCountryZipCode();
        if (countryCode != null) {
            edt_countrcode.setText("+" + countryCode);
        } else {
//some error?
        }
btn_signup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        objcf.show_toast("Signed Up Successfully");
        Intent in = new Intent(Register.this,Login.class);
        startActivity(in);
    }
});

edt_dob.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        set_start_date();
    }
});


    }


    public String GetCountryZipCode() {
        String CountryID = "";
        String CountryZipCode = "";


        TelephonyManager manager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        int simState = manager.getSimState();

        switch (simState) {
            //if sim is not available then country is find out using timezone id
            case TelephonyManager.SIM_STATE_ABSENT:
                TimeZone tz = TimeZone.getDefault();
                String timeZoneId = tz.getID();
                if (!timeZoneId.equals(null)) {

                } else {
                    //do something
                }
                break;

            case TelephonyManager.SIM_STATE_READY:


                //getNetworkCountryIso
                CountryID = manager.getSimCountryIso().toUpperCase();
                String[] rl = this.getResources().getStringArray(R.array.CountryCodes);
                for (int i = 0; i < rl.length; i++) {
                    String[] g = rl[i].split(",");
                    if (g[1].trim().equals(CountryID.trim())) {
                        CountryZipCode = g[0];
                        break;

                    }


                }
        }
        return CountryZipCode;
    }


    private void set_start_date() {
        // TODO Auto-generated method stub
        final AlertDialog.Builder dp_offer_date = new AlertDialog.Builder(Register.this);
        dp_offer_date.setTitle("Select DOB");

        final View offer_datepicker = View.inflate(Register.this, R.layout.datepick, null);
        dp_offer_date.setView(offer_datepicker);

        final DatePicker dp = (DatePicker) offer_datepicker.findViewById(R.id.dp_date);

        //set the date to date picker
        String date_from_et = edt_dob.getText().toString();
        if (!date_from_et.equals("")) {
            Log.e("Date//",date_from_et);
            int dp_day = Integer.parseInt(date_from_et.substring(0, 2));
            int dp_month = Integer.parseInt(date_from_et.substring(3, 5));
            int dp_year = Integer.parseInt(date_from_et.substring(6, 10));

            dp.updateDate(dp_year, dp_month, dp_day);
        }

        dp_offer_date.setPositiveButton("Set", new AlertDialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                String day = "" + dp.getDayOfMonth();
                int month = (dp.getMonth()) + 1;
                String year = "" + dp.getYear();
                //Toast.makeText(getApplicationContext(), day+"-"+month+"-"+year, 1000).show();
                String str_month = "" + month;
                if (day.length() < 2) {
                    day = "0" + day;
                }

                if (str_month.length() < 2) {
                    str_month = "0" + str_month;
                }
                edt_dob.setText("");
                //pass_et_from_date.setText(""+day+"-"+month+"-"+year);

                //assign to form date variable for bundle to next call
                edt_dob.setText("" + day + "-" + str_month + "-" + year);
                String str_date=edt_dob.getText().toString();
//                objcf.show_toast(str_date);
                Log.e("Date Selected",""+str_date);

            }
        });

        dp_offer_date.setNegativeButton("Cancel", null);
        dp_offer_date.show();
    }


}

