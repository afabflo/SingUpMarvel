package com.example.singupmarvel.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.singupmarvel.R
import com.example.singupmarvel.ui.components.icons.EmailIcon

@Composable
fun EmailField(email:String,onChange:(String) -> Unit) {
    var isError by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = email,
        onValueChange = {
            onChange(it)
            isError = !android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches()
        },
        label = { Text(text = stringResource(R.string.email_adress)) },
        singleLine = true,
        modifier = Modifier.sizeIn(maxWidth = 488.dp).fillMaxWidth(),
        leadingIcon = {
            Icon(
                imageVector = EmailIcon(),
                contentDescription = "Icono Email",
                tint = MaterialTheme.colorScheme.primary
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        isError = isError,
        trailingIcon = {
            if(isError)
                Icon(
                    Icons.Default.Warning,
                    contentDescription = stringResource(R.string.errorEmailFormat)
                )
        },
        supportingText = {
            if(isError){
                Text(
                    text="Introduce un correo valido",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    )
}
@Preview(showBackground = true)
@Composable
fun EmailFielPreview(){
    EmailField(("al.aitor.fabian.flores@iesportada.org"),{})
}