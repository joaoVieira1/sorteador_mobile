package br.edu.ifsp.dmo.sorteador

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.sorteador.databinding.ActivityMainBinding
import br.edu.ifsp.dmo.sorteador.model.DefinedLimit
import br.edu.ifsp.dmo.sorteador.model.Draw


class MainActivity : AppCompatActivity(), OnClickListener{

    private lateinit var binding: ActivityMainBinding
    private var draw = Draw()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListener()
    }

    override fun onClick(v: View?) {
        when(v){
            binding.buttonUseLimit -> {
                val limit: Int = try{
                    binding.editLimit.text.toString().toInt()
                } catch (e: NumberFormatException){
                    0
                }
                draw = if(limit > 1){
                    Draw(limit)
                }else{
                    Draw()
                }
                updateUI()
            }

            binding.buttonDraw -> {
                binding.textviewExit.text = draw.getNumber().toString()
                updateListView()
            }

        }
    }

    private fun setClickListener(){
        binding.buttonDraw.setOnClickListener(this)
        binding.buttonUseLimit.setOnClickListener(this)
    }

    private fun updateUI(){
        val str = "Intervalo de 1 à ${draw.getHighBorder()}"
        binding.textviewInterval.text = str
        binding.editLimit.text.clear()
        binding.textviewExit.text = getString(R.string.inicie_o_sorteio)
        updateListView()
    }

    private fun updateListView(){
        val adapter = NumberAdapter(this, draw.getHistory())

        binding.listviewDraw.adapter = adapter
    }

}