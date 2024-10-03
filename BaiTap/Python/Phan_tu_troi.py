class Troi:
    def __init__(self, size) -> None:
        self.a = []
        self.size = size 

    def push(self, data):
        if len(self.a) < self.size:
            self.a.append(data)
        else:
            return self.a

    def partition(self , x , i = 0 , j = 0 ):
        mid = int(len(self.a) / 2)

        ptt1 = self.dem(self.a[:mid] , x , i )
        ptt2 = self.dem(self.a[mid:],x,j)

        ptt = ptt1+ptt2
        return ptt
    def dem(self,b,x,index):
        if index >= len(b) :
            return 0
        if b[index] == x :
            count = 1 
        else:
            count =  0
        
        return count + self.dem(b,x,index+1)
    
    def check(self, x):
        total_ptt = self.partition(x)
        if total_ptt > (len(self.a) / 2):
            return f"Phan tu troi: {x} xuat hien {total_ptt} lan."
        else:
            return f"Khong co phan tu troi. vi {x} xuat hien {total_ptt} trong khi n/2 {int((len(self.a) / 2))} lan"
    
    def __str__(self) -> str:
        return str(self.a)

if __name__ == '__main__':
    t = Troi(10)
    t.push(3)
    t.push(3)
    t.push(3)
    t.push(2)
    t.push(1)
    t.push(2)
    t.push(2)
    t.push(3)
    
    print(t)
    result = t.check(2)
    print(result)
