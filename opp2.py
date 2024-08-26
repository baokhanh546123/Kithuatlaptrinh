class Phanso:
    def __init__(self, t=0, m=1):
        self.t = t
        self.m = m

    def show(self):
        print(f"{self.t}/{self.m}")

if __name__ == '__main__':
    A = Phanso()
    B = Phanso(2)
    C = Phanso(3, 4)
    
    A.show()
    B.show()
    C.show()
