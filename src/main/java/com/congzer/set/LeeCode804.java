package com.congzer.set;

import com.congzer.set.impl.BSTSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

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