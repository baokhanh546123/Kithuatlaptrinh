class tang:
    def __init__(self , n ):
        self.array = []
        self.size = n 

    def push(self,data):
        if len(self.array) >= self.size :
            print("FULL")
            quit()
        else:
            self.array.append(data)
        return self.array
    
    def check(self, i=0, dstn=0):
        if len(self.array) <= 1 or i >= len(self.array) - 1:
            return dstn
        if self.array[i] < self.array[i + 1]:
            dstn += 1
        return self.check(i + 1, dstn)
    def __str__(self):
        return str(self.array)
    
if __name__ == '__main__':
    T = tang(10)
    T.push(0)
    T.push(1)
    T.push(2)
    T.push(5)
    T.push(4)
    print(T)
    print("Co" , T.check() ,"day so tang dan")
    

    
            

            