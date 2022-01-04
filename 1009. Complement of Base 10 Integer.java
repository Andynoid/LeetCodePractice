// 100% speed
//9.95% memory
// 2022.1.4


class Solution {
    public int bitwiseComplement(int n) {
        int t = 0;
        int k = 0;
        for (int i=1; i<31; i++){
            k = 1 << i;
            if (n < k) {
                t = n ^ (k-1);
                break;
            }
        }
         return t;

    }
}
