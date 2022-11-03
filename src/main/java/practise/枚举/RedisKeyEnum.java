package practise.枚举;

public enum RedisKeyEnum {

    DMSS_DEVICE("设备信息", "DMSS_DEVICE::deviceCode", "DMSS_DEVICE::deviceCode::%s"),
    HASH_LOGIN_ATTEMPTS_PREFIX("登录错误冻结","hash:auc:login_attempts:project:userId","hash:auc:login_attempts:%s:%s"),
    DEVICE_MSGSWITCH_REDIS_MAP("绑定者的消息订阅内容","DEVICE_MSGSWITCH_REDIS_MAP::deviceCode","DEVICE_MSGSWITCH_REDIS_MAP::%s"),
    USER_MSGSWITCH_REDIS_MAP("分享用户的订阅详情","USER_MSGSWITCH_REDIS_MAP::deviceCode","USER_MSGSWITCH_REDIS_MAP::%s"),
    DEVICE_PERMISSION("用户对设备的权限","device-permission:deviceId:deviceCode:openUserId:openUserId","device-permission:deviceId:%s:openUserId:%s"),
    USER_INFO("用户信息","openUserId_openUserId","openUserId_%s"),
    USERINFO("用户信息","USERINFO_areaCode:userId","USERINFO_%s:%s"),
    USER_AREA_INFO("用户区域信息","pcs_hash_account::hashAccount","pcs_hash_account::%s"),
    USER_AREA_INFO_APP("用户区域信息(带appid)","pcs_hash_account::appId::hashAccount","pcs_hash_account::%s::%s"),
    USER_AREA_INFO_NAME("用户区域信息(用户名)","pcs_user_name::userName","pcs_user_name::%s"),
    USER_AREA_INFO_OPENUSERID("用户区域信息（openUserId）","pcs_openuser_id::openUserId","pcs_openuser_id::%s"),

    DEVICE_ABILITY("设备能力集","GatewayFacility-Ability::deviceCode","GatewayFacility-Ability::%s"),
    TOKEN_INFO("token信息","EMAIL_TOKEN:email","EMAIL_TOKEN:%s"),
    PLAYTOKEN_INFO("playtoken信息","UMS:TOKEN_KEY:openUserId","UMS:TOKEN_KEY:%s"),
    EN_SHARED_DEVICEID("en分享关系","ARC::EN:SHARED::deviceCode","ARC::EN:SHARED::%s"),
    CARD_ADD("设备卡片","CARD_ADD::deviceCode","CARD_ADD::%s"),
    CARD_ADD_CANCEL("取消添加卡片","CARD_ADD_CANCEL:deviceCode","CARD_ADD_CANCEL:%s"),
    CSITE_TOKEN_KEY("网关分享获取token","CSITE_TOKEN_KEY:targetOpenId","CSITE_TOKEN_KEY:%s"),
    OMS_USER_ANALYSIS_TASK("dmss注册用户统计","OmsUserAnalysisTask_areaCode","OmsUserAnalysisTask_%s"),
    OMS_ANALYSIS_TASK("dmss设备统计","OmsAnalysisTask_areaCode","OmsAnalysisTask__%s"),
    DEVICE_RELATIONSHIP("设备分享关系","DeviceRelationship::deviceCode","DeviceRelationship::%s"),
    //    REDIS_DEVICE("设备分享关系","DeviceRelationship::deviceCode","DeviceRelationship::%s"),
    EN_PERMISSION("EN分享关系设备权限","EN_PERMISSION::deviceCode","EN_PERMISSION::%s"),
    ERROR_PWD_TIMES("密码错误次数","error:pwd:times:userId","error:pwd:times:%s"),
    VALID_CODE("验证码","AuthCode_project_authCodeAppid_hashAccount_usage","AuthCode_%s_%s_%s_%s"),
    INVALID_AUTHCODE_COUNT("验证码错误次数","ErrorCodeCount_codeKey","ErrorCodeCount_%s"),

    ;

    // 成员变量
    private String name;
    private String key;
    private String pattern;

    // 构造方法
    private RedisKeyEnum(String name, String key, String pattern) {
        this.name = name;
        this.key = key;
        this.pattern = pattern;
    }

    public String getKey(String... strings) {
        return String.format(this.pattern, strings);
    }

}
