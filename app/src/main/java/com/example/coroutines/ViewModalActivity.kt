package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope

class ViewModalActivity : AppCompatActivity() {
    var TAG = "ViewModalActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_modal)
        Log.d(TAG, "onCreate: ")
        var model = ViewModelProvider(this).get(ViewModel::class.java)
        model.launchScope()
    }

}