/*Write a program to accept a string as a command line argument and check whether it is a file or directory.
 *If it is a directory,count how many files the directory has and delete all files with extension .txt .
 *If it is a file display all its information(path,size,attributes etc.*/
 import java.io.*;
 class Slip13_1
{
	public static void main(String args[])throws IOException
 	{
 		int cnt=0 ;
 		BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
 		File f1=new File(args[0]);
 		if(f1.isDirectory())
 		{
 			String filelist[]=f1.list();
 			for(String temp:filelist)
 			{
 				File ftemp=new File(args[0]+"/"+temp);
 				if(ftemp.isFile())
 				{
 					System.out.println(temp);
 				}
 				if(temp.endsWith(".txt"))
 				{
 					System.out.println("Delete "+temp+" ? (yes/no) :");
 					String c;
 					c=b.readLine();
 					if(c.equals("yes"))
 					{
 						cnt ++;
 						System.out.println("Deleted :"+ftemp.delete());
 					}
 				}
 			}
 			System.out.println("No of files deleted : "+cnt);
 		}
 		if(f1.isFile())
 		{
 			System.out.println("File Information:\nPath :"+f1.getAbsolutePath());
 			System.out.println("Size"+f1.length()+"Bytes\nAttributes :\n"+"Read: "+f1.canRead()+"\nWrite :"+f1.canWrite());
 		}
 	}
}