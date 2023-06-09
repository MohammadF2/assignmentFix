package xyz.mohammadf.assignmentfix;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

import xyz.mohammadf.assignmentfix.activitys.TaskActivity;
import xyz.mohammadf.assignmentfix.activitys.UpcomingActivity;
import xyz.mohammadf.assignmentfix.model.User;

public class MainActivity extends AppCompatActivity {

    private TextView greetingText;

    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        if(savedInstanceState != null) {
             user = new User(savedInstanceState.getString("fname"), savedInstanceState.getString("lname"),
                    savedInstanceState.getString("email"), savedInstanceState.getString("password"));
        } else {
             user = new User("Mohammad", "Faraj", "mohammad@mohammad.com", "123456");
        }

        System.out.println("test");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView greetingText = findViewById(R.id.greetingText);



        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if(hour < 6 || hour > 18){
            String text = "Good Evening, " + user.getfName() + " " + user.getlName() + "\uD83C\uDF19";
            greetingText.setText(text);
        } else {
            String text = "Good Morning, " + user.getfName() + " " + user.getlName() + "☀️";
            greetingText.setText(text);
        }

    }

    public void taskClick(View view) {
        Intent intent = new Intent(MainActivity.this, TaskActivity.class);
        startActivity(intent);
    }

    public void examClick(View view) {
        Intent intent = new Intent(MainActivity.this, UpcomingActivity.class);
        startActivity(intent);
    }

    public void gradesClick(View view) {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Will be added next update.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }

    public void taskClick(MenuItem item) {

    }



}