package com.divinelimoutah.textmessage;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;

public class TempClass extends AsyncTask<Void, Void, Void> {

    @Override
    public Void doInBackground(Void... params) {

        Connection c = null;

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://172.29.231.108:5432/DivineLimousine", "postgres", "kingston52");
            if (c != null)
                System.out.println("Opened database Successfully");

//            Statement st = c.createStatement();
//            String sql = "insert into customer values(  'Bob', 2)";

//            st.execute(sql);

        } catch (Exception e){

            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }



        return null;
    }
}
