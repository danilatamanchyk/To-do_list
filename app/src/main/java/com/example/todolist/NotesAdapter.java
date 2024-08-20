package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {
    private List<Note> notes = new ArrayList<>();
    public void setNotes(List<Note> notes){
        this.notes=notes;
        notifyDataSetChanged();
    }
    public List<Note> getNotes() {
        return notes;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_note_item, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Note note = notes.get(position);

        holder.textViewNote.setText(note.getText());
        holder.textViewNoteDate.setText(note.getDate());
        int colorResId;
        switch (note.getPriority()){
            case 0:
                colorResId = R.color.green;
                break;
            case 1:
                colorResId = R.color.yellow;
                break;
            default:
                colorResId = R.color.red;
        }
        int color = ContextCompat.getColor(holder.itemView.getContext(), colorResId);
        holder.constraintLayoutNewNote.setBackgroundColor(color);

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class NotesViewHolder extends RecyclerView.ViewHolder{
        private final TextView textViewNote;
        private final TextView textViewNoteDate;
        private final ConstraintLayout constraintLayoutNewNote;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNote = (TextView) itemView.findViewById(R.id.textViewNewNote);
            textViewNoteDate = (TextView) itemView.findViewById(R.id.textViewNewNoteDate);
            constraintLayoutNewNote = (ConstraintLayout) itemView.findViewById(R.id.constraintLayoutNewNote);
        }
    }
}
