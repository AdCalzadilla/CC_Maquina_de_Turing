package es.ull.cc.mt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Parser {

	private LinkedList<Integer>numFinalLine;
	private LinkedList<String>fileList;
	
	public Parser(String route){
		numFinalLine = new LinkedList<Integer>();
		fileList = new LinkedList<String>();
		
		File document;
		FileReader myFile;
		BufferedReader br;
		
		try {
			document = new File(route);
			myFile = new FileReader(document);
			br = new BufferedReader(myFile);
			readFile(br);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void readFile(BufferedReader br) {
		String line;
		String token_line;
		StringTokenizer st;
		int numElementBefore = 0;
		
		try {
			line = br.readLine();
			while(br != null && line != null){
				st = new StringTokenizer(line);
				while(st.hasMoreTokens()){
					token_line = st.nextToken();
					if(token_line.charAt(0) == '#'){
						break;
					}
					else{
						fileList.add(token_line);
					}
				}
				numFinalLine.add(fileList.size()- numElementBefore);
				numElementBefore = fileList.size();
				line = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LinkedList<Integer> getNumFinalLine() {
		return numFinalLine;
	}

	public void setNumFinalLine(LinkedList<Integer> numFinalLine) {
		this.numFinalLine = numFinalLine;
	}

	public LinkedList<String> getFileList() {
		return fileList;
	}

	public void setFileList(LinkedList<String> fileList) {
		this.fileList = fileList;
	}
	
	public int size(){
		return  fileList.size();
	}
}


