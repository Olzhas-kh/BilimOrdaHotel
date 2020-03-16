package com.example.bilimordahotel

data class Users (
    val name: String,
    val phone: Long,
    val city: String,
    val iin: Long,
    var uuid: String = ""
)