package practise.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class test0 {
    public static void main(String[] args) {
        String jsString = "{\n" +
                "    \"result\":true,\n" +
                "    \"session\":499161238,\n" +
                "    \"id\":545,\n" +
                "    \"params\":[\n" +
                "        {\n" +
                "            \"result\":true,\n" +
                "            \"id\":1,\n" +
                "            \"params\":{\n" +
                "                \"table\":[\n" +
                "                    [\n" +
                "                        {\n" +
                "                            \"Type\":\"CrossRegionDetection\",\n" +
                "                            \"Config\":{\n" +
                "                                \"Action\":[\n" +
                "                                    \"Cross\",\n" +
                "                                    \"Appear\"\n" +
                "                                ],\n" +
                "                                \"DetectRegion\":[\n" +
                "                                    [\n" +
                "                                        879,\n" +
                "                                        0\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        0,\n" +
                "                                        2984\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        138,\n" +
                "                                        8191\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        8191,\n" +
                "                                        8143\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        8191,\n" +
                "                                        2540\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        6532,\n" +
                "                                        0\n" +
                "                                    ]\n" +
                "                                ],\n" +
                "                                \"MinTargets\":1,\n" +
                "                                \"Sensitivity\":10,\n" +
                "                                \"MaxTargets\":100,\n" +
                "                                \"ReportInterval\":1,\n" +
                "                                \"MinDuration\":1,\n" +
                "                                \"SizeFilter\":{\n" +
                "                                    \"MinSize\":[\n" +
                "                                        0,\n" +
                "                                        0\n" +
                "                                    ],\n" +
                "                                    \"Type\":\"ByLength\",\n" +
                "                                    \"CalibrateBoxs\":[\n" +
                "                                        {\n" +
                "                                            \"CenterPoint\":[\n" +
                "                                                4096,\n" +
                "                                                4096\n" +
                "                                            ],\n" +
                "                                            \"Ratio\":1\n" +
                "                                        }\n" +
                "                                    ],\n" +
                "                                    \"MaxSize\":[\n" +
                "                                        8191,\n" +
                "                                        8191\n" +
                "                                    ]\n" +
                "                                },\n" +
                "                                \"Direction\":\"Enter\",\n" +
                "                                \"TrackDuration\":30,\n" +
                "                                \"AccuracySnap\":{\n" +
                "                                    \"HumanBody\":true,\n" +
                "                                    \"Normal\":true\n" +
                "                                }\n" +
                "                            },\n" +
                "                            \"TrackEnable\":false,\n" +
                "                            \"Enable\":true,\n" +
                "                            \"EventHandler\":{\n" +
                "                                \"MailEnable\":false,\n" +
                "                                \"MessageEnable\":false,\n" +
                "                                \"BeepEnable\":false,\n" +
                "                                \"Dejitter\":30,\n" +
                "                                \"LogEnable\":false,\n" +
                "                                \"AlarmOutChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"SnapshotEnable\":true,\n" +
                "                                \"Delay\":30,\n" +
                "                                \"RecordLatch\":10,\n" +
                "                                \"PtzLinkEnable\":false,\n" +
                "                                \"ExAlarmOutEnable\":false,\n" +
                "                                \"TourChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"VoiceEnable\":false,\n" +
                "                                \"OnVideoMessageEnable\":false,\n" +
                "                                \"ExAlarmOutChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"AlarmOutEnable\":false,\n" +
                "                                \"LightingLink\":{\n" +
                "                                    \"FilckerTimes\":1,\n" +
                "                                    \"LightDuration\":10,\n" +
                "                                    \"Enable\":true,\n" +
                "                                    \"FilckerIntevalTime\":0,\n" +
                "                                    \"LightLinkType\":\"Filcker\",\n" +
                "                                    \"FilckerLightType\":\"WhiteLight\"\n" +
                "                                },\n" +
                "                                \"MatrixEnable\":false,\n" +
                "                                \"AlarmOutLatch\":10,\n" +
                "                                \"LedLink\":{\n" +
                "                                    \"Enable\":false\n" +
                "                                },\n" +
                "                                \"SnapshotPeriod\":0,\n" +
                "                                \"RecordChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"SnapshotChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"SnapshotTimes\":1,\n" +
                "                                \"PtzLink\":[\n" +
                "                                    [\n" +
                "                                        \"None\",\n" +
                "                                        0,\n" +
                "                                        0,\n" +
                "                                        0,\n" +
                "                                        0\n" +
                "                                    ]\n" +
                "                                ],\n" +
                "                                \"Snapshot\":0,\n" +
                "                                \"MatrixChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"TimeSection\":[\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ]\n" +
                "                                ],\n" +
                "                                \"TourEnable\":false,\n" +
                "                                \"RecordEnable\":true,\n" +
                "                                \"SnapshotTitleEnable\":true,\n" +
                "                                \"MMSEnable\":false\n" +
                "                            },\n" +
                "                            \"Class\":\"Normal\",\n" +
                "                            \"ObjectTypes\":[\n" +
                "                                \"Human\"\n" +
                "                            ],\n" +
                "                            \"Id\":3,\n" +
                "                            \"PtzPresetId\":0,\n" +
                "                            \"Name\":\"IVS-1\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Type\":\"CrossRegionDetection\",\n" +
                "                            \"Config\":{\n" +
                "                                \"Action\":[\n" +
                "                                    \"Cross\",\n" +
                "                                    \"Appear\"\n" +
                "                                ],\n" +
                "                                \"DetectRegion\":[\n" +
                "                                    [\n" +
                "                                        0,\n" +
                "                                        1272\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        338,\n" +
                "                                        2970\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        738,\n" +
                "                                        8004\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        4706,\n" +
                "                                        5348\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        7568,\n" +
                "                                        4368\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        8191,\n" +
                "                                        0\n" +
                "                                    ]\n" +
                "                                ],\n" +
                "                                \"MinTargets\":1,\n" +
                "                                \"Sensitivity\":10,\n" +
                "                                \"MaxTargets\":100,\n" +
                "                                \"ReportInterval\":1,\n" +
                "                                \"MinDuration\":1,\n" +
                "                                \"SizeFilter\":{\n" +
                "                                    \"MinSize\":[\n" +
                "                                        0,\n" +
                "                                        0\n" +
                "                                    ],\n" +
                "                                    \"Type\":\"ByLength\",\n" +
                "                                    \"CalibrateBoxs\":[\n" +
                "                                        {\n" +
                "                                            \"CenterPoint\":[\n" +
                "                                                4096,\n" +
                "                                                4096\n" +
                "                                            ],\n" +
                "                                            \"Ratio\":1\n" +
                "                                        }\n" +
                "                                    ],\n" +
                "                                    \"MaxSize\":[\n" +
                "                                        8191,\n" +
                "                                        8191\n" +
                "                                    ]\n" +
                "                                },\n" +
                "                                \"Direction\":\"Enter\",\n" +
                "                                \"TrackDuration\":30,\n" +
                "                                \"AccuracySnap\":{\n" +
                "                                    \"HumanBody\":true,\n" +
                "                                    \"Normal\":true\n" +
                "                                }\n" +
                "                            },\n" +
                "                            \"TrackEnable\":false,\n" +
                "                            \"Enable\":false,\n" +
                "                            \"EventHandler\":{\n" +
                "                                \"MailEnable\":false,\n" +
                "                                \"MessageEnable\":false,\n" +
                "                                \"BeepEnable\":false,\n" +
                "                                \"Dejitter\":30,\n" +
                "                                \"LogEnable\":false,\n" +
                "                                \"AlarmOutChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"SnapshotEnable\":true,\n" +
                "                                \"Delay\":30,\n" +
                "                                \"RecordLatch\":10,\n" +
                "                                \"PtzLinkEnable\":false,\n" +
                "                                \"ExAlarmOutEnable\":false,\n" +
                "                                \"TourChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"VoiceEnable\":false,\n" +
                "                                \"OnVideoMessageEnable\":false,\n" +
                "                                \"ExAlarmOutChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"AlarmOutEnable\":false,\n" +
                "                                \"LightingLink\":{\n" +
                "                                    \"FilckerTimes\":1,\n" +
                "                                    \"LightDuration\":10,\n" +
                "                                    \"Enable\":true,\n" +
                "                                    \"FilckerIntevalTime\":0,\n" +
                "                                    \"LightLinkType\":\"Filcker\",\n" +
                "                                    \"FilckerLightType\":\"WhiteLight\"\n" +
                "                                },\n" +
                "                                \"MatrixEnable\":false,\n" +
                "                                \"AlarmOutLatch\":10,\n" +
                "                                \"LedLink\":{\n" +
                "                                    \"Enable\":true\n" +
                "                                },\n" +
                "                                \"SnapshotPeriod\":0,\n" +
                "                                \"RecordChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"SnapshotChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"SnapshotTimes\":1,\n" +
                "                                \"PtzLink\":[\n" +
                "                                    [\n" +
                "                                        \"None\",\n" +
                "                                        0,\n" +
                "                                        0,\n" +
                "                                        0,\n" +
                "                                        0\n" +
                "                                    ]\n" +
                "                                ],\n" +
                "                                \"Snapshot\":0,\n" +
                "                                \"MatrixChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"TimeSection\":[\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ]\n" +
                "                                ],\n" +
                "                                \"TourEnable\":false,\n" +
                "                                \"RecordEnable\":true,\n" +
                "                                \"SnapshotTitleEnable\":true,\n" +
                "                                \"MMSEnable\":false\n" +
                "                            },\n" +
                "                            \"Class\":\"Normal\",\n" +
                "                            \"ObjectTypes\":[\n" +
                "                                \"Human\"\n" +
                "                            ],\n" +
                "                            \"Id\":1,\n" +
                "                            \"PtzPresetId\":0,\n" +
                "                            \"Name\":\"IVS-2\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Type\":\"CrossRegionDetection\",\n" +
                "                            \"Config\":{\n" +
                "                                \"Action\":[\n" +
                "                                    \"Cross\",\n" +
                "                                    \"Appear\"\n" +
                "                                ],\n" +
                "                                \"MinTargets\":1,\n" +
                "                                \"Sensitivity\":10,\n" +
                "                                \"MaxTargets\":100,\n" +
                "                                \"ReportInterval\":1,\n" +
                "                                \"MinDuration\":1,\n" +
                "                                \"SizeFilter\":{\n" +
                "                                    \"MinSize\":[\n" +
                "                                        0,\n" +
                "                                        0\n" +
                "                                    ],\n" +
                "                                    \"Type\":\"ByLength\",\n" +
                "                                    \"CalibrateBoxs\":[\n" +
                "                                        {\n" +
                "                                            \"CenterPoint\":[\n" +
                "                                                4096,\n" +
                "                                                4096\n" +
                "                                            ],\n" +
                "                                            \"Ratio\":1\n" +
                "                                        }\n" +
                "                                    ],\n" +
                "                                    \"MaxSize\":[\n" +
                "                                        8191,\n" +
                "                                        8191\n" +
                "                                    ]\n" +
                "                                },\n" +
                "                                \"Direction\":\"Enter\",\n" +
                "                                \"TrackDuration\":30,\n" +
                "                                \"AccuracySnap\":{\n" +
                "                                    \"HumanBody\":true,\n" +
                "                                    \"Normal\":true\n" +
                "                                }\n" +
                "                            },\n" +
                "                            \"TrackEnable\":false,\n" +
                "                            \"Enable\":false,\n" +
                "                            \"EventHandler\":{\n" +
                "                                \"MailEnable\":false,\n" +
                "                                \"MessageEnable\":false,\n" +
                "                                \"BeepEnable\":false,\n" +
                "                                \"Dejitter\":30,\n" +
                "                                \"LogEnable\":false,\n" +
                "                                \"AlarmOutChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"SnapshotEnable\":true,\n" +
                "                                \"Delay\":30,\n" +
                "                                \"RecordLatch\":10,\n" +
                "                                \"PtzLinkEnable\":false,\n" +
                "                                \"ExAlarmOutEnable\":false,\n" +
                "                                \"TourChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"VoiceEnable\":false,\n" +
                "                                \"OnVideoMessageEnable\":false,\n" +
                "                                \"ExAlarmOutChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"AlarmOutEnable\":false,\n" +
                "                                \"LightingLink\":{\n" +
                "                                    \"FilckerTimes\":1,\n" +
                "                                    \"LightDuration\":10,\n" +
                "                                    \"Enable\":true,\n" +
                "                                    \"FilckerIntevalTime\":0,\n" +
                "                                    \"LightLinkType\":\"Filcker\",\n" +
                "                                    \"FilckerLightType\":\"WhiteLight\"\n" +
                "                                },\n" +
                "                                \"MatrixEnable\":false,\n" +
                "                                \"AlarmOutLatch\":10,\n" +
                "                                \"LedLink\":{\n" +
                "                                    \"Enable\":true\n" +
                "                                },\n" +
                "                                \"SnapshotPeriod\":0,\n" +
                "                                \"RecordChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"SnapshotChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"SnapshotTimes\":1,\n" +
                "                                \"PtzLink\":[\n" +
                "                                    [\n" +
                "                                        \"None\",\n" +
                "                                        0,\n" +
                "                                        0,\n" +
                "                                        0,\n" +
                "                                        0\n" +
                "                                    ]\n" +
                "                                ],\n" +
                "                                \"Snapshot\":0,\n" +
                "                                \"MatrixChannels\":[\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"TimeSection\":[\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        \"1 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\",\n" +
                "                                        \"0 00:00:00-23:59:59\"\n" +
                "                                    ]\n" +
                "                                ],\n" +
                "                                \"TourEnable\":false,\n" +
                "                                \"RecordEnable\":true,\n" +
                "                                \"SnapshotTitleEnable\":true,\n" +
                "                                \"MMSEnable\":false\n" +
                "                            },\n" +
                "                            \"Class\":\"Normal\",\n" +
                "                            \"ObjectTypes\":[\n" +
                "                                \"Human\"\n" +
                "                            ],\n" +
                "                            \"Id\":2,\n" +
                "                            \"PtzPresetId\":0,\n" +
                "                            \"Name\":\"IVS-3\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                ]\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"result\":true,\n" +
                "            \"id\":2,\n" +
                "            \"params\":{\n" +
                "                \"table\":[\n" +
                "                    {\n" +
                "                        \"OsdTwinkleEnable\":false,\n" +
                "                        \"PtzManualEnable\":true,\n" +
                "                        \"Enable\":true,\n" +
                "                        \"EventHandler\":{\n" +
                "                            \"MailEnable\":false,\n" +
                "                            \"MessageEnable\":false,\n" +
                "                            \"BeepEnable\":false,\n" +
                "                            \"Dejitter\":30,\n" +
                "                            \"LogEnable\":true,\n" +
                "                            \"AlarmOutChannels\":[\n" +
                "                                0\n" +
                "                            ],\n" +
                "                            \"SnapshotEnable\":true,\n" +
                "                            \"Delay\":0,\n" +
                "                            \"RecordLatch\":10,\n" +
                "                            \"PtzLinkEnable\":false,\n" +
                "                            \"AlarmOut\":1,\n" +
                "                            \"ExAlarmOutEnable\":false,\n" +
                "                            \"FlashLatch\":10,\n" +
                "                            \"Matrix\":1,\n" +
                "                            \"TourChannels\":[\n" +
                "                                0\n" +
                "                            ],\n" +
                "                            \"VoiceEnable\":false,\n" +
                "                            \"ExAlarmOutChannels\":[\n" +
                "                                0\n" +
                "                            ],\n" +
                "                            \"AlarmOutEnable\":false,\n" +
                "                            \"LightingLink\":{\n" +
                "                                \"FilckerTimes\":1,\n" +
                "                                \"LightDuration\":10,\n" +
                "                                \"Enable\":false,\n" +
                "                                \"FilckerIntevalTime\":0,\n" +
                "                                \"LightLinkType\":\"Filcker\",\n" +
                "                                \"FilckerLightType\":\"WhiteLight\"\n" +
                "                            },\n" +
                "                            \"Record\":1,\n" +
                "                            \"ExAlarmOut\":1,\n" +
                "                            \"MatrixEnable\":false,\n" +
                "                            \"AlarmOutLatch\":0,\n" +
                "                            \"LedLink\":{\n" +
                "                                \"Enable\":false\n" +
                "                            },\n" +
                "                            \"TipEnable\":false,\n" +
                "                            \"Tour\":1,\n" +
                "                            \"MonitorTour\":[\n" +
                "                                {\n" +
                "                                    \"Enable\":false\n" +
                "                                },\n" +
                "                                {\n" +
                "                                    \"Enable\":false\n" +
                "                                }\n" +
                "                            ],\n" +
                "                            \"RecordChannels\":[\n" +
                "                                0\n" +
                "                            ],\n" +
                "                            \"FlashEnable\":false,\n" +
                "                            \"SnapshotChannels\":[\n" +
                "                                0\n" +
                "                            ],\n" +
                "                            \"SnapshotTimes\":1,\n" +
                "                            \"PtzLink\":[\n" +
                "                                [\n" +
                "                                    \"None\",\n" +
                "                                    0\n" +
                "                                ]\n" +
                "                            ],\n" +
                "                            \"Snapshot\":1,\n" +
                "                            \"MatrixChannels\":[\n" +
                "                                0\n" +
                "                            ],\n" +
                "                            \"TimeSection\":[\n" +
                "                                [\n" +
                "                                    \"1 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\"\n" +
                "                                ],\n" +
                "                                [\n" +
                "                                    \"1 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\"\n" +
                "                                ],\n" +
                "                                [\n" +
                "                                    \"1 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\"\n" +
                "                                ],\n" +
                "                                [\n" +
                "                                    \"1 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\"\n" +
                "                                ],\n" +
                "                                [\n" +
                "                                    \"1 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\"\n" +
                "                                ],\n" +
                "                                [\n" +
                "                                    \"1 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\"\n" +
                "                                ],\n" +
                "                                [\n" +
                "                                    \"1 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\",\n" +
                "                                    \"0 00:00:00-24:00:00\"\n" +
                "                                ]\n" +
                "                            ],\n" +
                "                            \"TourEnable\":false,\n" +
                "                            \"RecordEnable\":true\n" +
                "                        },\n" +
                "                        \"MotionDetectWindow\":[\n" +
                "                            {\n" +
                "                                \"Window\":[\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    8191,\n" +
                "                                    8191\n" +
                "                                ],\n" +
                "                                \"Region\":[\n" +
                "                                    4194303,\n" +
                "                                    4194303,\n" +
                "                                    4194303,\n" +
                "                                    4194303,\n" +
                "                                    4194303,\n" +
                "                                    4194303,\n" +
                "                                    4194303,\n" +
                "                                    4194303,\n" +
                "                                    4194179,\n" +
                "                                    4194179,\n" +
                "                                    4194179,\n" +
                "                                    4194179,\n" +
                "                                    4194183,\n" +
                "                                    4194303,\n" +
                "                                    4194303,\n" +
                "                                    4194303,\n" +
                "                                    4194303,\n" +
                "                                    4194303\n" +
                "                                ],\n" +
                "                                \"Sensitive\":60,\n" +
                "                                \"Id\":0,\n" +
                "                                \"Name\":\"Region1\",\n" +
                "                                \"Threshold\":5\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"Window\":[\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"Region\":[\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"Sensitive\":60,\n" +
                "                                \"Id\":1,\n" +
                "                                \"Name\":\"Region2\",\n" +
                "                                \"Threshold\":5\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"Window\":[\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"Region\":[\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"Sensitive\":60,\n" +
                "                                \"Id\":2,\n" +
                "                                \"Name\":\"Region3\",\n" +
                "                                \"Threshold\":5\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"Window\":[\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"Region\":[\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0,\n" +
                "                                    0\n" +
                "                                ],\n" +
                "                                \"Sensitive\":60,\n" +
                "                                \"Id\":3,\n" +
                "                                \"Name\":\"Region4\",\n" +
                "                                \"Threshold\":5\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"Region\":[\n" +
                "                            4194303,\n" +
                "                            4194303,\n" +
                "                            4194303,\n" +
                "                            4194303,\n" +
                "                            4194303,\n" +
                "                            4194303,\n" +
                "                            4194303,\n" +
                "                            4194303,\n" +
                "                            4194179,\n" +
                "                            4194179,\n" +
                "                            4194179,\n" +
                "                            4194179,\n" +
                "                            4194183,\n" +
                "                            4194303,\n" +
                "                            4194303,\n" +
                "                            4194303,\n" +
                "                            4194303,\n" +
                "                            4194303\n" +
                "                        ],\n" +
                "                        \"Sensitive\":6,\n" +
                "                        \"Level\":1,\n" +
                "                        \"PirMotionLevel\":3,\n" +
                "                        \"DetectVersion\":\"V3.0\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        JSONObject contentJSON = JSONObject.parseObject(jsString);
        JSONArray dataJSONArray = contentJSON.getJSONArray("params");
        JSONObject jsonObject1 = (JSONObject) dataJSONArray.get(1);
        JSONObject tableObject = (JSONObject) jsonObject1.getJSONObject("params").getJSONArray("table").get(0);
        //第三代程序获取字段并没有改变
        //获取版本
        String detectVersion = tableObject.getString("DetectVersion");
        detectVersion = (detectVersion != null && detectVersion.equals("V3.0")) ? "Sensitive" : "Level";
        Integer integer = tableObject.getInteger(detectVersion);
        System.out.println(integer);


    }
}
