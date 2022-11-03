package practise.多态;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserInfo2 {
    /**
     *用户编号
     */

    private String id;
    /**
     *用户状态
     * enumchar[32]{
     * "NotPresent" - 不存在，未配置过用户信息
     * "Inactivated" - 未激活，已经配置过用户信息，但是未使能
     * "Activated" - 已激活
     * }
     */

    private String status;
    /**
     *用户名
     */

    private String name;
    /**
     *密码
     */

    private String password;
    /**
     *胁迫密码
     */

    private String duressPassword;
    /**
     *用户的权限列表，参见AlarmUserAuthorityList，最大支持32个
     */

    private List<String> authorityList;
    /**
     *用户所在组，
     * enumchar[32]{
     * "Admin" - 管理员
     * "Installer" - 安装员
     * "Manufacturer" - 制造商
     * "Operator" - 操作员
     * }
     */

    private String group;
    /**
     *是否为保留用户，保留用户不可删除
     */

    private String reserved;
    /**
     *用户类型，
     * enumchar[32]{
     * "Keypad" - 键盘用户
     * "ICCard" - IC卡用户
     * "RemoteControl" - 遥控器用户
     * "Mobile" - 手机用户
     * "Key" - Key用户
     * }
     */

    private String userType;
    /**
     *关联的子系统，对应子系统号，用户只能操作其关联的子系统。
     */

    private List<Integer> subSystem;
    /**
     *关联的卡片
     */

    private List<String> card;
}
