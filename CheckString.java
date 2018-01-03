package first;
import java.util.Scanner;

public class CheckString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        String hr = "hackerrank";
        int val = 0;
        
        for(int a0 = 0; a0 < q; a0++){
            int count = 0;
            val = 0;
            String s = in.next();
            for(int i = 0; i < hr.length(); i++){
                for(int j = val ; j < s.length(); j++){
                    // System.out.println("HR "+hr.charAt(i)+" actual:: "+s.charAt(j));
                    if(hr.charAt(i) == s.charAt(j)){
                        val = ++j; 
                        count++;
                        //System.out.println("count::"+count);
                        break;
                    }
                }
            }
            
            if(count == 10){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
