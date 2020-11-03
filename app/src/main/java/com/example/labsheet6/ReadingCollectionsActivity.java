package com.example.labsheet6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ReadingCollectionsActivity extends AppCompatActivity {

    private Button book,paper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_collections);

        book = findViewById(R.id.btnBook);
        paper =findViewById(R.id.btnPaper);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadingCollectionsActivity.this,AddReading.class);
                intent.putExtra("book",1);
                startActivity(intent);
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadingCollectionsActivity.this,AddReading.class);
                intent.putExtra("paper",2);
                startActivity(intent);
            }
        });


    }
}