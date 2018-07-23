package com.bjmarti.fitapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainWorkoutActivity extends AppCompatActivity {

    private static final String TAG_FRAGMENT_WORKOUTS = "tag_frag_workouts";
    private static final String TAG_FRAGMENT_PROGRESS = "tag_frag_progress";
    private static final String TAG_FRAGMENT_CALENDAR = "tag_frag_calendar";
    private static final String TAG_FRAGMENT_BODY = "tag_frag_body";

    private BottomNavigationView mBottomNavigationView;
    private List<Fragment> fragments = new ArrayList<>(4);

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
                        switchFragment(1, TAG_FRAGMENT_BODY);
                        //goToBody();
                        break;
                    case R.id.action_calendar:
                        Log.d("Fitness", "calendar selected");
                        switchFragment(3, TAG_FRAGMENT_CALENDAR);
                        //goToCalendar();
                        break;
                    case R.id.action_progress:
                        Log.d("Fitness", "progress selected");
                        switchFragment(2,TAG_FRAGMENT_PROGRESS);
                        //goToProgress();
                        break;
                    case R.id.action_workouts:
                        Log.d("Fitness", "workouts selected");
                        switchFragment(0,TAG_FRAGMENT_WORKOUTS);
                        //break;
                }
                return true;
            }
        });

        buildFragmentsList();

        // Set the 0th Fragment to be displayed by default.
        switchFragment(0, TAG_FRAGMENT_WORKOUTS);
    }

    public void goToCalendar() {
        Intent intent = new Intent(this, CalendarActivity.class);
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

    private void switchFragment(int pos, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_fragment_holder, fragments.get(pos), tag)
                .commit();
    }

    private void buildFragmentsList() {
        BodyFragment bodyFragment = buildBodyFragment("Body");
        BottomBarFragment calendarFragment = buildFragment("Calendar");
        BottomBarFragment workoutsFragment = buildFragment("Workouts");
        BottomBarFragment progressFragment = buildFragment("Progress");


        fragments.add(workoutsFragment);
        fragments.add(bodyFragment);
        fragments.add(progressFragment);
        fragments.add(calendarFragment);

    }

    private BottomBarFragment buildFragment(String title) {
        BottomBarFragment fragment = new BottomBarFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BottomBarFragment.ARG_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    private BodyFragment buildBodyFragment(String title) {
        BodyFragment fragment = new BodyFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BottomBarFragment.ARG_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }


}
