package com.explorer.tracker.viewmodels

import androidx.lifecycle.ViewModel
import com.explorer.tracker.Components
import kotlinx.coroutines.flow.flowOf

class MainViewModel : ViewModel() {

    fun updateCurrentContent(component: Components) {
        //business logic
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