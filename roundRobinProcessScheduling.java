public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        // process arrival time
        int processesArrival[] = { 1, 2, 3};
        int n = processesArrival.length;
      
        // Burst time of all processes
        int burst_time[] = {10, 5, 8};
      
        // Time quantum
        int quantum = 2;
        System.out.println("Average waiting time = " + findavgTime(processesArrival, n, burst_time, quantum));
     }
     
     public static double findavgTime(int [] arrival, int n, int[] bt, int quan){
         int wt[] = new int[n];
         int tat[] = new int[n];
         int total_wt = 0, total_tat = 0;
         
         // Function to find waiting time of all processes
        findWaitingTime(arrival, n, bt, wt, quan);
        // Function to find turn around time for all processes
        findTurnAroundTime(n, bt, wt, tat);
        
        // Calculate total waiting time and total turn
        // around time
        for (int i=0; i<n; i++)
        {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
        }
        
        System.out.println("Average turn around time = " +
                           (float)total_tat / (float)n);
        return (float)total_wt / (float)n;
     }
     
     public static void findWaitingTime(int[] arrival,int n,int[] bt,int []wt,int quan){
         int remBt[] = new int[n];  // remaining burst time
         for(int i =0;i<n;i++)
            remBt[i] = bt[i];
        
        int t = 0; //current time
        
        while(true){
            
            Boolean done = true;
            // Traverse all processes one by one repeatedly
            for (int i = 0 ; i < n; i++)
            {
                if(remBt[i] > 0){
                    done = false;
                    
                    if(remBt[i] > quan){
                        t += quan;
                        
                        remBt[i] -= quan;
                    }
                    
                    else{ //last cycle of the process
                        t += remBt[i];
                        wt[i] = t-bt[i]-arrival[i];
                        remBt[i] = 0;
                    }
                }
            }
            if(done == true)
                break;
        }
     }
     
     // Method to calculate turn around time
    static void findTurnAroundTime(int n,
                            int bt[], int wt[], int tat[])
    {
        // calculating turnaround time by adding
        // bt[i] + wt[i]
        for (int i = 0; i < n ; i++)
            tat[i] = bt[i] + wt[i];
    }
}
