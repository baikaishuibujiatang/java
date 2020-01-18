class Solution5 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
	public boolean isPalindrome2(int x) {
        String s1=Integer.toString(x);
        String s2=reverse(s1);
        return s1.equals(s2);
    }
    public String reverse(String s){
        int length=s.length();
        String r="";
        for(int i=length-1;i>=0;i--){
            char ch=s.charAt(i);
            r=r+ch;
        }
        return r;
    }
}