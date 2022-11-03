package exercise;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
public class GetArmModeResult {
    public GetArmModeResult(List<Mode> armMode) {
        this.armMode = armMode;
    }

    /**
     * 数组下标+1=Area号
     * Json数组,64个Area
     */
    private List<Mode> armMode;
    private List<String> name;

    @Data
    public static class Mode {
        public Mode(String mode) {
            this.mode = mode;
        }

        /**
         * 布撤防状态,
         * 取值参考ArmMode
         */
        @JsonProperty("Mode")
        private String mode;
    }
}
