class Solution {
    public boolean checkDivisibility(int n) {
        int digitSum=0;
        int digitProd=1;
        if(n==0)
        {
            return true;
        }
        int temp=n;
        while(temp!=0)
        {
            int digit=temp%10;
            digitSum+=digit;
            digitProd*=digit;
            temp=temp/10;
        }
        int divisibleSum=digitSum+digitProd;
        if(n%divisibleSum==0)
        {
            return true;
        }
    return false;
    }
}