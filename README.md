# ExamenEventosApp2

## Descripción

ExamenEventosApp2 es una aplicación móvil desarrollada en Kotlin utilizando Jetpack Compose. La aplicación permite a los usuarios gestionar eventos, incluyendo la creación, visualización y eliminación de eventos. Además, la aplicación soporta múltiples idiomas (inglés y español) y permite a los usuarios cambiar el idioma desde la configuración de la aplicación.

## Funcionalidades

1. **Pantalla Principal**:
   - Muestra una lista de eventos.
   - Permite navegar a la pantalla de añadir evento.
   - Permite navegar a la pantalla de configuración.

2. **Añadir Evento**:
   - Permite a los usuarios añadir un nuevo evento proporcionando nombre, descripción, precio y dirección.
   - Valida la entrada del precio para asegurar que es un número válido.
   - Permite guardar el evento o cerrar la pantalla sin guardar.

3. **Configuración**:
   - Permite a los usuarios seleccionar el idioma de la aplicación (inglés o español).
   - Guarda la preferencia de idioma utilizando `SharedPreferences`.
   - Aplica el idioma seleccionado a la interfaz de usuario.

## Estructura del Código

### `MainActivity.kt`

- **MainActivity**: La actividad principal que configura la navegación y la barra superior.
- **MainScreen**: Composable que muestra la lista de eventos y botones de navegación.
- **EventItem**: Composable que muestra los detalles de un evento individual.

### `AddEventScreen.kt`

- **AddEventScreen**: Composable que permite a los usuarios añadir un nuevo evento. Incluye campos de texto para nombre, descripción, precio y dirección, y botones para guardar o cerrar.

### `SettingsScreen.kt`

- **SettingsScreen**: Composable que permite a los usuarios seleccionar el idioma de la aplicación. Utiliza `SharedPreferences` para guardar la preferencia de idioma y `Configuration` para aplicar el idioma seleccionado.

### `Event.kt`

- **Event**: Data class que representa un evento con atributos como nombre, descripción, precio y dirección.

### `Theme.kt`

- **Exameneventosapp2Theme**: Configura el tema de la aplicación, incluyendo esquemas de colores para modos claro y oscuro.

### `strings.xml` y `strings-es.xml`

- Archivos de recursos que contienen las cadenas de texto en inglés y español, respectivamente.

## Dependencias

- Jetpack Compose
- Navigation Compose
- Material3
- Firebase (Analytics, Firestore, Auth, Database)

## Instalación

1. Clona el repositorio.
2. Abre el proyecto en Android Studio.
3. Sincroniza las dependencias de Gradle.
4. Ejecuta la aplicación en un dispositivo o emulador Android.

## Uso

1. Abre la aplicación.
2. En la pantalla principal, añade nuevos eventos utilizando el botón de añadir.
3. Cambia el idioma de la aplicación desde la pantalla de configuración.
4. Visualiza y gestiona los eventos desde la pantalla principal.

link al repositorio: https://github.com/cosmxr/ExamenEventosApp2.git
