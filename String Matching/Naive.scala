import scala.util.control._
import scala.io.StdIn._

object Naive {
    def naiveAlgo(A: String, B: String): Unit = {
        var n1 = A.length
        var n2 = B.length

        val (mainStr, subStr) = if (n1 > n2) (A, B) else (B, A)
        n1 = mainStr.length
        n2 = subStr.length

        val outloop = new Breaks
        val inLoop = new Breaks

        var found = 0
        var total = 0

        outloop.breakable {
            for (i <- 0 to (n1 - n2)) {
                found = 0 
                inLoop.breakable {
                    for (j <- 0 until n2) {
                        if (mainStr(i + j) == subStr(j)) {
                            printf(s"Same ${mainStr(i + j)} == ${subStr(j)}\n")
                            found += 1
                        } else {
                            printf(s"Different ${mainStr(i + j)} != ${subStr(j)}\n")
                            // inLoop.break() 
                        }
                    }
                }
                if (found == n2) {
                    total += 1
                    printf("Found \n\n")
                } else {
                    printf("Not found \n\n")
                }
            }
        }

        println(s"Total number of matches = $total")
    }

    def main(args: Array[String]): Unit = {
        println("Enter first word")
        var A = readLine()
        println("Enter sec word")
        var B = readLine()
        naiveAlgo(A, B)
    }
}
