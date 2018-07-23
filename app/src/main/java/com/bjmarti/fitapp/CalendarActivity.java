package com.bjmarti.fitapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class CalendarActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_body:
                        Log.d("Fitness", "body selected");
                        goToBody();
                        break;
                    case R.id.action_calendar:
                        Log.d("Fitness", "calendar selected");
                        break;
                    case R.id.action_progress:
                        Log.d("Fitness", "progress selected");
                        goToProgress();
                        break;
                    case R.id.action_workouts:
                        Log.d("Fitness", "workouts selected");
                        goToWorkouts();
                        break;
                }
                return true;
            }
        });
    }

    public void goToWorkouts() {
        Intent intent = new Intent(this, MainWorkoutActivity.class);
        finish();
        startActivity(intent);
    }

    public void goToProgress() {
        Intent intent = new Intent(this, ProgressActivity.class);
        finish();
        startActivity(intent);
    }

    public void goToBody() {
        Intent intent = new Intent(this, BodyActivity.class);
        finish();
        startActivity(intent);
    }
}
