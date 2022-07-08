package fr.esgi.aquarium.domain.service;
public class StringSearchMatching {
    // fuzzy matching
    public static boolean isFuzzyMatching(String search, String target, int threshold) {
        if (search == null || target == null) {
            return false;
        }
        if (search.length() > target.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < search.length(); i++) {
            if (search.charAt(i) == target.charAt(i)) {
                count++;
            }
        }
        return count >= search.length() * threshold / 100;
    }

    // leveinstein distance
    public static int levenshteinDistance(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= str2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                int cost = str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
            }
        }
        return dp[str1.length()][str2.length()];
    }
    // Similarity algorithm
    public static double similarity(String str1, String str2) {
        double m = str1.length();
        double n = str2.length();
        double max = Math.max(m, n);
        double min = Math.min(m, n);
        double similarity = 1 - (min / max);
        return similarity;
    }
}
