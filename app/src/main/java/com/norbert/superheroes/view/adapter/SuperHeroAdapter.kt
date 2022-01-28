package com.norbert.superheroes.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.norbert.superheroes.R
import com.norbert.superheroes.data.model.SuperHero
import com.squareup.picasso.Picasso

class SuperHeroAdapter: RecyclerView.Adapter<SuperHeroAdapter.ViewHolder>() {

    private var superHeroesList = mutableListOf<SuperHero>()
    private var noImage= "https://i.imgur.com/I9hD11N.jpg"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_super_hero_small_info, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val superHero = superHeroesList[position]
        holder.superheroName.text= superHero.name
        if (superHero.image.url.isNotEmpty()){
            Picasso.get().load(superHero.image.url).into(holder.superHeroImage)
        }else{
            Picasso.get().load(noImage).into(holder.superHeroImage)
        }

    }

    override fun getItemCount(): Int {
        return superHeroesList.size
    }

    fun updateData(data: List<SuperHero>){
        superHeroesList.clear()
        superHeroesList.addAll(data)
        notifyDataSetChanged()
    }

    fun addSuperHero(data: SuperHero){
        superHeroesList.add(data)
        notifyDataSetChanged()
    }

    fun addSuperHeroList(data: List<SuperHero>){
        superHeroesList.addAll(data)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val superHeroImage: ImageView = itemView.findViewById(R.id.ivSuperHeroImage)
        val superheroName: TextView = itemView.findViewById(R.id.tvSuperHeroName)
    }
}