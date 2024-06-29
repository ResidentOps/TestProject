package com.ntiteam.testproject.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ntiteam.testproject.R
import java.io.IOException
import java.net.ServerSocket
import java.util.concurrent.Executors

class ConfigActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfigUI()
        }
    }
}

@Composable
fun ConfigUI() {

    val contextConfig = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 10.dp),
            text = stringResource(R.string.text_config),
            fontSize = 20.sp
        )

        var textIP by remember { mutableStateOf("") }
        OutlinedTextField(
            value = textIP,
            onValueChange = { textIP = it },
            label = {
                Text(
                    text = stringResource(R.string.editText_ip)
                )
            }
        )

        var textPort by remember { mutableStateOf("") }
        OutlinedTextField(
            value = textPort,
            onValueChange = { textPort = it },
            label = {
                Text(
                    text = stringResource(R.string.editText_port)
                )
            }
        )

        Button(
            onClick = {
                var ip = textPort.toDouble()
                val port = textPort.toInt()
                if (textIP.isEmpty() || textPort.isEmpty()) {
                    Toast.makeText(contextConfig, R.string.error_emptyFields, Toast.LENGTH_SHORT).show()
                } else {
                    try {
                        val serverSocket = ServerSocket(port)
                        val socket = serverSocket.accept()
                        val inputStream = socket.getInputStream()
                        val outputStream = socket.getOutputStream()
                    }catch (ex: IOException){
                        ex.printStackTrace()
                    }
                    val executors = Executors.newSingleThreadExecutor()
                    val handler = Handler(Looper.getMainLooper())
                    executors.execute(Runnable{
                        kotlin.run {
                            val buffer = ByteArray(1024)
                            var byte:Int
                            while (true){

                            }
                        }
                    })

                }
            },
            modifier = Modifier
                .padding(top = 20.dp, bottom = 10.dp)
                .size(width = 200.dp, height = 50.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp),
                text = stringResource(R.string.button_save),
                color = Color.White,
            )
        }

    }

}

@Preview
@Composable
fun ConfigPreview() {
    ConfigUI()
}