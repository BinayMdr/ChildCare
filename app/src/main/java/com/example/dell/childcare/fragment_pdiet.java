package com.example.dell.childcare;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


public class fragment_pdiet extends Fragment {
    TableLayout first,second;
    UserSessionManager session;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment_pdiet, container, false);
        session = new UserSessionManager(getActivity());
        first=view.findViewById(R.id.first);
        second=view.findViewById(R.id.second);
        HashMap<String, String> user = session.getUserDetails();
        String name = user.get(UserSessionManager.KEY_NAME);
        String email = user.get(UserSessionManager.KEY_EMAIL);
        String d1 = email;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date dateObj = null;


        try {
            System.out.println(d1);
            dateObj = dateFormat.parse(d1);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date d2 = new Date();

        double diff = d2.getTime() - dateObj.getTime();
        double seconds = diff / 1000;
        double minutes = seconds / 60;
        double hours = minutes / 60;
        double day = hours / 24;
        double month = day / 30;
        double yr = month / 12;
        int yrs = (int) yr;
        if(yrs>=0 && yrs<6)
        {
            first.setVisibility(View.VISIBLE);
        }
        else if(yrs>=6 && yrs<=10)
        {
            second.setVisibility(View.VISIBLE);
        }
        return view;
    }


}
