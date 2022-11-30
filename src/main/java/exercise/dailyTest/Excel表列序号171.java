package exercise.dailyTest;

import org.junit.Test;

/*
给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 */
//A65   a97
public class Excel表列序号171 {
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) return 0;
        int res = 0;
        int len = columnTitle.length();
        for (int i = 0; i < columnTitle.length(); i++){
            //这里A实际是1 ， 让A的ascll码减去64完成转换。
            res += (Integer.valueOf(columnTitle.charAt(i)) - 64) * Math.pow(26, --len);
        }
        return res;
    }
    @Test
    public void test(){
        Character s = 'a';
        System.out.println(Integer.valueOf(s));
    }
}
