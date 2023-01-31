package ru.sergsports.androidcource.sporttestapp.presentation.mockview

import android.view.View
import com.squareup.picasso.Picasso
import ru.sergsports.androidcource.sporttestapp.data.SportsNews
import ru.sergsports.androidcource.sporttestapp.databinding.ItemMockFragmentBinding
import com.xwray.groupie.viewbinding.BindableItem
import ru.sergsports.androidcource.sporttestapp.R


class ItemNews(
    private val content: SportsNews
) : BindableItem<ItemMockFragmentBinding>()  {
    override fun bind(viewBinding: ItemMockFragmentBinding, position: Int) {
        viewBinding.textView.text = content.title
        Picasso.get()
            .load(content.imageId)
            .fit()
            .centerCrop()
            .into(viewBinding.imageSportsNews)
    }

    override fun getLayout(): Int = R.layout.item_mock_fragment

    override fun initializeViewBinding(view: View) = ItemMockFragmentBinding.bind(view)
}