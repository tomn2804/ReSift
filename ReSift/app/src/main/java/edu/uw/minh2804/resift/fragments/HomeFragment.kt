package edu.uw.minh2804.resift.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import edu.uw.minh2804.resift.R
import edu.uw.minh2804.resift.viewmodels.ArticleViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel: ArticleViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_home_search).setOnClickListener {
            view.findNavController().navigate(R.id.action_HomeFragment_to_ArticleFragment)
        }

        view.findViewById<TextView>(R.id.text_view_home_url).apply {
            viewModel.inputUrl.observe(viewLifecycleOwner) { text = it }
        }
    }
}