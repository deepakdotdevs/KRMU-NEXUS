package com.krmu.nexus.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.krmu.nexus.R
import com.krmu.nexus.databinding.FragmentTeacherLoginBinding
import com.krmu.nexus.utils.SessionManager
import com.krmu.nexus.viewmodel.AuthViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TeacherLoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TeacherLoginFragment : Fragment(R.layout.fragment_teacher_login) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentTeacherLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AuthViewModel
    private lateinit var sessionManager: SessionManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTeacherLoginBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]
        sessionManager = SessionManager(requireContext())

        binding.btnLoginTeacher.setOnClickListener {
            val email = binding.etTeacherEmail.text.toString().trim()
            val password = binding.etTeacherPassword.text.toString().trim()
            viewModel.login(email, password)
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.userData.observe(viewLifecycleOwner) { pair ->
            val uid = pair.first
            val role = pair.second
            sessionManager.saveUserSession(uid, role)
            findNavController().navigate(R.id.action_teacherLoginFragment_to_teacherDashboardFragment)
        }
        viewModel.loading.observe(viewLifecycleOwner) {
            // Optional: show progress bar later
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }
}