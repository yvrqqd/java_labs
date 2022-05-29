package task_1;

import java.io.*;
import java.lang.StringBuilder;
import java.util.*;


public class Main {
    private static final String IN_FILE_NAME = "in.txt";
    private static final String OUT_FILE_NAME = "out.txt";

    private static void compute_freq(String in_file, String out_file) throws IOException {
        Map<String, Integer> map = new HashMap<String, Integer>();

        Reader reader = null;
        reader = new InputStreamReader(new FileInputStream(in_file));

        int letter;
        int total_count = 0;
        StringBuilder tmp_str = new StringBuilder();

        while ((letter = reader.read()) != -1) {
            while (Character.isLetterOrDigit(letter)) {
                tmp_str.append((char) letter);
                letter = reader.read();
            }
            if (tmp_str.length() == 0) {
                continue;
            }
            if (map.containsKey(tmp_str.toString())) {
                map.put(tmp_str.toString(), map.get(tmp_str.toString()) + 1);
            } else {
                map.put(tmp_str.toString(), 1);
            }
            total_count++;
            tmp_str.setLength(0);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            Integer v1 = a.getValue();
            Integer v2 = b.getValue();
            int cmp = v2.compareTo(v1);

            if (cmp == 0) {
                String s1 = a.getKey();
                String s2 = b.getKey();
                cmp = s1.compareTo(s2);
            }
            return cmp;
        });

        BufferedWriter output = new BufferedWriter(new FileWriter(out_file));
        for (Map.Entry<String, Integer> i : list) {
            output.write(i.getKey() + ',' + (float) i.getValue() / (float) total_count * 100 + "%\n");
        }
        output.close();
    }

    public static void main(String[] args) {
        try {
            compute_freq(IN_FILE_NAME, OUT_FILE_NAME);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
