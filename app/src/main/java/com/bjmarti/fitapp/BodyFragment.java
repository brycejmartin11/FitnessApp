package com.bjmarti.fitapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BodyFragment extends Fragment {

    public static final String ARG_TITLE = "arg_title";
    private TextView textView;
    private EditText mEditText;
    private String inputText;


    public BodyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_body, container, false);

        textView = (TextView) rootView.findViewById(R.id.body_TextView);
        mEditText = (EditText) rootView.findViewById(R.id.body_text_editor);

        String title = getArguments().getString(ARG_TITLE, "");
        textView.setText(title);

        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_NULL || event != null) {
                    inputText = mEditText.getText().toString();
                    Toast.makeText(getActivity(), "You typed: " + inputText, Toast.LENGTH_LONG).show();
                    return true;
                }
                return false;
            }
        });

        return rootView;
    }
}
