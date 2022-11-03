//package practise.en备份;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.dahua.base.business.BusinessErrorCode;
//import com.dahua.base.business.RestBusinessHandler;
//import com.dahua.common.exception.HttpException;
//import com.dahua.common.util.Base64Util;
//import com.dahua.common.util.StringUtil;
//import com.google.common.collect.Lists;
//import io.netty.handler.codec.http.FullHttpRequest;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class SetShareDevice extends RestBusinessHandler {
//
//    @Override
//    public void processRequest(FullHttpRequest request) throws HttpException {
//        String deviceCode = null;
//        String account = null;
//        String operateType = null;
//        String functions = null;
//        String endTime = null;
//        String deviceName = null;
//        try {
//            deviceCode = requestData.getString("deviceCode");
//            account = requestData.getString("account");
//            operateType = requestData.getString("operateType");
//
//
//            if (requestData.has("endTime")) {
//                endTime = requestData.getString("endTime");
//            }
//
//            if (requestData.has("deviceName")) {
//                deviceName = requestData.getString("deviceName");
//            }
//
//            if (user == null) {
//                logger.error("user is null");
//                setResponseCode(BusinessErrorCode.INTERNAL_SERVER_ERROR);
//                return;
//            }
//
//            // 校验参数合法性
//            StringUtil.assertStringNotNullOrEmpty(deviceCode, "SetShareDevice.deviceCode");
//            StringUtil.assertStringNotNullOrEmpty(account, "SetShareDevice.account");
//            StringUtil.assertStringNotNullOrEmpty(operateType, "SetShareDevice.operateType");
//
//            //设备分享操作
//            if (operateType.equals("0")) {
//                functions = requestData.getString("functions");
//                Map<String, Object> data = new HashMap<String, Object>();
//                data.put("deviceId", deviceCode);
//                data.put("account", account);
//                data.put("functions", functions);
//                data.put("token", user.getOpenUserToken());
//                logger.info("begin limitVDPShareVTO job");
//                //限制VDP分享的VTO用户
//                Boolean boolResult = false;
//                try {
//                    boolResult = businessManager.userManager.limitVDPShareVTO(user,deviceCode,account);
//                }catch (Exception e){
//                    e.printStackTrace();
//                    logger.info("SetShareDevice fail:"+e);
//                }
//                if (boolResult){
//                    setResponseCode(BusinessErrorCode.VTO_HAS_SHARE);
//                    setResponseDesc("分享账号已在DMSS VDP上关联到该设备");
//                    return;
//                }
//
//                logger.info("end limitVDPShareVTO job");
//                JSONObject retData = businessManager.userManager.exShareDeviceAdd(data, appId);
//                JSONObject retJSON = (JSONObject) retData.get("result");
//                JSONObject dataJSON = (JSONObject) retJSON.get("data");
//                String code = retJSON.getString("code");
//
//                if (data != null && code.equals("0")) {
//                    setResponseData(dataJSON.toString());
//                }else {
//                    setResponseCode(BusinessErrorCode.INTERNAL_SERVER_ERROR);
//                    setResponseDesc(retJSON.getString("msg"));
//                }
//            }
//            //设备托管操作
//            else if (operateType.equals("1")) {
//                logger.info("31344-设备托管操作");
//                if (!requestData.has("devName")) {
//                    setResponseCode(BusinessErrorCode.BAD_REQUEST);
//                    return;
//                }
//                if (!requestData.has("devPassword")) {
//                    setResponseCode(BusinessErrorCode.BAD_REQUEST);
//                    return;
//                }
//                String devName = requestData.getString("devName");
//                String devPassword = requestData.getString("devPassword");
//                StringUtil.assertStringNotNullOrEmpty(devPassword, "SetShareDevice.devPassword");
//                StringUtil.assertStringNotNullOrEmpty(devName, "SetShareDevice.devName");
//                String deviceCatalog = null;
//                String redisKey = "DMSS_DEVICE::" + deviceCode;
//                deviceCatalog = businessManager.userManager.getDeviceCatalogByDeviceId(redisKey);
//                boolean checkResult = isSupportAsyncCheck(deviceCode, devName, devPassword);
//                if (!checkResult && !deviceCatalog.equals("ARC")) {
//                    setResponseCode(BusinessErrorCode.NO_ABILITY_ERROR);
//                    return;
//                }
//
//                JSONObject jsonObject = businessManager.smbWebService.getCompanyInfo(account);
//                if (jsonObject != null && jsonObject.containsKey("code") && jsonObject.getString("code").equals("0") && jsonObject.containsKey("data")) {
//
//                } else if (jsonObject != null && jsonObject.containsKey("code") && jsonObject.getString("code").equals("40001")) {
//                    setResponseDesc("Company not exist");
//                    setResponseCode(BusinessErrorCode.COMPANY_NOT_EXIST);
//                    logger.info("31344-设备托管操作-COMPANY_NOT_EXIST");
//                    return;
//                } else {
//                    logger.info("31344-设备托管操作-INTERNAL_SERVER_ERROR-1");
//                    setResponseCode(BusinessErrorCode.INTERNAL_SERVER_ERROR);
//                    return;
//                }
//
//                functions = requestData.getString("functions");
//                //先查询设备的托管状态
//                Map<String, Object> depositParam = new HashMap<>();
//                depositParam.put("ownerId", user.getId());
//                JSONObject deposit = businessManager.smbWebService.getShareInfoForClient(depositParam);
//                JSONArray depositData = deposit.getJSONArray("data");
//                String depositCode = deposit.getString("code");
//                if (depositCode.equals("0")) {
//                    for (Object object : depositData) {
//                        JSONObject depositDevice = (JSONObject) object;
//                        if (depositDevice.getString("deviceId").equalsIgnoreCase(deviceCode)
//                            //1.2改成一个设备只能托管给一个公司,修改判断
//                            //&& depositDevice.getIntValue("companyCode") == Integer.valueOf(account)
//                        ) {
//                            setResponseCode(BusinessErrorCode.DEVICE_HAS_DEPOSITED);
//                            logger.info("31344-设备托管操作-DEVICE_HAS_DEPOSITED");
//                            return;
//                        }
//                    }
//                } else {
//                    logger.info("31344-设备托管操作-INTERNAL_SERVER_ERROR-2");
//                    setResponseCode(BusinessErrorCode.INTERNAL_SERVER_ERROR);
//                    return;
//                }
//
//                //查询设备信息
//                Map<String, Object> bindDeviceParam = new HashMap<>();
//                bindDeviceParam.put("deviceId", deviceCode);
//                bindDeviceParam.put("token", user.getOpenUserToken()/*"Ut_37ef8edbf7124c028c39edb6dfbd9f6d"*/);
//
//                JSONObject bindDeviceInfo = businessManager.userManager.bindDeviceInfo(bindDeviceParam, appId);
//                JSONObject bindDeviceRet = (JSONObject) bindDeviceInfo.get("result");
//                JSONObject bindDeviceData = (JSONObject) bindDeviceRet.get("data");
//                String code = bindDeviceRet.getString("code");
//
//                if (bindDeviceInfo != null && code.equals("0")) {
//
//                } else {
//                    logger.info("31344-设备托管操作-INTERNAL_SERVER_ERROR-3");
//                    setResponseCode(BusinessErrorCode.INTERNAL_SERVER_ERROR);
//                    setResponseDesc(bindDeviceRet.getString("msg"));
//                    return;
//                }
//
//                //发起托管
//                Map<String, Object> totalMap = new HashMap<String, Object>();
//                totalMap.put("ownerId", user.getId());
//                totalMap.put("ownerEmail", user.getEmail());
//                totalMap.put("deviceId", deviceCode);
//                totalMap.put("functions", functions);
//                totalMap.put("companyCode", account);
//                totalMap.put("depositPeriod", Integer.valueOf(endTime));
//                totalMap.put("ownerName", user.getNickName());
//                totalMap.put("ownerPicUrl", user.getAvatarUrl());
//                totalMap.put("ability", bindDeviceData.getString("ability"));
//                totalMap.put("deviceModel", bindDeviceData.getString("deviceModel"));
//                totalMap.put("deviceName", bindDeviceData.getString("name"));
//                totalMap.put("deviceCatalog", bindDeviceData.getString("deviceCatalog"));
//                totalMap.put("linkStatus", 0);
//                totalMap.put("depositCountry", user.getCountryIsoCode());
//                totalMap.put("devUsername", devName);
//                totalMap.put("devPassword", devPassword);
//                JSONObject resultJson = businessManager.smbWebService.applyForShareDevice(totalMap);
//                if (resultJson.containsKey("code") && resultJson.getString("code").equals("0")) {
//                    subscribeDeviceErrorCheck(deviceCode, devName, devPassword);
//                    setResponseCode(BusinessErrorCode.SUCCESS);
//                } else {
//                    logger.info("31344-设备托管操作-INTERNAL_SERVER_ERROR-4");
//                    setResponseCode(BusinessErrorCode.INTERNAL_SERVER_ERROR);
//                    setResponseDesc(resultJson.getString("errMsg"));
//                }
//            }
//            //托管续期
//            else if (operateType.equals("2")) {
//
//                //查询设备信息
//                Map<String, Object> bindDeviceParam = new HashMap<>();
//                bindDeviceParam.put("deviceId", deviceCode);
//                bindDeviceParam.put("token", user.getOpenUserToken()/*"Ut_37ef8edbf7124c028c39edb6dfbd9f6d"*/);
//
//                JSONObject bindDeviceInfo = businessManager.userManager.bindDeviceInfo(bindDeviceParam, appId);
//                JSONObject bindDeviceRet = (JSONObject) bindDeviceInfo.get("result");
//                JSONObject bindDeviceData = (JSONObject) bindDeviceRet.get("data");
//                String code = bindDeviceRet.getString("code");
//
//                String dName = null;
//                if (bindDeviceInfo != null && code.equals("0")) {
//                    dName = bindDeviceData.getString("name");
//                }
//
//                Map<String, Object> data = new HashMap<>();
//                JSONArray array = new JSONArray();
//                array.add(deviceCode);
//                data.put("deviceId", array);
//                data.put("companyId", Integer.valueOf(account));
//                data.put("cancelShareFlag", false);
//                data.put("endTime", Integer.valueOf(endTime));
//                data.put("ownerId", user.getId());
//                data.put("depositCountry", user.getCountryIsoCode());
//
//                if (dName != null) {
//                    data.put("deviceName", dName);//续期的时候可能会被修改名称
//                }
//                JSONObject jsonObject = businessManager.smbWebService.updateShareEndDate(data);
//                if (jsonObject != null && jsonObject.containsKey("code") && jsonObject.getString("code").equals("0") && jsonObject.containsKey("data")) {
//                    setResponseCode(BusinessErrorCode.SUCCESS);
//                } else {
//                    setResponseCode(BusinessErrorCode.INTERNAL_SERVER_ERROR);
//                    setResponseDesc(jsonObject.getString("errMsg"));
//                }
//            }
//            //重新托管
//            else if (operateType.equals("3")) {
//                //查询设备信息
//                Map<String, Object> bindDeviceParam = new HashMap<>();
//                bindDeviceParam.put("deviceId", deviceCode);
//                bindDeviceParam.put("token", user.getOpenUserToken()/*"Ut_37ef8edbf7124c028c39edb6dfbd9f6d"*/);
//
//                JSONObject bindDeviceInfo = businessManager.userManager.bindDeviceInfo(bindDeviceParam, appId);
//                JSONObject bindDeviceRet = (JSONObject) bindDeviceInfo.get("result");
//                JSONObject bindDeviceData = (JSONObject) bindDeviceRet.get("data");
//                String code = bindDeviceRet.getString("code");
//
//                String dName = null;
//                if (bindDeviceInfo != null && code.equals("0")) {
//                    dName = bindDeviceData.getString("name");
//                }
//
//                functions = requestData.getString("functions");
//                Map<String, Object> data = new HashMap<>();
//                JSONArray array = new JSONArray();
//                array.add(deviceCode);
//                data.put("deviceId", array);
//                data.put("companyId", Integer.valueOf(account));
//                data.put("cancelShareFlag", false);
//                data.put("endTime", Integer.valueOf(endTime));
//                data.put("functions", functions);
//                data.put("ownerId", user.getId());
//                data.put("depositCountry", user.getCountryIsoCode());
//
//                if (dName != null) {
//                    data.put("deviceName", dName);//续期的时候可能会被修改名称
//                }
//                JSONObject jsonObject = businessManager.smbWebService.updateShareEndDate(data);
//                if (jsonObject != null && jsonObject.containsKey("code") && jsonObject.getString("code").equals("0") && jsonObject.containsKey("data")) {
//                    setResponseCode(BusinessErrorCode.SUCCESS);
//                } else {
//                    setResponseCode(BusinessErrorCode.INTERNAL_SERVER_ERROR);
//                    setResponseDesc(jsonObject.getString("errMsg"));
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("rest api error:", e);
//            setResponseCode(BusinessErrorCode.INTERNAL_SERVER_ERROR);
//            return;
//        }
//    }
//
//    /**
//     * 订阅故障检测
//     *
//     * @param deviceId
//     * @param devName
//     * @param devPassword
//     */
//    private void subscribeDeviceErrorCheck(String deviceId, String devName, String devPassword) {
//        try {
//            List<String> deviceCodeList = Lists.newArrayList("StorageFailure", "StorageNotExist", "UnderVoltage", "OverVoltage",
//                    "VideoUnFocus", "HDDTemperatureAlarm", "FanSpeedAlarm",
//                    "StorageLowSpace", "NetMonitorAbort", "VideoLoss", "callEvent","SceneChange",
//                    "VideoUnFocus", "LeftDetection","TakenAwayDetection","ProfileAlarmTransmit",
//                    "FaceRecognition","TrafficJunction","AlarmIPC","VideoTalkLog","NumberStatDeviceSummary",
//                    "MoveDetection","ObjectPlacementDetection","ObjectRemovalDetection","CrowdDetection","AlarmNet","WanderDetection",
//                    "SmokingDetect","PhoneCallDetect","FireWarning","AnatomyTempDetect","SCADADevAlarm");
//            List<JSONObject> collect = deviceCodeList.stream().map(deviceCode -> {
//                JSONObject json = new JSONObject();
//                json.put("deviceCode", deviceCode);
//                //需要图片地址事件
//                if("FaceRecognition".equalsIgnoreCase(deviceCode) || "TrafficJunction".equalsIgnoreCase(deviceCode)
//                        || "AnatomyTempDetect".equalsIgnoreCase(deviceCode)){
//                    json.put("pictureMask", "*");
//                    json.put("messageMask", "0");
//                }else{
//                    json.put("pictureMask", "0");
//                    json.put("messageMask", "*");
//                }
//                return json;
//            }).collect(Collectors.toList());
//            JSONArray jsonArray = JSONArray.parseArray(collect.toString());
//            JSONObject content = new JSONObject();
//            content.put("events", jsonArray);
//
//            Map<String, Object> data = new HashMap<String, Object>();
//            data.put("deviceId", deviceId);
//            data.put("token", user.getOpenUserToken());
//            data.put("type", "EventFilter");
//            data.put("devName", devName);
//            data.put("devPassword", devPassword);
//            data.put("content", Base64Util.encode(content.toJSONString().getBytes()));
//            JSONObject retData = businessManager.userManager.deviceThrough(data, appId);
//            JSONObject retJSON = (JSONObject) retData.get("result");
//            JSONObject dataJSON = (JSONObject) retJSON.get("data");
//            String code = retJSON.getString("code");
//            //{"result":{"msg":"Operation is successful.","code":"0","data":{}},"id":"geck88n50z3knnpkrkmifkspxaikrkg4"}
//            if (retData != null && code.equals("0")) {
//                logger.info("lc subscribeDeviceErrorCheck success");
//            } else {
//                logger.info("lc subscribeDeviceErrorCheck fail");
//            }
//
//        } catch (Exception e) {
//            logger.info(deviceId + "---subscribeDeviceErrorCheck fail");
//            e.printStackTrace();
//        }
//    }
//
//    private boolean isSupportAsyncCheck(String deviceId, String devName, String devPassword) throws Exception {
//        Map<String, Object> data = new HashMap<String, Object>();
//        data.put("deviceId", deviceId);
//        data.put("token", user.getOpenUserToken());
//        data.put("type", "DHPri");
//        data.put("devName", devName);
//        data.put("devPassword", devPassword);
//        JSONObject content = new JSONObject();
//        content.put("method", "FaultCheck.getCaps");
//        content.put("params", null);
//        content.put("session", null);
//        content.put("id", null);
//        data.put("content", Base64Util.encode(content.toJSONString().getBytes()));
//        JSONObject retData = businessManager.userManager.deviceThrough(data, appId);
//        JSONObject retJSON = (JSONObject) retData.get("result");
//        JSONObject dataJSON = (JSONObject) retJSON.get("data");
//        String code = retJSON.getString("code");
//        if (retData != null && code.equals("0") && dataJSON.containsKey("content")) {
//            String contentStr = dataJSON.getString("content");
//            JSONObject contentJSON = JSONObject.parseObject(new String(Base64Util.decode(contentStr.toCharArray())));
//            logger.info("contentJSON=" + contentJSON);
//            boolean devResult = contentJSON.getBoolean("result");
//            if (devResult) {
//                JSONObject paramsJSON = (JSONObject) contentJSON.get("params");
//                Boolean isSupportAsyncCheck = (Boolean) paramsJSON.get("SupportAsyncCheck");
//                logger.info("isSupportAsyncCheck=" + isSupportAsyncCheck);
//                return isSupportAsyncCheck;
//            } else {
//                logger.info("device accessControlManager.getCaps fail");
//            }
//        } else {
//            logger.info("lc accessControlManager.getCaps fail");
//        }
//
//        return false;
//    }
//}
