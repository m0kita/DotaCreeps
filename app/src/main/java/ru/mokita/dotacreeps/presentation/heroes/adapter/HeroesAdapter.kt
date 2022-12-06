package ru.mokita.dotacreeps.presentation.heroes.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import ru.mokita.dotacreeps.BuildConfig
import ru.mokita.dotacreeps.databinding.ItemHeroBinding
import ru.mokita.dotacreeps.core.AttackType
import ru.mokita.dotacreeps.core.Attribute

class HeroesAdapter(private val heroes: List<ru.mokita.domain.model.Hero>, private val context: Context) :
    RecyclerView.Adapter<HeroesAdapter.HeroViewHolder>() {

    inner class HeroViewHolder(private val binding: ItemHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(hero: ru.mokita.domain.model.Hero) {
            with(binding) {
                progressBar.visibility = View.VISIBLE
                Glide.with(context).load("${BuildConfig.BASE_URL}${hero.url}").listener(object:
                    RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }
                }
                ).into(ivHeroImage)
                tvHeroName.text = hero.name
                when(hero.primaryAttribute) {
                    Attribute.AGILITY.attribute -> Glide.with(context).load(
                        Attribute.AGILITY.url).into(ivPrimaryAttribute)
                    Attribute.STRENGTH.attribute -> Glide.with(context).load(
                        Attribute.STRENGTH.url).into(ivPrimaryAttribute)
                    else -> Glide.with(context).load(Attribute.INTELLECT.url).into(ivPrimaryAttribute)
                }
                when(hero.attackType) {
                    AttackType.MELEE.attackType -> Glide.with(context).load(
                        AttackType.MELEE.link).into(ivAttackType)
                    else -> Glide.with(context).load(AttackType.RANGE.link).into(ivAttackType)
                }
                tvMovementSpeed.text = hero.basedMovementSpeed

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val binding = ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.onBind(heroes[position])
    }

    override fun getItemCount(): Int = heroes.size


}