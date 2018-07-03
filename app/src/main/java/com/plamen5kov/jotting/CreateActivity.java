package com.plamen5kov.jotting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.plamen5kov.jotting.Contants.SERIALIZED_NOTE_KEY;

public class CreateActivity extends AppCompatActivity {
    private EditText title;
    private EditText content;
    private Button save;
    private Button discard;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_page);
        title = findViewById(R.id.create_title);
        content = findViewById(R.id.create_content);
        save = findViewById(R.id.btn_create_save);
        discard = findViewById(R.id.btn_create_discard);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = new Note();
                note .setTitle(title.getText().toString());
                note .setContent(content.getText().toString());

                //TODO: add request to db with note
            }
        });
        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateActivity.this, HomePageActivity.class));
            }
        });

    }
}
