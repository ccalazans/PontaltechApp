package com.example.pontaltech

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pontaltech.ui.theme.PontaltechTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val auth = Firebase.auth
        Log.i(TAG, "onCreate usuário atual:${auth.currentUser?.uid} ")

//     auth.createUserWithEmailAndPassword("cacaudomau@gmail.com","cc1o2a3c").addOnCompleteListener{task->if(task.isSuccessful){
//         Log.i(TAG, "onCreate: sucesso")
//     } else{
//         Log.i(TAG, "onCreate: falha -> ${task.exception}")
//     }
//     }

     auth.signInWithEmailAndPassword("cacaudomau@gmail.com","cc1o2a3c").addOnCompleteListener{task->if(task.isSuccessful){
            Log.i(TAG, "Login: sucesso")
        } else{
            Log.i(TAG, "Login: falha -> ${task.exception}")
        }
        }

 //    auth.signOut()

        enableEdgeToEdge()
        setContent {
            PontaltechTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
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
    PontaltechTheme {
        Greeting("Android")
    }
}