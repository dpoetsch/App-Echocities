package com.example.echocities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.echocities.data.Map
import com.example.echocities.endpoint.Endpoint
import com.example.echocities.network.NetworkUtils
import kotlinx.android.synthetic.main.activity_main_api.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityAPI : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_api)

        val myBtn = findViewById<Button>(R.id.myBtn)
        val myTxt = findViewById<TextView>(R.id.myTextView)

        myBtn.setOnClickListener{
            getData()
        }

        val button: androidx.appcompat.widget.AppCompatButton = findViewById(R.id.button6)
        button.setOnClickListener {
            openNextActivity()
        }

    }
    fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("API address hidden for security reasons.")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getPost()

        callback.enqueue(object : Callback<List<Map>> {
            override fun onFailure(call: Call<List<Map>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Map>>, response: Response<List<Map>>) {
                response.body()?.forEach {
                    myTextView.text = myTextView.text.toString().plus("Código do mapa: " + it.cd_mapea + "\n" + "Nome do mapa: " + it.nm_mapea + "\n" + "Data de criação do mapa: " + it.dt_inicio_map + "\n" + "Nome fantasia: " + it.nm_fantasia + "\n" + "\n")
                }
            }
        })

    }

    private fun openNextActivity(){
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }


}