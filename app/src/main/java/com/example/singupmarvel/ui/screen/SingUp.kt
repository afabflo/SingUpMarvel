package com.example.singupmarvel.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.singupmarvel.R
import com.example.singupmarvel.ui.components.EmailField
import com.example.singupmarvel.ui.components.PasswordField
import com.example.singupmarvel.ui.theme.MarvelTipo
import com.example.singupmarvel.ui.theme.colorMarvel

@Composable
fun SingUp(modifier: Modifier) {
    var scrollState = rememberScrollState();
    var email  by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var selectUser by remember { mutableStateOf("") }
    var notifyAlerts by remember { mutableStateOf(false) }
    var acceptTerms by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
    Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState))
    {
        HeaderBox() //Up arriba
        Column(
            modifier = Modifier.
            padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Text(
                text = stringResource(R.string.Singup),
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = stringResource(R.string.createaccount),
                style = MaterialTheme.typography.titleSmall
            )
            EmailField(email, onChange = {email=it})
            PasswordField(password, onChange = {password=it})
            PasswordField(confirmPassword, onChange = { confirmPassword = it })
            if(confirmPassword.isNotEmpty() && confirmPassword != password)
                Text(
                    text = stringResource(R.string.password_mismatch),
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            SelectUser(selectUser, onSelectedChange = {selectUser = it})
            NotifyAccept(notifyAlerts = notifyAlerts, onCheckedChange = {notifyAlerts = it})
            AcceptTermsAccount(acceptTerms, onCheckedChange = {acceptTerms = it})
            LoginButton(onLogin = {})
            SingUp(onSingUp = {})


        }
    }
    }
}

@Composable
fun SelectUser(selectUser :String,onSelectedChange:(String)-> Unit) {
Row(verticalAlignment = Alignment.CenterVertically){
    RadioButton(
        selected = selectUser == "User",
        onClick = {onSelectedChange("User")},
        colors = RadioButtonDefaults.colors(MaterialTheme.colorScheme.primary)
    )
    Text("User")
    RadioButton(
        selected = selectUser == "Administrador",
        onClick = {onSelectedChange("Administrador")},
        colors = RadioButtonDefaults.colors(MaterialTheme.colorScheme.primary)

    )
    Text("Administrador")
}
}
@Composable
fun NotifyAccept(notifyAlerts : Boolean,onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text("Recibir noticias y ofertas")
        Switch(
            checked = notifyAlerts,
            onCheckedChange = {onCheckedChange(it)},
            colors = SwitchDefaults.colors(MaterialTheme.colorScheme.primary,Color.White)
        )
    }
}

@Composable
fun AcceptTermsAccount(accepted : Boolean,onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier =  Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Checkbox(
            checked = accepted,
            onCheckedChange = {onCheckedChange(it)}
        )
        Text("Aceptas los terminos de la cuenta")
    }
}

@Composable fun LoginButton(onLogin:() -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Button(
            onClick = onLogin,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6A1B9A),
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.create))
        }


    }
}
@Composable
fun SingUp(onSingUp: () -> Unit) {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().widthIn(max=360.dp).padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically,) {
        Text(text = stringResource(R.string.YesAccount))
        TextButton(onClick = onSingUp) {
            Text(text = stringResource(R.string.sing_up))
        }
    }
}
@Composable
fun HeaderBox() {
   Box(
       modifier =  Modifier.fillMaxWidth().height(240.dp)
   ){
       Image(
           painter = painterResource(R.drawable.marvel),
            contentDescription = stringResource(R.string.imgMarvel),
           modifier = Modifier.matchParentSize(),
           contentScale = ContentScale.Crop
       )
       Box(
           modifier = Modifier.background(Color(0xAA000000))
               .matchParentSize()
       )
       Text(
           text = stringResource(R.string.marvel),
           fontSize = 45.sp,
           color = colorMarvel,
           fontFamily = MarvelTipo,
           fontWeight = FontWeight.Normal,
           modifier  = Modifier.align(Alignment.BottomEnd)

       )
   }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun singUpPreview(){
    SingUp(modifier = Modifier)
}