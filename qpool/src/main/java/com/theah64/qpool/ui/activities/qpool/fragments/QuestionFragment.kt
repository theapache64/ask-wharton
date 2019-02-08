package com.theah64.qpool.ui.activities.qpool.fragments


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.theah64.qpool.R
import com.theah64.qpool.databinding.FragmentQuestionBinding
import com.theah64.qpool.questions.Question
import com.theah64.qpool.ui.activities.qpool.Callback

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class QuestionFragment : Fragment() {

    private lateinit var callback: Callback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.callback = context as Callback
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding =
            DataBindingUtil.inflate<FragmentQuestionBinding>(inflater, R.layout.fragment_question, container, false)

        val viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)

        arguments?.let {
            val question = it.get(Question.KEY) as Question
            viewModel.question = question

            // Loading image
            Glide.with(binding.ivImage)
                .load(question.imageUrl)
                .into(binding.ivImage)
        }

        binding.viewModel = viewModel

        // Watching for button clicks
        viewModel.getButtonClicks().observe(this, Observer { buttonId ->
            when (buttonId) {

                // Next
                R.id.b_next -> {
                    callback.onNextButtonClicked()
                }

                // Prev
                R.id.b_prev -> {
                    callback.onPrevButtonClicked()
                }

                else -> throw IllegalArgumentException("Unmanaged click")
            }
        })

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
