package safe.safeinsurance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Policy_list extends AppCompatActivity {

    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        value= getIntent().getExtras().getString("Pnumber");
        if(value.equals("1")){
            setContentView(R.layout.health_child);
        }else if(value.equals("2")){
            setContentView(R.layout.motor_child);
        }
        else if (value.equals("3")){
            setContentView(R.layout.life_child);
        }





    }
}