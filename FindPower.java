public class FindPower {
    public static void main(String[] args) {
        int a=3;
        int b=8;
        int ans=1;
        int base=3;

        while(b>0)
        {
            int last=b&1;
            if(last==1)
            {
               ans*=last*base;
            }
            base*=base;
            b=b>>1;
        }
        System.out.println(ans);
    }
}
