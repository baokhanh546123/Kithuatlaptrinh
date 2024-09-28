class dem:
    def __init__(self , size ):
        self.a = []
        self.size = size 
        self.counts = {}
    def push(self,data):
        if  len(self.a) >= self.size : 
            quit()
        else:
            self.a.append(data)

    def count(self,i = 0 , dem = 0 , x = 0  ):
        if (len(self.a) <= 1 or i >= len(self.a) - 1):
            return dem 
        if (self.a[i] == x ):
            dem+=1
        return self.count(i+1,dem,x)

    def __str__(self) -> str:
        return str(self.a)
    
if __name__ == '__main__':
    d = dem(10)
    d.push(4)
    d.push(5)
    d.push(4)
    d.push(4)
    d.push(7)
    d.push(6)
    d.push(4)
    d.push(5)
    print(d)
    result = d.count(x=4)  # Count occurrences of 4
    print(f'Occurrences of 4: {result}')
    result = d.count(x=5)  # Count occurrences of 4
    print(f'Occurrences of 5: {result}')
    


