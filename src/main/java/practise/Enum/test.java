package practise.Enum;

public class test {
    public static void main(String[] args) {
        int res = SysUserTypeEnum.AGENT.getKey();
        System.out.println(res);
    }
}
enum SysUserTypeEnum {

    SUPER_MANAGER(1,"超级管理员"),
    MARKET_MANAGER(2,"管理员"),
    DEALER(3,"分销销售"),
    AGENT(4,"代理商"),
    PROPERTY_MANAGER(5,"物业公司"),
    DAHUA_MANAGER(6,"大华管理员");

    private Integer key;

    private String desc;

    private SysUserTypeEnum(Integer key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
