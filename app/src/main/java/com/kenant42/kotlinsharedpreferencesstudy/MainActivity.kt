package com.kenant42.kotlinsharedpreferencesstudy

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kenant42.kotlinsharedpreferencesstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sp = getSharedPreferences("infos", Context.MODE_PRIVATE)
        val editor = sp.edit()

        editor.putString("name", "Kenan")
        editor.putInt("age", 24)
        editor.putFloat("height", 1.70f)
        editor.putBoolean("isMarried", false)

        val friendList = HashSet<String>()
        friendList.add("Ahmet")
        friendList.add("Mehmet")
        friendList.add("Hüseyin")

        editor.putStringSet("friendList", friendList)
        editor.commit()

        binding.buttonGetData.setOnClickListener {
            val name = sp.getString("name", "NA")
            val age = sp.getInt("age", 0)
            val height = sp.getFloat("height", 0.0f)
            val isMarried = sp.getBoolean("isMarried", false)

            Log.e("NAME: ", name!!)
            Log.e("AGE: ", age.toString())
            Log.e("NAME: ", height.toString())
            Log.e("NAME: ", isMarried.toString())

            val friendList = sp.getStringSet("friendList", null)
            if (friendList != null) {
                for (user in friendList) {
                    Log.e("FRIEND NAME: ", user)
                }
            }

        }


    }
}