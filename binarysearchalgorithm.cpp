#include<bits/stdc++.h>
using namespace std;
bool BinarySearch(vector<int>&arr,int to_be_found){
int low=0,high=arr.size()-1,mid;
while(high-low>1){
    mid=(low+high)/2;
    if(arr[mid]<to_be_found){
        low=mid+1;
    }
    else{
        high=mid;
    }
}
    if(arr[low]==to_be_found || arr[high]==to_be_found ){
        return true;
    }
    else{
        return false;
    }

}
int main(){
vector<int>ans={1,5,4,8,3,28,20};
sort(ans.begin(),ans.end());
bool flag=BinarySearch(ans,12);
if(flag) cout<<"Found"<<endl;
else cout<<"Not Found"<<endl;
return 0;
}