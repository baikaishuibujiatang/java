class Solution2 {
    public String toLowerCase(String str) {
        String str2="";
        for(int i=0;i<str.length();i++){
            char s=str.charAt(i);
            if(s>='A'&&s<='Z'){
                s+=32;
            }
            str2+=s;
        }
        return str2;
    }
	public String toLowerCase2(String str){
        return str.toLowerCase();
    }
}