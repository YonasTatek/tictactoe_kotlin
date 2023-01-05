fun main() {
    // put your code here
    var alphabet = "abcdefghijklmnopqrstuvwxyz"

    readln().map {
        alphabet=alphabet.replace(it.toString(),"")

    }
    println(alphabet)
}