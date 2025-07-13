// N Queen Revisited -> from algozenith platform.

#include<bits/stdc++.h>
using namespace std;

bool checkOuterSquare(int currRow, int currCol, int placedQueenRow, int placedQueenCol) {

    // checking each box of the 2 length outer square where we want to place the queen
    for(int dx = -2; dx <= 2; dx++) {
        for(int dy = -2; dy <= 2; dy++) {
            int x = currRow+dx;
            int y = currCol+dy;

            if(x == placedQueenRow && y == placedQueenCol) return true;
        }
    }

    return false;
}

bool check(int row, int col, int placedQueen[]) {

    for(int i = 0; i < row; i++) {
        int currRow = i;
        int currCol = placedQueen[currRow];
        
        // check col and the diagonals and checking the 2 length square of the placing queen.
        if(currCol == col || (abs(currRow-row) == abs(currCol == col)) || (checkOuterSquare(row, col, currRow, currCol))) {
            return false;
        }
    }

    return true;
}

int solve(int n, int currRow, int placedQueen[]) {
    if(currRow == n) return 1;

    int ans = 0;
    for(int col = 0; col < n; col++) {
        if(check(currRow, col, placedQueen)) {
            placedQueen[currRow] = col;
            ans += solve(n, currRow+1, placedQueen);
            placedQueen[currRow] = -1;
        }
    }

    return ans;
}

int main() {
    int n; cin >> n;
    
    int placedQueen[n+1];
    memset(placedQueen, -1, sizeof(placedQueen));

    cout << solve(n, 0, placedQueen);

    return 0;
}