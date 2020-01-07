package QIAnXin;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 {
    public static int[] pid ;
    public static int[] ppid ;
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        String[] b = sc.nextLine().trim().split(" ");
        int kill = sc.nextInt();
        pid = new int[a.length];
        ppid = new int[b.length];
        if(a.length >= 1 && a.length <= 100 && b.length >= 1 && b.length <= 100){
            for (int i = 0; i < a.length; i++) {
                pid[i]= Integer.valueOf(a[i]);
            }
            for (int i = 0; i < b.length; i++) {
                ppid[i]=Integer.valueOf(b[i]);
            }
            List<Integer> result = killpid(kill);
            if(result!=null){
                System.out.println(result.size());
            }else{
                System.out.println(0);
            }
        }else {
            System.out.println(0);
        }

    }

    public static List<Integer> killpid(int kill){
        List<Integer> result = new ArrayList<Integer>();
        result.add(kill);
        for (int i = 0; i < ppid.length; i++) {
            if(ppid[i]==kill){
                result.addAll(killpid(pid[i]));
            }
        }
        return result;
    }
}
