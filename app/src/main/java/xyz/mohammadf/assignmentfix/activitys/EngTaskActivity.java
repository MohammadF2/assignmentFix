package xyz.mohammadf.assignmentfix.activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

import xyz.mohammadf.assignmentfix.MainActivity;
import xyz.mohammadf.assignmentfix.R;
import xyz.mohammadf.assignmentfix.model.Task;

public class EngTaskActivity extends AppCompatActivity {


    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng);

        final TextView date = findViewById(R.id.taskDate);
        final EditText taskText = findViewById(R.id.taskText);
        final TextView desc = findViewById(R.id.taskDescription);

        task = new Task("English essay",
                "You need to write an essay about how to change cars",
                new Date(2022, 2, 13),
                "NotReal");

        date.setText(task.getDueDate().toString());
        taskText.setHint(task.getTitle());
        desc.setText(task.getDescription());



    }


    public void submit(View view) {
        final EditText taskText = findViewById(R.id.taskText);
        if(taskText.getText().toString().trim().isEmpty()) {
            return;
        }

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Are you sure?.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        task.setAnswer(taskText.getText().toString());
                        Intent intent = new Intent(EngTaskActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }



    public void taskClick(MenuItem item) {

        Intent intent = new Intent(EngTaskActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
