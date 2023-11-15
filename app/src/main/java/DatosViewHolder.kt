import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectojota.databinding.ItemDatoBinding

class DatosViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemDatoBinding.bind(view)

    fun bind(dato:String){
        binding.dato
    }
}