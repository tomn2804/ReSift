package edu.uw.minh2804.resift

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import edu.uw.minh2804.resift.viewmodels.SiftResultViewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val viewModel: SiftResultViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when (intent?.action) {
            Intent.ACTION_SEND -> {
                assert(intent.type == "text/plain")
                viewModel.search(intent.getStringExtra(Intent.EXTRA_TEXT)!!)
            }
            else -> {
                Log.v(TAG, "Landing page here")
            }
        }
    }

    companion object {
        val TAG = MainActivity::class.simpleName!!
    }
}
