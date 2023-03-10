package com.example.homework71.presentation.ui.fragment.notes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework71.databinding.ItemNoteBinding
import com.example.homework71.domain.model.Note

class NoteAdapter(
    val onLongClick: (position:Int) -> Unit,
    val onClick: (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var listNote = arrayListOf<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun sendNote(position: Int):Note{
        return listNote[position]
    }

    override fun getItemCount() = listNote.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(listNote[position])
    }
    @SuppressLint("NotifyDataSetChanged")
    fun deleteNote(note:Note){
        listNote.remove(note)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAllNotes(note: List<Note>) {
        listNote.clear()
        listNote.addAll(note)
        notifyDataSetChanged()
    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            with(binding) {
                itemView.setOnLongClickListener {
                onLongClick(adapterPosition)
                    return@setOnLongClickListener false
                }
                itemView.setOnClickListener {
                    onClick(note)
                }
                titleNote.text = note.title
                descriptionNote.text = note.description
            }
        }
    }
}