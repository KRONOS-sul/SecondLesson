package com.example.secondlesson;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationToFragment();
    }
    private void navigationToFragment() {
        getSupportFragmentManager().
                beginTransaction().
                add(R.id.fragmentContainerView, new FirstFragment()).
                commit();
    }
}