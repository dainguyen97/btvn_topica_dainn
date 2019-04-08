package demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		String fileName = "D:/TOPICA/b4_raw.txt";
		String context = "";
		FileReader reader = null;
		BufferedReader bufferedReader = null;
		
		try {
			reader = new FileReader(fileName);
			bufferedReader = new BufferedReader(reader);
			String i;
			while((i = bufferedReader.readLine()) != null) {
				context += i;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			bufferedReader.close();
			reader.close();
		}
		
		//System.out.println(context);
		
		String lowerContext = context.toLowerCase();
		
		String context1 = lowerContext.replaceAll("\\s*[\" '.,*]+", " ");
		//System.out.println(context1);
		
		Map<String, Integer> wordMap = countWords(context1);
		Map<String, Integer> sortMap = sortByCount(wordMap);
		
		String show2 = "";
		for(String key:sortMap.keySet()) {
			show2 += key +": " +sortMap.get(key) +" ";
		}
		//System.out.println(show2);
		
		String fileResult = "D:/TOPICA/bai4output.txt";
		FileWriter writer = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			writer = new FileWriter(fileResult);
			bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(show2);
			System.out.println("Success!");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//Cái nào mở trước thì phải đóng sau
			bufferedWriter.close();
			writer.close();
		}
		
	}
	
	public static Map<String, Integer> sortByCount(Map<String, Integer> unsortMap){
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
	
	public static Map<String, Integer> countWords(String str){
		Map<String, Integer> wordMap = new TreeMap<>();
		if(str == null) {
			return wordMap;
		}
		
		int size = str.length();
		StringBuilder stringBuilder = new StringBuilder();
		for(int x = 0; x < size; x++) {
			if(str.charAt(x) != ' ') {
				stringBuilder.append(str.charAt(x));
			}else {
				addWord(wordMap, stringBuilder);
				stringBuilder = new StringBuilder();
			}
		}
		return wordMap;
	}
	
	public static void addWord(Map<String, Integer> wordMap, StringBuilder stringBuilder) {
		String word = stringBuilder.toString(); 
		if(word.length() == 0) { 
			return;
		}
		if(wordMap.containsKey(word)) { 
			int count = wordMap.get(word) + 1;
			wordMap.put(word, count); 
		}else {
			wordMap.put(word, 1);
		}
	}
}
