package com.example.bookofrecipes;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FirstFragment extends Fragment {

    private MyTimer timer;
    private TextView timerView;
    private Button start;
    private MediaPlayer player;
    private Vibrator vibrator;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button backMain = (Button) view.findViewById(R.id.back);
        start = (Button) view.findViewById(R.id.button4);
        Button reset = (Button) view.findViewById(R.id.button5);

        timerView = (TextView) view.findViewById(R.id.textView8);
        EditText myTimeText = (EditText) view.findViewById(R.id.myTime);
        TextView exceptionText = (TextView) view.findViewById(R.id.exeText);

        player = MediaPlayer.create(getContext(),R.raw.kolokol);

        vibrator=(Vibrator)getActivity().getSystemService(Context.VIBRATOR_SERVICE);

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


        // Кнопка старт таймера
         start.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (timer != null) {
                     timer.cancel();
                 }
                 String time_str = timerView.getText().toString();
                 String[] arr = time_str.split(":");
                 try{
                     int min = Integer.parseInt(arr[0]);
                     int sec = Integer.parseInt(arr[1]);
                     long mils = (min * 60 + sec) * 1000;
                     timer=new MyTimer(mils,1000,getContext(),timerView, start, player, vibrator);
                timer.start();
                 }catch (NumberFormatException nfe){
                     exceptionText.setVisibility(View.VISIBLE);
                 }

             }
         });

        // Кнопка остановить таймер и сбросить на заданное время
        reset. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setText("Начать");
                start.getBackground().setColorFilter(Color.parseColor("#4CAF50"), PorterDuff.Mode.MULTIPLY);
                timerView.setTextColor(Color.parseColor("#4CAF50"));
                if (timer != null){
                    timer.cancel();}
                timerView.setText("08:00");

                exceptionText.setVisibility(View.INVISIBLE);

//                if (player.isPlaying()){
//                    player.stop();
//                    player.release();
//                    player=MediaPlayer.create(getContext(),R.raw.kolokol);
//                }


//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    long[] pattern = {0, 400, 100, 0};
//                    vibrator.vibrate(VibrationEffect.createWaveform(pattern, -1));
//                }else {
//                    vibrator.vibrate(1000);
//                }
            }
        });


        // При изменении текста
        myTimeText.addTextChangedListener(new TextWatcher() {

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

                timerView.setText(s.toString());
            }

        });
        //


        // Inflate the layout for this fragment
        return view;
    }
public void ch(){
        timerView.setText("cadasd");
}
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

//        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState!=null) {
            ch();
            long time_save = savedInstanceState.getLong("time_save");
            if (timer != null) {
                timer.cancel();
                timerView.setText("sad");
            }

            timer = new MyTimer(time_save, 1000, getContext(), timerView, start, player, vibrator);
            timer.start();
        }
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putLong("time_save", timer.getMilisecleft());


    }

        }
