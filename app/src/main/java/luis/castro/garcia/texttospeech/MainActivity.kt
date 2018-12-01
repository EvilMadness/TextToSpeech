package luis.castro.garcia.texttospeech

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            val result = tts!!.setLanguage(Locale("es_MX"))
            if(result != TextToSpeech.LANG_NOT_SUPPORTED || result != TextToSpeech.LANG_MISSING_DATA){
            }else{
                Toast.makeText(this, "no soportado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    var tts : TextToSpeech? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tts = TextToSpeech(this, this)
        Log.i("Languages", Locale.getAvailableLocales().toString())
        btnLeer!!.setOnClickListener{
            val oracion = etLeer.text.toString()
            if(oracion == ""){
                tts!!.speak("Escriba una frase", TextToSpeech.QUEUE_FLUSH, null, null)
                etLeer.error = "Escriba una frase"
            } else {
                Toast.makeText(this, "Presionado", Toast.LENGTH_SHORT).show()
                tts!!.speak(oracion, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }
    }
}
