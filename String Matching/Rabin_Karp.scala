import scala.collection.mutable.ListBuffer

object RK {

  def rabinKarp(text: String, pattern: String): List[Int] = {
    val base = 4  // Since we have 4 characters: 'a', 'b', 'c', 'r'
    val modulus = 101  // A prime number to minimize hash collisions

    def computeHash(s: String): Int = {
      var hash = 0
      for (char <- s) {
        hash = (hash * base + (char - 'a')) % modulus
      }
      hash
    }

    val m = pattern.length
    val n = text.length
    val results = ListBuffer[Int]()

    val patternHash = computeHash(pattern)
    var windowHash = computeHash(text.substring(0, m))

    val highestBase = math.pow(base, m - 1).toInt % modulus

    if (windowHash == patternHash && text.substring(0, m) == pattern) {
      results += 0
    }

    for (i <- 1 to n - m) {
      windowHash = (windowHash * base - (text(i - 1) - 'a') * highestBase + (text(i + m - 1) - 'a')) % modulus
      if (windowHash < 0) {
        windowHash += modulus
      }
      // Check if hashes match before comparing substrings
      if (windowHash == patternHash) {
        // Check substring only if hashes match
        if (text.substring(i, i + m) == pattern) {
          results += i
        }
      }
    }

    results.toList
  }

  def main(args: Array[String]): Unit = {
    val text = "abracadabra"
    val pattern = "abra"
    val matches = rabinKarp(text, pattern)
    println(s"Pattern found at positions: ${matches.mkString(", ")}")
  }
}
