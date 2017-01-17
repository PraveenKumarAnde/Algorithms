package com.st.algos;
import java.util.*;

/**
 * Created by Praveen on 12/7/16.
 */
public class Test {

    public static void main(String args[]) {
        String mix = mix("looping is fun but dangerous", "less dangerous than coding");
        System.out.print(mix);
    }

    public static String mix(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            if (ch != ' '){
                Integer count = s1Map.get(ch);
                s1Map.put(ch, count != null ? count + 1 : 1);
            }

        }
        Map<Character, Integer> s2Map = new HashMap<>();
        for (char ch : s2.toCharArray()) {
            if (ch != ' '){
                Integer count = s2Map.get(ch);
                s2Map.put(ch, count != null ? count + 1 : 1);
            }
        }
        Map<Integer, Set<String>> resMap = new TreeMap<>(Collections.reverseOrder());
        Set<Character> characters = new HashSet<>(s2Map.keySet());
        characters.addAll(s1Map.keySet());
        for(char ch : characters) {
            Integer s1Count = s1Map.get(ch);
            s1Count = s1Count == null ? 0 : s1Count;
            Integer s2Count = s2Map.get(ch);
            s2Count = s2Count == null ? 0 : s2Count;
            if( s1Count > 1 || s2Count > 1){
                if (s1Count > s2Count) {
                    addWinner(resMap, s1Count, '1', ch);
                } else if (s1Count < s2Count) {
                    addWinner(resMap, s2Count, '2', ch);
                } else {
                    addWinner(resMap, s2Count, '=', ch);
                }
            }
        }
        return returnResults(resMap);
        // your code
    }

    private static String returnResults(Map<Integer, Set<String>> resMap) {
        StringBuilder sb = new StringBuilder();
        for(Integer max : resMap.keySet()) {
            Set<String> chMap = resMap.get(max);
            for(String string : chMap) {
                sb.append(string);
                sb.append("/");
            }
        }
        return sb.toString().substring(0, sb.length()-1);
    }

    private static void addWinner(Map<Integer, Set<String>> resMap, int count, char winner, char ch) {
        Set<String> results = resMap.get(count);
        if (results == null) {
            results = new TreeSet<>();
        }
        StringBuilder str = new StringBuilder();
        str.append(winner).append(":");
        for (int i =0 ;i < count; i++) {
            str.append(ch);
        }
        results.add(str.toString());
        resMap.put(count, results);
    }

}
