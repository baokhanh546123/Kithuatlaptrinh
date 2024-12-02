package Vidu2;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class Document implements BaoMat,IODatabase {
	String S;
	public Document(String S) {
		this.S = S ;
	}
	public void read(String FileName) {
		S = "";
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(FileName);
			int i = 0 ; 
			while ((i = fin.read()) != -1) {
				S += (char)i;
			}
			fin.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void write(String FileName) {
		FileOutputStream fout = null ; 
		try {
			fout = new FileOutputStream(FileName);
			byte b[] = S.getBytes();
			fout.write(b);
			fout.close();
			System.out.println("Success");
			
		}catch(Exception e ) {
			System.out.println(e);
		}
	}
	
	public void MaHoa() {
		String kq = "";
		byte [] b = S.getBytes();
		for (int i = 0 ; i < S.length();i++) {
			kq +=(char)(b[i]+5);
		}
		S = kq ;
	}
	public void GiaiMa() {
		String kq = "";
		byte [] b = S.getBytes();
		for (int i = 0 ; i < S.length();i++) {
			kq +=(char)(b[i]-5);
		}
		S = kq ;
	}
	public String getData() {
		return S ;
	}
	
}
