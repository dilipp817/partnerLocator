package com.explorer.tracker.viewmodels

import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.lifecycle.ViewModel
import com.explorer.tracker.Components
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf

class MainViewModel : ViewModel() {

    private val _currentComponent = MutableStateFlow(Components.CONSTRAINTLAYOUT)
    val currentComponent = _currentComponent.asStateFlow()

    fun updateCurrentContent(component: Components) {
        _currentComponent.value = component
    }

    fun getComponents() = listOf(
        Components.CONSTRAINTLAYOUT,
        Components.SCAFFOLD,
        Components.COLUMN,
        Components.ROW,
        Components.BOX,
        Components.CANVAS,
        Components.IMAGE,
        Components.LAZYVERTICALGRID,
        Components.SHAPE,
        Components.TEXT,
        Components.ALERTDIALOG,
        Components.BUTTON,
        Components.CARDS,
        Components.CHECKBOX,
        Components.PROGRESSINDECATORS,
        Components.DROPDOWNMENU,
        Components.FLOATINGACTIONBUTTON,
        Components.MODALDRAWERLAYOUT,
        Components.RADIOBUTTON,
        Components.SLIDER,
        Components.SNACKBAR,
        Components.SWITCH,
        Components.TEXTFIELD,
    )
}