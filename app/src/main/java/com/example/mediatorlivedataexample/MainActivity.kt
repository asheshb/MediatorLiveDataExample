package com.example.mediatorlivedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this)[MainViewModel::class.java]

        model.firstPlayerScore.observe(this, Observer<Float>{ score ->
            previous_player_score_label.text = getString(R.string.previous_player_score, score)
        })

        model.secondPlayerScore.observe(this, Observer<Float>{ score ->
            previous_player_score_label.text = getString(R.string.previous_player_score, score)
        })

        //region
//            model.currentScore.observe(this, Observer<Float>{ score ->
//            previous_player_score_label.text = getString(R.string.previous_player_score, score)
//        })
        //endregion

        submit_first_player_score.setOnClickListener { model.setFirstPlayerScore(
            first_player_score.text.toString().toFloat()) }

        submit_second_player_score.setOnClickListener { model.setSecondPlayerScore(
            second_player_score.text.toString().toFloat()) }
    }
}
