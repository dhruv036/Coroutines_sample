package com.example.coroutines

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {
    var TAG = "ViewModel"

     fun launchScope(){
        viewModelScope.launch(){
           change()
        }
    }

    suspend fun change(){
        var i=0
        while (true){
            delay(1000)
            Log.e(TAG,i.toString())
            i++
        }
    }
}