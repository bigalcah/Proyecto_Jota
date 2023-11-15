import android.os.Bundle
import android.provider.DocumentsContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectojota.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DatosAdapter
    private val listaDatos = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycleView()
    }

    private fun initRecycleView() {
        adapter = DatosAdapter(listaDatos)
        binding.dato.layoutManager = LinearLayoutManager(this)
        binding.dato.adapter = adapter
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("http://44.219.124.55:8081/GETLAST/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    private fun mostrarDatos(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getData()
            val datosObtenidos = call.body()
            runOnUiThread{
                if(call.isSuccessful){
                    val datos: List<String> = datosObtenidos ?: emptyList()
                    listaDatos.clear()
                    listaDatos.addAll(datos)
                    adapter.notifyDataSetChanged()
                }else{
                    showError()
                }
            }

        }
    }

    private fun showError(){
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_LONG).show()
    }

}