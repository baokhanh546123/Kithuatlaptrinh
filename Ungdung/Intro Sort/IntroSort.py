import math
from heapq import heappush, heappop

class IntroSort:
    def __init__(self):
        self.a = []
    def heapsort(self):
        h = []
        for value in self.a:
            heappush(h, value)
        self.a = [heappop(h) for _ in range(len(h))]
    def insertion_sort(self, low, high):
        for i in range(low + 1, high + 1):
            key = self.a[i]
            j = i - 1
            while j >= low and self.a[j] > key:
                self.a[j + 1] = self.a[j]
                j -= 1
            self.a[j + 1] = key
    def partition(self, low, high):
        pivot = self.a[high]
        i = low - 1
        for j in range(low, high):
            if self.a[j] <= pivot:
                i += 1
                self.a[i], self.a[j] = self.a[j], self.a[i]
        self.a[i + 1], self.a[high] = self.a[high], self.a[i + 1]  
        return i + 1
    def median_of_three(self, a, b, c):
        A = self.a[a]
        B = self.a[b]
        C = self.a[c]
        if A <= B <= C or C <= B <= A:
            return b 
        if B <= A <= C or C <= A <= B:
            return a 
        return c
    def introsort(self, low, high, depth_limit):
        size = high - low 
        if size < 16:
            self.insertion_sort(low, high)
        elif depth_limit == 0:
            self.heapsort()
        else:
            pivot = self.median_of_three(low, low + size // 2, high)
            self.a[pivot], self.a[high] = self.a[high], self.a[pivot]
            partition_point = self.partition(low, high)
            self.introsort(low, partition_point - 1, depth_limit - 1)
            self.introsort(partition_point + 1, high, depth_limit - 1)
    def introsorts(self, low, high):
        depth_limit = 2 * math.floor(math.log2(high - low))
        self.introsort(low, high, depth_limit)

    def __str__(self):
        return str(self.a)
if __name__ == '__main__':
    sorter = IntroSort()
    sorter.a = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]  # Dữ liệu mẫu
    print("Before sorting:", sorter)
    sorter.introsorts(0, len(sorter.a) - 1)
    print("After sorting:", sorter)
