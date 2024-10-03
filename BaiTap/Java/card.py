class Quanli:
    def __init__(self):
        self.size = int(input("Nhap so lan: "))
        self.index = 0 ; 
        self.ID = 1 ; 
        self.Q = [None] * self.size

    def input(self):
        for _ in range(self.size):
            title = str(input("Nhap tua de : "))
            author = str(input("Nhap tua de : "))
            amount = int(input("Nhap so luong sach "))
            if amount > 0 : 
                self.store(title,author,amount)  
            else:
                print("Failed")         
    def store(self,title,author,amount):
        if self.index < self.size : 
            book_info = f" ID : {self.ID} , Title : {title} , Author : {author} , Amount : {amount}"
            self.Q[self.index] = book_info
            print("Succes", book_info)
            self.index +=1
            self.ID += 1
        else:
            print("Not add")

    def searching(self):
        searchingID = int(input("Nhap ID : "))
        found = False
        for i  in range (self.index):
            if f"ID : {searchingID}" in self.Q[i]:
                print("Found :" , self.Q[i])
                found = True
                break
        if (not found ):
            print("Not found " , searchingID)
                
    def display(self):
        print("List of books")
        for book in self.Q:
            print(book)
if __name__ == '__main__':
    q = Quanli()
    q.input()
    q.display()
    q.searching()
