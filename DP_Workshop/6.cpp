// Question is similar as 5.cpp but the added part is now we have to find the actual subsets which sums equal to the T.

#include<iostream>
#include<vector>
using namespace std;

void solve(int n, int t, int arr[], int ptr, int currSum, vector<int> currSubset, vector<vector<int>> &allSubsets) {
    if(ptr == n) {
        if(currSum == t) {
            allSubsets.push_back(currSubset);
        }
        return ;
    }



    // take
    currSubset.push_back(arr[ptr]);
    solve(n, t, arr, ptr+1, currSum+arr[ptr], currSubset, allSubsets);

    // notTake
    currSubset.pop_back();  // revert back!
    solve(n, t, arr, ptr+1, currSum, currSubset, allSubsets);
}

int main() {
    int n = 6, t = 8;

    int arr[n] = {1, 2, 5, 9, 2, 1};
    vector<int> currSubset;
    vector<vector<int>> allSubsets;
    
    solve(n, t, arr, 0, 0, currSubset, allSubsets);

    if(allSubsets.size()) {
        for(auto vec: allSubsets) {
            for(int val: vec) {
                cout << val << " ";
            }
            cout << endl;
        }
    }
    else {
        cout << "no subset found with the sum " << t << endl;
    }

    return 0;
}