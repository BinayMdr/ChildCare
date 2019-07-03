package com.example.dell.childcare;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragementTab1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragementTab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragementTab1 extends Fragment {
    private static final String TAG="TAB1";
    private ImageButton zero,one,two,three,four,five,six,seven,eight,nine;
    MediaPlayer zerom,onem,twom,threem,fourm,fivem,sixm,sevenm,eightm,ninem;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragement_tab1,container,false);
        zero=view.findViewById(R.id.zero);
        one=view.findViewById(R.id.one);
        two=view.findViewById(R.id.two);
        three=view.findViewById(R.id.three);
        four=view.findViewById(R.id.four);
        five=view.findViewById(R.id.five);
        six=view.findViewById(R.id.six);
        seven=view.findViewById(R.id.seven);
        eight=view.findViewById(R.id.eight);
        nine=view.findViewById(R.id.nine);
        zerom= MediaPlayer.create(getContext(),R.raw.zero);
        onem= MediaPlayer.create(getContext(),R.raw.one);
        twom= MediaPlayer.create(getContext(),R.raw.two);
        threem= MediaPlayer.create(getContext(),R.raw.three);
        fourm= MediaPlayer.create(getContext(),R.raw.four);
        fivem= MediaPlayer.create(getContext(),R.raw.five);
        sixm= MediaPlayer.create(getContext(),R.raw.six);
        sevenm= MediaPlayer.create(getContext(),R.raw.seven);
        eightm= MediaPlayer.create(getContext(),R.raw.eight);
        ninem= MediaPlayer.create(getContext(),R.raw.nine);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zerom.start();
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onem.start();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twom.start();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threem.start();
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fourm.start();
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fivem.start();
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sixm.start();
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sevenm.start();
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eightm.start();
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ninem.start();
            }
        });
        return view;
    }
}
