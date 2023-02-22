package com.example.bookofrecipes;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AFragment extends Fragment {

    public AFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        Button dumplings = (Button) view.findViewById(R.id.button_dumplings);
        Button borsch = (Button) view.findViewById(R.id.button_borsch);
        Button pancakes = (Button) view.findViewById(R.id.button_pancakes);

        dumplings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragment firstFragment = new FirstFragment();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.replace(R.id.container, firstFragment);
                ft.commit();

            }
        });

        borsch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TwoFragment twoFragment = new TwoFragment();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.replace(R.id.container, twoFragment);
                ft.commit();
            }
        });

        pancakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThreeFragment threeFragment = new ThreeFragment();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.replace(R.id.container, threeFragment);
                ft.commit();
            }
        });

        return view;
    }




}