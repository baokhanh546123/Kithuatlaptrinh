package Vidu;

public class BubbleSort
{   
    int count, size; 
    int[] a;
    
    public BubbleSort(int size){
        this.count = -1;  // Initialize count to -1 to indicate an empty array
        this.size = size;
        this.a = new int[size];  // Initialize the array with the given size
    }
    
    public void push(int i){
        if (count < size - 1){  // Check if there's room to add the element
            count++;
            a[count] = i;
            System.out.println("Added: " + i);
        }
        else{
            System.out.println("FULL");
        }
    }
    
    
    public void sort(){
        for (int i = 0 ; i < a.length;i++){
            boolean swap  = true ; 
            for (int j = 0 ; j < a.length - i - 1 ; j++){
                if (a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swap = false;
                }
                
                if (! swap ){
                    break;
                }
                
            }
        }
    }
    public void displayArray() {
        for (int i = 0; i <= count; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        BubbleSort m = new BubbleSort(3);  // Create an instance with size 3
        m.push(6);  // Add elements
        m.push(3);
        m.push(9);
        m.sort();
        m.displayArray();// This will print "FULL" because the array is full
    }
}
