package com.quanghoa.itbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quanghoa.itbook.models.Books
import com.quanghoa.itbook.providers.createBookService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadNewBooks()
    }

    fun loadNewBooks(){
        books_control.showLoading(true)
        books_control.showBooks(null)
        books_control.showError("")

        createBookService().getNew().enqueue(object: retrofit2.Callback<Books> {
            override fun onFailure(call: Call<Books>, t: Throwable) {
                books_control.showLoading(false)
                books_control.showError(t.message + "")
            }

            override fun onResponse(call: Call<Books>, response: Response<Books>) {
                books_control.showLoading(false)
                if(response.isSuccessful){
                    books_control.showBooks(response.body()!!.books)
                }else{
                    books_control.showError(response.errorBody()!!.string())
                }
            }
        })
    }
}
