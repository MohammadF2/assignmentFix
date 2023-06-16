package xyz.mohammadf.assignmentfix.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import xyz.mohammadf.assignmentfix.MainActivity;
import xyz.mohammadf.assignmentfix.R;
import xyz.mohammadf.assignmentfix.helpers.MyAdapter;
import xyz.mohammadf.assignmentfix.model.Task;

public class TestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        List<Task> tasks = new ArrayList<>();


        tasks.add(new Task("arabic", "test", new Date(), "test"));
        tasks.add(new Task("English", "test", new Date(), "test"));
        tasks.add(new Task("French", "test", new Date(), "test"));
        tasks.add(new Task("Android", "test", new Date(), "test"));
        tasks.add(new Task("Java", "test", new Date(), "test"));
        tasks.add(new Task("QA", "test", new Date(), "test"));
        tasks.add(new Task("Database", "test", new Date(), "test"));
        tasks.add(new Task("software", "test", new Date(), "test"));


        RecyclerView recyclerView = findViewById(R.id.tasksVeiw);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), tasks));
    }

    public void examClick(View view) {

        Intent intent = new Intent(TestActivity.this, EngTaskActivity.class);
        startActivity(intent);

    }

    public void taskClick(MenuItem item) {

        Intent intent = new Intent(TestActivity.this, MainActivity.class);
        startActivity(intent);

    }


}
