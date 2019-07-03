package com.example.dell.childcare;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static android.content.Context.ALARM_SERVICE;


public class PVaccination extends Fragment {

    Button logout, search;
    UserSessionManager session;


    private NoteAdapter adapter;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Notebook");
    private DocumentReference noteRef = db.document("Notebook/My First Note");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)

    {
        View view = inflater.inflate(R.layout.fragment_pvaccination, container, false);
        session = new UserSessionManager(getActivity());
        logout = view.findViewById(R.id.logout);
        Toast.makeText(getActivity(), "User login Status:" + session.isUserLoggedIn(), Toast.LENGTH_SHORT).show();
        HashMap<String, String> user = session.getUserDetails();
        String name = user.get(UserSessionManager.KEY_NAME);
        String email = user.get(UserSessionManager.KEY_EMAIL);


        //first=findViewById(R.id.first);
        //second=findViewById(R.id.second);

        //  String d1=dob;
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
        //tv1.setText(Double.toString(yr));
        // forVac(day,month,yr);
        //forDiet(yr);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                session.logoutUser();
            }
        });

        if (session.checkLogin()) {
            Activity activity = getActivity();
            activity.finish();
        }

        setUpRecycle(yrs, view);
        nottify();

        return view;

    }

    public void setUpRecycle(int a, View view) {


        Query query = notebookRef.whereEqualTo("priority", a);
        FirestoreRecyclerOptions<Note> options = new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query, Note.class)
                .build();
        adapter = new NoteAdapter(options);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onStart() {
        super.onStart();
        if (adapter != null) {
            adapter.startListening();
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }


    }
    public void nottify()
    {
        Date dat  = new Date();//initializes to now
        AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getContext(), Alarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(),0010000,intent,0);
        Calendar cal_alarm = Calendar.getInstance();
        Calendar cal_now = Calendar.getInstance();
        cal_now.setTime(dat);
        cal_alarm.setTime(dat);
        cal_alarm.set(Calendar.HOUR_OF_DAY,21);//set the alarm time
        cal_alarm.set(Calendar.MINUTE, 30);
        cal_alarm.set(Calendar.SECOND,0);
        alarmManager.set(AlarmManager.RTC,cal_alarm.getTimeInMillis(),pendingIntent);

    }


}