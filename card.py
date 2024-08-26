class card : 
    def __init__(self):
        self.stores = []

    def store(self):
        self.stores.append(("Harry Potter","JK Rowling",5))
        self.stores.append(("Conan","Aoyama Gosho",3))

    def show(self):
        for book in self.stores:
             print(f"Title: {book[0]}, Author: {book[1]}, Amount: {book[2]}")

if __name__ == '__main__':
    cards = card()
    cards.store()
    cards.show()
