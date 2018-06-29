public class SolveMaze{
    
    final static int n = 4;
     public static void main(String []args){
        
        int maze[][] = {   {1, 1, 0, 0},
                           {0, 1, 1, 0},
                           {1, 1, 0, 0},
                           {0, 1, 1, 1} };
                           
        System.out.println(solveMaze(maze));
     }
     
     public static boolean solveMaze(int[][] maze){
         int sol[][] = {   {0, 0, 0, 0},
                           {0, 0, 0, 0},
                           {0, 0, 0, 0},
                           {0, 0, 0, 0} };
                           
        if(mazeUtil(maze,0,0,sol) == true){
            printSolution(sol);
            return true;
        }
        System.out.println("Solution doesn't exist");
        return false;
     }
     
    static void printSolution(int sol[][])
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
                System.out.print(" " + sol[i][j] +
                                 " ");
            System.out.println();
        }
    }
    
     public static boolean mazeUtil(int[][] maze, int x, int y, int[][] sol){
         if(x == n-1 && y == n-1){
             sol[x][y] = 1;
             return true;
         }
         
         if(isSafeMaze(maze,x,y) == true){
             // mark x,y as part of solution path
            sol[x][y] = 1;
            
             /* Move forward in x direction */
             if(mazeUtil(maze,x+1,y,sol))
                return true;
                
            /* If moving in x direction doesn't give
                   solution then  Move down in y direction */
            if(mazeUtil(maze,x,y+1,sol))
                return true;
            
            /* If none of the above movements works then
                   BACKTRACK: unmark x,y as part of solution
                   path */
            sol[x][y] = 0;
            
            return false;
         }
         return false;
     }
     
     public static boolean isSafeMaze(int[][] maze,int x,int y){
         return(x>=0 && x<n && y >=0 && y<n && maze[x][y] == 1);
     }
}
