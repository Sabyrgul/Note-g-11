package com.geektech.note_g_11.presentation.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.note_g_11.databinding.ItemNoteBinding
import com.geektech.note_g_11.domain.models.Note

class NoteAdapter(
    private val onItemClick: (Note) -> Unit,
    private val onLongItemClick: (Note) -> Unit
) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private var notes = arrayListOf<Note>()
    private var deletedNote: Note? = null

    fun update(list: List<Note>) {
        notes = list as ArrayList<Note>
        notifyDataSetChanged()
    }

    fun delete() {
        if (deletedNote != null) {
            notes.remove(deletedNote)
            deletedNote = null
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNoteBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount() = notes.size

    inner class ViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.apply {
                tvTitle.text = note.title
                tvDescription.text = note.description
                tvData.text = note.createdAt.toString()
                binding.root.setOnClickListener {
                    onItemClick(note)
                }
                binding.root.setOnLongClickListener {
                    deletedNote = note
                    onLongItemClick(note)
                    true
                }
            }
        }

    }
}