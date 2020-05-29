package com.jpmcosta.androidtestproject.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jpmcosta.androidtestproject.R
import com.jpmcosta.androidtestproject.adapter.NumberAdapter

class MainActivity : AppCompatActivity() {

    companion object {

        private const val COUNT = 20
    }

    @BindView(R.id.fab)
    lateinit var fab: FloatingActionButton

    @BindView(R.id.fab_reset)
    lateinit var fabReset: FloatingActionButton

    @BindView(android.R.id.list)
    lateinit var recyclerView: RecyclerView

    private var numberAdapter = NumberAdapter(COUNT)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupContentView()
    }

    private fun setupContentView() {
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        setupFabs()

        setupRecyclerView()
    }

    private fun setupFabs() {
        fab.setOnClickListener {
            numberAdapter.count--
        }

        fabReset.setOnClickListener {
            numberAdapter.count = COUNT
            (recyclerView.layoutManager as? LinearLayoutManager)?.scrollToPositionWithOffset(COUNT - 1, 0)
        }
    }

    private fun setupRecyclerView() {
        recyclerView.run {
            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = numberAdapter
        }
    }
}