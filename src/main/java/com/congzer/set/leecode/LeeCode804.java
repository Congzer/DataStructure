package com.congzer.set.leecode;

import com.congzer.set.Set;
import com.congzer.set.impl.BSTSet;

/**
 * @Description 唯一的摩尔斯密码词
 * @Author zhangzhucong
 * @Date 2020/6/11
 **/
public class LeeCode804 {

    public static void main(String[] args) {

        String[] words = {"gin", "zen", "gig", "msg"};
        //String[] words = {"a"};
        System.out.println(uniqueMorseRepresentations(words));
    }

    /* 对传入的单词数组，返回不重复摩斯密码的个数*/
    public static int uniqueMorseRepresentations(String[] words) {

        //TreeSet<String> set = new TreeSet<>();
        //java.util.Set<String> set = new HashSet<>();
        Set<String> set = new BSTSet<>();
        for (String word : words) {

            set.add(generateMorseCode(word));
        }
        return set.getSize();
    }

    private static String generateMorseCode(String word) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder builder = new StringBuilder();
        for (int i = 0, len = word.length(); i < len; i++) {

            builder.append(codes[word.charAt(i) - 'a']);
        }
        return builder.toString();
    }
}