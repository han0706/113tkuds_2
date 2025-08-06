public class GradeStatisticsSystem {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 82, 90};
        int sum = 0, max = scores[0], min = scores[0];
        int[] gradeCount = new int[5];
        for (int score : scores) {
            sum += score;
            if (score > max) max = score;
            if (score < min) min = score;
            if (score >= 90) gradeCount[0]++;
            else if (score >= 80) gradeCount[1]++;
            else if (score >= 70) gradeCount[2]++;
            else if (score >= 60) gradeCount[3]++;
            else gradeCount[4]++;
        }
        double avg = sum / (double) scores.length;
        int aboveAvg = 0;
        for (int score : scores) if (score > avg) aboveAvg++;
        System.out.println("平均: " + avg);
        System.out.println("最高: " + max);
        System.out.println("最低: " + min);
        System.out.println("A: " + gradeCount[0]);
        System.out.println("B: " + gradeCount[1]);
        System.out.println("C: " + gradeCount[2]);
        System.out.println("D: " + gradeCount[3]);
        System.out.println("F: " + gradeCount[4]);
        System.out.println("高於平均人數: " + aboveAvg);
        System.out.print("成績: ");
        for (int score : scores) System.out.print(score + " ");
    }
}
