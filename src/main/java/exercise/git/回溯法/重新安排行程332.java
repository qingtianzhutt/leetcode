package exercise.git.回溯法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
提示：
如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
所有的机场都用三个大写字母表示（机场代码）。
假定所有机票至少存在一种合理的行程。
所有的机票必须都用一次 且 只能用一次。
输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */
//超出时间限制了。
//本质上来讲，这题并不难，重点在前期对于 自然排序的处理上，后续只是  典型的回溯。
public class 重新安排行程332 {
    private boolean[] used;
    private List<String> path = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        used = new boolean[tickets.size()];
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));

        //对结果进行排序
//        Collections.sort(res, new Comparator<List<String>>() {
//            @Override
//            public int compare(List<String> o1, List<String> o2) {
//                for (int i = 0; i < o1.size(); i++){
//                    //字典序
//                    if (o1.get(i).compareTo(o2.get(i)) != 0) {
//                        return o1.get(i).compareTo(o2.get(i));
//                    }
//                }
//                return 0;
//            }
//        });
        if (dfs(tickets, "JFK"))return path;
        return null;
    }
    private boolean dfs(List<List<String>> tickets, String start){
        if (path.size() == tickets.size() + 1){
            return true;
        }
        for (int i = 0; i < tickets.size(); i++){
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            if (!tickets.get(i).get(0).equals(start) || used[i])continue;
            path.add(from);
            if (path.size() == tickets.size())path.add(to);
            used[i] = true;
            if (dfs(tickets, to)){
                return true;
            }
            path.remove(path.size() - 1);
            if (path.size() == tickets.size())path.remove(path.size() - 1);
            used[i] = false;
        }
        return false;
    }
    @Test
    public void  test(){
        List<String> s1 = Stream.of("MUC", "LHR").collect(Collectors.toList());
        List<String> s2 = Stream.of("JFK", "MUC").collect(Collectors.toList());
        List<String> s3 = Stream.of("SFO", "SJC").collect(Collectors.toList());
        List<String> s4 = Stream.of("LHR", "SFO").collect(Collectors.toList());
        List<List<String>> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        System.out.println(findItinerary(list));
    }
}
