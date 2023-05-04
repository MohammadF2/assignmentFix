package xyz.mohammadf.assignmentfix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

import xyz.mohammadf.assignmentfix.model.User;

public class MainActivity extends AppCompatActivity {

    private TextView greetingText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        greetingText = findViewById(R.id.greetingText);

        User user = new User();


        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if(hour < 6 || hour > 18){
            String text = "Good Evening, " + user.getfName() + " " + user.getlName() + "\uD83C\uDF19";
            greetingText.setText(text);
        } else {
            String text = "Good Morning, " + user.getfName() + " " + user.getlName() + "☀️";
            greetingText.setText(text);
        }



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




}