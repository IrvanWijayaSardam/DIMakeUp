package com.aminivan.dimakeup.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aminivan.dimakeup.R
import com.aminivan.dimakeup.databinding.ActivityMainBinding
import com.aminivan.dimakeup.viewmodel.ViewModelMakeUp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var makeupAdapter : MakeupAdapter
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setVmToAdapter()
    }

    fun setVmToAdapter(){
        val viewModel = ViewModelProvider(this).get(ViewModelMakeUp::class.java)
        viewModel.calApiMakeUp()
        viewModel.getLiveDataMakeUp().observe(this, Observer {
            makeupAdapter = MakeupAdapter(it)
            if(it != null){
                binding.rvMakeup.layoutManager = LinearLayoutManager(this,
                    LinearLayoutManager.VERTICAL,false)
                binding.rvMakeup.adapter = MakeupAdapter(it)
            }
        })
    }

}