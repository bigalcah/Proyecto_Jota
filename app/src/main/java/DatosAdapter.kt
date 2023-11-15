import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectojota.R

class DatosAdapter(private val datos:List<String>):RecyclerView.Adapter<DatosViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DatosViewHolder(layoutInflater.inflate(R.layout.item_dato, parent, false))
    }

    override fun getItemCount(): Int = datos.size

    override fun onBindViewHolder(holder: DatosViewHolder, position: Int) {
        val item:String = datos[position]
        holder.bind(item)
    }
}