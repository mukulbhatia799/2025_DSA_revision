/*
In workshop -> N problems -> {Ti, Si} where T is time and S is skill.
You have x time & k slots.
Find max skill gain you can get.

*/
#include<bits/stdc++.h>
using namespace std;

int findMaxSkillGain(int n, int time[], int skill[], int x, int k, int curr) {
    if(curr == n) return 0;

    if(k == 0) return 0;        // when no slots left return 0.

    // take
    int take = 0;
    if(x-time[curr] >= 0) {
        take = skill[curr] + findMaxSkillGain(n, time, skill, x-time[curr], k-1, curr+1);
    }

    // not take
    int notTake = findMaxSkillGain(n, time, skill, x, k, curr+1);

    return max(take, notTake);
}

int main() {
    int time[] = {3, 5, 4, 2, 1};
    int skill[] = {3, 4, 1, 3, 1};

    int size = sizeof(time) / sizeof(time[0]);

    int x = 6, k = 2; // x -> max time, k -> max slots.

    cout << "max skill can be gained: " << findMaxSkillGain(size, time, skill, x, k, 0);
    // ans: 6 as (3, 3) and (2, 3) gives the maximum skill gain in k(2) slots and less than or equal to x(6) time.
    return 0;
}