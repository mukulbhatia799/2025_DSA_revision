#include<bits/stdc++.h>
using namespace std;

bool canPlaceCheck(int row, int col, vector<int> &currPlacedQueen) {

    for(int i = 0; i < row; i++) {
        int prow = i;
        int pQueen = currPlacedQueen[i];

        if(col == pQueen || (abs(prow-row) == abs(pQueen-col))) {
            return false;
        }
    }
    return true;
}

void placeQueen(int n, vector<vector<int>> &placedQueenColArr, vector<int> currPlacedQueen, int row) {
    if(row == n) {
        placedQueenColArr.push_back(currPlacedQueen);
        return;
    }

    // col traverse
    for(int col = 0; col < n; col++) {
        if(canPlaceCheck(row, col, currPlacedQueen)) {
            currPlacedQueen[row] = col;
            placeQueen(n, placedQueenColArr, currPlacedQueen, row+1);
            currPlacedQueen[row] = -1;
        }
    }
}

int main() {
    int n = 8;
    vector<vector<int>> placedQueenColArr;
    vector<int> currPlacedQueen(n, -1);
    placeQueen(n, placedQueenColArr, currPlacedQueen, 0);

    cout << "printing all occurences: " << endl;
    
    for(auto vec1: placedQueenColArr) {
        cout << "occ: " << endl;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j == vec1[i]) cout << "1 ";
                else cout << "0 ";
            }
            cout << endl;
        }
    }

    cout << endl << "Total: " << placedQueenColArr.size() << endl;

    return 0;
}