public class Ques5 {
    public static void findAnsRE(int arr[], int start, int end) {
        if(start > end) return ;

        System.out.print(arr[start] + " ");
        findAnsRE(arr, start+1, end);
    }
    public static void main(String[] args) {
        
        int arr[] = {1, 2, 3, 4, 5};

        for(int i = 0; i < arr.length; i++) {
            findAnsRE(arr, 0, i);
            System.out.println();
        }
    }
}
