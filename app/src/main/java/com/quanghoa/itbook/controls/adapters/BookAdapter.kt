package com.quanghoa.itbook.controls.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.quanghoa.itbook.R
import com.quanghoa.itbook.models.Book
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.book_layout.*

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>(){

    var books = listOf<Book>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    inner class BookViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        var book: Book? = null
            set(value){
                field = value
                if(value!=null){
                    txt_price.text = value.price
                    txt_isbn.text = value.isbn13
                    txt_title.text = value.title
                    txt_subtitle.text = value.subtitle
                    Glide.with(img_cover)
                        .load(value.image)
                        .into(img_cover)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_layout, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.book = books[position]
    }

}