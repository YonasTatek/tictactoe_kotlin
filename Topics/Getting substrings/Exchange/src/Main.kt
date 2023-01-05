fun main() {
    // put your code here
    val word = readln()
    println( word.last() + word.substringAfter(word.first()).substringBeforeLast(word.last()) + word.first())
}
