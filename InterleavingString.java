class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(),
            len2 = s2.length(),
            len3 = s3.length();
        if (len1 + len2 != len3) return false;
        // cache[i][j] == true means first i + j chars are matched by
        // first j chars from s1 and first i chars from s2
        boolean[][] cache = new boolean[len2 + 1][len1 + 1];
        cache[0][0] = true; // empty and empty matches empty
        int m3 = 1; // matched length, m1 and m2 are similar
        while (m3 <= len3) {
            // this loop fill in cache matrix from left-top to right-bottom, diagonally.
            // note that loop conditions are pretty tricky here.
            for (int m1 = Math.max(m3 - len2, 0); m1 <= len1 && m1 <= m3; m1++) {
                int m2 = m3 - m1;
                cache[m2][m1] =
                    m1 > 0 && cache[m2][m1 - 1] && s3.charAt(m3 - 1) == s1.charAt(m1 - 1) ||
                    m2 > 0 && cache[m2 - 1][m1] && s3.charAt(m3 - 1) == s2.charAt(m2 - 1);
            }
            m3++;
        }
        return cache[len2][len1];
    }
}
