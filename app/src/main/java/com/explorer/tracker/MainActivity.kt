package com.explorer.tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.explorer.tracker.Components.*
import com.explorer.tracker.ui.theme.TrackerTheme
import com.explorer.tracker.ui.ui_components.ColumnDemo
import com.explorer.tracker.ui.ui_components.ConstraintLayoutDemo
import com.explorer.tracker.ui.ui_components.LeftNavigationDrawerContent
import com.explorer.tracker.viewmodels.MainViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScaffold()
                }
            }
        }
    }
}

@Composable
fun MainScaffold() {
    val mainViewModel: MainViewModel = viewModel()
    val currentComponent = mainViewModel.currentComponent.collectAsState()

    val materialBlue = colorResource(R.color.material_blue)
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(id = R.string.app_bar))
                },
                backgroundColor = materialBlue
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Text("X")
            }
        },
        drawerContent = { LeftNavigationDrawerContent(scaffoldState) },
        content = { MainScreenContent(currentComponent.value) },
        bottomBar = {
            BottomAppBar(backgroundColor = materialBlue) {
                Text(stringResource(id = R.string.bottom_navigation))
            }
        }
    )
}

@Composable
fun MainScreenContent(currentContent: Components) = when (currentContent) {
    CONSTRAINTLAYOUT -> {ConstraintLayoutDemo()}
    SCAFFOLD -> {}
    COLUMN -> { ColumnDemo() }
    ROW -> {}
    BOX -> {}
    CANVAS -> {}
    IMAGE -> {}
    LAZYVERTICALGRID -> {}
    SHAPE -> {}
    TEXT -> {}
    ALERTDIALOG -> {}
    BUTTON -> {}
    CARDS -> {}
    CHECKBOX -> {}
    PROGRESSINDECATORS -> {}
    DROPDOWNMENU -> {}
    FLOATINGACTIONBUTTON -> {}
    MODALDRAWERLAYOUT -> {}
    RADIOBUTTON -> {}
    SLIDER -> {}
    SNACKBAR -> {}
    SWITCH -> {}
    TEXTFIELD -> {}
}
