package com.example.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import com.example.firstcomposeproject.ui.theme.MainViewModel
import com.example.firstcomposeproject.ui.theme.VkNewsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContent {
            Test(viewModel)
        }
    }

    @Composable
    private fun Test(viewModel: MainViewModel) {
        FirstComposeProjectTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                LazyColumn {
                    item {
                        Text(text = "Title ")
                    }
                    items(10) {
                        VkNewsScreen(viewModel = viewModel)
                    }
                    item {
                        Icon(Icons.Outlined.Call, contentDescription = null)
                    }
                    items(200) {
                        VkNewsScreen(viewModel = viewModel)
                    }
                }
            }
        }
    }
}
