package com.mustafayigit.apsiyonmovielistcase.ui

import android.os.Bundle
import com.mustafayigit.apsiyonmovielistcase.databinding.ActivityMainBinding
import com.mustafayigit.apsiyonmovielistcase.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}