//IODatabase.java is interface
package Example3;

import java.util.ArrayList;

public interface IODatabase {
	void read();
	void write(ArrayList<String> content);
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//HS.java
package Example3;

import java.io.*;
import java.util.*;

public class HS implements IODatabase {
    
    String FileName;
    
    // Constructor của lớp HS
    public HS(String FileName) {
        this.FileName = FileName;
    }
    
    
    // Phương thức đọc file và nhận đầu vào từ người dùng
    public void read() {
        try {
            File obj = new File(FileName);
            Scanner inputFile = new Scanner(obj); // Đọc từ file
            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                System.out.println(line);
            }
            inputFile.close(); // Đóng file sau khi đọc
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
    
    // Phương thức ghi vào file
    public void write(ArrayList<String> content) {
        try {
            FileWriter obj = new FileWriter(FileName, true); // Thêm dữ liệu vào file nếu đã tồn tại
            obj.write(content + "\n"); // Ghi nội dung vào file
            obj.close(); // Đóng file sau khi ghi
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred during writing to the file.");
            e.printStackTrace();
        }
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------'
//GV.java
  package Example3;

import java.io.*;
import java.util.*;

public class GV implements IODatabase {
	String FileName ; 
	public GV(String FileName) {
		this.FileName = FileName;
	}
	public void read() {
		try {
            File obj = new File(FileName);
            Scanner inputFile = new Scanner(obj); // Đọc từ file
            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                System.out.println(line);
            }
            inputFile.close(); // Đóng file sau khi đọc
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
	}
	
	public void write(ArrayList<String> content) {
		 try {
	            FileWriter obj = new FileWriter(FileName, true); // Thêm dữ liệu vào file nếu đã tồn tại
	            obj.write(content + "\n"); // Ghi nội dung vào file
	            obj.close(); // Đóng file sau khi ghi
	            System.out.println("Successfully wrote to the file.");
	        } catch (IOException e) {
	            System.out.println("An error occurred during writing to the file.");
	            e.printStackTrace();
	        }
	    }
		
	}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------'
//Main
  package Example3 ;

import java.util.*;

class main{
	public static void main(String [] args) {
		HS sv = new HS("D:\\python\\hocjava\\datauser.txt");
		GV gv = new GV("D:\\python\\hocjava\\datauser.txt");
		
			Scanner scanner = new Scanner(System.in);
	        System.out.print("So luong hoc sinh: ");
	        int n = scanner.nextInt();
	        scanner.nextLine(); // Clear the newline character
	        
	        ArrayList<String> content = new ArrayList<>();
	        
	        for (int i = 0; i < n; i++) {
	            System.out.println("Enter details for student " + (i + 1) + ":");

	            System.out.println("MSSV:");
	            int id = scanner.nextInt();
	          

	            System.out.println("Name:");
	            String name = scanner.nextLine();

	            System.out.println("Class:");
	            String classroom = scanner.nextLine();

	            System.out.println("Address:");
	            String address = scanner.nextLine();

	            System.out.println("Country:");
	            String country = scanner.nextLine();

	            System.out.println("Enter number of subjects:");
	            int numSubjects = scanner.nextInt();
	            scanner.nextLine(); // Clear the newline character

	            Map<String, String> dsdsv = new HashMap<>();
	            for (int j = 0; j < numSubjects; j++) {
	                System.out.println("Subject " + (j + 1) + ":");
	                String subject = scanner.nextLine();

	                System.out.println("Score:");
	                String score = scanner.nextLine();

	                dsdsv.put(subject, score);
	            }
	            
	            String total = String.format(
	                "ID: %d, Name: %s, Class: %s, Address: %s, Country: %s, List of Score Subject: %s",
	                id, name, classroom, address, country, dsdsv
	            );
	            
	            content.add(total);
	        }
	        sv.write(content);
	        for (String entry : content) {
	           
	            sv.read();
	        }
	        Scanner input = new Scanner(System.in);
	        System.out.print("So luong giang vien : ");
	        int m = input.nextInt();
	        input.nextLine(); // Clear the newline character
	        
	        ArrayList<String> content_gv = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            System.out.println("Enter details for student " + (i + 1) + ":");

	            System.out.println("MSSV:");
	            int id = input.nextInt();
	            input.nextLine(); // Clear the newline character

	            System.out.println("Name of teacher :");
	            String name = input.nextLine();

	            System.out.println("Class:");
	            String classroom = input.nextLine();

	            System.out.println("Address:");
	            String address = input.nextLine();

	            System.out.println("Country:");
	            String country = input.nextLine();

	            System.out.println("Enter number of subjects:");
	            int numSubjects = input.nextInt();
	            input.nextLine(); // Clear the newline character

	            Map<String, String> dsdsv = new HashMap<>();
	            for (int j = 0; j < numSubjects; j++) {
	                System.out.println("Subject " + (j + 1) + ":");
	                String subject = input.nextLine();

	                System.out.println("Score:");
	                String score = input.nextLine();

	                dsdsv.put(subject, score);
	            }
	            
	            String total = String.format(
	                "ID: %d, Name: %s, Class: %s, Address: %s, Country: %s, Scores: %s",
	                id, name, classroom, address, country, dsdsv
	            );
	            
	            content_gv.add(total);
	     
	        }
	        gv.write(content_gv);
	        // Output all collected data
	        for (String entry : content) {
	            
	            gv.read();
	        }
	        input.close();
	    }
	
}
