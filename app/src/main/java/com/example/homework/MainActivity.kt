package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework.databinding.ActivityMainBinding
import com.example.presenter.Presenter
import com.example.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {

    private lateinit var binding: ActivityMainBinding
    private var presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClick()
    }

    private fun initClick() {
        with(binding) {
            incrementBtn.setOnClickListener {
                presenter.incrementCount()
            }
            decrementBtn.setOnClickListener {
                presenter.decrementCount()
            }
        }
    }

    override fun updateText(count: String) {
        binding.tvResult.text = count
    }

    override fun changeColor(color: Int) {
        binding.tvResult.setTextColor(color)
    }

    override fun showToast() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }
}