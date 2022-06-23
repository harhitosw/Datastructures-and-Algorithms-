#include<bits/stdc++.h>
#define ll long long int 
#define minv *min_element
#define maxv *max_element
#define bp __builtin_popcount
#define gcd __gcd
#define pb push_back
#define ins insert
#define sz size
#define p2 log2
#define endl "\n"
using namespace std;
// Kadanes algorithm is used to find the maximum subarray sum in O(n) time complexity it can be done using a Dynamic programming paradigm
int Kadanes(vector<int>&nums){
    //we declare a variable to compare with initially and a variable that holds the maximum sum so far 
    int max_so_far=INT_MIN;
    int max_ending=0;
    for(int i=0;i<nums.sz();++i){
    // while we iterate through the array we keep on updating the value of variable  
        max_ending=max_ending+nums[i];
        if(max_so_far<max_ending){
            max_so_far=max_ending;
        }
    // we handle the case where we get a negative sum , this algorithm requires atleast one positive number 
        if(max_ending<0){
            max_ending=0;
        }
    }
return max_so_far;

}
int main(){
vector<int>nums={-2, -3, 4, -1, -2, 1, 5, -3};
cout<<"The maximum subarray sum that can be obtained is "<<Kadanes(nums);
    return 0;
}