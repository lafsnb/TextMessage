package com.divinelimoutah.textmessage;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MainActivity extends ActionBarActivity{

    private EditText phone;
    private String phoneNumber;
    TempClass temp = new TempClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void click(View view) {
        phone = (EditText) findViewById(R.id.editText);
        phoneNumber = phone.getText().toString();
        SmsManager smsManager = SmsManager.getDefault();

        PendingIntent sentPI;
        String SENT = "SMS_SENT";

        sentPI = PendingIntent.getBroadcast(this, 0, new Intent(SENT), 0);

        temp.doInBackground();
//        Connection c = null;
//
//        try {
//
//            Class.forName("org.postgresql.Driver");
//            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DivineLimousine", "postgres", "kingston52");
//            if (c != null)
//                System.out.println("Opened database Successfully");
//
////            Statement st = c.createStatement();
////            String sql = "insert into customer values(  'Bob', 2)";
//
////            st.execute(sql);
//
//        } catch (Exception e){
//
//            e.printStackTrace();
//            System.err.println(e.getClass().getName() + ":" + e.getMessage());
//            System.exit(0);
//        }
        smsManager.sendTextMessage(phoneNumber, null, "Hey guess what, I figured out how to send a text via app XD.", sentPI, null);
        Toast.makeText(getApplicationContext(), SENT, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
