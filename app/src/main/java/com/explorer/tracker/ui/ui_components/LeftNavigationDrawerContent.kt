package com.explorer.tracker.ui.ui_components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.explorer.tracker.viewmodels.MainViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun LeftNavigationDrawerContent(scaffoldState: ScaffoldState) {
    val viewModel: MainViewModel = viewModel()
    val components = viewModel.getComponents()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 25.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Jetpack Compose Elements",
                    style = MaterialTheme.typography.h5
                )
            }
        }
        items(components) { component ->
            val coroutineScope = rememberCoroutineScope()
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable(
                        onClick = {
                            viewModel.updateCurrentContent(component)
                            coroutineScope.launch {
                                if (scaffoldState.drawerState.isClosed)
                                    scaffoldState.drawerState.open()
                                else
                                    scaffoldState.drawerState.close()
                            }
//
                    }),
                elevation = 10.dp
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    text = component.name,
                    style = TextStyle(fontSize = 16.sp, textAlign = TextAlign.Center)
                 )
            }
        }
    }
}