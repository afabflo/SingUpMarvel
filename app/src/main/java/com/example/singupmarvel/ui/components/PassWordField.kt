package com.example.singupmarvel.ui.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.singupmarvel.ui.components.icons.PasswordIcon
import  com.example.singupmarvel.R

@Composable
fun PasswordField(password:String,onChange:(String) -> Unit) {
    var passwordVisible by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = password,
        onValueChange = {onChange(it)},
        label = { Text(text = stringResource(id = R.string.password)) },
        singleLine = true,
        modifier = Modifier.sizeIn(maxWidth = 488.dp).
        fillMaxWidth(),
        leadingIcon = {
            Icon(
                imageVector = PasswordIcon(),
                contentDescription = "Icono Email",
                tint = MaterialTheme.colorScheme.primary
            )
        },
        trailingIcon = {
            val visibilityIcon = if (passwordVisible)
                Icons.Default.Info
            else
                Icons.Default.Person

            val description = if(passwordVisible)
                stringResource(R.string.password_visibleOFF)
            else{
                stringResource(R.string.password_visible)
            }

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    imageVector = visibilityIcon,
                    contentDescription = null
                )
            }

        },
        keyboardOptions = KeyboardOptions (
            keyboardType = KeyboardType.Password
        ),
        visualTransformation =
            if(passwordVisible)
                VisualTransformation.None
            else {
                PasswordVisualTransformation('*')
            }


    )
}


