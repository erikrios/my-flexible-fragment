package io.erikrios.github.myflexiblefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import io.erikrios.github.myflexiblefragment.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDetailCategory.setOnClickListener {
            val mDetailCategoryFragment = DetailCategoryFragment()

            val mBundle = Bundle()
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle")
            val description = "Kategori ini akan berisi produk-produk lifestyle"

            mDetailCategoryFragment.arguments = mBundle
            mDetailCategoryFragment.description = description

            val mFragmentManager = parentFragmentManager
            mFragmentManager.commit {
                addToBackStack(null)
                replace(
                    R.id.frame_container,
                    mDetailCategoryFragment,
                    DetailCategoryFragment::class.java.simpleName
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
