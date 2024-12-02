class SimpleHashset:
    def __init__(self , size ):
        self.size = size 
        self.buckets = [[] for _ in range (size)]
    def hash_function(self , value):
        return sum(ord(char) for char in value ) % self.size
    def add(self,value):
        index = self.hash_function(value);
        bucket = self.buckets[index]
        if value not in bucket:
            bucket.append(value)
    def contains(self,value):
        index = self.hash_function(value)
        bucket = self.buckets[index]
        return value in bucket

    def remove(self,value):
        index = self.hash_function(value)
        bucket = self.buckets[index]
        if value in bucket:
            bucket.remove(value)
    def display(self):
        print("Hash Set")
        for index , bucket in enumerate(self.buckets):
            print(f"Bucket {index} : {bucket}")
if __name__ == '__main__':
    hash_set = SimpleHashset(10)
    names = ["Messi","Toll","Huyen","Drake"]
    for name in names :
        hash_set.add(name)
    hash_set.display()
    print("Toll co trong hashset khong " , hash_set.contains("Toll")) 
    print("Xoa mot value trong hashset")
    hash_set.remove("Drake")
    hash_set.display()
    print("Drake co trong hashset khong " , hash_set.contains("Drake"))
