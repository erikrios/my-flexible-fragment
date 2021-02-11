package io.erikrios.github.myflexiblefragment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import io.erikrios.github.myflexiblefragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val mFragmentManager = supportFragmentManager
        val mHomeFragment = HomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name : ${HomeFragment::class.java.simpleName}")
            mFragmentManager.commit {
                add(binding.frameContainer.id, mHomeFragment, HomeFragment::class.java.simpleName)
            }
        }
    }
}