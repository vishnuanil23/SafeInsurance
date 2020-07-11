package Support;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHelper {

	String MY_DATABASE_NAME = "Safe_Insurance.db";
	public final String User_details_tbl = "User_details_tbl";
	public final String Agent_fetch_details = "Agent_fetch_details";


	public final SQLiteDatabase db;
	Context con;

	public DatabaseHelper(Context con) {
		// TODO Auto-generated constructor stub
		this.con = con;
		db = con.openOrCreateDatabase(MY_DATABASE_NAME, Context.MODE_PRIVATE, null);
		createTable(1);
	}

	public void createTable(int i) {
		switch (i) {
			case 1:
				try {

					db.execSQL("create table if not exists " +
							User_details_tbl
							+"(ID integer primary key autoincrement,Name varchar2," +
							"Phonenumber varchar2,Emailid varchar2,Country varchar2,Loginstatus varchar2," +
							"LoginDate varchar2)");

				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				break;
		}
	}

	public void insertlogindetails(String agentcode, String agentname, String brnchcode, String brnchnme, String logstat, String Date)
	{
		String sqlstr= "INSERT INTO "+User_details_tbl+"(Agn_Code,Agn_Name,Branch_Code,Br_Name,Loginstatus, LoginDate)" +
				"VALUES('"+agentcode+"','"+agentname+"','"+brnchcode+"','"+brnchnme+"','"+logstat+"','"+Date+"')";
		db.execSQL(sqlstr);
	}





}
