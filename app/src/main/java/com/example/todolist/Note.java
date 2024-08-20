package com.example.todolist;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "text")
    private String text;
    @ColumnInfo(name = "priority")
    private int priority;
    @ColumnInfo(name = "date")
    private String date;

    public Note(int id, String text, int priority, String date) {
        this.id = id;
        this.text = text;
        this.priority = priority;
        this.date = date;
    }
    @Ignore
    public Note(String text, int priority, String date) {
        this.id = 0;
        this.text = text;
        this.priority = priority;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getPriority() {
        return priority;
    }

    public String getDate() {
        return date;
    }
}
