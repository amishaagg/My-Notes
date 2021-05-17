package com.app.mynotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_note.view.*

//made seventh(after MainActivity)
class NotesRVAdapter(private val listener: NoteItemClicked):RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {
    private val items:ArrayList<Note> = ArrayList()
    inner class NoteViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val textView=itemView.text
        val deleteBtn=itemView.deleteBtn
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false)
        val viewHolder=NoteViewHolder(view)
        viewHolder.deleteBtn.setOnClickListener {
            listener.onIemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentItem=items[position]
        holder.textView.text=currentItem.text
    }
    fun updateList(updatedNotes:List<Note>){
        items.clear()
        items.addAll(updatedNotes)
        notifyDataSetChanged()
    }
}
//made to handle clicking of list items
interface NoteItemClicked{
    fun onIemClicked(item: Note)
}
