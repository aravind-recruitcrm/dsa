/*2391. Minimum Amount of Time to Collect Garbage2391. Minimum Amount of Time to Collect Garbage
https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/

/*
->First sum the all lengths of garbage
->Find the last postions of P, G and M
->Make travel arrays as prefix sum array
->Add the last positions of P, G, M from the prefix sum array
*/

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int sum=0;
        int mPos=0,pPos=0,gPos=0;
        
        for(int i=0;i<garbage.length;i++){
            sum+=garbage[i].length();
            
            for(char c:garbage[i].toCharArray()){
                if(c=='M') mPos=i;
                if(c=='P') pPos=i;
                if(c=='G') gPos=i;
            }
        }
        // System.out.println(sum+" "+mPos+"  "+pPos+" "+gPos);
        for(int i=1;i<garbage.length;i++){
            int count=0;
            if(i<=mPos) count++;
            if(i<=pPos) count++;
            if(i<=gPos) count++;
            // System.out.println(count);
            sum+=(count*travel[i-1]);
        }
        return sum;
    }
}
