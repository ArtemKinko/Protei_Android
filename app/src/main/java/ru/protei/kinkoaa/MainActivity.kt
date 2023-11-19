package ru.protei.kinkoaa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.protei.kinkoaa.domain.Note
import ru.protei.kinkoaa.ui.theme.KinkoaaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // crating list of notes
        var noteList = listOf<Note>(
            Note("Андроид", "операционная система, которая открыта для всех"),
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
                    "в целых туда идти не стоит\n4. Кто как обзывается - тот сам так называется")
        )
        setContent {
            KinkoaaTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .absolutePadding(left = 20.dp, right = 20.dp)
                        .verticalScroll(rememberScrollState())) {
                    for (note in noteList)
                        ShowNote(note)
                }
            }
        }
    }
}

@Composable
fun ShowNote(note: Note) {
    Column(modifier = Modifier.absolutePadding(top = 20.dp, bottom = 20.dp)) {
        Text(
            text = note.getTitle(),
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Justify
            )
        )

        Text(
            text = note.getText(),
            style = TextStyle(
                color = Color.Gray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Justify
            )
        )
    }
}