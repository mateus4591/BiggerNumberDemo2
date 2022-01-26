package edu.stanford.rkpandey.biggernumberdemo

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.random
import java.util.*

class MainActivity : AppCompatActivity() {
    var contador:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        assinalarNumerosParaBotao()
        btnLeft.setOnClickListener {
            checarInputDoUsuario(true)
            assinalarNumerosParaBotao()


        }
        btnRight.setOnClickListener {
            checarInputDoUsuario(false)
            assinalarNumerosParaBotao()
        }
    }

    private fun checarInputDoUsuario(isLeftButtonSelected:Boolean) {
        var btnLeft = btnLeft.text.toString().toInt()
        var btnRight = btnRight.text.toString().toInt()
        //Ternário para saber qual botão é (true para left e false para right)
        //Ele checa se isLeftButtonSelected é true e a expressão fica btnLeft > btnRight
        //se falso é btnRight > btnLeft
        //e assim seguindo o princípio DRY(DONT REPEAT YOURSELF)
        var isAnswerCorrect = if(isLeftButtonSelected) btnLeft > btnRight else btnRight > btnLeft
        //Checar para ver se o número é maior
        if (isAnswerCorrect) {
            //Mudar a cor do background
            backgroundView.setBackgroundColor(Color.GREEN)
            // Exibir a toast embaixo na tela
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
            // Aumenta o contador na tela
            aumentarStreak()
        } else {
            //Mudar a cor do background
            backgroundView.setBackgroundColor(Color.RED)
            // Exibir a toast embaixo na tela
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            // Iguala o contador na tela á 0
            diminuirStreak()
        }

    }

    private fun diminuirStreak() {
        contador = 0
        streakCount.text = contador.toString()
    }

    private fun aumentarStreak() {
        contador += 1
        streakCount.text = contador.toString()
    }

    private fun assinalarNumerosParaBotao() {
        var leftNum: Int = (1..10).random()
        var rightNum: Int = leftNum
        while (leftNum == rightNum) {
            rightNum = (1..10).random()
        }
        btnLeft.text = leftNum.toString()
        btnRight.text = rightNum.toString()
    }

}
