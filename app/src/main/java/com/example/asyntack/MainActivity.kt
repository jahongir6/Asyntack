package com.example.asyntack

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.asyntack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvTime.setOnClickListener {
            MyTask().execute()
        }
    }

    var count = 0

    inner class MyTask : AsyncTask<Void, Void, Void>() {
        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            Toast.makeText(this@MainActivity, "end", Toast.LENGTH_SHORT).show()
            binding.tvTime.text = count.toString()
        }

        override fun doInBackground(vararg params: Void?): Void? {
            while (count <= 10) {
                count++
                Thread.sleep(1000)
            }
            return null
        }

        override fun onPreExecute() {
            super.onPreExecute()
            binding.tvTime.text = count.toString()
            Toast.makeText(this@MainActivity, "start", Toast.LENGTH_SHORT).show()
        }
    }
}