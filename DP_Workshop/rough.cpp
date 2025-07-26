// backtracking approch -> extra arr[] to track the usage is used. Can be removed using In-Place Swapping.

// *** Draw a tree if forgot the logic of In-Place Swapping instead of watching videos:)***

#include<iostream>
#include<vector>
#include<string.h>
using namespace std;

void printPermBE(string& str, int arr[], string curr) {
    if(curr.size() == str.size()) {
        cout << "-> " << curr << endl;
        return ;
    }

    for(int i = 0; i < str.size(); i++) {
        if(arr[i] == 0) {
            arr[i] = 1;
            curr.push_back(str[i]);
            printPermBE(str, arr, curr);
            curr.pop_back();
            arr[i] = 0;
        }
    }
}

void printPermUsingInPlaceSwapping(string str, int ptr) {
    if(ptr >= str.size()) {
        cout << "-> " << str << endl;
        return ;
    }

    for(int i = ptr; i < str.size(); i++) {
        swap(str[i], str[ptr]);
        printPermUsingInPlaceSwapping(str, ptr+1);
        swap(str[i], str[ptr]);
    }
}

int main() {
    string str = "abc";
    
    int arr[str.size()];
    memset(arr, 0, sizeof(arr));
    cout << "All permutations using backtracking" << endl;
    // printPermBE(str, arr, "");


    cout << "All permutations using backtracking + In place swapping" << endl;

    printPermUsingInPlaceSwapping(str, 0);

    return 0;
}