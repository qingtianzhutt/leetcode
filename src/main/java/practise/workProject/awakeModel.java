package practise.workProject;

import lombok.Data;

import java.util.List;

@Data
public class awakeModel {
    private List<Integer> data;

    private String beginTime;

    private String endTime;

    public awakeModel(List<Integer> data, String beginTime, String endTime) {
        this.data = data;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }
}
