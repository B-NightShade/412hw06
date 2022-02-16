import java.io.*;
import java.util.TreeMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TreeMap <String, Integer> treeMap = new TreeMap<>();
        String[] words;
        int totalWords = 0;
        int highCount = 0;
        String highO = "";
        System.out.print("fileName: ");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            String inputLine = bufferedReader.readLine();
            File file = new File(inputLine);
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file));
            String fline;
            while((fline = bufferedReader1.readLine())!=null){
                words = fline.split(" ");
                for(int i = 0; i<words.length; i++){
                    words[i] = words[i].replaceAll("[^a-zA-Z]", "").toLowerCase();
                }
                for(String w : words){
                    if(!treeMap.containsKey(w)){
                        treeMap.put(w, 0);
                    }
                    int count = treeMap.get(w);
                    count += 1;
                    totalWords += 1;
                    treeMap.put(w,count);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("output fileName: ");
        InputStreamReader inputStreamReader2 = new InputStreamReader(System.in);
        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
        try {
            String inputLine2 = bufferedReader2.readLine();
            File file2 = new File(inputLine2);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
            for(Map.Entry<String, Integer> entry : treeMap.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                bufferedWriter.write(String.format("%s: %d \n", key, value));
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String msg = String.format("read %d words", totalWords);
        System.out.println(msg);
        for(Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            int value = entry.getValue();
            if (value > highCount){
                highCount = value;
                highO = entry.getKey();
            }
        }
        String msg2 = String.format("\"%s\" occurred %d times", highO, highCount);
        System.out.println(msg2);
    }
}
