fun main() {
    // write your code here
    val dna = readln()

    var encoded  = encoding(dna,0)
    var result = encoded[0]
    var start =encoded[1].toString().toInt()
    while(start <= dna.lastIndex){
        encoded=encoding(dna,start)
        result +=encoded[0]
        start = encoded[1].toString().toInt()


    }
    println(result)

}
fun encoding(dna:String,start:Int):MutableList<String>{
    var counter = 1
    for(i in start+1..dna.lastIndex){
 if(dna[start]==dna[i])   counter++
 else break
    }
    return mutableListOf(dna[start]+counter.toString(),(start+counter).toString())
}