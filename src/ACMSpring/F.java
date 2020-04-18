package ACMSpring;

import sun.font.DelegatingShape;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName:F
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/18 下午2:55
 **/
public class F {

    static String[] strings = {"0","1st","2nd","3rd","4th","5th","6th","7th","8th",
            "9th","10th","11th","12th","13th","14th","15th","16th","17th",
            "18th","19th","20th","21st","22nd","23rd","24th","25th","26th","27th",
            "28th","29th","30th","31st","32nd","33rd","34th","35th","36th","37th","38th","39th","40th"};

    public static int[] findMotherDay(int year){
        //计算母亲节，母亲节为每年的5月份，第二个周日
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        //因为从0开始，所以减1
        cal.set(Calendar.MONTH, 5-1);
        int maxDate = cal.getActualMaximum(Calendar.DATE);
        int sundays = 0;
        for(int i = 1; i <= maxDate; i ++) {
            cal.set(Calendar.DATE, i);
            //判断是周日
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                sundays ++;
                //第二个周日，返回
                if(sundays == 2) {
                    break;
                }
            }
        }
        String date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        String[] dataInt = date.trim().split("-");
        int[] result = new int[3];
        for(int i=0;i<3;i++){
            result[i] = Integer.parseInt(dataInt[i]);
        }
        return result;
    }

    public static int[] findFtherDay(int year){
        //计算父亲节，父亲节为每年的6月份，第三个周日
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        //因为从0开始，所以减1
        cal.set(Calendar.MONTH, 6-1);
        int maxDate = cal.getActualMaximum(Calendar.DATE);
        int sundays = 0;
        for(int i = 1; i <= maxDate; i ++) {
            cal.set(Calendar.DATE, i);
            //判断是周日
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                sundays ++;
                //第三个周日，返回
                if(sundays == 3) {
                    break;
                }
            }
        }
        String date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        String[] dataInt = date.trim().split("-");
        int[] result = new int[3];
        for(int i=0;i<3;i++){
            result[i] = Integer.parseInt(dataInt[i]);
        }
        return result;
    }

    public static boolean judedate(int[] date,HashSet<Integer> m1,HashSet<Integer> m2){
        if(date[0] < 2000 || date[0] > 2100){
            return false;
        }else {
            if(date[1] < 1 || date[1] > 12){
                return false;
            }else {
                if(m1.contains(date[1])){
                    if(date[2] <1 || date[2] > 31)
                        return false;
                    else
                        return true;
                }else if(m2.contains(date[1])){
                    if(date[2] <1 || date[2] > 30)
                        return false;
                    else
                        return true;
                }else {
                    if(date[0] % 4 ==0){
                        if(date[2] <1 || date[2] > 28)
                            return false;
                        else
                            return true;
                    }else {
                        if(date[2] <1 || date[2] > 29)
                            return false;
                        else
                            return true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        HashSet<Integer> m1 = new HashSet<Integer>();
        m1.add(1);m1.add(3);m1.add(5);m1.add(7);m1.add(8);m1.add(10);m1.add(12);
        HashSet<Integer> m2 = new HashSet<Integer>();
        m2.add(4);m2.add(6);m2.add(9);m2.add(11);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n > 100)
            return;
        ArrayList<int[]> arrayList = new ArrayList<>();
        for(int i=0;i<n;i++){
            int[] arr = new int[3];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();
            if(!judedate(arr,m1,m2)){
                return;
            }
            arrayList.add(arr);
        }
        if(arrayList.size() == 0){
            return;
        }
        for(int[] arr: arrayList){

            int[] mom = findMotherDay(arr[0]);
            int[] father = findFtherDay(arr[0]);
            int[] mom1 = findMotherDay(arr[0]+1);
            if(arr[1] < 5)
                System.out.println("Mother's Day: May "+strings[mom[2]]+", "+arr[0]);
            if(arr[1] == 5){
                if(arr[2]<mom[2])
                    System.out.println("Mother's Day: May "+strings[mom[2]]+", "+arr[0]);
                else
                    System.out.println("Father's Day: June "+strings[father[2]]+", "+arr[0]);
            }
            if(arr[1] == 6){
                if(arr[2] < father[2])
                    System.out.println("Father's Day: June "+strings[father[2]]+", "+arr[0]);
                else
                    System.out.println("Mother's Day: May "+strings[mom1[2]]+", "+(arr[0]+1));
            }
            if(arr[1] > 6 && arr[1] <= 12){
                System.out.println("Mother's Day: May "+strings[mom1[2]]+", "+(arr[0]+1));
            }
        }
    }
}
