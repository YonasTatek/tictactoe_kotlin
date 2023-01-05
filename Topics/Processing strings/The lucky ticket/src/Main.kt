fun main() {
    // write your code here    4
    val ticketNumber = readln().map { it->it.toString().toInt() }
    val status = if(ticketNumber[0]+ticketNumber[1]+ticketNumber[2] ===
        ticketNumber[3]+ticketNumber[4]+ticketNumber[5])  "Lucky" else "Regular"
    println(status)
}