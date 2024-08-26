class ps :
    def __init__(self , a = 0 , b = 1 ):
        self.a = a 
        self.b = b 
    
    def nhap(self):
        self.a = int(input())
        self.b = int(input())

    def xuat(self):
        print(self.a + "/" + self.b)
    
if __name__ == '__main__':
    opp1 = ps()
    opp1.nhap()
    opp1.xuat()
