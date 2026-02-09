import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {
        int[] arr={1,2,2};
dice("",4);

    }
    static boolean sorted(int[] arr,int index)
    {
        if(index==arr.length-1) return true;
        return arr[index]<arr[index+1] &&sorted(arr,index+1);

    }
    static ArrayList<Integer> findIndex(int[] arr,int target,int index,ArrayList<Integer> list)
    {

        if (index == arr.length) {
            return list;
        }
        if(arr[index]==target)
            list.add(index);
        return findIndex(arr,target,index+1,list);
    }
    static ArrayList<Integer> findIndex2(int[] arr,int target,int index)
    {
        ArrayList<Integer> list=new ArrayList<>();
        if (index == arr.length) {
            return list;
        }
        if(arr[index]==target)
            list.add(index);
        list.addAll(findIndex2(arr,target,index+1));
        return list;
    }
    static int rotatedBinarySearch(int[] arr,int target,int start,int end)
    {
        if (start>end) {
            return -1;
        }
        int mid=start+(end-start)/2;
        if(arr[mid]==target){

            return mid;
        }
        else if(arr[start]<arr[mid])
        {
            if(target>=arr[start]&&target<=arr[mid])
                end=mid-1;
            else
                start=mid+1;
        }
        else
        if(target>=arr[mid]&&target<=arr[end])
            start=mid+1;
        else
            end=mid-1;

        return rotatedBinarySearch(arr,target,start,end);
    }
    static void skip(String p,String up){
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        if(ch=='a')
            skip(p,up.substring(1));
        else skip(p+ch,up.substring(1));
    }
    static String skipString(String up)
    {
        if (up.isEmpty()) {
            return "";
        }
        char ch=up.charAt(0);
        if(up.startsWith("apple")) return skipString(up.substring(5));
        else return ch+ skipString(up.substring(1));
    }
    static ArrayList<String> subseq(String p,String up)
    {
        if(up.isEmpty()) {
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch=up.charAt(0);
        ArrayList<String> list1=subseq(p+ch,up.substring(1));
        ArrayList<String> list2=subseq(p,up.substring(1));
        list2.addAll(list1);
        return list2;

    }
    static List<List<Integer>> arrSubseq(int[] nums)
    {
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        int s=0,e=0;
        for(int j=0;j<nums.length;j++){
            int n=outer.size();
            s=0;
            if(j>0&& nums[j]==nums[j-1])
                s=e+1;
            e=outer.size()-1;
            for (int i = s; i <n ; i++) {
                ArrayList<Integer> inner=new ArrayList<>(outer.get(i));
                inner.add(nums[j]);
                outer.add(inner);

            }
        }
        return outer;
    }
    static void permutattions(String p,String up)
    {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for (int i=0;i<=p.length();i++)
        {
            String f=p.substring(0,i);
            String s=p.substring(i);
            permutattions(f+ch+s,up.substring(1));

        }
    }
    static List<String> helper(String p,String up)
    {
        if(up.isEmpty())
        {
            List<String> list =new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list =new ArrayList<>();
        int n=up.charAt(0)-'0';
        int start = 3 * n - 6 + Math.max(0, (n - 6) / 2);
        int count = 3 + ((n >= 7 && n % 2 == 1) ? 1 : 0);
        for(int i=0;i<count;i++)
        {
            int a=start+i;
            char ch=(char)('a'+a);
            list.addAll(helper(p+ch,up.substring(1)));
        }
        return list;

    }
    static void dice(String p,int up)
    {
        if(up==0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <=6&&i<=up; i++) {
            dice(p+i,up-i);
        }
    }
}
