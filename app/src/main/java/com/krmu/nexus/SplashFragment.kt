package com.krmu.nexus.ui.splash

import android.os.Bundle
import android.se.omapi.Session
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.krmu.nexus.R
import com.krmu.nexus.databinding.FragmentSplashBinding
import com.krmu.nexus.utils.SessionManager
import kotlinx.coroutines.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SplashFragment : Fragment(R.layout.fragment_splash) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentSplashBinding?= null
    private val binding get() = _binding!!
    private lateinit var sessionManager: SessionManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSplashBinding.bind(view)
        sessionManager = SessionManager(requireContext())
        startAnimation()
        navigateNext()
    }
    private fun startAnimation() {
        binding.logoImage.alpha = 0f
        binding.logoImage.scaleX = 0.8f
        binding.logoImage.scaleY = 0.8f

        binding.logoImage.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(1200)
            .start()
    }
    private fun navigateNext() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            if(sessionManager.isLoggedIn()) {
                val role = sessionManager.getRole()
                if(role=="teacher") {
                    findNavController().navigate(R.id.action_splash_to_teacherDashboard)
                } else {
                    findNavController().navigate(R.id.action_splash_to_studentDashboard)
                }
            } else {
                findNavController().navigate(R.id.action_splash_to_roleSelection)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SplashFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SplashFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}