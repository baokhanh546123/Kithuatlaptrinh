class Hashmap:
    def __init__(self , size = 100):
        self.size = size 
        self.bucket = [[] for _ in range (size)]
    
    def hashFunction(self,key):
        return sum(ord(char) for char in key) % self.size
    def put(self, key , value ):
        index = self.hashFunction(key)
        bucket = self.bucket[index]
        for i , (k,v) in enumerate(bucket):
            if k == key :
                bucket[i] = (key , value)
                return 
        bucket.append((key , value))

    def get(self,key):
        index = self.hashFunction(key)
        bucket = self.bucket[index]
        for k , v in bucket:
            if k == key : 
                return v
        return None 
    
    def remove(self,key):
        index = self.hashFunction(key)
        bucket = self.bucket[index]
        for i , (k , v ) in enumerate(bucket):
            if k == key :
                del bucket[i]
                return 
    
    def display(self):
        print("Hash map")
        for index , bucket in enumerate(self.bucket):
            print(f"Bucket {index} : {bucket}")

if __name__ == "__main__" :
    hm = Hashmap(10)
    hm.display()
    #key is name , value is age 
    hm.put("James", 30)
    hm.put("Messi", 35)
    hm.put("Ronaldo", 38)
    hm.put("Neymar", 32)
    hm.display()

    print("Tuoi vua bong da la bong nhieu " , hm.get("Messi"))

    hm.remove("Ronaldo")
    hm.display()

