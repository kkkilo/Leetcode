package leetcode._0033_Search_in_Rotated_Sorted_Array;

public class Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int[] A = nums;
        if(A.length == 0){
            return -1;
        }
        if(A.length == 1){
            if(target == A[0]){
                return 0;
            }else{
                return -1;
            }
        }
        if(A.length ==2){
            if(A[0] == target){return 0;}
            else if(A[1] == target){return 1;}
            else return -1;
        }

        boolean isLeft = false;
        if(target>=A[0]){
            isLeft = true;
        }

        int head = 0;
        int tail = A.length-1;

        while (A[head] > A[tail] && head < tail) {
            int mid = (head+tail)/2;
            int midNum = A[mid];

            if(midNum == target) return mid;
            if(isLeft) {
                if(midNum>A[head]) {
                    if(midNum>target){
                        tail = mid-1;
                    } else {
                        head = mid+1;
                    }
                } else {
                    tail = mid-1;
                }
            }else {
                if(midNum < A[tail]){
                    if(midNum>target){
                        tail = mid-1;
                    }else {
                        head = mid+1;
                    }
                } else {
                    head = mid+1;
                }
            }
        }

        if(head == tail) {
            if(A[head] == target) return head;
        }
        if(head > tail){
            return -1;
        }

        int res = binarySearch(A,head,tail,target);

        return res;
    }

    public int binarySearch(int[] arr, int head, int tail, int target) {
        while(head<tail) {
            int mid = (head+tail)/2;
            if(arr[mid] == target){
                return mid;
            } else if(arr[mid]>target) {
                tail = mid-1;
            }else {
                head = mid+1;
            }

        }

        if(head == tail && arr[head] == target) {
            return head;
        } else {
            return -1;
        }
    }
}
