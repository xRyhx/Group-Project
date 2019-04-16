import java.io.*;
import java.util.ArrayList;



public class Snack {
	public static void main (String args[]) throws IOException {
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		String man=reader.readLine();
		//Sentence Parser
		char[] array=man.toCharArray();
		ArrayList<String> list=new ArrayList<String>();
		int index=0;
		StringBuilder word=new StringBuilder();
		String actualword=null;
		while(array[index]!='.') 
		{
			char letter=array[index];
			if((letter!=' ')&&(letter!=',')&&(array[index+1]!='.')) 
			{
				word.append(letter);
			}
			else 
			{
				if(array[index+1]=='.') {
					word.append(array[index]);
				}	
				
				if(array[index]==',') {
					list.add(word.toString());
				}
				else {
					if(letter==' '||array[index+1]=='.') {
						if(array[index-1]==',') {
							list.add("then");
						}
						else {
						actualword=word.toString();
						list.add(actualword);
						}
					}
				}
				//BufferedWriter writer = new BufferedWriter(new FileWriter("testingfile.txt",true));
/*				writer.flush();
			    writer.newLine();
				writer.write(actualword);
			    writer.flush();
				writer.close();
			   */
			    word=new StringBuilder();
				//Word Evaluation
			}
			
				
			index++;
		}//Endwhile
		int index2=0;
		while(list.size()!=index2) {
			System.out.println(list.get(index2));
			index2++;
		}
		Sentence statement = new Sentence();
		ArrayList<String> List2=statement.determineStatement(list);
		int index1=0;
		while(List2.size()!=index1) {
			System.out.println(List2.get(index1));
			index1++;
		}
	}
}
