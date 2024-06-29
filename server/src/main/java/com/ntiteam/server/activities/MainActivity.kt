package com.ntiteam.server.activities

import android.content.Intent
import android.os.Bundle
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ntiteam.server.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainServerUI()
        }
    }
}

@Composable
fun MainServerUI() {

    val contextMainServer = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(
            text = stringResource(R.string.app_name),
            fontSize = 20.sp
        )

        Button(
            onClick = {
                contextMainServer.startActivity(Intent(contextMainServer, PortSelectActivity::class.java))
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
                text = stringResource(R.string.button_config),
                color = Color.White,
            )
        }

        Button(
            onClick = {
            },
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
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
                text = stringResource(R.string.button_turnOn),
                color = Color.White,
            )
        }

        Button(
            onClick = {
            },
            modifier = Modifier
                .padding(top = 10.dp, bottom = 20.dp)
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
                text = stringResource(R.string.button_switchOff),
                color = Color.White,
            )
        }

    }

}

@Preview
@Composable
fun MainServerPreview() {
    MainServerUI()
}