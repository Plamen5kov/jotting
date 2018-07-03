package com.plamen5kov.jotting;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.plamen5kov.jotting.Contants.SERIALIZED_NOTE_KEY;

public class DetailsActivity  extends AppCompatActivity {
    private EditText title;
    private EditText content;
    private Button save;
    private Button discard;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_page);
        Note note = (Note)getIntent().getSerializableExtra(SERIALIZED_NOTE_KEY);
        title = findViewById(R.id.details_title);
        content = findViewById(R.id.details_content);
        save = findViewById(R.id.btn_details_save);
        discard = findViewById(R.id.btn_details_discard);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: add request to db
            }
        });
        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailsActivity.this, HomePageActivity.class));
            }
        });

        title.setText(note.getTitle());
        content.setText(note.getContent());
    }
}
