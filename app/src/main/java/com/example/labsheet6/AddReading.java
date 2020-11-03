package com.example.labsheet6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddReading extends AppCompatActivity {

    private TextView lblAuthor, lblTitle;
    private EditText txtTitle,txtAuthor;
    private Button view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reading);

        lblTitle = findViewById(R.id.lblTitle);
        lblAuthor = findViewById(R.id.lblAuthor);

        txtTitle = findViewById(R.id.txtTitle);
        txtAuthor = findViewById(R.id.txtAuthor);

        view= findViewById(R.id.btnView);
        FragmentChange();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickView();
            }
        });


    }

    private void FragmentChange(){
        Integer flag = getIntent().getIntExtra("book",0);
        if(flag==1){
            lblTitle.setText("Title: ");
            lblAuthor.setText("Author: ");

            Fragment fragment1 = new BookFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment,fragment1);
            ft.commit();
        }else{
            lblTitle.setText("Title of the Article: ");
            lblAuthor.setText("Editor: ");

            Fragment fragment2 = new PaperFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment2,fragment2);
            ft.commit();
        }
    }

    private void clickView(){
        String title = txtTitle.getText().toString();
        String author = txtAuthor.getText().toString();

        AlertDialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(AddReading.this);
        builder.setTitle("You Are reading! ");
        builder.setMessage(title+" by "+author);
        builder.setPositiveButton("OK",null);
        dialog = builder.create();
        dialog.show();
    }
}