import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;
import java.util.TreeMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TreeMap <String, Integer> treeMap = new TreeMap<>();
        String[] words;
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
                    treeMap.put(w,count);
                }
            }
            /*
            for(Map.Entry<String, Integer> entry : treeMap.entrySet()){
                String key = entry.getKey();
                int value = entry.getValue();
                System.out.println(String.format("%s: %d", key, value));
            }
            */

        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        System.out.print("output fileName: ");
        InputStreamReader inputStreamReader2 = new InputStreamReader(System.in);
        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
        try {
            String inputLine2 = bufferedReader2.readLine();
            //System.out.println("you entered: " + inputLine2);
        } catch (IOException e) {
            e.printStackTrace();
        }
         */

    }
}
