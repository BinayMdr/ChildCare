package com.example.dell.childcare;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private static final String KEY__nameofparent="nameofparent";
    private static final String KEY_nameofchild="nameofchild";
    private static final String KEY_gender="gender";
    private static final String KEY_birthdate="birthdate";
    RadioGroup radioGroup;
    RadioButton radioButton;

    EditText editnop,editnoc,editdob,mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference notebookRef=db.collection("Registeration");
    private DocumentReference noteRef=db.document("Registeration/Info");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       editnop=findViewById(R.id.nameofparent);
        editnoc=findViewById(R.id.nameofchild);
        radioGroup=findViewById(R.id.gender);
        mDisplayDate=findViewById(R.id.birthdate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        RegisterActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = month + "/" + day + "/" + year;
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date dateObj = null;
                try {
                    System.out.println(date);
                    dateObj = dateFormat.parse(date);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Date d2=new Date();

                long diff =d2.getTime()-dateObj.getTime();
                long seconds = diff / 1000;
                long minutes = seconds / 60;
                long hours = minutes / 60;
                long days = hours / 24;
                if(days<=0||days>3650)
                {
                    mDisplayDate.setText("");
                }
                    else
                        {
                    mDisplayDate.setText(date);
                }
            }
        };


    }
    public void SaveData(View view)
    {
        String parent=editnop.getText().toString();
        String child=editnoc.getText().toString();
        int radioInt=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(radioInt);
        String gender=radioButton.getText().toString();
        String dob=mDisplayDate.getText().toString();
        if(parent.equals("")||child.equals("")||dob.equals(""))
        {
            Toast.makeText(this,"Fields are empty",Toast.LENGTH_SHORT).show();

        }
        else {
            if(!haveNetwork())
            {
                Toast.makeText(this,"Please make sure you are connected to internet",Toast.LENGTH_SHORT).show();
            }
            else {
                Register note = new Register(parent, child, gender, dob);
                notebookRef.add(note);
                Toast.makeText(this, "Thank you for registering", Toast.LENGTH_SHORT).show();
                editnop.setText("");
                editnoc.setText("");
                mDisplayDate.setText("");
            }
        }

    }
    private boolean haveNetwork()
    {
        boolean have_WIFI=false;
        boolean have_MobileData=false;
        ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos=connectivityManager.getAllNetworkInfo();
        for(NetworkInfo info:networkInfos)
        {
            if(info.getTypeName().equalsIgnoreCase("WIFI"))
                if(info.isConnected())
                    have_WIFI=true;
            if(info.getTypeName().equalsIgnoreCase("MobileData"))
                if(info.isConnected())
                    have_MobileData=true;
        }
      return have_MobileData||have_WIFI;
    }
}
