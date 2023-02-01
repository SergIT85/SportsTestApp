package ru.sergsports.androidcource.sporttestapp.presentation.vebview

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.sergsports.androidcource.sporttestapp.R
import ru.sergsports.androidcource.sporttestapp.databinding.FragmentVebViewBinding
import android.webkit.CookieManager
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController

class WebViewFragment : Fragment(R.layout.fragment_veb_view)  {

    private var _binding: FragmentVebViewBinding? = null
    private val binding get() = _binding!!
    private var urlAddress: String = ""

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
        _binding = FragmentVebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        urlAddress = requireArguments().getString("URL").toString()
        val webActivity = binding.webView
        webActivity.settings.javaScriptEnabled = true
        webActivity.settings.domStorageEnabled = true

        CookieManager.getInstance().setAcceptThirdPartyCookies(webActivity, true)
        CookieManager.getInstance().flush()

        val regPattern = Regex("""(?:https?|ftp)://\S+""")
        val containUrl = regPattern.containsMatchIn(urlAddress)

        if (!urlAddress.isEmpty() && containUrl) {
            webActivity.loadUrl(urlAddress)
        } else {
            findNavController().navigate(R.id.mockNewsFragment)
        }


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val webActivity = binding.webView
                if (webActivity.canGoBack()){
                    webActivity.goBack()
                } else {

                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }



    companion object {

    }
}