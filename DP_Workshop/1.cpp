// Number of ways to reach nth stair. You can jump upto 3 stairs in a go.
#include<iostream>
using namespace std;

int solve(int curr, int n) {
    if(curr == n) return 1;
    if(curr > n) return 0;

    int total = 0;
    for(int jump = 1; jump <= 3; jump++) {
        if(curr+jump > n) break;
        total += solve(curr+jump, n);
    }

    return total;
}

int main() {
    int n = 3;
    cout << "No. of ways to reach " << n << "th stair is " << solve(0, n);

    return 0;
}