package ru.protei.kinkoaa.ui.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesEdit(notesViewModel: NotesViewModel) {
    var titleText by remember {
        mutableStateOf(notesViewModel.selected.value?.getTitle())
    }

    var detailText by remember {
        mutableStateOf(notesViewModel.selected.value?.getText())
    }
    
    if (notesViewModel.selected.value == null)
        NotesScreen(notesViewModel = notesViewModel)

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors (
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    if (notesViewModel.selected.value?.getTitle() == "")
                        Text(
                            "Добавление записи",
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    else
                        Text(
                            "Редактирование записи",
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                }
            )
        },
        bottomBar = {
            BottomAppBar (
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                Text(text = "Кинько Артем",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth())
            }
        },
        floatingActionButton = {
            FloatingActionButton(containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.tertiary,
                onClick = {
                    if (titleText!! != "" && detailText!! != "")
                        if (notesViewModel.selected.value?.getTitle() == "")
                            titleText?.let {
                                detailText?.let {
                                    notesViewModel.onNoteChange(titleText!!, detailText!!)
                                }}
                        else
                            titleText?.let {
                                detailText?.let {
                                    notesViewModel.onNoteChange(titleText!!, detailText!!)
                                }}


                }) {
                Icon(Icons.Filled.Check, "Floating action button.")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(16.dp),

            ) {
            titleText?.let { note ->
                TextField(value = note,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 18.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        focusedIndicatorColor =  Color.Transparent, //hide the indicator
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.secondaryContainer),
                    textStyle = MaterialTheme.typography.titleMedium,
                    label = {
                        Text("Заголовок заметки", style = MaterialTheme.typography.titleSmall)
                    },
                    onValueChange = {titleText = it})
            }
            detailText?.let {note ->
                TextField(value = note,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp)
                        .height(400.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        focusedIndicatorColor =  Color.Transparent, //hide the indicator
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.secondaryContainer),
                    textStyle = MaterialTheme.typography.bodyMedium,
                    label = {
                        Text("Текст заметки", style = MaterialTheme.typography.titleSmall)
                    },
                    onValueChange = {detailText = it})
            }
            }
        }
}
