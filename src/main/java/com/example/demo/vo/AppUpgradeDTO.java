package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUpgradeDTO implements Serializable {

    /**
     * 0-不需要强制更新，1-强制更新
     */
    private Integer forceUpgrade;

    /**
     * 最新版本
     */
    private String latestVersion;

    /** 生效时间，时间戳，为空表示立即生效 */
    private Long effectiveTime;

}
