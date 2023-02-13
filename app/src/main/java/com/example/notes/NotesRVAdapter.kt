package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_note.view.*

class NotesRVAdapter(private val context: Context, private val listener:iNotesRVAdapter):RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

    private val allNotes= ArrayList<Note>()

    inner class NoteViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val textview:TextView=itemView.text
        val deleteButton:ImageView=itemView.deleteButton

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NoteViewHolder {
       val viewHolder=NoteViewHolder( LayoutInflater.from(context).inflate(R.layout.item_note,p0,false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote=allNotes[position]
        holder.textview.text=currentNote.text
    }

    override fun getItemCount(): Int {
       return allNotes.size
    }

    fun updateList(newList:List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

}
interface iNotesRVAdapter{
    fun onItemClicked(note:Note)
}