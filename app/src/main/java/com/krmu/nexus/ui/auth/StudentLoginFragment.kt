package com.krmu.nexus.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.krmu.nexus.R
import com.krmu.nexus.databinding.FragmentStudentLoginBinding
import com.krmu.nexus.viewmodel.AuthViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StudentLoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentLoginFragment : Fragment(R.layout.fragment_student_login) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentStudentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentStudentLoginBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]

        binding.btnLoginStudent.setOnClickListener {
            val email = binding.etStudentEmail.text.toString()
            val password = binding.etStudentPassword.text.toString()
            viewModel.login(email, password)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}