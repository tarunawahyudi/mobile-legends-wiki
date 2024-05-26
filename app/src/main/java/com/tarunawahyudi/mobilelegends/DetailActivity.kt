package com.tarunawahyudi.mobilelegends

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private lateinit var imgDetail: ImageView
    private lateinit var tvTitleDetail: TextView
    private lateinit var tvDescriptionDetail: TextView
    private lateinit var tvRole: TextView
    private lateinit var tvStory: TextView
    private lateinit var btnBack: Button

    companion object {
        const val EXTRA_HERO = "extra_hero"
    }

    private fun initComponents() {
        imgDetail = findViewById(R.id.img_detail)
        tvTitleDetail = findViewById(R.id.tv_title_detail)
        tvDescriptionDetail = findViewById(R.id.tv_description_detail)
        tvRole = findViewById(R.id.tv_role_content)
        tvStory = findViewById(R.id.tv_story_detail)
        btnBack = findViewById(R.id.btn_back)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        this.initComponents()

        val hero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>(EXTRA_HERO, Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>(EXTRA_HERO)
        }

        hero?.let {
            imgDetail.setImageResource(it.imageDetail)
            tvTitleDetail.text = it.name
            tvDescriptionDetail.text = it.description
            tvRole.text = it.role
            tvStory.text = it.story
        }

        btnBack.setOnClickListener {
            val intent = Intent(this@DetailActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}