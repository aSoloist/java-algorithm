package cn.org.soloist.algorithm;

/**
 * 2021/4/14 17:48
 *
 * @author soloist<soloist1511 @ gmail.com>
 * @version 1.0
 */
public class IsPalindrome {

    static class Solution {
        public boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            char[] chars = s.toCharArray();
            while (left < right) {
                while (left < right && !Character.isLetterOrDigit(chars[left])) {
                    left++;
                }
                while (left < right && !Character.isLetterOrDigit(chars[right])) {
                    right--;
                }

                if (Character.toLowerCase(chars[left++]) != Character.toLowerCase(chars[right--])) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(s));
    }

}


