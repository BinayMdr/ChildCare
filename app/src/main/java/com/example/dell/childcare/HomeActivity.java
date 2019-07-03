package com.example.dell.childcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.drm.DrmStore;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.onesignal.OneSignal;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    UserSessionManager session;
    ViewFlipper v_flipper;
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        session = new UserSessionManager(getApplicationContext());
        int images[] = {R.drawable.kid, R.drawable.kiddo};
        v_flipper = findViewById(R.id.v_flipper);
        mDrawerLayout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        for (int i = 0; i < images.length; i++) {
            flipperImages(images[i]);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.food) {
            Intent intent = new Intent(HomeActivity.this, FoodActivity.class);
            startActivity(intent);
        }
        if (id == R.id.map) {
            Intent intent = new Intent(HomeActivity.this, MapsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.vaccination) {

            Intent intent = new Intent(HomeActivity.this, MainDatabaseActivity.class);
            startActivity(intent);
        }
        if (id == R.id.learning) {
            Intent intent = new Intent(HomeActivity.this, LearningActivity.class);
            startActivity(intent);
        }

        if (id == R.id.email) {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "binaymdr25@gmail.com", null));
            intent.putExtra(Intent.EXTRA_SUBJECT, "About App");
            intent.putExtra(Intent.EXTRA_TEXT, "Is there anyone to talk?");
            startActivity(intent);
        }
        return false;
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(5000);
        v_flipper.setAutoStart(true);


    }

    public void Register(View view) {
        if (session.checkLogin()) {

            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);

        } else
            {
                Intent intent = new Intent(HomeActivity.this, ViewActivity.class);
                startActivity(intent);

        }

    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent i=new Intent(this,HomeActivity.class);
            startActivity(i);
            finish();
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        finish();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
