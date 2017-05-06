package com.bizhawkz.listitemdelete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Tutedrager extends AppCompatActivity {
    String strToPrint;
    String temp,t=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutedrager);
        int aNums[] = { 2, 4, 6 };
        System.out.println(java.util.Arrays.toString(aNums));
        for(int i=0; i<5; i++) {

            for (int j = 0; j < 5 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
