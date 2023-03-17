package com.example.homework71.presentation.ui.fragment.notes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework71.databinding.ItemNoteBinding
import com.example.homework71.domain.model.Note

class NoteListAdapter(
    val onLongClick: (Note) -> Unit,
    val onClick: (Note) -> Unit
) : ListAdapter<Note, NoteListAdapter.NoteViewHolder>(NoteDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            with(binding) {
                itemView.setOnLongClickListener {
                onLongClick.invoke(note)
                     true
                }
                itemView.setOnClickListener {
                    onClick(note)
                }
                titleNote.text = note.title
                descriptionNote.text = note.description
            }
        }
    }

    private class NoteDiffUtil: DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Note, newItem: Note)=(oldItem.equals(newItem))

    }
}