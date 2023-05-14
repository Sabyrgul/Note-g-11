package com.geektech.note_g_11.presentation.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.note_g_11.databinding.ItemNoteBinding
import com.geektech.note_g_11.domain.models.Note

class NoteAdapter(private var notes: MutableList<Note> = ArrayList()) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNoteBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bind(notes[position])
    }

    override fun getItemCount()=notes.size

    inner class ViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.apply {
                tvTitle.text=note.title
                tvDescription.text=note.description
            }
        }

    }
}