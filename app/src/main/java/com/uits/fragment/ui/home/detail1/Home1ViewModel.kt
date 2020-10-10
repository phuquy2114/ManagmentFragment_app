package com.uits.fragment.ui.home.detail1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Home1ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is HOME !!!! Fragment"
    }
    val text: LiveData<String> = _text
}