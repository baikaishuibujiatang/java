class Solution8 {
    public String reverseOnlyLetters(String S) {
        if(S.length() <= 1) return S;
        int i=0;
        int j=S.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i<S.length()&&i>=0){
            if(!isLetter(S.charAt(i))){
                sb.append(S.charAt(i));
                i++;
            }else if(!isLetter(S.charAt(j))){
                j--;
            }else{
                sb.append(S.charAt(j));
                j--;
                i++;
            }
        }
        sb.append(S.substring(i,S.length()));
        return sb.toString();
    }
    public boolean isLetter(char c){
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';   
    }
}