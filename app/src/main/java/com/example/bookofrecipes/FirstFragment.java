package com.example.bookofrecipes;

import android.app.NotificationManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FirstFragment extends Fragment {

//    private TextView timerView;
//    private MyTimer timer;
//
//    private EditText myTimeText;
//    private TextView exceptionText;
//    private static final int NOTIFY_ID = 100;
//    private Handler handler;
//    private NotificationManager notificationManager;
//    private final String CHANEL = "main";


    public FirstFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button backMain = (Button) view.findViewById(R.id.back);
        Button start = (Button) view.findViewById(R.id.back);
        Button reset = (Button) view.findViewById(R.id.back);


        // Inflate the layout for this fragment
        return view;
    }
}