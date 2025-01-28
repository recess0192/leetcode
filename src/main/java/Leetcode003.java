import java.awt.peer.SystemTrayPeer;

public class Leetcode003 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int innerLeft = left; innerLeft < i; innerLeft++) {
                if (s.charAt(innerLeft) == s.charAt(i)) {
                    maxLength = Math.max(maxLength, i - innerLeft);
                    left = innerLeft + 1;
                    break;
                }
            }
        }

        return Math.max(maxLength, s.length() - left);
    }
}
