package com.wattanar.sqliteexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList employees;
    private EditText txtSearch;
    private ListView lView;
    private Button clear_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSearch = (EditText)findViewById(R.id.txtSearch);
        lView = (ListView)findViewById(R.id.lw);
        clear_search = (Button)findViewById(R.id.clear_search);

        clear_search.setOnClickListener(this);

        okSearch("");

        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                okSearch(txtSearch.getText().toString());
            }
        });
    }

    public  void okSearch(String s) {
        MyDB db = new MyDB(this);
        db.getReadableDatabase();
        employees = db.getEmployees(s);

        Adapter adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.textview2, employees);
        lView.setAdapter((ListAdapter) adapter);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v == clear_search) {
            txtSearch.setText("");
        }
    }
}
