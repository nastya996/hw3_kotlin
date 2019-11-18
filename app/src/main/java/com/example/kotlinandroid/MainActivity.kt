package com.example.kotlinandroid

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinandroid.Post.Post
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myPost = Post(
            author = "Anastasia Shtrezer",
            content = "My first post",
            created = "11 march 2018",
            createdTime = 1541116869,
            likeMe = true,
            numberOfComment = 13,
            numberOfRepost = 6,
            numberOfLike = 28


        )


        val currentTime = System.currentTimeMillis() / 1000
        watchTv.text = timeInSeconds(currentTime - myPost.createdTime)
        authorText.text = myPost.author
        contentCard.text = myPost.content


        if (myPost.numberOfLike == 0) {
            numberOfLike.text = ""
        } else {
            numberOfLike.text = myPost.numberOfLike.toString()
        }
        if (myPost.likeMe) {
            numberOfLike.setTextColor(Color.RED)
            likeTg.isChecked = true
        }

//-------------------------------------------------------
        if (myPost.numberOfComment == 0) {
            numberOfComments.text = ""
        } else {
            numberOfComments.text = myPost.numberOfComment.toString()
        }
        if (myPost.commentMe) {
            numberOfComments.setTextColor(Color.RED)
            commentTg.isChecked = true
        }
//-------------------------------------------------------
        if (myPost.numberOfRepost == 0) {
            numberOfPosts.text = ""
        } else {
            numberOfPosts.text = myPost.numberOfRepost.toString()
        }
        if (myPost.repostMe) {
            numberOfPosts.setTextColor(Color.RED)
            shareTg.isChecked = true
        }
    }

//-----------------------------------------------
    fun timeInSeconds(sec: Long): String {
        val Minute = 60
        val Hour = Minute * 60
        val Day = Hour * 24
        val Mounth = Day * 30
        val Year = Mounth * 12
        val publishedAgo: String = when {
            (sec > Year * 2) -> "Some years ago"
            (sec > Year) -> "One year ago"
            (sec >= Mounth * 2) -> "" + (sec / Mounth) + " months ago"
            (sec >= Mounth) -> "One mnth ago"
            (sec >= Day * 2) -> "" + (sec / Day) + " days ago"
            (sec >= Day) -> "One day ago"
            (sec >= Hour * 2) -> "" + (sec / Hour) + " hours ago"
            (sec >= Hour) -> "One hour ago"
            (sec >= Minute * 2) -> "" + (sec / Minute) + " minutes ago"
            (sec >= Minute) -> "One minute ago"
            else -> "less than a minute ago"
        }
        return publishedAgo
    }
}







