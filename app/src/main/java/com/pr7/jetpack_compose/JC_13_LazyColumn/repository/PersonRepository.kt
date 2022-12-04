package com.pr7.jetpack_compose.JC_13_LazyColumn.repository

import com.pr7.jetpack_compose.JC_13_LazyColumn.model.Person

class PersonRepository {


    fun getAllData():List<Person>{
        val mylist= listOf<Person>(
            Person(id = 0, firstName = "Aminov", lastName = "Fourcade", age = 24),
            Person(id = 1, firstName = "Aminov", lastName = "Mirjalol", age = 20),
            Person(id = 2, firstName = "Yusupov", lastName = "Umar", age = 29),
            Person(id = 3, firstName = "Aminov", lastName = "Islom", age = 28),
            Person(id = 4, firstName = "Aminov", lastName = "Mirsaid", age = 16),
        )
        return mylist
    }

}