package com.theah64.qpool.ui.activities.qpool.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide

import com.theah64.qpool.R
import com.theah64.qpool.databinding.FragmentQuestionBinding
import com.theah64.qpool.questions.Question

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class QuestionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding =
            DataBindingUtil.inflate<FragmentQuestionBinding>(inflater, R.layout.fragment_question, container, false)

        arguments?.let {
            val question = it.get(Question.KEY) as Question
            binding.question = question

            // Loading image
            Glide.with(binding.ivImage)
                .load(question.imageUrl)
                .into(binding.ivImage)
        }

        return binding.root
    }


    companion object {
        /**
         * Creates new instance of the question fragment
         */
        fun newInstance(question: Question): QuestionFragment {
            val fragment = QuestionFragment()
            val args = Bundle()
            args.putSerializable(Question.KEY, question)
            fragment.arguments = args
            return fragment
        }
    }


}
