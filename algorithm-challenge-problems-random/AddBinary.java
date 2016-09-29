package practice;

public class AddBinary {
	public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int m = a.length()-1;
        int n = b.length()-1;
        int carry = 0;
        int sum = 0;
        int[] add = new int[(m>n?m:n)+2];
        for(int i = add.length-1; i >=0; i--){
            
            if(m>=0){
                sum += a.charAt(m)-'0';
                m--;
            }
            if(n>=0){
                sum += b.charAt(n)-'0';
                n--;
            }
            sum += carry;
            carry = 0;
            if(sum==3){
                carry = 1;
                add[i] = 1;
            }else if(sum==2){
                carry = 1;
                add[i] = 0;
            } else{
                add[i] = sum;
            }
            sum = 0;
        }
        
        for(int i: add){
            if(!(res.length()==0 && i==0)){
                res.append(i);
            }
        }
        return (res.length()==0)?"0":res.toString();
    }
	
	public static void main(String[] args){
		AddBinary obj = new AddBinary();
		String res = obj.addBinary("1", "1");
		System.out.println(res);
	}
}
