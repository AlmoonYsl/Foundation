package com.almoon.foundation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.almoon.foundation_annotation.ObserveFun
import com.almoon.foundation_lib.Foundation

class BlankFragment : Fragment() {
    lateinit var viewModel : TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Foundation.getLog().openAutoUpload(activity!!, uploadEnable = true, saveEnable = true)
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)
        Foundation.getVM().bind(this)
        viewModel.getTest().value = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    @ObserveFun("viewModel.getTest()")
    fun test() {
        Log.d("aaa","ccc")
    }

}