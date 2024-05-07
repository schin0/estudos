package br.com.fiap.retrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pesquisaCEP: Button = findViewById(R.id.pesquisaCEP)
        val cep: EditText = findViewById(R.id.cep)
        val uf: EditText = findViewById(R.id.uf)
        val cidade: EditText = findViewById(R.id.cidade)
        val rua: EditText = findViewById(R.id.rua)
        val pesquisaRCE: Button = findViewById(R.id.pesquisaRCE)
        val progress_bar: ProgressBar = findViewById(R.id.progress_bar)

        pesquisaCEP.setOnClickListener {

            progress_bar.visibility = View.VISIBLE

            val call = RetrofitFactory().retrofitService().getCEP(cep.text.toString())

            call.enqueue(object : Callback<CEP> {

                override fun onResponse(call: Call<CEP>, response: Response<CEP>) {

                    response?.let {
                        val coletaCEP: CEP? = it.body()
                        coletaCEP?.toString()?.let { it1 -> Log.i("CEP", it1) }
                        Toast.makeText(this@MainActivity, coletaCEP.toString(), Toast.LENGTH_LONG)
                            .show()

                        Log.i("Response", Gson().toJson(response.body()))

                        progress_bar.visibility = View.INVISIBLE
                    }
                }

                override fun onFailure(call: Call<CEP>?, t: Throwable?) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                    progress_bar.visibility = View.INVISIBLE
                }
            })
        }

        pesquisaRCE.setOnClickListener {

            progress_bar.visibility = View.VISIBLE

            val call = RetrofitFactory().retrofitService().getRCE(
                uf.text.toString(),
                cidade.text.toString(),
                rua.text.toString()
            )

            call.enqueue(object : Callback<List<CEP>> {

                override fun onResponse(call: Call<List<CEP>>?, response: Response<List<CEP>>?) {

                    response?.let {
                        val coletaCEP: List<CEP>? = it.body()
                        Log.i("CEP", coletaCEP.toString())
                        Toast.makeText(this@MainActivity, coletaCEP.toString(), Toast.LENGTH_LONG)
                            .show()

                        Log.i("Response", Gson().toJson(response.body()))

                        progress_bar.visibility = View.INVISIBLE
                    }
                }

                override fun onFailure(call: Call<List<CEP>>?, t: Throwable?) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                    progress_bar.visibility = View.INVISIBLE
                }
            })
        }
    }
}

