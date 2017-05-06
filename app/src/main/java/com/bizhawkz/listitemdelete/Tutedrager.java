package com.bizhawkz.listitemdelete;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class Tutedrager extends AppCompatActivity {
    String strToPrint;
    String temp,t=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutedrager);

        List<String> list = Arrays.asList(new String[] {"First", "Second", "Third"});
        int index = list.indexOf("Third"); // 1
        System.out.println(index);
    }
}
