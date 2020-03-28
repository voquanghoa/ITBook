package com.quanghoa.itbook.controls

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.quanghoa.itbook.R
import com.quanghoa.itbook.controls.adapters.BookAdapter
import com.quanghoa.itbook.models.Book
import kotlinx.android.synthetic.main.book_list_layout.view.*

class BookListControl: FrameLayout{

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        LayoutInflater.from(context).inflate(R.layout.book_list_layout, this, true)
        recycler_view.adapter = BookAdapter()
    }

    fun showLoading(isLoading: Boolean){
        if(isLoading){
            progressBar.visibility = View.VISIBLE
        }else{
            progressBar.visibility = View.GONE
        }
    }

    fun showBooks(books: List<Book>?){
        txt_no_book.visibility = View.GONE
        recycler_view.visibility = View.GONE

        if(books != null){
            if(books.isEmpty()){
                txt_no_book.visibility = View.VISIBLE
            }else{
                recycler_view.visibility = View.VISIBLE
                (recycler_view.adapter as BookAdapter).books = books
            }
        }
    }

    fun showError(error: String?){
        if(error.isNullOrBlank()){
            txt_error.visibility = View.GONE
        }else{
            txt_error.visibility = View.VISIBLE
            txt_error.text = error
        }
    }
}