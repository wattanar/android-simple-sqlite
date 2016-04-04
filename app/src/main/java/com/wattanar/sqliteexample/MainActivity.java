package com.wattanar.sqliteexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDB db = new MyDB(this);
        db.getReadableDatabase();
        employees = db.getEmployees();

        final ListView lView = (ListView)findViewById(R.id.lw);
        Adapter adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, employees);
        lView.setAdapter((ListAdapter) adapter);
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
