package DSA;

public class HashMap {
	int size;
	String[] keys;
	String[] values;

	public HashMap(int size) {
		this.size = size;
		this.keys = new String[size];
		this.values = new String[size];
	}

	public int hashFunction(String key) {
		int sumOfChar = 0;
		for (char c : key.toCharArray()) {
			sumOfChar += (int) c;
		}
		return sumOfChar % size;
	}

	public void put(String key, String value) {
		int index = hashFunction(key);
		while (keys[index] != null && !keys[index].equals(key)) {
			index = (index + 1) % size;
		}
		keys[index] = key;
		values[index] = value;
	}

	String get(String key) {
		int index = hashFunction(key);
		while (keys[index] != null) {
			if (keys[index].equals(key))
				return values[index];
			index = (index + 1) & size;
		}

		return null;
	}

	void remove(String key) {
		int index = hashFunction(key);
		while (keys[index] != null) {
			if (keys[index].equals(key)) {
				keys[index] = null;
				values[index] = null;
				return;
			}
			index = (index + 1) % size;
		}
	}

	void display() {
		System.out.println("HashMap");
		for (int i = 0; i < size; i++) {
			if (keys[i] == null)
				System.out.println("Index " + i + ": " + "null");
			else
				System.out.println("Index " + i + ": " + keys[i] + " : " + values[i]);
		}
	}

	public static void main(String[] args) {
		HashMap hm = new HashMap(10);
		hm.put("James", "30");
		hm.put("Messi", "35");
		hm.put("Ronaldo", "38");
		hm.put("Neymar", "32");
		hm.display();
		System.out.print(hm.get("Messi"));
		hm.remove("Ronaldo");
		hm.display();
	}
}
