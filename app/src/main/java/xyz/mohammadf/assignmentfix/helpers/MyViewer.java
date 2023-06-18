package xyz.mohammadf.assignmentfix.helpers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.logging.ConsoleHandler;

import xyz.mohammadf.assignmentfix.R;
import xyz.mohammadf.assignmentfix.activitys.TaskActivity;
import xyz.mohammadf.assignmentfix.activitys.TaskWindowActivity;

public class MyViewer extends RecyclerView.ViewHolder {



    TextView textView;
    ImageView img;

    public MyViewer(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.taskName);
        img = itemView.findViewById(R.id.imgInCard);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                }, 500);

                SharedPreferences sharedPreferences = v.getContext().getSharedPreferences("main", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("task", textView.getHint().toString());
                editor.commit();


                Intent intent = new Intent(v.getContext(), TaskWindowActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                v.getContext().startActivity(intent);
            }
        });

    }


}
