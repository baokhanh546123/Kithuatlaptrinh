package DSA;

public class HashSet {
	int size;
	String[] bucket;

	public HashSet(int size) {
		this.size = size;
		this.bucket = new String[size];
	}

	public int hashFunction(String value) {
		int sumOfChar = 0;
		for (char c : value.toCharArray()) {
			sumOfChar += (int) c;
		}
		return sumOfChar % size;
	}

	public boolean contains(String value) {
		int index = hashFunction(value);
		if (bucket[index] == null)
			return false;
		if (bucket[index].equals(value))
			return true;
		return false;
	}

	public void add(String value) {
		int index = hashFunction(value);
		while (bucket[index] != null && !bucket[index].equals(value)) {
			index = (index + 1) % size;
		}
		bucket[index] = value;
	}

	public void remove(String value) {
		int index = hashFunction(value);
		if (bucket[index].equals(value))
			bucket[index] = null;
	}

	public void display() {
		for (int i = 0; i < size; i++) {
			System.out
					.println("Index " + i + ": " + (bucket[i] != null ? "\"" + "[" + bucket[i] + "]" + "\"" : "null"));
		}
	}

	public static void main(String[] args) {
		HashSet hs = new HashSet(10);
		System.out.println(" Danh sach ban dau ");
		hs.display();
		String[] myArray = { "Peter", "Messi", "Rose", "Toll", "Huyen" };
		for (String name : myArray) {
			hs.add(name);
		}
		System.out.println(" Danh sach sau khi them ");
		hs.display();
		String ele_remove = "Toll";
		System.out.println(" Danh sach sau khi xoa  " + ele_remove);
		hs.remove(ele_remove);
		hs.display();
		String ele_check = "Rose";
		System.out.print("Kiem tra " + ele_check + " co trong " + hs.contains(ele_check));
	}
}
