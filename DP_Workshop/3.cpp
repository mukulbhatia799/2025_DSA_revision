/*
In workshop -> N problems -> {Ti, Si} where T is time and S is skill.
You have x time & k slots.
Find max skill gain you can get.

*/
#include<bits/stdc++.h>
using namespace std;

int findMaxSkillGain(int n, int time[], int skill[], int x, int k, int curr, vector<vector<vector<int>>> dp) {
    // pruning
    if(k == 0) return 0;        // when no slots left return 0.
    
    // base case
    if(curr == n) return 0;

    // cache check
    if(dp[n][x][k] != -1) {
        return dp[n][x][k];
    }

    // compute transition

    int notTake = findMaxSkillGain(n, time, skill, x, k, curr+1, dp);  // not take

    int take = 0;
    if(x-time[curr] >= 0) {
        take = skill[curr] + findMaxSkillGain(n, time, skill, x-time[curr], k-1, curr+1, dp);   // // take
    }


    return dp[n][x][k] = max(take, notTake);
}

int main() {
    int time[] = {3, 5, 4, 2, 1};
    int skill[] = {3, 4, 1, 3, 1};

    
    int size = sizeof(time) / sizeof(time[0]);
    
    int x = 6, k = 2; // x -> max time, k -> max slots.

    vector<vector<vector<int>>> dp(size+1, vector<vector<int>>(x+1, vector<int>(k+1, -1)));  //     int dp[size+1][x+1][k+1];


    cout << "max skill can be gained: " << findMaxSkillGain(size, time, skill, x, k, 0, dp);
    // ans: 6 as (3, 3) and (2, 3) gives the maximum skill gain in k(2) slots and less than or equal to x(6) time.
    return 0;
}