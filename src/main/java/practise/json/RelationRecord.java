package practise.json;

import java.io.Serializable;
import java.util.List;

public class RelationRecord implements Serializable {
    /**
     * token用户分享的设备
     */
    private List<String> deviceCodes;

    private String ownerEmail; //分享者邮箱

    public List<String> getDeviceCodes() {
        return deviceCodes;
    }

    public void setDeviceCodes(List<String> deviceCodes) {
        this.deviceCodes = deviceCodes;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
}
