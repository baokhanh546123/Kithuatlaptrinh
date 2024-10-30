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
