package Support;

import android.content.Context;
import android.widget.Toast;

public class Commonfunction {
    Context con;

    public Commonfunction(Context cont) {
        con = cont;
    }
    public void show_toast(String msg) {
        Toast.makeText(this.con, msg,Toast.LENGTH_LONG).show();
    }
}
