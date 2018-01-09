package question1;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
	double[][] trainingData;
	double[][] testData;
    public final char DEFAULT_SEPARATOR = ',';
    public final char DEFAULT_QUOTE = '"';
	public Data(){
		trainingData=new double[10][3];
		testData=new double[10][3];
	}
	public double[][] readData(int type)throws IOException{
		String csvFile,csv1,csv2;
		int m=0;
		String[][] stringData=new String[10][3];
		double[][] data = new double[10][3];
		String[] temp=null;
		BufferedReader br = null;
		
		csv1="E:/Masters in Computer Science/Artificial Intelligence Programming 1/training.csv";
		csv2="E:/Masters in Computer Science/Artificial Intelligence Programming 1/test.csv";
		
		if(type==1)
			csvFile=csv1;
		else
			csvFile=csv2;
		
		Scanner scanner = new Scanner(new File(csvFile));
		
		while (scanner.hasNext()) {
		    List<String> line = parseLine(scanner.nextLine());
		    for(int k=0;k<3;k++)
		    stringData[m][k]=line.get(k);
		    m++;          
	   }
		
		scanner.close();
	
		for(int i=0;i<10;i++)
			for(int j=0;j<3;j++){
				if(stringData[i][j]==null)
					break;
				data[i][j]=Double.parseDouble(stringData[i][j]);
			}
		
		if(type==1)
			trainingData=data;
		else
			testData=data;
		
		return data;
			
	}	
	
	public void writeData(){
		
	}
	 public List<String> parseLine(String cvsLine) {
	        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
	    }

	    public List<String> parseLine(String cvsLine, char separators) {
	        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
	    }

	    public List<String> parseLine(String cvsLine, char separators, char customQuote) {
          List<String> result = new ArrayList<>();
	        if (cvsLine == null && cvsLine.isEmpty()) {
	            return result;
	        }

	        if (customQuote == ' ') {
	            customQuote = DEFAULT_QUOTE;
	        }

	        if (separators == ' ') {
	            separators = DEFAULT_SEPARATOR;
	        }

	        StringBuffer curVal = new StringBuffer();
	        boolean inQuotes = false;
	        boolean startCollectChar = false;
	        boolean doubleQuotesInColumn = false;

	        char[] chars = cvsLine.toCharArray();

	        for (char ch : chars) {

	            if (inQuotes) {
	                startCollectChar = true;
	                if (ch == customQuote) {
	                    inQuotes = false;
	                    doubleQuotesInColumn = false;
	                } else {

	                    if (ch == '\"') {
	                        if (!doubleQuotesInColumn) {
	                            curVal.append(ch);
	                            doubleQuotesInColumn = true;
	                        }
	                    } else {
	                        curVal.append(ch);
	                    }

	                }
	            } else {
	                if (ch == customQuote) {

	                    inQuotes = true;

	                    if (chars[0] != '"' && customQuote == '\"') {
	                        curVal.append('"');
	                    }

	                    if (startCollectChar) {
	                        curVal.append('"');
	                    }

	                } else if (ch == separators) {

	                    result.add(curVal.toString());

	                    curVal = new StringBuffer();
	                    startCollectChar = false;

	                } else if (ch == '\r') {
	                    continue;
	                } else if (ch == '\n') {
	                    break;
	                } else {
	                    curVal.append(ch);
	                }
	            }

	        }

	        result.add(curVal.toString());

	        return result;
	    }



}
