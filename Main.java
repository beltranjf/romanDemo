import java.util.*;

class Main {
    public static void main(String[] args) {
        String input = "LVI";
        System.out.println(romanToInteger(input));
    }

    private static int romanToInteger(String roman) {
        int value = 0;
        HashMap<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        int value1 = 0;
        int value2 = 0;
        if(roman.length() == 1) {
            return values.get(roman.charAt(0));
        }
        for (int i = 0; i <= roman.length()-2; i++) {
            value1 = values.get(roman.charAt(i));
            value2 = values.get(roman.charAt(i+1));
            if(i == (roman.length()-2)) {
                if(value1 < value2) {
                    value += (value2 - value1); 
                } else {
                    value += value1;
                    value += value2;
                }
            } else {
                if(value1 < value2) {
                    value += (value2 - value1);
                    i++; 
                } else {
                    value += value1;
                }
            }
        }
        return value;
    }
}