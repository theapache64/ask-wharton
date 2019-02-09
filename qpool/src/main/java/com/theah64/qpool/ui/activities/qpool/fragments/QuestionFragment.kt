package com.theah64.qpool.ui.activities.qpool.fragments


import android.content.Context
import android.os.Bundle
import android.util.Log
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

    private lateinit var viewModel: QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)

        // Watching for button clicks
        viewModel.getButtonClicks().observe(this, Observer { buttonId ->

            Log.e("X", "Button clicked trigger from vm to fragment")

            when (buttonId) {

                // Next
                QuestionViewModel.ID_NEXT -> {

                    Log.e("X", "Next button clicked @fragment")
                    callback.onNextButtonClicked()
                }

                // Prev
                QuestionViewModel.ID_PREV -> {

                    Log.e("X", "Prev button clicked @fragment")
                    callback.onPrevButtonClicked()
                }

                else -> throw IllegalArgumentException("Unmanaged click")
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding =
            DataBindingUtil.inflate<FragmentQuestionBinding>(inflater, R.layout.fragment_question, container, false)



        arguments?.let {
            val question = it.get(Question.KEY) as Question
            viewModel.question = question

            // Loading image
            Glide.with(binding.ivImage)
                .load(question.imageUrl)
                .into(binding.ivImage)
        }

        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)



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
