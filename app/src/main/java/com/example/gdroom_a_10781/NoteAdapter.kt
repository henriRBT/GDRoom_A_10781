package com.example.gdroom_a_10781

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.gdroom_a_10781.room.Note
import kotlinx.android.synthetic.main.activity_note_adapter.view.*

class NoteAdapter (private val notes: ArrayList<Note> , private val listerner: OnAdapterListerner):
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_note_adapter,parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteAdapter.NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.view.text_title.text = note.title
        holder.view.text_title.setOnClickListener{
            listerner.onClick(note)
        }
        holder.view.icon_edit.setOnClickListener{
            listerner.onUpdate(note)
        }
        holder.view.icon_delete.setOnClickListener{
            listerner.onDelete(note)
        }
    }

    override fun getItemCount() = notes.size

    inner class NoteViewHolder(val view: View) :
            RecyclerView.ViewHolder(view)

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Note>){
        notes.clear()
        notes.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListerner{
        fun onClick(note: Note)
        fun onUpdate(note: Note)
        fun onDelete(note: Note)
    }
}