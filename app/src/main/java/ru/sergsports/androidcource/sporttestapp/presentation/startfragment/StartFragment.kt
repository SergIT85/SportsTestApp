package ru.sergsports.androidcource.sporttestapp.presentation.startfragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import ru.sergsports.androidcource.sporttestapp.R

private const val RESULT_URL = "RESULT_URL"
private const val ARG_PARAM2 = "param2"

@Suppress("UNREACHABLE_CODE")
class StartFragment : Fragment() {

    var pref: SharedPreferences? = null
    var urlAddress = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
        pref = context?.getSharedPreferences(RESULT_URL, Context.MODE_PRIVATE)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch(Dispatchers.Main) {
            urlAddress = pref?.getString(RESULT_URL, "").toString()
            if(urlAddress == "") {
                urlAddress = async(Dispatchers.IO) {
                    firebaseConnect()
                }.toString()

                when(urlAddress) {
                    "" -> {
                        urlAddress = "BadAdr"
                        saveResultConnection(urlAddress)
                        findNavController().navigate(R.id.mockNewsFragment)
                    }
                    "BadAdr" -> {
                        findNavController().navigate(R.id.mockNewsFragment)
                    }
                    else -> {
                        saveResultConnection(urlAddress)
                        openWeb(urlAddress)
                    }
                }
            }


        }
    }

    fun saveResultConnection(string: String) {
        val edit = pref?.edit()
        edit?.putString("RESULT_URL", string)
        edit?.apply()
    }
    fun openWeb(urlAddress: String) {
        val bundle = Bundle()
        bundle.putString("URL", urlAddress)
        findNavController().navigate(R.id.vebViewFragment, bundle)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StartFragment().apply {
                arguments = Bundle().apply {

                    putString(ARG_PARAM2, param2)
                }
            }
    }
}