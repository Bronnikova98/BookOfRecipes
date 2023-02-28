package com.example.bookofrecipes;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TwoFragment extends Fragment {

    private MyTimer timer;
    private MyTimer timer2;
    private MyTimer timer3;
    private MyTimer timer4;
    MediaPlayer player;
    MediaPlayer player2;
    MediaPlayer player3;
    MediaPlayer player4;

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        Button backMain = (Button) view.findViewById(R.id.button11);
        Button start1 = (Button) view.findViewById(R.id.button_s);
        Button reset1 = (Button) view.findViewById(R.id.button2);
        Button start2 = (Button) view.findViewById(R.id.button3);
        Button reset2 = (Button) view.findViewById(R.id.button6);
        Button start3 = (Button) view.findViewById(R.id.button7);
        Button reset3 = (Button) view.findViewById(R.id.button8);
        Button start4 = (Button) view.findViewById(R.id.button9);
        Button reset4 = (Button) view.findViewById(R.id.button10);

        TextView timerView1 = (TextView) view.findViewById(R.id.textView22);
        EditText myTimeText1 = (EditText) view.findViewById(R.id.textView23);
        TextView exceptionText1 = (TextView) view.findViewById(R.id.exetextView34);
        TextView timerView2 = (TextView) view.findViewById(R.id.textView25);
        EditText myTimeText2 = (EditText) view.findViewById(R.id.textView26);
        TextView exceptionText2 = (TextView) view.findViewById(R.id.exetextView36);
        TextView timerView3 = (TextView) view.findViewById(R.id.textView28);
        EditText myTimeText3 = (EditText) view.findViewById(R.id.textView29);
        TextView exceptionText3 = (TextView) view.findViewById(R.id.exetextView37);
        TextView timerView4 = (TextView) view.findViewById(R.id.textView31);
        EditText myTimeText4 = (EditText) view.findViewById(R.id.textView32);
        TextView exceptionText4 = (TextView) view.findViewById(R.id.exetextView38);

        player = MediaPlayer.create(getContext(),R.raw.kolokol);
        player2 = MediaPlayer.create(getContext(),R.raw.kolokol);
        player3 = MediaPlayer.create(getContext(),R.raw.kolokol);
        player4 = MediaPlayer.create(getContext(),R.raw.kolokol);

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

        start1.setOnClickListener(new View.OnClickListener() {
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
                    timer=new MyTimer(mils,1000,getContext(),timerView1, start1);
                    timer.start();
                }catch (NumberFormatException nfe){
                    exceptionText1.setVisibility(View.VISIBLE);
                }

                if (player.isPlaying()){
                    player.stop();
                    player.release();
                    player=MediaPlayer.create(getContext(),R.raw.kolokol);
                }
                player.start();

            }
        });

        reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start1.setText("Начать");
                start1.getBackground().setColorFilter(Color.parseColor("#4CAF50"), PorterDuff.Mode.MULTIPLY);
                timerView1.setTextColor(Color.parseColor("#4CAF50"));
                if (timer != null){
                    timer.cancel();}
                timerView1.setText("30:00");

                exceptionText1.setVisibility(View.INVISIBLE);

                if (player.isPlaying()){
                    player.stop();
                    player.release();
                    player=MediaPlayer.create(getContext(),R.raw.kolokol);
                }
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

        start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer2 != null) {
                    timer2.cancel();
                }
                String time_str = timerView2.getText().toString();
                String[] arr = time_str.split(":");
                try{
                    int min = Integer.parseInt(arr[0]);
                    int sec = Integer.parseInt(arr[1]);
                    long mils = (min * 60 + sec) * 1000;
                    timer2=new MyTimer(mils,1000,getContext(),timerView2, start2);
                    timer2.start();
                }catch (NumberFormatException nfe){
                    exceptionText2.setVisibility(View.VISIBLE);
                }

                if (player2.isPlaying()){
                    player2.stop();
                    player2.release();
                    player2=MediaPlayer.create(getContext(),R.raw.kolokol);
                }
                player2.start();
            }
        });

        reset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start2.setText("Начать");
                start2.getBackground().setColorFilter(Color.parseColor("#4CAF50"), PorterDuff.Mode.MULTIPLY);
                timerView2.setTextColor(Color.parseColor("#4CAF50"));
                if (timer2 != null){
                    timer2.cancel();}
                timerView2.setText("10:00");

                exceptionText2.setVisibility(View.INVISIBLE);

                if (player2.isPlaying()){
                    player2.stop();
                    player2.release();
                    player2=MediaPlayer.create(getContext(),R.raw.kolokol);
                }

            }
        });

        myTimeText2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if (timer2 != null){
                    timer2.cancel();}

                timerView2.setText(s.toString());
            }

        });

        start3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer3 != null) {
                    timer3.cancel();
                }
                String time_str = timerView3.getText().toString();
                String[] arr = time_str.split(":");
                try{
                    int min = Integer.parseInt(arr[0]);
                    int sec = Integer.parseInt(arr[1]);
                    long mils = (min * 60 + sec) * 1000;
                    timer3=new MyTimer(mils,1000,getContext(),timerView3, start3);
                    timer3.start();
                }catch (NumberFormatException nfe){
                    exceptionText3.setVisibility(View.VISIBLE);
                }

                if (player3.isPlaying()){
                    player3.stop();
                    player3.release();
                    player3=MediaPlayer.create(getContext(),R.raw.kolokol);
                }
                player3.start();
            }
        });

        reset3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start3.setText("Начать");
                start3.getBackground().setColorFilter(Color.parseColor("#4CAF50"), PorterDuff.Mode.MULTIPLY);
                timerView3.setTextColor(Color.parseColor("#4CAF50"));
                if (timer3 != null){
                    timer3.cancel();}
                timerView3.setText("15:00");

                exceptionText3.setVisibility(View.INVISIBLE);

                if (player3.isPlaying()){
                    player3.stop();
                    player3.release();
                    player3=MediaPlayer.create(getContext(),R.raw.kolokol);
                }
            }
        });

        myTimeText3.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if (timer3 != null){
                    timer3.cancel();}

                timerView3.setText(s.toString());
            }

        });

        start4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer4 != null) {
                    timer4.cancel();
                }
                String time_str = timerView4.getText().toString();
                String[] arr = time_str.split(":");
                try{
                    int min = Integer.parseInt(arr[0]);
                    int sec = Integer.parseInt(arr[1]);
                    long mils = (min * 60 + sec) * 1000;
                    timer4=new MyTimer(mils,1000,getContext(),timerView4, start4);
                    timer4.start();
                }catch (NumberFormatException nfe){
                    exceptionText4.setVisibility(View.VISIBLE);
                }

                if (player4.isPlaying()){
                    player4.stop();
                    player4.release();
                    player4=MediaPlayer.create(getContext(),R.raw.kolokol);
                }
                player4.start();
            }
        });

        reset4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start4.setText("Начать");
                start4.getBackground().setColorFilter(Color.parseColor("#4CAF50"), PorterDuff.Mode.MULTIPLY);
                timerView4.setTextColor(Color.parseColor("#4CAF50"));
                if (timer4 != null){
                    timer4.cancel();}
                timerView4.setText("20:00");

                exceptionText4.setVisibility(View.INVISIBLE);

                if (player4.isPlaying()){
                    player4.stop();
                    player4.release();
                    player4=MediaPlayer.create(getContext(),R.raw.kolokol);
                }
            }
        });

        myTimeText4.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if (timer4 != null){
                    timer4.cancel();}

                timerView4.setText(s.toString());
            }

        });

        return view;
    }
}