class Account:
    def __init__(self):
        self.tk = int(input("Nhap so tai khoan: "))
        self.ten = input("Nhap ten tai khoan: ")
        self.tien = int(input("Nhap so tien co trong tai khoan: "))
        self.data = {self.tk: {'ten': self.ten, 'tien': self.tien}}  # Initialize account data

    def check(self):
        tk_input = int(input("Nhap so tai khoan de dang nhap: "))
        ten_input = input("Nhap ten tai khoan de dang nhap: ")
        if tk_input in self.data:
            if self.data[tk_input]['ten'] == ten_input:
                print("Tai khoan hop le")
                return True
            else:
                print("Ten tai khoan khong khop")
        else:
            for i in range (5):
                print("So tai khoan khong hop le")
            quit()
        return False

    def nap(self):
        nap_tien = int(input("So tien can nap: "))
        if nap_tien >= 0:
            self.tien += nap_tien
            print(f"So tien ban vua nap {nap_tien} da vao ngan hang cua ban")
        else:
            print("Khong thanh cong")
        return self.tien

    def rut(self):
        phi = 5
        rut_tien = int(input("So tien ban muon rut: "))
        if rut_tien <= (self.tien - phi):
            self.tien -= (rut_tien + phi)
            print(f"So tien ban vua rut la {rut_tien}")
        else:
            print("Khong hop le")
        return self.tien

    def daohao(self):
        laisuat = 0.5
        self.tien += self.tien * laisuat
        print(f"Ban vua dao han thanh cong, so tien moi la {self.tien}")
        return self.tien

    def __str__(self):
        return f"So tai khoan: {self.tk}, Ten tai khoan: {self.ten}, So tien hien tai: {self.tien}"


if __name__ == '__main__':
    a = None  # Initialize account variable
    while True:
        print("\n------Menu-------")
        print("1. Tao tai khoan / Dang nhap")
        print("2. Nap tien")
        print("3. Rut tien")
        print("4. Dao han")
        print("5. Thoat")
        print("-------------------")
        n = input("Chon lua chon cua ban: ")

        if n == '1':
            print("\n1. Dang ky")
            print("2. Dang nhap")
            choice = input("Chon lua chon cua ban: ")
            if choice == '1':
                a = Account()
                print(a)
            elif choice == '2':
                if a:
                    if a.check():
                        print("Dang nhap thanh cong.")
                    else:
                        print("Dang nhap that bai.")
                else:
                    print("Ban chua tao tai khoan. Vui long dang ky truoc.")
            else:
                print("Lua chon khong hop le.")
        elif n == '2':
            if a:
                a.nap()
                print(a)
            else:
                print("Ban can tao tai khoan truoc khi thuc hien giao dich.")
        elif n == '3':
            if a:
                a.rut()
                print(a)
            else:
                print("Ban can tao tai khoan truoc khi thuc hien giao dich.")
        elif n == '4':
            if a:
                a.daohao()
                print(a)
            else:
                print("Ban can tao tai khoan truoc khi thuc hien giao dich.")
        elif n == '5' and str(n).isdigit():
            print("Da thoat")
            break
        else:
            print("Lua chon khong hop le. Vui long chon lai.")
