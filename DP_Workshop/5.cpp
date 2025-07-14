/*
    There are N items
        x1, x2, x3 ... xn
    
        Find if a subset of the items exists that sums up to target -> T

        Point: In array, subsets* and subsequences* word means the same. For continuous array, we use subarrays* word

        eg: {1, 2, 5, 9}

            if T=3 -> we have subset -> {1, 2}
            if T=4 -> we have subset -> X(don't have)
            if T=16 -> we have subset -> {2, 5, 9}

*/

#include<iostream>
#include<vector>
using namespace std;

bool solve(int n, int t, int arr[], int ptr, int currSum, vector<vector<int>> dp) {
    if(currSum == t) return true;

    if(currSum > t) return false;

    if(ptr == n) {
        return false;
    }

    if(dp[ptr][currSum] != -1) return dp[ptr][currSum];     // You might think why the dp on subsets problem of array, draw a tree and know!!. There are (2*(level+1))/2 similar calls on each level. So, this can be reduced using dp which will tell that at this state we have previously got the subsets in future calls.

    // take
    bool take = solve(n, t, arr, ptr+1, currSum+arr[ptr], dp);

    // not take
    currSum = 0;
    bool notTake = solve(n, t, arr, ptr+1, currSum, dp);

    return dp[ptr][currSum] = (take || notTake);
}

int main() {
    int n = 4, t = 3;

    int arr[n] = {1, 2, 5, 9};
    vector<vector<int>> dp(n, vector<int>(n, -1));

    if(solve(n, t, arr, 0, 0, dp)) {
        cout << "yes" << endl;
    }
    else {
        cout << "no" << endl;
    }

    return 0;
}