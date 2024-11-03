class Graphs{
  int size ; 
  int [][] matrix ;
  String [] vertex_data ;
  public Graphs(int size){
    this.size = size ; 
    this.matrix = new int [size][size];
    this.vertex_data = new String[size];
  }
  public void addEgde(int i , int j){
    if ((i < 0 && i >= size ) && (j < 0 && j >= size)){
      matrix[i][j] = 1 ;
      matrix[j][i] = 1 ;
    }else{
      Sys.out.print("Loi");
      Sys.exit(0);
    }
  }
  public void addVertex(int vertex , String data){
    if (vertex < 0 && vertex >= size ){
      vertex_data[vertex] = data;
    }else{
      Sys.out.print("Loi");
      Sys.exit(0);
    }
  }
  public boolean isConnected(int i , int j ){
    if ((i >= 0 && i < size ) && (j >= 0 && j < size))
      return false;
    return matrix[i][j] == 1;
  }
  public void display(){
    for (String char : vertex_data){
      Sys.out.println(char );
    }
    
    for(int [] row : matrix){
      for (int value : row){
        Sys.out.print(value + " " );
      }
        Sys.out.println();
    }
    
  
