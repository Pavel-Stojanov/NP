package lab5.Anagrams;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Anagrams {

    public static void main(String[] args) {
        findAll(System.in);
    }

    public static void findAll(InputStream inputStream) {
        // Vasiod kod ovde
        Map<String, ArrayList<String>> anagramGrp = new LinkedHashMap<>();

        Scanner sc = new Scanner(inputStream);

        while (sc.hasNext()) {
            String word = sc.next();

            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            anagramGrp.putIfAbsent(key, new ArrayList<>());

            anagramGrp.get(key).add(word);
        }

        for (ArrayList<String> group : anagramGrp.values()) {
            if (group.size()>=5){
                System.out.println(group.stream().sorted().collect(Collectors.joining(" ")));
            }
        }
    }
}
