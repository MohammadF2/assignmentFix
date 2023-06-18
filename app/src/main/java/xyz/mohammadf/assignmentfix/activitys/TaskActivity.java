package xyz.mohammadf.assignmentfix.activitys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import xyz.mohammadf.assignmentfix.MainActivity;
import xyz.mohammadf.assignmentfix.R;
import xyz.mohammadf.assignmentfix.helpers.MyAdapter;
import xyz.mohammadf.assignmentfix.model.Task;

public class TaskActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        List<Task> tasks = new ArrayList<>();
        SharedPreferences sharedPreferences = this.getSharedPreferences("main", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        Log.d("test1313131", sharedPreferences.getString("tasks", "[{}]"));

        if (!sharedPreferences.getString("tasks", "[{}]").equals("[{}]")) {
            tasks = Arrays.asList(gson.fromJson(sharedPreferences.getString("tasks", "[{}]"), Task[].class));
            tasks = new ArrayList<>(tasks);
        } else {
            tasks.add(new Task("arabic", "test", new Date(), "test"));
            tasks.add(new Task("English", "test", new Date(), "test"));
            tasks.add(new Task("French", "test", new Date(), "test"));
            tasks.add(new Task("Android", "test", new Date(), "test"));
            tasks.add(new Task("Java", "test", new Date(), "test"));
            tasks.add(new Task("QA", "test", new Date(), "test"));
            tasks.add(new Task("Database", "test", new Date(), "test"));
            tasks.add(new Task("software", "test", new Date(), "test"));

            Task[] tasks1 = tasks.toArray(new Task[0]);
            editor.putString("tasks", gson.toJson(tasks1));
            editor.commit();
        }



        RecyclerView recyclerView = findViewById(R.id.tasksVeiw);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), tasks));
    }

    public void examClick(View view) {

        Intent intent = new Intent(TaskActivity.this, TaskWindowActivity.class);
        startActivity(intent);

    }

    public void taskClick(MenuItem item) {

        Intent intent = new Intent(TaskActivity.this, MainActivity.class);
        startActivity(intent);

    }


}
