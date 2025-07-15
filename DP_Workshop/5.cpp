/*
    There are N items
        x1, x2, x3 ... xn
    
        Find if a subset of the items exists that sums up to target -> T

        Point: In array, subsets* and subsequences* word means the same(non-contiguous). For continuous array, we use subarrays* word.

        eg: {1, 2, 5, 9}

            if T=3 -> we have subset -> {1, 2}
            if T=4 -> we have subset -> X(don't have)
            if T=16 -> we have subset -> {2, 5, 9}

*/

#include<iostream>
#include<vector>
using namespace std;

bool solve(int n, int t, int arr[], int ptr, int currSum) {
    if(ptr == n) {
        if(currSum == t) return true;
        return false;
    }

    bool take = false;
    // take
    if(currSum+arr[ptr] <= t) take = solve(n, t, arr, ptr+1, currSum+arr[ptr]);

    // not take
    bool notTake = solve(n, t, arr, ptr+1, currSum);
    return (take || notTake);
}

int main() {
    int n = 4, t = 4;

    int arr[n] = {1, 2, 5, 9};

    cout << "Result: " << solve(n, t, arr, 0, 0);
    

    return 0;
}