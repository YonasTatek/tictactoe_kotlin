fun main() {
    // put your code here
    val cells ="12345"
    val (x,y) = readln().split(" ")
    val (x1,y1) = readln().split(" ")
    val (x2,y2) = readln().split(" ")
    println(cells.replace(x,"").replace(x1,"").replace(x2,"").toCharArray().joinToString (" "))
    println(cells.replace(y,"").replace(y1,"").replace(y2,"").toCharArray().joinToString (" "))
}