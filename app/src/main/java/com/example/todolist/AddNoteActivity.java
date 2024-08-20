package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextNote;
    private RadioButton radioButtonLow;
    private RadioButton radioButtonMedium;
    private Button buttonSave;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private AddNoteViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        init();
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote();
            }
        });
    }
    private void init(){
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        viewModel = new AddNoteViewModel(getApplication());
        editTextNote = findViewById(R.id.editTextNote);
        radioButtonLow = findViewById(R.id.radioButtonLow);
        radioButtonMedium = findViewById(R.id.radioButtonMedium);
        buttonSave = findViewById(R.id.buttonSave);
    }
    private void addNote(){
        String text = editTextNote.getText().toString().trim();
        if (text.isEmpty()) {
            Toast.makeText(getApplicationContext(), "please enter text", Toast.LENGTH_SHORT).show();
        } else {
            String date = getDate();
            int priority = getPriority();
            Note note = new Note(text, priority, date);
            viewModel.addNote(note);
            finish();
        }

    }

    private int getPriority(){
        int priority;
        if(radioButtonLow.isChecked()){
            priority=0;
        } else if(radioButtonMedium.isChecked()){
            priority=1;
        } else {
            priority=2;
        }
        return priority;
    }
    private String getDate(){
        String strDate;
        Date date = calendar.getTime();
        strDate = dateFormat.format(date);
        return strDate;
    }
    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, AddNoteActivity.class);
        return intent;
    }
}