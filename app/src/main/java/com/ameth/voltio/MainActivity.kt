package com.ameth.voltio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ameth.voltio.core.di.AppContainer
import com.ameth.voltio.core.navigation.NavigationWrapper
import com.ameth.voltio.features.login.di.AuthModule
import com.ameth.voltio.features.login.presentation.navigation.LoginNavGraph
import com.example.compose.AppTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ameth.voltio.ui.theme.VoltioTheme

class MainActivity : ComponentActivity() {
    lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appContainer = AppContainer(this)
        val authModule = AuthModule(appContainer)

        val navGraphs = listOf(
            LoginNavGraph(authModule.provideLoginViewModelFactory())
        )

        enableEdgeToEdge()
        setContent {
            AppTheme {
                NavigationWrapper()
            VoltioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                NavigationWrapper(navGraphs = navGraphs)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VoltioTheme {
        Greeting("Android")
    }
}
}