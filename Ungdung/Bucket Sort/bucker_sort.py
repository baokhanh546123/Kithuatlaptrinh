class bucket_sort:
    def __init__(self , n):
        self.array = []
        self.size =  n 

    def push(self,data):
        if (len(self.array)) >= self.size :
            print("FULL")
            quit()
        else:
            self.array.append(data)

    def sort(self):
        bucket = []
        for i in range(self.size):
            bucket.append([])

        for j in self.array:
            index = int(self.size * j )
            bucket[index].append(j)


        for i in range(self.size):
            bucket[i] = sorted(bucket[i])

        k = 0 
        for i  in range(self.size):
            for j in range(len(bucket[i])):
                self.array[k] = bucket[i][j]
                k+=1

        return self.array
    
    def __str__(self) -> str:
        return str(self.array)
    
if __name__ == '__main__':
    b = bucket_sort(4)
    b.push(0.31)
    b.push(0.21)
    b.push(.42)
    print(b)
    b.sort()
    print(b)




            
