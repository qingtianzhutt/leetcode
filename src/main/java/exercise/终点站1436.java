package exercise;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
//输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
//输出："Sao Paulo"
//太简单了
public class 终点站1436 {
    public static void main(String[] args) {

    }
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<String>();
        for(List<String> i : paths){
            set.add(i.get(0));
        }
        for(List<String> i : paths){
            if(!set.contains(i.get(1))){
                return i.get(1);
            }
        }
        return "";
    }
}
