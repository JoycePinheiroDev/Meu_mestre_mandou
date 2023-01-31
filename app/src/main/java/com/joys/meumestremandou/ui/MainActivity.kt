package com.joys.meumestremandou.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.joys.meumestremandou.infra.OrderConstants
import com.joys.meumestremandou.R
import com.joys.meumestremandou.data.Mock
import com.joys.meumestremandou.infra.SecurityPreferences
import com.joys.meumestremandou.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        handleFilter(R.id.image_all)
        handleNextPhrase()

        binding.buttonNewOrder.setOnClickListener(this)

        binding.imageAll.setOnClickListener(this)
        binding.imageRandom.setOnClickListener(this)
        binding.imageColors.setOnClickListener(this)
        binding.imageMusic.setOnClickListener(this)
        binding.textUserName.setOnClickListener(this)
    }

    override fun onRestart() {
        super.onRestart()
    }
    override fun onResume() {
        super.onResume()
        handleUserName()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_order) {
            handleNextPhrase()
        } else if (view.id in listOf(R.id.image_all, R.id.image_random, R.id.image_colors, R.id.image_music)){
            handleFilter(view.id)
        } else if (view.id == R.id.text_user_name){
            startActivity(Intent(this, UserActivity::class.java))
        }
    }

    private fun handleNextPhrase() {
        binding.textPhase.text = Mock().getPhrase(categoryId)
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(OrderConstants.KEY.USER_NAME)
        binding.textUserName.text = "Olá, $name!"
    }

    private fun handleFilter(id: Int){
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageRandom.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageColors.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageMusic.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = OrderConstants.FILTER.ALL
            }
            R.id.image_random -> {
                binding.imageRandom.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = OrderConstants.FILTER.RANDOM
            }
            R.id.image_colors -> {
                binding.imageColors.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = OrderConstants.FILTER.COLORS
            }
            R.id.image_music -> {
                binding.imageMusic.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = OrderConstants.FILTER.MUSIC
            }
        }
    }

}