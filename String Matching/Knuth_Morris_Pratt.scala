// function kmp_search(text, pattern):
//     n = length of text
//     m = length of pattern
//     pi = compute_prefix_function(pattern)
//     q = 0
//     for i = 0 to n - 1:
//         while q > 0 and pattern[q] != text[i]:
//             q = pi[q - 1]
//         if pattern[q] == text[i]:
//             q = q + 1
//         if q == m:
//             print("Pattern found at index", i - m + 1)
//             q = pi[q - 1]

// function compute_prefix_function(pattern):
//     m = length of pattern
//     pi = array of length m
//     k = 0
//     for i = 1 to m - 1:
//         while k > 0 and pattern[k] != pattern[i]:
//             k = pi[k - 1]
//         if pattern[k] == pattern[i]:
//             k = k + 1
//         pi[i] = k
//     return pi


object KMP{
    def(String : text, String: pattern): Unit = {
        var n = text.length()
        var m = pattern.length()



    }

    def compute_prefix_function(String: pattern): Array[Char]{
        var m = pattern.length() // 5
        var pi = new Array[Char](m) // _ _ _ _ _
        var k = 0
        for (i <- 1 to (m-1)){
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

    


}