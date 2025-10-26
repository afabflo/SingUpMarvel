SingUpMarvel

Formulario de registro moderno inspirado en Marvel Studios, desarrollado en Kotlin + Jetpack Compose (Material 3).
Incluye validación de email, contraseñas, selección de usuario, interruptores de preferencias y control de aceptación de términos.

🧾 Descripción del proyecto

SingUpMarvel es una pantalla de creación de cuenta de usuario con diseño limpio y validaciones reactivas.
El usuario puede:

Introducir su correo electrónico (con validación automática de formato).

Escribir y confirmar su contraseña (ambas deben coincidir).

Seleccionar el tipo de cuenta (Usuario o Administrador).

Activar el switch para recibir notificaciones y ofertas.

Aceptar los términos y condiciones mediante un checkbox.

Pulsar el botón “Crear cuenta” (redondeado tipo pill).

Acceder al enlace “¿Tiene una cuenta? Sign in” para volver al login.

🧩 Componentes principales
📨 EmailField.kt

Campo de texto con validación en tiempo real.

OutlinedTextField(
    value = email,
    onValueChange = {
        onChange(it)
        isError = !android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches()
    },
    label = { Text("Email") },
    leadingIcon = { Icon(imageVector = EmailIcon(), contentDescription = "Icono Email") },
    isError = isError,
    supportingText = {
        if (isError) Text("Introduce una dirección válida", color = MaterialTheme.colorScheme.error)
    }
)


✔️ Usa android.util.Patterns para comprobar el formato del correo.
✔️ Muestra un texto de error y un icono de advertencia si el formato no es válido.

🔒 PasswordField.kt

Campo de contraseña con botón de visibilidad (mostrar/ocultar).

OutlinedTextField(
    value = password,
    onValueChange = { onChange(it) },
    label = { Text("Password") },
    leadingIcon = { Icon(imageVector = PasswordIcon(), contentDescription = null) },
    trailingIcon = {
        IconButton(onClick = { passwordVisible = !passwordVisible }) {
            Icon(
                imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                contentDescription = null
            )
        }
    },
    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
)


✔️ Controla la visibilidad del texto.
✔️ Se usa dos veces: una para “Password” y otra para “Confirm Password”.

⚙️ SelectUser

Permite elegir el tipo de cuenta con RadioButton.

Row(verticalAlignment = Alignment.CenterVertically) {
    RadioButton(
        selected = selectUser == "User",
        onClick = { onSelectedChange("User") },
        colors = RadioButtonDefaults.colors(MaterialTheme.colorScheme.primary)
    )
    Text("User")

    RadioButton(
        selected = selectUser == "Administrador",
        onClick = { onSelectedChange("Administrador") },
        colors = RadioButtonDefaults.colors(MaterialTheme.colorScheme.primary)
    )
    Text("Administrador")
}

📰 NotifyAccept

Interruptor tipo Switch para suscribirse a noticias y ofertas.

Switch(
    checked = notifyAlerts,
    onCheckedChange = { onCheckedChange(it) },
    colors = SwitchDefaults.colors(MaterialTheme.colorScheme.primary)
)

✅ AcceptTermsAccount

Checkbox para aceptar los términos de la cuenta.

Row(verticalAlignment = Alignment.CenterVertically) {
    Checkbox(checked = accepted, onCheckedChange = { onCheckedChange(it) })
    Text("Aceptas los términos de la cuenta")
}

🎨 HeaderBox

Encabezado visual con fondo de imagen y texto “MARVEL”.

Box(
    modifier = Modifier.fillMaxWidth().height(240.dp)
) {
    Image(
        painter = painterResource(R.drawable.marvel),
        contentDescription = "Imagen Marvel",
        contentScale = ContentScale.Crop,
        modifier = Modifier.matchParentSize()
    )
    Box(modifier = Modifier.background(Color(0xAA000000)).matchParentSize())
    Text(
        text = stringResource(R.string.marvel),
        fontSize = 45.sp,
        color = colorMarvel,
        fontFamily = MarvelTipo,
        fontWeight = FontWeight.Normal,
        modifier = Modifier.align(Alignment.BottomEnd)
    )
}

🖋️ Botón y enlace inferior
Button(
    onClick = { /* Crear cuenta */ },
    shape = RoundedCornerShape(50),
    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE0E0E0)),
    enabled = false,
    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
) {
    Text("Crear cuenta", fontWeight = FontWeight.Bold)
}

Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
    Text("¿Tiene una cuenta? ")
    Text("Sign in", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
}

🧠 Lógica de validación

Email válido: android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

Contraseñas iguales: password == confirmPassword

El botón Crear cuenta se puede habilitar solo si todo es válido:

val formValid = email.isNotEmpty() && password == confirmPassword && acceptTerms

🌈 Diseño y estilo

Material 3 Components: botones, campos, switches y tipografías.

Color principal: colorMarvel = Color(0xFF6A1B9A)

Tipografía Marvel: definida en Type.kt

val MarvelTipo = FontFamily(Font(R.font.marvel_regular))


Layout principal: Box con Column centrada vertical y horizontalmente.

🚀 Preview
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SingUpPreview() {
    SingUp(modifier = Modifier)
}


Permite visualizar el formulario completo dentro de Android Studio sin necesidad de ejecutar la app.

📦 Tecnologías utilizadas

Kotlin 2.x

Jetpack Compose (Material 3)

Android Studio 2025

ViewModel + State (Compose remember/mutableStateOf)

Git + GitHub para control de versiones
