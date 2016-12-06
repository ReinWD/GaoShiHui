package com.example.gaoshihui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ArrayList<String>ins=new ArrayList<>();

        ListView mListView = (ListView) findViewById(R.id.list_1);
        ListAdapter mListAdapter = new ArrayAdapter<String>(this,R.layout.list_layout,ins);

        ins.add("张巍");
        ins.add("dalao");
    }

}
