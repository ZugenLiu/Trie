package ug.algo.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import ug.algo.trie.Trie;

public class App {
	public static void main(String[] args) {

		File fileName = new File("Input/testCase2");
		// Calculate Elapsed / Execute Time
		long startTime = System.currentTimeMillis();
		// this is a case sensitive trie
		Trie trie = new Trie(true, StandardCharsets.UTF_8);

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			br.readLine();
			for (String line; (line = br.readLine()) != null;) {
				//System.out.println(line);
				String[] in = line.split(" ");
				String op = in[0];
				String contact = in[1];
				if (op.equals("add")) {
					trie.add(contact);
				} else if (op.equals("find")) {
					//trie.countWordStartsWith(contact);
					//trie.getWordStartsWithJava7(contact);
					//trie.getWordStartsWith(contact).count();					
					System.out.println("Number Of Words Starts with '"+contact+"': "+trie.countWordStartsWith(contact));
				}
			}
			//trie.show();
			System.out.println("Number Of Words: "+trie.getNumberOfWords());
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.println('\n');
			System.out.println("Elapsed / Execute Time");
			System.out.println('\n');
			System.out.println("Elapsed Time in milliseconds: " + elapsedTime);
			System.out.println('\n');
			System.out.println("Elapsed Time in seconds: " + (elapsedTime / 1000) % 60);
			System.out.println('\n');
			System.out.println("Elapsed Time in minutes: " + ((elapsedTime / (1000 * 60)) % 60));
			System.out.println('\n');
			System.out.println("Elapsed Time in hours: " + ((elapsedTime / (1000 * 60 * 60)) % 24));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
