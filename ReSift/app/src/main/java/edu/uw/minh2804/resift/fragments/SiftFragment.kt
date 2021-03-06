package edu.uw.minh2804.resift.fragments

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.button.MaterialButton
import edu.uw.minh2804.resift.MainActivity
import edu.uw.minh2804.resift.R
import edu.uw.minh2804.resift.viewmodels.SiftViewModel

class SiftFragment : Fragment(R.layout.fragment_sift) {
	private val viewModel: SiftViewModel by activityViewModels()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val shareButtonView = view.findViewById<MaterialButton>(R.id.material_button_sift_share_result)
		viewModel.url.observe(viewLifecycleOwner) {
			if (it != null) {
				val sendIntent = Intent().apply {
					action = Intent.ACTION_SEND
					type = "text/plain"
					putExtra(Intent.EXTRA_TEXT, it)
				}
				val shareIntent = Intent.createChooser(sendIntent, null)
				shareButtonView.setOnClickListener { startActivity(shareIntent) }
			}
		}
		val mainActivity = requireActivity() as MainActivity
		mainActivity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
		mainActivity.findViewById<TextView>(R.id.text_view_toolbar_main_app_name).apply {
			layoutParams = Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT).apply {
				gravity = Gravity.CENTER
			}
		}
	}
}
