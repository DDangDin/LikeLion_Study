package com.example.likelion

import java.io.File

// 복습
// 1. 변수 선언 키워드 2개
// 2. 상수 선언 키워드
// 3. 함수 선언 방법
// 4. 조건문, 반복문 등 코틀린에서 대부분 문이 아니라 () 이다.
// 5. 코틀린에서 switch문 대신 있는 것은?
// 6. 예외처리 하는 방법
// 7. 문자열 템플릿
// 8. 범위, 수열 표현 법
// 9. 구조 분해
// 10. 앨비스 연산자

// ----------------------------------------

/** 1. 클래스 **/
class Person(val name: String) // -> 괄호 안에 주 생성자
// -> 접근제한자 키워드: 코틀린은 기본으로 public (생략)
// -> 이런 유형의 클래스(코드가 없이 데이터만 저장하는 클래스)를 값 객체(value object)라 부름

// 클래스의 목적: 데이터를 캡슐화

class Person2(
    val name: String,
    val age: Int
)

// 클래스 초기화 (주 생성자와 초기화 블록)
class Person3 constructor(_name: String) {
    val name: String

    init { // 초기화 블록
        name = _name
    }

//    constructor() {}
}
// constructor 키워드는 주 생성자나 부 생성자 정의를 시작할 때 사용
// 그리고 주 생성자 앞에 별다른 애노테이션이나 가시성 변경자가 없다면 constructor를 생략해도 됨

class Person4(_name: String) {
    val name = _name
}

// 결국 다 생략해서
//class Person(val name: String) -> 처럼 사용 가능

class Person5(val name: String = "kotlin")

// 팁
// 상속할 때
//class ExampleClass: A(), B {
//
//}


/** 2. 커스텀 접근자 **/
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() { // 프로퍼티 게터 선언
            return height == width
        }
}

/** 3. enum class **/
// enum class를 배우기 전에
fun getStateTest(state: String) {
    when(state) {
        "Success" -> "성공"
        "Loading" -> "로딩"
        "Error" -> "에러"
    }
}

//enum class State {
//    Success, Loading, Error;
//
//    fun print() = "$this"
//}
//// 프로퍼티와 메서드가 있는 enum 클래스 선언
//// -> enum class도 일반 class처럼 생성자와 프로퍼티 선언 가능
//
//fun getState(state: State<Any?>) {
//    when(state) {
//        State.Success -> "성공"
//        State.Loading -> "로딩"
//        State.Error -> "오류"
//    }
//}
// 혹시나 분기에서 enum class에 대해서 전부 사용하지 않으면 else 분기 사용해야함

/** 4. sealed class **/
// 여러 자식 Class들이 하나의 부모 Class를 상속 받았다고 했을 때 컴파일러는 부모 Class를 상속 받은 자식 Class들이 있는지 알지 못한다.

// 그런데 enum class는 제한점이 많다.
// 1. enum 클래스의 각 상수들은 싱글톤 디자인 패턴이고 단 하나의 인스턴스만 존재하게 된다.
// enum 각각에 대한 상태를 변경할 수 없다. -> 속성 값을 바꾸지 못함

// 2. 상속 불가능
// enum class에 대한 서브 클래스를 생성할 수 없다

enum class Result {
    Success;
//    Error(val message: String)
}

//class ResultClass: com.example.likelion.Result -> "에러"

// sealed class는
// sealed 클래스는 자기 자신이 추상 클래스이고,
// 자신을 상속받는 여러 서브 클래스들을 가질 수 있다.
// 이를 사용하면 enum 클래스와 달리 상속을 지원하기 때문에,
// 상속을 활용한 다양한 동작을 구현할 수 있다.

sealed class ResultSealed {
    data class Success(val data: File): ResultSealed()
    data class Error(val message: String): ResultSealed()
}

// enum class의 확장 버전, else 분기를 쓰지 않아도 됨

/** 5. 확장 함수 **/
// 확장 함수: 어떤 클래스의 멤버 메서드인 것처럼 호출할 수 있지만 그 클래스의 밖에 선언된 함수
// 쉽게 말해서, 기존에 정의된 클래스에 함수를 추가하는 기능

fun String.lastChar(): Char = this[this.length - 1]
// String(클래스 이름) -> 수신 객체 타입(receiver type)
// this(확장 함수가 호출되는 대상이 되는 값) -> 수신 객체(receiver object)

/** 6. 인터페이스 **/
// - 코틀린 인터페이스 안에는 추상 메서드뿐 아니라 구현이 있는 메서드도 정의 가능
// - 다만 인터페이스에는 아무런 상태(필드)도 들어갈 수 없음
// 자바와 마찬가지로 인터페이스는 여러 개 구현 가능하고,
// 클래스는 오직 하나만 확장 가능

interface Clickable {
    fun click() // 추상 메서드 (일반 메서드 선언)
    fun showOff() = println("I'm clickable!")   // 디폴트 구현이 있는 메서드
}

class Button: Clickable {
    override fun click() = println("I was clicked")
//    override fun showOff() = println("I'm clickable! (Button)")
}

/** 7. 내부 클래스와 중첩된 클래스: 기본적으로 중첩 클래스 **/
// 코틀린도 자바처럼 클래스 안에 다른 클래스 선언 가능
// 클래스 안에 다른 클래스를 선언하면 도우미 클래스를 캡슐화하거나
// 코드 정의를 그 코드를 사용하는 곳 가까이에 두고 싶을 때 유용
// 설명 자세하게 X, 코드를 보다보면 자연스럽게 이해

// 차이점
// !! 자바와 코틀린의 중첩 클래스와 내부 클래스의 관계
// 중첩 클래스(바깥쪽 클래스에 대한 참조를 저장하지 않음)
// 내부 클래스(바깥쪽 클래스에 대한 참조를 저장함)
// 또한, 중첩 클래스는 클래스 계층을 만들되 그 계층에 속한 클래스의 수를 제한하고 싶은 경우 편리

// inner class 예시
class Outer {
    inner class Inner {
        // 내부 클래스(Inner) 안에서 바깥쪽 클래스(Outer)의 참조에 접근하려면 this@Outer 사용
        fun getOuterReference(): Outer = this@Outer
    }
}

//class Outer2 {
//    class Inner {
//        fun getOuter(): Outer2 = this@Outer2
//    }
//}


/** 8. companion object **/
class CompanionClass {
    companion object {
        val code = "10101"
    }

//    companion object Constants{
//        const val CODE = "10101"
//    }
}
// 자바의 static 메서드와 비슷
// 싱글턴 패턴에서 많이 쓰임


fun main() {

    val person = Person("LikeLion")
    val personKotlin = Person("코틀린")
    val personAndroid = Person("안드로이드")
    println(person.name)
    println("${personKotlin.name}, ${personAndroid.name}")
    println()

    val rect = Rectangle(100,200)
    val rect2 = Rectangle(100,100)
    println(rect.isSquare)
    println(rect2.isSquare)
    println()

//    println(State.Success.print())
    println()

    println("가나다".lastChar())
    println()

    val button = Button()
    button.click()
    button.showOff()
    println()

    println(CompanionClass.code)
    println()
}