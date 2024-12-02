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
