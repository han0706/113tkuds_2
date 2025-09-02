class Solution {
    public String intToRoman(int num) {
        // 羅馬數字對應表
        int[] values =    {1000, 900, 500, 400, 100, 90,  50, 40,  10, 9,  5, 4, 1};
        String[] symbols = {"M", "CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        // 從最大值開始處理
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
