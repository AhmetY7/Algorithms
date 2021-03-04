/*
The longest common subsequence (LCS) is defined as the longest subsequence that is common to all the given sequences,
provided that the elements of the subsequence are not required to occupy consecutive positions within the original
sequences.

Longest Common Subsequence Applications
-in compressing genome resequencing data
-to authenticate users within their mobile phone through in-air signatures
 */
public class LCS {
    static void lcs(String s1, String s2, int m, int n) {
        int[][] LCSTable = new int[m+1][n+1];

        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                if (i == 0 || j == 0) {
                    LCSTable[i][j] = 0;
                } else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    LCSTable[i][j] = LCSTable[i-1][j-1] + 1;
                } else {
                    LCSTable[i][j] = Math.max(LCSTable[i-1][j], LCSTable[i][j-1]);
                }
            }
        }

        int index = LCSTable[m][n];
        int temp = index;

        char[] lcs = new char[index+1];
        lcs[index] = '\0';

        int i=m, j=n;
        while (i>0 && j>0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                lcs[index-1] = s1.charAt(i-1);
                i--;
                j--;
                index--;
            } else if (LCSTable[i-1][j]>LCSTable[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.print("s1 : " + s1 + "\ns2 : " + s2 + "\nLCS: ");
        for (int k=0; k<=temp; k++) {
            System.out.print(lcs[k]);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        String s1 = "ACADB";
        String s2 = "CBDA";
        int m = s1.length();
        int n = s2.length();
        lcs(s1, s2, m, n);
    }
}
