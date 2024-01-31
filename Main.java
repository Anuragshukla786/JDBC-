import java.sql.*;
import java.util.*;

//its all are boilerplate of jdbc
public class Main {
    //Create Connection
    //We are declare private because our data is not access aother user
    //We are declare Static because We are note a crete a object of variables
    //we are declare final never change the value again

   private static final String url="jdbc:mysql://127.0.0.1:3306/mydb";
    private static final  String username="root";
    private static final String password="root";

    public static void main(String[] args) {
        //We are Load  necessary Drivers In java
       try{
           //is case me ClassNotFoundException ata hai
        Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
       //create Connection with database
        try
        {
            //ek ata hai sql Exception iske neehe jitna code
            //likhenge sab me sql Exception ayega chae wo statement ho ya resultset ho ye
            // //interfaces hai jdbc components ke
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();//sql queris ko run kre ke liye hum
            //use krte hai sql interface ka statement interface  sql quieris ko run krta hai creatStatement ki help se
            //createStatement ke method ka instance hota hi connection Interface ki refrence variable ke pass

//            String query="select * from students";
            //We are using this Query to insert data

           // statement.executeQuery(query);//yha table aa jayegi
            //lekin ise hold krega resultset Interface
           // ResultSet resultSet=statement.executeQuery(query);
            //abe hme data mil hi nhi rgha to usle loop chlane ko koi benefit nahi

//                while(resultSet.next())
//            {
                //hme  jo feilds database me hai wo chye to hum ek
                //java ke local variable bna lenge

                //ye hmne data ko retrive kia
//                int id=resultSet.getInt("id");
//                String name=resultSet.getString("name");
//                int age=resultSet.getInt("age");
//                double marks=resultSet.getDouble("marks");
//                System.out.println("ID"+id);
//                System.out.println("NAME"+name);
//                System.out.println("AGE"+age);
//                System.out.println("MARKS"+marks);
//            }
            //update data
            String query=String.format("UPDATE  students SET marks=%f WHERE id =%d",89.5,2);
          //  String query=String.format("INSERT INTO students(name, age, marks) VALUES('%s',%o,%f)","Rahul",23,74.5);
            //update  data  query
            int rowsAffected=statement.executeUpdate(query);
            if(rowsAffected>0)
            {
                System.out.println("Data Updated Successfully");
            }
            else
            {
                System.out.println("Data not Updated");
            }

        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
