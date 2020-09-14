public class Encrypter {

    public Encrypter(){

    }
    String encrypt(String num){
        int n = num.length();
        int[] vals = new int[n];
        for(int i =0;i<n;i++){
            vals[i] = (num.charAt(i)-'0'+7)%10;
        }
        boolean[] v = new boolean[n];
        for(int i = 0;i<n-2;i++){
            if(v[i])continue;
            v[i+2] = true;
            int temp = vals[i];
            vals[i] = vals[i+2];
            vals[i+2] = temp;
        }
        String res = "";
        for(int i = 0;i<n;i++){
            res+=vals[i];
        }
        return res;
    }
}
