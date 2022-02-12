package task_0;

import java.io.*;
import java.lang.StringBuilder;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String IN_FILE_NAME = "/home/qqd/IdeaProjects/task1/out/production/task1/task1/in.txt";
    private static final String OUT_FILE_NAME = "out.txt";

    private static void compute_freq(String in_file, String out_file) throws IOException {
        Map<String, Integer> map = new HashMap<>();

        Reader reader = null;
        reader = new InputStreamReader(new FileInputStream(in_file));

        int total_count = 0;
        StringBuilder tmp_str = new StringBuilder();

        while (true) {
            int letter = reader.read();
            if (letter == -1) {
                break;
            }
            while (Character.isLetterOrDigit(letter)) {
                tmp_str.append((char) letter);
                letter = reader.read();
            }
            if (tmp_str.length() == 0) {
                break;
            }
            if (map.containsKey(tmp_str.toString())) {
                map.put(tmp_str.toString(), map.get(tmp_str.toString()) + 1);
            } else {
                map.put(tmp_str.toString(), 1);
            }
            total_count++;
            tmp_str.setLength(0);
        }

        BufferedWriter output = new BufferedWriter(new FileWriter(out_file));
        for (var i : map.keySet()) {
            output.write(i + ',' + map.get(i) + ',' + (float) map.get(i) / (float) total_count * 100 + "%\n");
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
