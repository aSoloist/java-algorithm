package cn.org.soloist.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/11/10 22:29
 * @email ly@soloist.top
 * @description
 */
public class MagicDictionary {

    private Map<String, List<int[]>> map;

    public MagicDictionary() {
    }

    public void buildDict(String[] dict) {
        map = new HashMap<>(); // 初始化
        for (String s : dict) {
            for (int i = 0; i < s.length(); i++) {
                // 分割字符串
                String key = s.substring(0, i) + s.substring(i + 1);
                // 保存位置与字符
                int[] pos = {i, s.charAt(i)};

                List<int[]> orDefault = map.getOrDefault(key, new ArrayList<>());
                orDefault.add(pos);
                map.put(key, orDefault);
            }
        }
    }

    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + word.substring(i + 1);
            // 存在key
            if (map.containsKey(key)) {
                for (int[] pos : map.get(key)) {
                    if (pos[0] == i && pos[1] != word.charAt(i)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
