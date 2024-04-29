package hasanalmunawr.Dev.springproject2;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Test {

    public static String generateSequence(int n) {
        StringBuilder sb = new StringBuilder();
        int currentNum = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < currentNum; j++) {
                sb.append(currentNum).append(",");
                sum += currentNum;
            }
            currentNum++;
        }

        // Remove the trailing comma
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString() + String.format(" (sum: %d)", sum);
    }

    public static void main(String[] args) {
        System.out.print(soalGrub(4));
    }

    public static List<Integer> soalGrub(int n) {
        List<Integer> list = new ArrayList<>();
        int currentNum = 1;
        int sum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < currentNum; j++) {
                list.add(sum);
                sum += currentNum;
            }
            currentNum++;
        }
        return list;
    }
}
