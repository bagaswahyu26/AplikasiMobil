package id.ac.amikom.appmobil.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import id.ac.amikom.appmobil.R
import id.ac.amikom.appmobil.data.repository.AuthRepository
import id.ac.amikom.appmobil.databinding.FragmentLoginBinding
import id.ac.amikom.appmobil.databinding.FragmentLoginBinding.*
import id.ac.amikom.appmobil.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    val parent: AuthActivity by lazy { activity as AuthActivity }

    val viewModel : AuthViewModel by lazy { AuthViewModel(AuthRepository(parent)) }
    lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observe()
    }

    private fun observe() {
        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
        }
    }

    private fun init() {
        viewModel.authRegister.observe(viewLifecycleOwner){
            if (it.isConsumed){
                Log.i("Register" ,"isConsumed")
            }else if (!it.issSuccess){
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
            }
            it.isConsumed = true
        }
    }


}