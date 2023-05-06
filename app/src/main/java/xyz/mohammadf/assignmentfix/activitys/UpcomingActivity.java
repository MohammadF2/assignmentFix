package xyz.mohammadf.assignmentfix.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import xyz.mohammadf.assignmentfix.MainActivity;
import xyz.mohammadf.assignmentfix.R;

public class UpcomingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcomming);
    }




    public void taskClick(MenuItem item) {

        Intent intent = new Intent(UpcomingActivity.this, MainActivity.class);
        startActivity(intent);

    }
}