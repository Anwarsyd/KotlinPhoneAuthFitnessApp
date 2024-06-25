package cusat.ddukk.mphoneauth.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cusat.ddukk.mphoneauth.R
import cusat.ddukk.mphoneauth.model.WorkoutAdapterModel

class WorkoutAdapter (private val data : List<WorkoutAdapterModel>) :
        RecyclerView.Adapter<WorkoutAdapter.ViewHolder>(){
        private lateinit var parent: ViewGroup


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val wkImages: ImageView = itemView.findViewById(R.id.imagebg_workout)
        val tv_WkHead: TextView = itemView.findViewById(R.id.tv_workouthead)
        val tv_WkSub: TextView = itemView.findViewById(R.id.tv_workoutsub)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutAdapter.ViewHolder {
        this.parent = parent
        val Inflator = LayoutInflater.from(parent.context)
        val view = Inflator.inflate(
            R.layout.workout_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkoutAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.wkImages.setImageResource(item.wkImage)
        holder.tv_WkHead.text = item.wkHead
        holder.tv_WkSub.text = item.wkSub

//        holder.itemView.setOnClickListener {
//
//        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
