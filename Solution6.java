class Solution6 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character , Integer> hashMap = new HashMap<>();

    char[] magazine_ar = magazine.toCharArray();
    char[] ransomNote_ar = ransomNote.toCharArray();
    for(int i = 0; i < magazine.length();i++){
        if(hashMap.containsKey(magazine_ar[i])){
            hashMap.put(magazine_ar[i],hashMap.get(magazine_ar[i])+1);
        }else{
            hashMap.put(magazine_ar[i],1);
        }
    }

    for(int i = 0;i < ransomNote.length();i++){
        if(hashMap.containsKey(ransomNote_ar[i]) && hashMap.get(ransomNote_ar[i]) > 0){
            hashMap.put(ransomNote_ar[i],hashMap.get(ransomNote_ar[i]) - 1);
        }else{
            return false;
        }
    }
    return true;
    }
}