package bitsindri.hncc.collegeapp.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bitsindri.hncc.collegeapp.Adapters.commentsAdapter
import bitsindri.hncc.collegeapp.GetterAndSetter.comment
import bitsindri.hncc.collegeapp.R
import de.hdodenhof.circleimageview.CircleImageView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CommentActivityForMenuChange : AppCompatActivity() {

    lateinit var dateAndTime:TextView
    lateinit var old_menu_name:TextView
    lateinit var new_menu_name:TextView
    lateinit var old_menu_image:ImageView
    lateinit var new_menu_image:ImageView
    lateinit var post_likes:TextView
    lateinit var person:CircleImageView
    lateinit var time:TextView
    lateinit var comment_edit_text:EditText
    lateinit var send_comment_button:ImageButton

    lateinit var calendar: Calendar
    lateinit var simpleDateFormat: SimpleDateFormat

  lateinit  var commentList: ArrayList<comment>
   lateinit var commentsAdapter: commentsAdapter


    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_for_m_enu_change)

        dateAndTime = findViewById(R.id.dateTime)
        time = findViewById(R.id.eating_time)
        old_menu_image = findViewById(R.id.old_menu_image)
        old_menu_name = findViewById(R.id.old_menu_name)
        new_menu_image = findViewById(R.id.new_menu_image)
        new_menu_name = findViewById(R.id.new_menu_name)
        post_likes = findViewById(R.id.update_menu_likes)
        person = findViewById(R.id.person)
        comment_edit_text = findViewById(R.id.comment_edit_text)
        send_comment_button = findViewById(R.id.send_comment_button)


        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("MM-dd-yyyy")


        val intent = intent

        dateAndTime.setText(intent.getStringExtra("dateAndTime"))
        old_menu_name.setText(intent.getStringExtra("old_menu"))
        new_menu_name.setText(intent.getStringExtra("new_menu"))
        intent.getStringExtra("old_image")?.toInt()?.let { old_menu_image.setImageResource(it) }
        intent.getStringExtra("new_image")?.toInt()?.let { new_menu_image.setImageResource(it) }
        post_likes.setText(intent.getStringExtra("likes"))
        intent.getStringExtra("photo")?.toInt()?.let { person.setImageResource(it) }
        time.setText(intent.getStringExtra("eating_time"))


        val commentsRecyclerView = findViewById<RecyclerView>(R.id.commentsRecyclerView)
        commentsRecyclerView.layoutManager = LinearLayoutManager(this)

        commentList = ArrayList<comment>()

        commentsAdapter = commentsAdapter(commentList, this)
        commentsRecyclerView.adapter = commentsAdapter







        send_comment_button.setOnClickListener(View.OnClickListener {
            val myComment: String = comment_edit_text.getText().toString()
            if (myComment != "") {
                val myCommentObj = comment("Person A", simpleDateFormat.format(calendar.time), myComment)
                commentList.add(myCommentObj)
                comment_edit_text.setText("")
                commentsAdapter.notifyDataSetChanged()
            }
        })

        ViewCompat.setNestedScrollingEnabled(commentsRecyclerView, false)

    }
}