package xyz.mohammadf.assignmentfix.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

import xyz.mohammadf.assignmentfix.MainActivity;
import xyz.mohammadf.assignmentfix.R;
import xyz.mohammadf.assignmentfix.model.Task;
import xyz.mohammadf.assignmentfix.model.User;

public class AccountActivity extends AppCompatActivity {


    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        assert savedInstanceState != null;
        user = new User(savedInstanceState.getString("fname"), savedInstanceState.getString("lname"),
                savedInstanceState.getString("email"), savedInstanceState.getString("password"));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

    }

    public void saveB(View view) {

        EditText fnameT = findViewById(R.id.fname);
        EditText lnameT = findViewById(R.id.lname);


        if(fnameT.getText().toString().isEmpty() || lnameT.getText().toString().isEmpty()) {
            return;
        }

        user.setfName(fnameT.getText().toString());
        user.setlName(lnameT.getText().toString());

        Intent intent = new Intent(AccountActivity.this, MainActivity.class);
        intent.putExtra("fname", user.getfName());
        intent.putExtra("lname", user.getlName());
        intent.putExtra("email", user.getEmail());
        intent.putExtra("password", user.getPassword());
        startActivity(intent);

    }




    public void taskClick(MenuItem item) {

        Intent intent = new Intent(AccountActivity.this, MainActivity.class);
        startActivity(intent);

    }

}
