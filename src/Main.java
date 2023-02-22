import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                "=========================\n" +
                        " 주택용 전기요금(저압) 계산기 \n" +
                        "=========================");
        Scanner input = new Scanner(System.in);
        double[] cost = {60.7, 125.9, 187.9, 280.6, 417.7, 670.6}; // {100이하,100초과,200초과,300초과,400초과,500초과}
        while(true){
            System.out.print("총사용량(kw):");
            String ele = input.nextLine();
            System.out.println(ele + "kWh의 전기 요금은 " + cal(cost, ele) + "원 입니다.");
        }
    }
    public static double cal(double[] cost, String ele){
        double result = 0;
        int ele_use = Integer.parseInt(ele);
        if(ele_use <= 100){
            result = ele_use * cost[0];
        }
        else if(ele_use < 200){
            result = (ele_use-100) * cost[1] + cost[0] * 100;
        } else if(ele_use < 300){
            result = (ele_use-200) * cost[2] + (cost[1] + cost[0]) * 100;
        } else if(ele_use < 400){
            result = (ele_use-300) * cost[3] + (cost[2] + cost[1] + cost[0]) * 100;
        } else if(ele_use < 500){
            result = (ele_use-400) * cost[4] + (cost[3] + cost[2] + cost[1] + cost[0]) * 100;
        } else{
            result = (ele_use-500) * cost[5] + (cost[4] + cost[3] + cost[2] + cost[1] + cost[0]) * 100;
        }
        return result;
    }
}