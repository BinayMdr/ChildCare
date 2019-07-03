package com.example.dell.childcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity {
    UserSessionManager session;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Registeration");
    private DocumentReference noteRef = db.document("Registeration/Info");
  EditText one,two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session=new UserSessionManager(getApplicationContext());
        one=findViewById(R.id.one);
        two=findViewById(R.id.second);
        Toast.makeText(getApplicationContext(),
                "User Login Status: " + session.isUserLoggedIn(),
                Toast.LENGTH_LONG).show();


    }
    @Override
    protected void onStart() {
        super.onStart();
        notebookRef.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            private QuerySnapshot queryDocumentSnapshots;
            private FirebaseFirestoreException e;

            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
                this.queryDocumentSnapshots = queryDocumentSnapshots;
                this.e = e;
                if (e != null) {
                    return;
                }

                String data = "";

                for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    Register note = documentSnapshot.toObject(Register.class);
                    note.setDocumentId(documentSnapshot.getId());

                    String documentId = note.getDocumentId();
                    String title = note.getNameofparent();
                    String description = note.getNameofchild();

                }


            }
        });
    }



    public void loadNotes(View v) {
        final String nameofp=one.getText().toString();
        final  String nameofc=two.getText().toString();
        if(nameofp.equals("")||nameofc.equals(""))
        {
            Toast.makeText(this,"Fields are empty",Toast.LENGTH_SHORT).show();
        }
else {
            notebookRef.whereEqualTo("nameofparent", nameofp)
                    .whereEqualTo("nameofchild", nameofc)
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


                            for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                                Register note = documentSnapshot.toObject(Register.class);
                                note.setDocumentId(documentSnapshot.getId());

                                String documentId = note.getDocumentId();
                                String title = note.getNameofparent();
                                String description = note.getNameofchild();
                                String gender=note.getGender();
                                String dob=note.getBirthdate();
                                session.createUserLoginSession(gender,dob);
                                Intent i = new Intent(LoginActivity.this, ViewActivity.class);
                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


                                startActivity(i);
                                finish();

                            }


                        }
                    });

        }


    }
    public void RegisterHere(View v)
    {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent i=new Intent(this,HomeActivity.class);
        startActivity(i);
        finish();
    }
}
