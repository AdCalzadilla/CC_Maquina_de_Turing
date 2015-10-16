package es.ull.cc.mt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Parser {

	private LinkedList<Integer>numRow;
	private LinkedList<String>fileList;
	
	public Parser(String route){
		numRow = new LinkedList<Integer>();
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
		boolean notAdd;
		
		try {
			line = br.readLine();
			while(br != null && line != null){
				notAdd = false;
				st = new StringTokenizer(line);
				while(st.hasMoreTokens()){
					token_line = st.nextToken();
					if(token_line.charAt(0) == '#'){
						notAdd = true;
						break;
					}
					else{
						fileList.add(token_line);
					}
				}
				if(!notAdd){
					numRow.add(fileList.size()- numElementBefore);
					numElementBefore = fileList.size();
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LinkedList<Integer> getNumRow() {
		return numRow;
	}

	public void setNumRow(LinkedList<Integer> numRow) {
		this.numRow = numRow;
	}

	public LinkedList<String> getFileList() {
		return fileList;
	}

	public void setFileList(LinkedList<String> fileList) {
		this.fileList = fileList;
	}
	
	public int fileListSize(){
		return  fileList.size();
	}
	
	public int numRowSize(){
		return numRow.size();
	}
	
	// --- Nuevos métodos
	public LinkedList<String> getFileLine(int line){
		LinkedList<String>temp = new LinkedList<String>();
		int element = 0;
		
		for(int i=0; i < line; i++){
			element = element + numRow.get(i);
		}
		
		for(int i = 0; i < numRow.get(line); i++){
				System.out.print(fileList.get(element)+" ");
				temp.add(fileList.get(element));
				element++;
		}
		return temp;
	}
}


