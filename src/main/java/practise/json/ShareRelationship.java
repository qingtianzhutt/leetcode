package practise.json;
import java.io.Serializable;

public class ShareRelationship implements Serializable {

    private Long id;

    /**
     * 授权人 openUserId
     */
    private String fromUserId;

    /**
     * 被授权人的邮箱
     */
    private String account;

    /**
     * B端企业id
     */
    private String companyId;

    /**
     * 分享来自哪个OpenUserId
     */
    private String fromOpenUserId;

    /**
     * 设备绑定人 openUserId
     */
    private String ownerId;

    /**
     * 设备序列号
     */
    private String deviceId;

    /**
     * 设备类型
     */
    private String deviceCatalog;

    /**
     * 普通设备权限
     */
    private String functions;

    /**
     * 托管有效时间-开始
     */
    private String startTime;

    /**
     * 网关设备权限
     */
    private String arcAuth;

    private String endTime;

    /**
     * 1:C端到C端，2:C端到B端，3：B端到C端
     */
    private String type;

    private String status;

    /**
      * B->c配置权限保留时长：-1 -- 永久访问;  1,2,4,8-小时
      */

    private Integer remainHours;

    /**
      * B->c是否保留配置权限
      */
    private String retainRight;

    private String beSharedEmail;//被分享用户邮箱

    private String companyName;

    private String deviceName;

    private String userId;

    private String toOpenUserId;

    private String ownerEmail;

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }


    public String getToOpenUserId() {
        return toOpenUserId;
    }

    public void setToOpenUserId(String toOpenUserId) {
        this.toOpenUserId = toOpenUserId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }


    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public String getFromOpenUserId() {
        return fromOpenUserId;
    }

    public void setFromOpenUserId(String fromOpenUserId) {
        this.fromOpenUserId = fromOpenUserId;
    }


    public String getDeviceCatalog() {
        return deviceCatalog;
    }

    public void setDeviceCatalog(String deviceCatalog) {
        this.deviceCatalog = deviceCatalog;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getArcAuth() {
        return arcAuth;
    }

    public void setArcAuth(String arcAuth) {
        this.arcAuth = arcAuth;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRemainHours() {
        return remainHours;
    }

    public void setRemainHours(Integer remainHours) {
        this.remainHours = remainHours;
    }

    public String getRetainRight() {
        return retainRight;
    }

    public void setRetainRight(String retainRight) {
        this.retainRight = retainRight;
    }

    public String getBeSharedEmail() {
        return beSharedEmail;
    }

    public void setBeSharedEmail(String beSharedEmail) {
        this.beSharedEmail = beSharedEmail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
