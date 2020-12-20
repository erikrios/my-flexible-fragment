package io.erikrios.github.myflexiblefragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import io.erikrios.github.myflexiblefragment.databinding.FragmentOptionDialogBinding

class OptionDialogFragment : DialogFragment() {

    private var _binding: FragmentOptionDialogBinding? = null
    private val binding get() = _binding!!
    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOptionDialogBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnChoose.setOnClickListener {
            val checkedRadioButtonId = binding.rgOptions.checkedRadioButtonId
            if (checkedRadioButtonId != -1) {
                var coach: String? = null
                when (checkedRadioButtonId) {
                    binding.rbSaf.id -> coach = binding.rbSaf.text.toString().trim()
                    binding.rbMou.id -> coach = binding.rbMou.text.toString().trim()
                    binding.rbLvg.id -> coach = binding.rbLvg.text.toString().trim()
                    binding.rbMoyes.id -> coach = binding.rbMoyes.text.toString().trim()
                }
                optionDialogListener?.onOptionChosen(coach)
                dialog?.dismiss()
            }
        }

        binding.btnClose.setOnClickListener {
            dialog?.cancel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val fragment = parentFragment

        if (fragment is DetailCategoryFragment) {
            val detailCategoryFragment = fragment
            this.optionDialogListener = detailCategoryFragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }
}