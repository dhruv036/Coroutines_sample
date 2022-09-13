package com.example.coroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    var TAG= "MainAcivity"
    var job = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//         GlobalScope.launch(Dispatchers.Main){
//    }


        lifecycleScope.launch(Dispatchers.IO) {
            longRunningTask()
        }

        findViewById<Button>(R.id.button2).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,ViewModalActivity::class.java))
        })

//        CoroutineScope(Dispatchers.Main).launch {
//            getFollowers()
//        }
//        CoroutineScope(Dispatchers.IO).launch { // Parent
////            var insta = getInstaFollowers()
////            var fb = getFbFollowers()
//
//            var insta =  async { getInstaFollowers() }//  Child
//            var fb =  async { getFbFollowers() }
//            Log.e("context","${Thread.currentThread().name}")
////            insta.join()
////            fb.join()
//
//
//            Log.e("Follower","Insta ${insta.await()} fb ${fb.await()}")
//            withContext(Dispatchers.Main){
//                findViewById<TextView>( R.id.textView).text = "Follower Insta ${insta.await()} fb ${fb.await()}"
//                Log.e("context","${Thread.currentThread().name}")
//            }

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }
   suspend fun getFollowers(){
        Log.e("TASK","One Start")
        yield()
        Log.e("TASK","One Stop")
    }

   suspend fun getInstaFollowers():Int{
       delay(1000)
        return 180
    }
   suspend fun getFbFollowers(): Int{
       delay(1000)
        return 125
    }

    suspend fun longRunningTask(){
        while (true){
            delay(1000)
            Log.e(TAG,"${Thread.currentThread().name}")
        }
    }

     fun th(){
        Log.e("aaaaaaaaaaaaaaaaaaaa","start")
        Toast.makeText(applicationContext,"Thread Started",Toast.LENGTH_SHORT).show()
        Thread.sleep(10000)
         throw Exception("jhhhj")
        Log.e("aaaaaaaaaaaaaaaaaaaaaaa","stop")
        Toast.makeText(applicationContext,"Thread Stoped",Toast.LENGTH_SHORT).show()
    }
}