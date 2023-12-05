package ru.protei.kinkoaa.domain

class Note (
    private var title: String,
    private var text: String
) {

    fun getTitle(): String {
        return title
    }

    fun getText(): String {
        return text
    }

}