import java.sql.*;
import java.io.*;
class slip28
{
	public static void main(String args[]) throws Exception
	{
		Statement st;ResultSet rs;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=root&amp;password=");		
		
			st=con.createStatement();
		
			int tot=0,per=0,ans=1;
			do
			{
				System.out.print("Enter rollno :");
				int r=Integer.parseInt(br.readLine());
				System.out.print("Enter name :");
				String name=br.readLine();
				System.out.print("Enter marks1 :");
				int m1=Integer.parseInt(br.readLine());
				System.out.print("Enter marks2 :");
				int m2=Integer.parseInt(br.readLine());
				System.out.print("Enter marks3 :");
				int m3=Integer.parseInt(br.readLine());
				String str="insert into student values ("+r+",'"+name+"',"+m1+","+m2+","+m3+")";
				System.out.println(str);
				st.executeUpdate(str);
		
				System.out.println("Row inserted");
		
				System.out.print("Add More (Yes 1/No 0) :");
				ans=Integer.parseInt(br.readLine());
	
			}while(ans!=0);
		
		
			rs=st.executeQuery("Select * from student");
			while(rs.next()) //moves to next rows
			{
				tot=tot+rs.getInt(3)+rs.getInt(4)+rs.getInt(5);
				per=tot/3;
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+tot+" "+per);  //access each column
				tot=0;per=0;
			}
		}
		catch(Exception e)
		{
			System.out.println("error"+e);
		}

	}
}