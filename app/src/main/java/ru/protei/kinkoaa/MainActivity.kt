package ru.protei.kinkoaa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import ru.protei.kinkoaa.ui.notes.NotesScreen
import ru.protei.kinkoaa.ui.notes.NotesViewModel
import ru.protei.kinkoaa.ui.theme.KinkoaaTheme

class MainActivity : ComponentActivity() {
    private val notesViewModel: NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KinkoaaTheme {
                Surface(
                    modifier = Modifier.fillMaxHeight(),
                ) {
                    NotesScreen(notesViewModel)
                }
            }
        }
    }
}