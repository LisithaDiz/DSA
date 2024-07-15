object RK {
  val d = 256   

  def search(pattern: String, text: String, q: Int): Unit = {
    val m = pattern.length()
    val n = text.length()
    var p = 0    
    var t = 0    
    var h = 1

    // h would be "pow(d, m-1)%q"
    for (i <- 0 until m - 1) {
      h = (h * d) % q
    }

    for (i <- 0 until m) {
      p = (d * p + pattern(i)) % q
      t = (d * t + text(i)) % q
    }

    for (i <- 0 to n - m) {

      if (p == t) {
        var j = 0
        while (j < m && text(i + j) == pattern(j)) {
          j += 1
        }

        if (j == m) {
          println(s"Found at index $i")
        }
      }


      if (i < n - m) {
        t = (d * (t - text(i) * h) + text(i + m)) % q

        if (t < 0) {
          t = (t + q)
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val text = "ababcabcabababd"
    val pattern = "ababd"
    val q = 101 

    search(pattern, text, q)
  }
}
