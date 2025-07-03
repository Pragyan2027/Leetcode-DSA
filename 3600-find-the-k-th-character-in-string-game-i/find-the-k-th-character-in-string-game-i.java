class Solution {
    public char kthCharacter(int k) {
        StringBuilder s = new StringBuilder("a");
        while(s.length() < k){
            int size = s.length();
            for(int i = 0 ; i < size;i++){
                s.append((char)('a' + ((s.charAt(i)-'a')+1)%26));
            }
        }
        return s.charAt(k-1);
    }
}