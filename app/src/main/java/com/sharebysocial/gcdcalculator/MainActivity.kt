package com.sharebysocial.gcdcalculator

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sharebysocial.gcdcalculator.ui.theme.GCDCalculatorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GCDCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Layout()
                }
            }
        }
    }
}


@Composable
@Preview
fun Layout() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(10.dp)
    ) {
        HeaderText()

    }
}

@Composable
fun HeaderText() {

    Text(
        text = "CGPA Calculator\n" + "Apka anka,aapka vabisya",
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center)
    )
    Spacer(modifier = Modifier.padding(5.dp))
    TextView(title = "Subject 1")
    Spacer(modifier = Modifier.padding(top = 5.dp))
    EditTextGrade("a", {})
    Spacer(modifier = Modifier.padding(top = 2.dp))
    EditTextCredit(credit = "70", onValueChange = {})

    // Second subject
    Spacer(modifier = Modifier.padding(2.dp))
    TextView(title = "Subject 2")
    Spacer(modifier = Modifier.padding(top = 5.dp))
    EditTextGrade("b", {})
    Spacer(modifier = Modifier.padding(top = 2.dp))
    EditTextCredit(credit = "75", onValueChange = {})

    // Third subject
    Spacer(modifier = Modifier.padding(2.dp))
    TextView(title = "Subject 3")
    Spacer(modifier = Modifier.padding(top = 5.dp))
    EditTextGrade("a", {})
    Spacer(modifier = Modifier.padding(top = 2.dp))
    EditTextCredit(credit = "70", onValueChange = {})
    //Fourth subjects
    Spacer(modifier = Modifier.padding(2.dp))
    TextView(title = "Subject 4")
    Spacer(modifier = Modifier.padding(top = 5.dp))
    EditTextGrade("a", {})
    Spacer(modifier = Modifier.padding(top = 2.dp))
    EditTextCredit(credit = "70", onValueChange = {})
    Row() {
        Column() {
            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    Color(0xFFBEABE0)
                ),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Calculate CGPA", color = Color.Black)
            }
            Surface(
                modifier = Modifier
                    .width(148.dp)
                    .wrapContentHeight(),
                color = Color(0xFF263238),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(
                    text = "Your all time \n CGPA: ",
                    modifier = Modifier.padding(5.dp),
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.White
                    )
                )
            }
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = Color(0xFF263238),
            shape = RoundedCornerShape(15.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Previous Semester ", color = Color.White,

                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextGrade(grade: String, onValueChange: (String) -> Unit) {
    TextField(
        value = grade, onValueChange = { text ->
            onValueChange(text)
        }, modifier = Modifier
            .fillMaxWidth()
            .height(47.dp), label = {
            Text(text = "Enter your Grade", color = Color.White, fontSize = 12.sp)
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color(0xFF7E57C2)
        ),
        shape = RoundedCornerShape(15.dp),
        textStyle = TextStyle(fontSize = 12.sp, color = Color.White)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextCredit(credit: String, onValueChange: (String) -> Unit) {
    TextField(
        value = credit, onValueChange = { text ->
            onValueChange(text)
        }, modifier = Modifier
            .fillMaxWidth()
            .height(47.dp), label = {
            Text(text = "Enter your credit point", fontSize = 12.sp)
        }, shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        textStyle = TextStyle(fontSize = 12.sp)
    )
}

@Composable
fun TextView(title: String) {
    Text(text = title, style = TextStyle(fontSize = 20.sp, color = Color.Black))
}



