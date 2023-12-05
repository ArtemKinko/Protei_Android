package ru.protei.kinkoaa.ui.notes

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ru.protei.kinkoaa.domain.Note

class NotesViewModel : ViewModel(){
    var selected = mutableStateOf<Note?>(null)

    val notes = mutableListOf<Note>(Note("Андроид", "операционная система, которая открыта для всех"),
        Note("Why I Love Kotlin?", "Lambdas and inline functions"),
        Note("I Love Coding", "programming is a hobby"),
        Note("Features of Kotlin", "In this league of best Programming " +
                "languages what sets Kotlin stand class apart is its ability to emphasize " +
                "the architecture and ecosystem. The owning company JetBrains has worked well " +
                "on the productivity that comes from more than just syntax. That's not it, " +
                "Kotlin has numerous beneficial features that make writing code more fun and " +
                "enjoyable"),
        Note("Цитаты Стетхема", "1. Когда кажется, что весь мир настроен против тебя, " +
                "помни, что самолет взлетает против ветра\n2. На сердце боль, в душе тоска, " +
                "второго нет нигде носка\n3. Если где-то тебе не рады в рваных носках, то и " +
                "в целых туда идти не стоит\n4. Кто как обзывается - тот сам так называется"))

    fun onNoteChange(title: String, text: String) {
        if (selected.value?.getTitle() == "")
            notes.add(Note(title, text))
        else
            notes[notes.indexOf(selected.value)] = Note(title, text)
        selected.value = null
    }

    fun onNoteSelected(note: Note) {
        selected.value = note
        // don't forget to change rendering scene to editing note
    }

    fun onAddNoteClicked() {
        // don't forget to change rendering scene to adding note
        selected.value = Note("", "")
    }
}