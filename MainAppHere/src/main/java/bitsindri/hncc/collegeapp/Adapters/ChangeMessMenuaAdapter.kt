package bitsindri.hncc.collegeapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import bitsindri.hncc.collegeapp.GetterAndSetter.VotingChangeMenu
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.activities.CommentActivityForMenuChange
import de.hdodenhof.circleimageview.CircleImageView

class ChangeMessMenuaAdapter(context: Context, itemList: ArrayList<VotingChangeMenu>): RecyclerView.Adapter<ChangeMessMenuViewHolder>() {

    var context:Context
    var itemList:ArrayList<VotingChangeMenu>

    init {
        this.context = context
        this.itemList = itemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChangeMessMenuViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.change_menu_resource, parent, false
        )
        return ChangeMessMenuViewHolder(view)

    }

    override fun onBindViewHolder(holder: ChangeMessMenuViewHolder, position: Int) {


        val vote = itemList[position]

        val isLiked = booleanArrayOf(false)
        val postLikes = intArrayOf(vote.post_likes)

        holder.time.setText(vote.time)
        holder.dateTime.setText(vote.dateAndTime)
        holder.old_menu_image.setImageResource(vote.old_menu_image)
        holder.new_menu_image.setImageResource(vote.new_menu_image)
        holder.old_menu_name.setText(vote.old_menu_name)
        holder.new_menu_name.setText(vote.new_menu_name)
        holder.update_menu_likes.setText(postLikes.get(0).toString())
        holder.person.setImageResource(vote.person)


        holder.like_linear_layout.setOnClickListener(View.OnClickListener {
            if (isLiked.get(0)) {
                // user is unliking the post
                isLiked[0] = false
                --postLikes[0]
                vote.setPostLikes(postLikes[0])
                holder.update_menu_likes.setText(postLikes.get(0).toString())
                holder.like_button.setImageResource(R.drawable.vector_unlike)
            } else {
                // user is liking the post
                isLiked[0] = true
                ++postLikes[0]
                vote.setPostLikes(postLikes.get(0))
                holder.update_menu_likes.setText(postLikes.get(0).toString())
                holder.like_button.setImageResource(R.drawable.vector_like)
            }
        })

        holder.comment_linear_layout.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, CommentActivityForMenuChange::class.java)
            intent.putExtra("dateAndTime", vote.dateAndTime)
            intent.putExtra("old_menu", vote.old_menu_name)
            intent.putExtra("new_menu", vote.new_menu_name)
            intent.putExtra("old_image", vote.old_menu_image)
            intent.putExtra("new_image", vote.new_menu_image)
            intent.putExtra("likes", vote.post_likes)
            intent.putExtra("photo", vote.person)
            intent.putExtra("eating_time", vote.time)
            context.startActivity(intent)
        })

        holder.share_linear_layout.setOnClickListener(View.OnClickListener {
          Toast.makeText(context,"Shared to the authority",Toast.LENGTH_SHORT).show()

        })


    }

    override fun getItemCount(): Int {

        return itemList.size
    }
}

class  ChangeMessMenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    val time:TextView
    val dateTime:TextView
    val old_menu_image: ImageView
    val new_menu_image:ImageView
    val old_menu_name:TextView
    val new_menu_name:TextView
    val person:CircleImageView
    val like_linear_layout:LinearLayout
    val like_button:ImageView
    val comment_linear_layout:LinearLayout
    val share_linear_layout:LinearLayout
    val update_menu_likes:TextView

    init {

        time = itemView.findViewById(R.id.eating_time)
        dateTime =itemView.findViewById(R.id.dateTime)
        old_menu_image = itemView.findViewById(R.id.old_menu_image)
        new_menu_image = itemView.findViewById(R.id.new_menu_image)
        old_menu_name = itemView.findViewById(R.id.old_menu_name)
        new_menu_name = itemView.findViewById(R.id.new_menu_name)
        person = itemView.findViewById(R.id.person)
        like_linear_layout = itemView.findViewById(R.id.like_linear_layout)
        like_button = itemView.findViewById(R.id.like_button)
        comment_linear_layout = itemView.findViewById(R.id.comment_linear_layout)
        share_linear_layout = itemView.findViewById(R.id.share_linear_layout)
        update_menu_likes = itemView.findViewById(R.id.update_menu_likes)

    }

}