package com.example.dell.childcare;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Food.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Food#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Food extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment__food, container, false);
        return view;
    }
}