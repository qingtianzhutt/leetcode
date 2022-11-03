package exercise.git.哈希表;

/**
 * 重点，利用26个字母的特点，利用哈希表
 */
public class 有效的字母异位词242 {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int count: record) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++){
            record[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            record[t.charAt(j) - 'a']--;
        }
        for (int k = 0; k < record.length; k++) {
            if (record[k] != 0) {
                return false;
            }
        }
        return true;
    }


}
