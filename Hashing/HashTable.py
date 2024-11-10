class SimpleHashTable:
    def __init__(self, size):
        self.size = size
        self.myhash = [None] * size  
    def hash_function(self, value):
        sum_of_chars = 0
        for char in value:
            sum_of_chars += ord(char)  
        return sum_of_chars % self.size  
    def contains(self, name):
        index = self.hash_function(name) 
        if self.myhash[index] is None:  
            return False
        return name in self.myhash[index]  
    def add(self, value):
        index = self.hash_function(value) 
        if self.myhash[index] is None:
            self.myhash[index] = []  
        if value not in self.myhash[index]:  
            self.myhash[index].append(value)
    def delete(self, value):
        index = self.hash_function(value)
        if self.myhash[index] is None:  
            return False
        if value in self.myhash[index]: 
            self.myhash[index].remove(value)
            return True
        return False 
if __name__ == "__main__":
    hashTable = SimpleHashTable(10)
    myArray = ["Peter" , "Bob" , "Lisa" , "Toll" , "Wick" , "Sanchez" , "Messi" , "Jack97"]
    for name in myArray:
        hashTable.add(name)
    print("Hash Table ban dau" , hashTable.myhash)
    print("Them mot value vao Hash Table")
    hashTable.add("Huyen")
    print("Hash Table xong khi them" , hashTable.myhash)
    print("Peter co trong HashTable khong " , hashTable.contains("Peter"))
    print("Xoa mot value ra Hash Table")
    hashTable.delete("Jack97")
    print("Hash Table xong khi them" , hashTable.myhash)
    print("Jack97 co trong HashTable khong " , hashTable.contains("Jack97"))
