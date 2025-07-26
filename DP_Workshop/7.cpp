// Question is similar as 5.cpp but the added part is now there will be q Queries. So, the time complexity will become (n*t*q). But can we decrease the t.c somehow. Also, do we need to update the dp array with -1 after each Query? as the t will be different in each query.

/*
    We can reduce the t.c from O(n*t*q) -> O(n*t) and don't need to update the dp array with -1 after each query. How?

    previously we have states in dp array as (ptr, taken). but let's change it to (ptr, sub_left). With (ptr, sub_left) state there will not be requirement of changing the dp array to -1 as the already used dp array can also be used in further queries because now we are storing the sub_left part at each particualar index. So even if the t is changing in each query, still the dp array can be used for other queries.
*/



#include<iostream>
#include<vector>
#include<string.h>
using namespace std;



bool solve(int arr[], int n, int t, int ptr, int currSum) {
    if(currSum == t) return 1;

    if(ptr == n) return 0;

    // not take
    bool notTake = solve(arr, n, t, ptr+1, currSum);

    // take
    bool take = solve(arr, n, t, ptr+1, currSum+arr[ptr]);

    return (take || notTake);
}

int main() {
    cout << "q: "; int q; cin >> q;

    int dp[n];
    memset(dp, -1, sizeof(dp));
    while(q--) {
        cout << "n: "; int n; cin >> n;
        cout << "input arr: ";
        for(int i = 0; i < n; i++) cin >> arr[i];
        cout << "t: "; int t; cin >> t;


        cout << "Result: " << solve(arr, n, t, 0, 0);
    }

    return 0;
}