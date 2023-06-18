package xyz.mohammadf.assignmentfix.activitys;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.Date;

import xyz.mohammadf.assignmentfix.MainActivity;
import xyz.mohammadf.assignmentfix.R;
import xyz.mohammadf.assignmentfix.model.Task;

public class TaskWindowActivity extends AppCompatActivity {


    private Task task;

    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng);

        final TextView date = findViewById(R.id.taskDate);
        final EditText taskText = findViewById(R.id.taskText);
        final TextView desc = findViewById(R.id.taskDescription);

        sp = this.getSharedPreferences("main", Context.MODE_PRIVATE);
        Gson gson = new Gson();

        task = gson.fromJson(sp.getString("task", "test, test, 05/05/2023, test"), Task.class);

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
                        Gson gson = new Gson();

                        Task[] tasks = gson.fromJson(sp.getString("tasks", "[{}]"), Task[].class);
                        if (tasks != null) {

                            for (int i = 0; i < tasks.length; i++) {
                                if (task.getTitle().equals(tasks[i].getTitle())) {
                                    Log.d("Test", "found");
                                    tasks[i].setSolved(true);
                                }
                            }

                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("tasks", gson.toJson(tasks));
                            editor.commit();
                        }
                        Intent intent = new Intent(TaskWindowActivity.this, MainActivity.class);
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

        Intent intent = new Intent(TaskWindowActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
