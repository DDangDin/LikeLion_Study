package com.example.likelion

import java.io.BufferedReader
import java.io.StringReader

// val/var 변수이름: 타입 = 초기화 값
val a: String = "val"
var b: String = "var"

// 상수 선언
const val c = "Constant"

// 함수 선언 키워드 - fun
fun max(a: Int, b: Int): Int {
//    val a = if (a > b) a else b
//    return a
    return if (a > b) a else b
}

fun max2(a: Int, b: Int): Int = if (a > b) a else b

// 조건문 if는 문이 아닌 식 (값)
// 반복문: for, while, when

fun sample(i: Int) = when {
    i % 2 == 0 -> "2의 배수"
    i % 3 == 0 -> "3의 배수"
    else -> "아무 값도 아니다"
}


fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: java.lang.NumberFormatException) {
        return null
    }
}


fun main() {
    println(max(1, 2))
    println(max2(1, 2))

    // 문자열 템플릿
    val str: String = "kim"
    println("my name is $str")

    println(sample(11))


    // 범위, 수열
    val intRange = 1..10
    val intRange2 = 1 until 10

    // 반복문
    for (i in 10 downTo 1 step 2) {
        println(i)
    }

    for ((index, value) in intRange.withIndex()) {
        println("$index: $value")
    }

    for (i in 'a'..'z') {
        println(i)
    }

    val list = listOf(1,2,3)
    val list2 = arrayListOf(1,2,3)

    val reader = BufferedReader(StringReader("aaa"))
    println(readNumber(reader))

    // 앨비스 연산자 (null 일때 대체 값)
    val tmp : String? = null
    println(tmp ?: "Default")
}