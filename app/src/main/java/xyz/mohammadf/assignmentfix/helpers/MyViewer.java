package xyz.mohammadf.assignmentfix.helpers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import xyz.mohammadf.assignmentfix.R;

public class MyViewer extends RecyclerView.ViewHolder {

    TextView textView;
    ImageView img;

    public MyViewer(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.taskName);
        img = itemView.findViewById(R.id.imgInCard);
    }


}
