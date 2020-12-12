package com.jpmcosta.androidtestproject.activity

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.jpmcosta.androidtestproject.databinding.ActivityMainBinding
import com.jpmcosta.androidtestproject.fragment.ColorTextFragment

class MainActivity : AppCompatActivity() {

    companion object {

        private const val TAG_FRAGMENT_1 = "fragment_1"

        private const val TAG_FRAGMENT_2 = "fragment_2"
    }

    private lateinit var binding: ActivityMainBinding

    private var fragment1: Fragment? = null

    private var fragment2: Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupContentView()
    }


    private fun setupContentView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFragments()

        setupFabs()
    }

    private fun setupFragments() {
        fragment1 = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_1)
        if (fragment1 == null) {
            val newFragment1 = ColorTextFragment.newInstance(Color.RED, "Hello World 1!")
            this.fragment1 = newFragment1
            supportFragmentManager.beginTransaction()
                    .add(android.R.id.tabcontent, newFragment1, TAG_FRAGMENT_1)
                    .commitNow()
        }

        fragment2 = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_2)
        if (fragment2 == null) {
            val newFragment2 = ColorTextFragment.newInstance(Color.BLUE, "Hello World 2!")
            this.fragment2 = newFragment2
            supportFragmentManager.beginTransaction()
                    .add(android.R.id.tabcontent, newFragment2, TAG_FRAGMENT_2)
                    .hide(newFragment2)
                    .commitNow()
        }
    }

    private fun setupFabs() {
        binding.fab.setOnClickListener {
            toggleFragmentVisibility()
        }
    }

    private fun toggleFragmentVisibility() {
        val fragment1 = fragment1 ?: return
        val fragment2 = fragment2 ?: return

        val transaction = supportFragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        if (fragment1.isHidden) {
            transaction.show(fragment1).hide(fragment2)
        } else {
            transaction.hide(fragment1).show(fragment2)
        }.commit()
    }
}