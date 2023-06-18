package xyz.mohammadf.assignmentfix.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import xyz.mohammadf.assignmentfix.R;
import xyz.mohammadf.assignmentfix.model.Task;

public class MyAdapter extends RecyclerView.Adapter<MyViewer> {


    Context context;
    List<Task> tasks;

    public MyAdapter(Context context, List<Task> tasks) {
        SharedPreferences sp = context.getSharedPreferences("main", Context.MODE_PRIVATE);
        Gson gson = new Gson();

        Task[] tasksArr = gson.fromJson(sp.getString("tasks", ""), Task[].class);
        if(tasksArr != null) {
            for (Task t: tasksArr) {
                if(t.isSolved()) {
                    tasks.remove(t);
                }
            }
        }
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public MyViewer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewer(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewer holder, int position) {
        holder.textView.setText(tasks.get(position).getTitle());
        Gson gson = new Gson();
        holder.textView.setHint(gson.toJson(tasks.get(position)));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
