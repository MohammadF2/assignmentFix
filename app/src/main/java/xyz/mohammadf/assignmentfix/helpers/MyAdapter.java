package xyz.mohammadf.assignmentfix.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import xyz.mohammadf.assignmentfix.R;
import xyz.mohammadf.assignmentfix.model.Task;

public class MyAdapter extends RecyclerView.Adapter<MyViewer> {


    Context context;
    List<Task> tasks;

    public MyAdapter(Context context, List<Task> tasks) {
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
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
