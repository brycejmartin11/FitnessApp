package com.bjmarti.fitapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottomBarFragment extends Fragment {

    public static final String ARG_TITLE = "arg_title";
    private TextView textView;

    public BottomBarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_calendar, container, false);

        textView = (TextView) rootView.findViewById(R.id.calendar_TextView);

        String title = getArguments().getString(ARG_TITLE, "");
        textView.setText(title);

        return rootView;
    }
}
