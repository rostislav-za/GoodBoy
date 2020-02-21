package progr.rostoslav.za.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easyreader3.presentation.adapters.base.BaseAdapter
import com.example.easyreader3.presentation.adapters.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_message_system.view.*
import kotlinx.android.synthetic.main.item_message_user.view.*
import progr.rostoslav.za.R

class MessageAdapter : BaseAdapter<ChatMessage>() {

    override fun getItemViewType(position: Int) = if (items[position].system) 0 else 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if (viewType == 0) {
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_message_system, parent, false)
        )
    } else {
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_message_user, parent, false)
        )
    }


    class ViewHolder(itemView: View) : BaseViewHolder<ChatMessage>(itemView) {
        override fun bind(model: ChatMessage) {
            if(model.system){
                itemView.im_system_text.text=model.text
            }else{
                itemView.im_user_text.text=model.text
            }

        }
    }
}


data class ChatMessage(val system: Boolean = true, val text: String = "...") {

}