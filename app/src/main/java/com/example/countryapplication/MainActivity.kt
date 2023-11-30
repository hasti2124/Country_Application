package com.example.countryapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countryapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: CountryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CountryAdapter()

        ApiCall()
    }

    private fun ApiCall() {
        var api= ApiClient.getApiClient()?.create(ApiInterface::class.java)
        api?.getApiInterface()?.enqueue(object : Callback<List<CountryModel>> {
            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>,
            ) {
                if (response.isSuccessful) {
                    var flags = response.body()
                    adapter.setFlag(flags as List<CountryModel>)
                    binding.rcvCountryFlag.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rcvCountryFlag.adapter = adapter
                }
            }
            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {

            }
        })
    }
    private fun searchApi(name: String) {

        var api = ApiClient.getApiClient()?.create(ApiInterface::class.java)
        api?.searchname(name)?.enqueue(object : Callback<List<CountryModel>> {
            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>,
            ) {
                if (response.isSuccessful) {
                    var name = response.body()
//                        adapter.search(name as List<CountryModel>)
                    binding.rcvCountryFlag.layoutManager = GridLayoutManager(this@MainActivity, 1)
                    binding.rcvCountryFlag.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {

            }
        })
    }
}