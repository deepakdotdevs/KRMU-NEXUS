package com.krmu.nexus.ui.role

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.krmu.nexus.R
import com.krmu.nexus.databinding.FragmentRoleSelectionBinding
import java.security.AuthProvider

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RoleSelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RoleSelectionFragment : Fragment(R.layout.fragment_role_selection) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentRoleSelectionBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRoleSelectionBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]

        binding.btnStudent.setOnClickListener {
            viewModel.setRole("student")
            val action = RoleSelectionFragmentDirections.actionRoleSelectionToLogin("student")
            findViewController().navigate(action)
        }
        binding.btnTeacher.setOnClickListener {
            viewModel.setRole("teacher")
            val action = RoleSelectionFragmentDirections.actionRoleSelectionToLogin("teacher")
            findViewController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}