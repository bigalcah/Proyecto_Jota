import com.google.gson.annotations.SerializedName

data class DatosResponse(@SerializedName("Humedad") var humedad:Float, @SerializedName("PM10") var pm10:Float,
        @SerializedName("PM25") var pm25:Float, @SerializedName("Temperaitura") var temperatura:Float)