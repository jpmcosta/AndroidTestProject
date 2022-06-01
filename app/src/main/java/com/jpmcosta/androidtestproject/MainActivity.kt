package com.jpmcosta.androidtestproject

import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.jpmcosta.androidtestproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupIcon(root = binding.root, icon = binding.iconIssue)
        setupIcon(root = binding.root, icon = binding.iconFixed)
    }

    private fun setupIcon(root: MotionLayout, icon: ImageView) {
        root.setPaddingConstraints(viewId = icon.id, padding = 0)

        root.post {
            val padding = resources.getDimensionPixelSize(R.dimen.padding_icon)
            root.setPaddingConstraints(viewId = icon.id, padding)

            icon.setImageResource(R.drawable.ic_android_128)
        }
    }

    private fun MotionLayout.setPaddingConstraints(@IdRes viewId: Int, padding: Int) {
        getConstraintSet(R.id.start).run {
            setIntValue(viewId, "Padding", padding)
        }
        getConstraintSet(R.id.end).run {
            setIntValue(viewId, "Padding", padding)
        }
    }
}