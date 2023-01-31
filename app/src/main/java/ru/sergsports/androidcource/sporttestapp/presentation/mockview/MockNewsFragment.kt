package ru.sergsports.androidcource.sporttestapp.presentation.mockview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import ru.sergsports.androidcource.sporttestapp.R
import ru.sergsports.androidcource.sporttestapp.data.MockRepository
import ru.sergsports.androidcource.sporttestapp.databinding.ItemMockFragmentBinding
import ru.sergsports.androidcource.sporttestapp.databinding.MockFragmentBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MockNewsFragment : Fragment(R.layout.mock_fragment) {

    private var _binding: MockFragmentBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy {
        GroupAdapter<GroupieViewHolder>()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MockFragmentBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listNews = context?.let { MockRepository.getSportsNews(it) }
        val insertList = listNews?.map {
            ItemNews(it)
        }?.toList()
        binding.mockNewsRecyclerView.adapter = adapter.apply { insertList?.let { addAll(it) } }
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            MockNewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}