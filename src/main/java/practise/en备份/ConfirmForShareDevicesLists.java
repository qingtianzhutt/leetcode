//package practise.en备份;
//
//import com.dahua.base.business.BusinessErrorCode;
//import com.dahua.base.business.RestBusinessHandler;
//import com.dahua.common.exception.HttpException;
//import com.dahua.common.pojo.FailedEntity;
//import com.dahua.common.pojo.User;
//import com.dahua.common.util.StringUtil;
//import io.netty.handler.codec.http.FullHttpRequest;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//
//public class ConfirmForShareDevicesLists extends RestBusinessHandler {
//
//    @Override
//    public void processRequest(FullHttpRequest request) throws HttpException {
//        logger.info("enter ------------------------------v1");
//        JSONArray deviceList;
//        String companyId = null;
//        String reason = null;
//        boolean operateType = false;
//        String companyEmail;
//        String companyName = null;
//
//        try {
//            deviceList = requestData.getJSONArray("devices");
//            if (requestData.has("reason")) {
//                reason = requestData.getString("reason");
//            }
//            operateType = requestData.getBoolean("result");
//            companyEmail = requestData.getString("companyEmail");
//            Object comObj = requestData.get("companyId");
//            if (comObj instanceof Long) {
//                Long companyIdLong = requestData.getLong("companyId");
//                companyId = companyIdLong.toString();
//            } else if (comObj instanceof String) {
//                companyId = requestData.getString("companyId");
//            } else {
//                logger.info("companyId's value : " + comObj.toString());
//                try {
//                    Long.parseLong(comObj.toString());
//                    companyId = comObj.toString();
//                } catch (NumberFormatException e) {
//                    e.printStackTrace();
//                }
//            }
//
//
////            companyId = "25";//先写死
//            //根据companyId去B端获取companyName
//            com.alibaba.fastjson.JSONObject jsonObject = businessManager.smbWebService.getCompanyInfo(companyId);
//            if (jsonObject != null && jsonObject.containsKey("data")) {
//                com.alibaba.fastjson.JSONObject dataJson = jsonObject.getJSONObject("data");
//                companyName = dataJson.getString("companyName");
//            }
//
//            if (operateType) {
//                //托管请求，发起分享
//                List<Map<String, Object>> list = new ArrayList<>();
//
//                for (int i = 0; i < deviceList.length(); i++) {
//                    logger.info("begin share2:" + com.alibaba.fastjson.JSONObject.toJSONString(list));
//                    JSONObject device = (JSONObject) deviceList.get(i);
//                    Map<String, Object> data = new HashMap<String, Object>();
//                    data.put("deviceId", device.getString("deviceCode"));
//                    data.put("deviceName", device.getString("deviceName"));
//                    data.put("account", StringUtil.getEmailForB(companyEmail));
//                    if (device.has("endTime")) {
//                        data.put("endTime", device.getLong("endTime"));
//                    }
////                    if (device.has("functions")) {
////                        data.put("functions", device.getString("functions"));
////                    } else {
////                        data.put("functions", "");
////                    }
//                    data.put("functions","realtime,videoMonitor,alarmMsg,videoRecord,localVideoRecord,seniorConfigure,configure");
//                    User owner = businessManager.userManager.getUser(device.getLong("ownerId"), "en", appId);
//                    if (owner == null || owner.getOpenUserToken() == null) {
//                        logger.info("begin share3:" + com.alibaba.fastjson.JSONObject.toJSONString(list));
//                        setResponseCode(BusinessErrorCode.INTERNAL_SERVER_ERROR);
//                        return;
//                    }
////                    owner.setOpenUserToken("Ut_cbdc538b07d74ef08c34f22701afb7e8");
//                    data.put("token", owner.getOpenUserToken());
//                    data.put("openUserId", owner.getOpenUserId());
//                    list.add(data);
//                }
//                List<FailedEntity> collect = list.parallelStream().filter(Objects::nonNull).map(entry -> {
//                    try {
//                        FailedEntity failedEntity = new FailedEntity();
//                        com.alibaba.fastjson.JSONObject retData = businessManager.userManager.exShareDeviceAdd(entry, appId);
//                        com.alibaba.fastjson.JSONObject retJSON = (com.alibaba.fastjson.JSONObject) retData.get("result");
//                        com.alibaba.fastjson.JSONObject dataJSON = (com.alibaba.fastjson.JSONObject) retJSON.get("data");
//                        String code = retJSON.getString("code");
//                        if (retData != null && code.equals("0")) {
//                            failedEntity.setDeviceCode(entry.get("deviceId").toString());
//                            failedEntity.setSucceedFlag(true);
//                        } else {
//                            failedEntity.setDeviceCode(entry.get("deviceId").toString());
//                            failedEntity.setReason(retJSON.getString("msg"));
//                            failedEntity.setSucceedFlag(false);
//                            failedEntity.setErrCode(code);
//                        }
//                        if (entry.containsKey("endTime") && entry.get("endTime") != null) {
//                            failedEntity.setEndTime(Long.valueOf(entry.get("endTime").toString()));
//                        }
//                        failedEntity.setDeviceName(entry.get("deviceName").toString());
//                        failedEntity.setOpenUserId(entry.get("openUserId").toString());
//
//                        return failedEntity;
//                    } catch (Exception e) {
//                        logger.error("rest api error:", e);
//                        setResponseCode(BusinessErrorCode.INTERNAL_SERVER_ERROR);
//                        return null;
//                    }
//
//                }).filter(Objects::nonNull).collect(Collectors.toList());
//
//                if (collect.isEmpty()) {
//                    setResponseCode(BusinessErrorCode.INTERNAL_SERVER_ERROR);//未提交
//                } else {
//                    JSONArray failList = new JSONArray();
//                    JSONArray successList = new JSONArray();
//                    for (FailedEntity entry : collect) {
//                        JSONObject jsObj = new JSONObject();
//                        jsObj.put("openUserId", entry.getOpenUserId());
//                        jsObj.put("deviceCode", entry.getDeviceCode());
//                        jsObj.put("deviceName", entry.getDeviceName());
//                        jsObj.put("endTime", entry.getEndTime());
//                        if (entry.getReason() != null) {
//                            jsObj.put("reason", entry.getReason());
//                        }
//                        if (entry.getErrCode() != null) {
//                            jsObj.put("errCode", entry.getErrCode());
//                        }
//                        jsObj.put("successFlag", entry.getSucceedFlag());
//                        if (entry.getSucceedFlag()) {
//                            successList.put(jsObj);
//                        } else {
//                            failList.put(jsObj);
//                        }
//                    }
//                    JSONObject result = new JSONObject();
//                    result.put("failList", failList);
//                    result.put("successList", successList);
//                    setResponseData(result.toString());
//
//                }
//            } else {
//                JSONArray denyList = new JSONArray();
//                for (int i = 0; i < deviceList.length(); i++) {
//                    JSONObject jsObj = (JSONObject) deviceList.get(i);
//                    User owner = businessManager.userManager.getUser(jsObj.getLong("ownerId"), "en", appId);
//                    jsObj.put("openUserId", owner.getOpenUserId());
//                    jsObj.put("deviceCode", jsObj.getString("deviceCode"));
//                    jsObj.put("reason", reason);
//                    jsObj.put("deviceName", jsObj.getString("deviceName"));
//                    denyList.put(jsObj);
//                }
//
//                //审核拒绝，具体业务在SMB处理
//                setResponseCode(BusinessErrorCode.SUCCESS);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("rest api error:", e);
//            setResponseCode(BusinessErrorCode.INTERNAL_SERVER_ERROR);
//            return;
//        }
//    }
//
//
//}
