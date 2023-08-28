import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardActions.Companion.Default
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
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
            .padding(10.dp)
            .fillMaxWidth()
            .background(Color(0, 0, 0, 40), RoundedCornerShape(16.dp))
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            val chunkedApps = apps.chunked(3) // Split apps into groups of 3
            items(chunkedApps.size) { groupIndex ->
                val groupApps = chunkedApps[groupIndex]
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 1.dp, start = 1.dp, end = 1.dp, bottom = 1.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    groupApps.forEachIndexed { index, app ->
                        // You can use your actual icons here
                        Icon(
                            imageVector = Icons.Default.AccountBox,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(64.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        if (index < groupApps.size - 1) {
                            Spacer(modifier = Modifier.width(4.dp))
                        }
                    }
                }
                if (groupIndex < chunkedApps.size - 1) {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}


@Composable
fun GroupedAppsList(appsGroup1: List<App>, appsGroup2: List<App>) {
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GroupedApps(apps = appsGroup1, groupName = "Tools")
            Text(
                text = "Tools", // Add label text here
                fontSize = 20.sp,
                color = Color.White, // Customize the color
                modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 4.dp)
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GroupedApps(apps = appsGroup2, groupName = "Games")
            Text(
                text = "Games", // Add label text here
                fontSize = 20.sp,
                color = Color.White, // Customize the color
                modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 4.dp)
            )
        }
    }
}

@Preview
@Composable
fun AppScreen() {
    val appsGroup1 = listOf(
        App("App1", ""),
        App("App2", ""),
        App("App3", ""),
        App("App1", ""),
        App("App2", ""),
        App("App3", "")
    )

    val appsGroup2 = listOf(
        App("App4", ""),
        App("App5", ""),
        App("App6", ""),
        App("App1", ""),
        App("App2", ""),
        App("App3", "")
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
