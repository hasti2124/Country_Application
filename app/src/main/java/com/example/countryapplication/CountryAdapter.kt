package com.example.countryapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countryapplication.databinding.CountryitemBinding

class CountryAdapter: RecyclerView.Adapter<CountryAdapter.CountryHolder>() {

    lateinit var context: Context
    var list = ArrayList<CountryModel>()

    class CountryHolder(itemView: CountryitemBinding) : RecyclerView.ViewHolder(itemView.root) {
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        context = parent.context
        var binding = CountryitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.binding.apply {
            list.get(position)?.flags?.apply {
                Glide.with(context).load(png).into(imgflag)
            }

            list.get(position).apply {
                txtcountryname.text = name
                txtcapitalname.text = capital
            }
        }

        holder.binding.country.setOnClickListener {

            Toast.makeText(context, "${list.get(position).name}", Toast.LENGTH_SHORT).show()

            val intent = Intent(it.context, CountryInformation::class.java)

            intent.putExtra("png",list.get(position).flags?.png)
            intent.putExtra("name",list.get(position).name)
            intent.putExtra("capital",list.get(position).capital)
            intent.putExtra("region",list.get(position).region)
            intent.putExtra("subregion",list.get(position).subregion)
            intent.putExtra("nativeName",list.get(position).nativeName)
            intent.putExtra("population",list.get(position).population)
            intent.putExtra("area",list.get(position).area.toString())
            intent.putExtra("demonym",list.get(position).demonym)
            intent.putExtra("borders", list.get(position).borders.toString())
            intent.putExtra("independent",list.get(position).independent)
            intent.putExtra("timezones",list.get(position).timezones.toString())
            intent.putExtra("topLevelDomain",list.get(position).topLevelDomain.toString())
            intent.putExtra("callingCodes",list.get(position).callingCodes.toString())

            it.context.startActivity(intent)
        }
    }

    fun setFlag(flags: List<CountryModel>?) {
        this.list = (flags as ArrayList<CountryModel>?)!!
    }

    fun search(name: List<CountryModel>?) {
        this.list = (name as ArrayList<CountryModel>?)!!
    }
}