package rraysAndSorting;

import java.io.IOException;
import java.io.*;
public class Sorting {
	public static void main(String[] args)
	{
		try
		{  //Reading file containing the dictionary words
			BufferedReader reader=new BufferedReader(new FileReader("F:\\Java Programs\\csx-351-hw2-prk21-master\\HW2-dictionary.txt"));
			FileWriter wr_f=new FileWriter("F:\\Java Programs\\csx-351-hw2-prk21-master\\HW-2output.txt");
			BufferedWriter f_write=new BufferedWriter(wr_f);
			//To read the file line by line
			String line=reader.readLine();
			String dict[]=new String[16000];
			int i=0;
			
			while(line!=null)
			{// To test :System.out.println(line);
			//Storing the words in an array of strings
				dict[i++]=line;
			//Going to the next line
				line=reader.readLine();
			
			}
			// Testing:   for(int j=0;j<16000;j++)
				//          System.out.println(dict[j]);
			//Closing reader
			reader.close();
			
			BufferedReader reader1=new BufferedReader(new FileReader("F:\\Java Programs\\csx-351-hw2-prk21-master\\HW2-keywords.txt"));
			String line1=reader1.readLine();
			String keywords[]=new String[84];
			 i=0;
			
			while(line1!=null)
			{
				// To test :System.out.println(line);
				//Storing the words in an array of strings
				keywords[i++]=line1;
                //Goin to the next line
				line1=reader1.readLine();
			
			}
			
			//Closing reader
			 reader1.close();
			//System.out.println("sorted: ");
			
			 //Applying bubble sort on both the arrays
			bubbleSort(keywords,84);
			
			//Testing:        for(int j=0;j<84;j++)
			//                   System.out.println(keywords[j]);
			bubbleSort(dict,16000);
			int count=0;
			String str="keyword not found: ";
			for(i=0;i<84;i++)
			{		//If the word is not present in dictionary then:	
					if(notpresent(keywords[i],dict,16000)==1)
					{String str1=str+keywords[i];
					
						System.out.println(str1);
						f_write.write(str1);
						f_write.newLine();
						count++;
						
					}
				
			}
			String str1="Number of keyword: "+Integer.toString(count);
			f_write.write(str1);
			//Closing writer
		f_write.close();
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void bubbleSort(String arr[],int n)
	{
		
		String temp;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{   //If the next string is smaller(acc to dictionary) then perform swap operaation
				if(arr[i].compareTo(arr[j])>0)
				{//Swapping
					temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
					
				}
			}
		}
		
	}
 public static int notpresent(String str,String arr[],int n)
 {
	 //method to check whether a word is present in an array or not
	 for(int i=0;i<n;i++)
	 {
		 if(str.compareTo(arr[i])==0)
			 return 0;
	 }
	 return 1;
 }
	
	
}
