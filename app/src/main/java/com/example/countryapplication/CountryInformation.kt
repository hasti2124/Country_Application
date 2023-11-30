package com.example.countryapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.countryapplication.databinding.ActivityCountryInformationBinding

class CountryInformation : AppCompatActivity() {
    lateinit var binding: ActivityCountryInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityCountryInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val png = intent?.getStringExtra("png")
        val name = intent?.getStringExtra("name")
        val capital = intent?.getStringExtra("capital")
        val region = intent?.getStringExtra("region")
        val subregion = intent?.getStringExtra("subregion")
        val nativeName = intent?.getStringExtra("nativeName")
        val population = intent?.getIntExtra("population",0)
        val area = intent?.getStringExtra("area")
        val demonym = intent?.getStringExtra("demonym")
        val borders = intent?.getStringExtra("borders")
        val independent = intent?.getBooleanExtra("independent",true)
        val timezones = intent?.getStringExtra("timezones")
        val topLevelDomain = intent?.getStringExtra("topLevelDomain")
        val callingCodes = intent?.getStringExtra("callingCodes")

        if (png != null) {
            Glide.with(this).load(png).into(binding.imgflag)
        }
        binding.txtcountryname.text = name
        binding.txtcapital.text = capital
        binding.txtregion.text = region
        binding.txtsubregion.text = subregion
        binding.txtnativename.text = nativeName
        binding.txtpopulation.text = population.toString()
        binding.txtarea.text = area
        binding.txtdemonym.text = demonym
        binding.txtbordes.text = borders
        binding.txtindependent.text = independent.toString()
        binding.txttimezone.text = timezones
        binding.txtdomain.text = topLevelDomain
        binding.txtcallingcode.text = callingCodes

        binding.txtinformation.setText("$name's information")
    }
}