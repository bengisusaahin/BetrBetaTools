import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardActions.Companion.Default
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
data class App(val name: String, val genre: String)

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun GroupedApps(apps: List<App>, groupName: String) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.Red)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = groupName,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))

        LazyColumn {
            items(apps.size) { index ->
                val app = apps[index]
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // You can use your actual icons here
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = app.name,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GroupedAppsList(appsGroup1: List<App>, appsGroup2: List<App>) {
    Column {
        GroupedApps(apps = appsGroup1, groupName = "Tools")
        GroupedApps(apps = appsGroup2, groupName = "Games")
    }
}
@Preview
@Composable
fun AppScreen() {
    val appsGroup1 = listOf(
        App("App1", ""),
        App("App2", ""),
        App("App3", "")
    )

    val appsGroup2 = listOf(
        App("App4", ""),
        App("App5", ""),
        App("App6", "")
    )

    GroupedAppsList(appsGroup1, appsGroup2)
}

@Composable
fun App() {
    MaterialTheme {
        AppScreen()
    }
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

annotation class AndroidEntryPoint
