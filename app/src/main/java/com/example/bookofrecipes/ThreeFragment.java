package com.example.bookofrecipes;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThreeFragment extends Fragment {

    private MyTimer timer;

    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        Button backMain = (Button) view.findViewById(R.id.button13);
        Button start = (Button) view.findViewById(R.id.button_start);
        Button reset = (Button) view.findViewById(R.id.button12);

        TextView timerView1 = (TextView) view.findViewById(R.id.textView48);
        EditText myTimeText1 = (EditText) view.findViewById(R.id.textView49);
        TextView exceptionText1 = (TextView) view.findViewById(R.id.exetextView50);

        MediaPlayer player = MediaPlayer.create(getContext(),R.raw.kolokol);
        Vibrator vibrator=(Vibrator)getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        // Кнопка вернуться назад к списку рецептов
        backMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AFragment aFragment = new AFragment();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, aFragment);
                ft.commit();

            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer != null) {
                    timer.cancel();
                }
                String time_str = timerView1.getText().toString();
                String[] arr = time_str.split(":");
                try{
                    int min = Integer.parseInt(arr[0]);
                    int sec = Integer.parseInt(arr[1]);
                    long mils = (min * 60 + sec) * 1000;
                    timer=new MyTimer(mils,1000,getContext(),timerView1, start, player, vibrator);
                    timer.start();
                }catch (NumberFormatException nfe){
                    exceptionText1.setVisibility(View.VISIBLE);
                }


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setText("Начать");
                start.getBackground().setColorFilter(Color.parseColor("#4CAF50"), PorterDuff.Mode.MULTIPLY);
                timerView1.setTextColor(Color.parseColor("#4CAF50"));
                if (timer != null){
                    timer.cancel();}
                timerView1.setText("30:00");

                exceptionText1.setVisibility(View.INVISIBLE);


            }
        });

        // При изменении текста
        myTimeText1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if (timer != null){
                    timer.cancel();}

                timerView1.setText(s.toString());
            }

        });

        return view;
    }
}