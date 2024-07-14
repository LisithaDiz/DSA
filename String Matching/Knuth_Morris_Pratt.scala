object KMP{

    def kmp_search(text: String, pattern: String): Unit = {
        var m = pattern.length() 
        var n = text.length()
        var pi = create_pi(pattern)
        var q = 0

        for (i <- 0 to n - 1){
            while((q>0) && pattern(q) != text(i)){
                printf(s" Compare ${pattern (q)} != ${text(i)} (${i}) ")
                q = pi(q-1)
            }

            if(pattern (q) == text(i)){
                printf(s" Compare ${pattern (q)} == ${text(i)} (${i}) \n")
                q = q + 1
            }

            if(q == m){
                println(s"Pattern found at index - ${i - m + 1}")
                q = pi(q-1)
            }
        }
    }

    def create_pi(pattern: String): Array[Int] = { // ababd
        var m = pattern.length() // 5
        var pi = new Array[Int](m) // 0, 0, 0, 0, 0
        var k = 0
        for (i <- 1 to m-1){

            while((k > 0) && (pattern(k) != pattern(i))){
                k = pi(k - 1)
            }

            if(pattern(k) == pattern(i)){
                k = k + 1
            }

            pi(i) = k
        }
        pi
    }

    def main(args: Array[String]): Unit = {
        val pi = create_pi("ababd")
        println(pi.mkString(", "))

        kmp_search("ababcabcabababd", "ababd")
        
    }
}