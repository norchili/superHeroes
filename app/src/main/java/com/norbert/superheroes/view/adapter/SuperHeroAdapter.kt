package com.norbert.superheroes.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.norbert.superheroes.R
import com.norbert.superheroes.data.model.SuperHero
import com.norbert.superheroes.databinding.ItemSuperHeroSmallInfoBinding
import com.squareup.picasso.Picasso

class SuperHeroAdapter(private val onClickListener:(SuperHero) -> Unit): RecyclerView.Adapter<SuperHeroAdapter.ViewHolder>() {

    private var superHeroesList = mutableListOf<SuperHero>()
    private var noImage= "https://i.imgur.com/I9hD11N.jpg"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_super_hero_small_info, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val superHero = superHeroesList[position]
        holder.render(superHero, onClickListener)

    }

    override fun getItemCount(): Int {
        return superHeroesList.size
    }

    fun updateData(data: List<SuperHero>){
        superHeroesList.clear()
        superHeroesList.addAll(data)
        notifyDataSetChanged()
    }




    class ViewHolder(view:View):RecyclerView.ViewHolder(view){

        private val binding = ItemSuperHeroSmallInfoBinding.bind(view)

        fun render(superHeroModel:SuperHero, onClickListener:(SuperHero) -> Unit){
            binding.tvSuperHeroName.text= superHeroModel.name
            Picasso.get().load(superHeroModel.image.url).into(binding.ivSuperHeroImage)
            itemView.setOnClickListener {
                onClickListener(superHeroModel)
            }
        }
        //val superHeroImage: ImageView = itemView.findViewById(R.id.ivSuperHeroImage)
        //val superheroName: TextView = itemView.findViewById(R.id.tvSuperHeroName)
    }
}