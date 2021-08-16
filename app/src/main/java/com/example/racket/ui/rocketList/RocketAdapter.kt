package com.example.racket.ui.rocketList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.racket.databinding.ItemRocketCardBinding
import com.example.racket.domain.model.Model

class RocketAdapter:
    ListAdapter<Model.Rocket, RocketAdapter.RocketViewHolder>(DiffCallback()) {
    private lateinit var listener: ClickListener

     inner class RocketViewHolder(private val binding: ItemRocketCardBinding) :
        RecyclerView.ViewHolder(binding.root),View.OnClickListener {

        private lateinit var rocketDetail: Model.Rocket

        fun bind(rocket: Model.Rocket) = with(itemView) {
            rocketDetail = rocket
            binding.rocket = rocket
        }

        init {
            binding.rocketItem.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            if (view != null) {
                listener.onClick(rocketDetail)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        return RocketViewHolder(
            ItemRocketCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setOnItemClickListener(aClickListener: Any) {
        listener = aClickListener as ClickListener
    }

    interface ClickListener {
        fun onClick(rocket: Model.Rocket)
    }
}

class DiffCallback : DiffUtil.ItemCallback<Model.Rocket>() {
    override fun areItemsTheSame(oldItem: Model.Rocket, newItem: Model.Rocket): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Model.Rocket, newItem: Model.Rocket): Boolean {
        return oldItem == newItem
    }

}