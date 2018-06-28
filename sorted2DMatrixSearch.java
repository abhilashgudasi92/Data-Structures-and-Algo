public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        int mat[][] = { {10, 20, 30, 40},
                           {15, 25, 35, 45},
                           {27, 29, 37, 48},
                           {32, 33, 39, 50} };
            
        Search(mat, 4, 29);
     }
     
     public static void Search(int[][] mat, int n,int x){
         int i=0,j = n-1;
         
         while(i<n && j >=0){
             if ( mat[i][j] == x )
              {
                 System.out.print("n Found at "+ i + " " + j);
                 return;
              }
              if ( mat[i][j] > x )
                j--;
              else //  if mat[i][j] < x
                i++;
         }
         System.out.print("n Element not found");
         return;  // if ( i==n || j== -1 )
     }
}
