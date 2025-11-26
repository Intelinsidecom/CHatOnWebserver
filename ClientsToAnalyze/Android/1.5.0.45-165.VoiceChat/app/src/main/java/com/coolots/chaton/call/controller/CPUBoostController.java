package com.coolots.chaton.call.controller;

import android.os.DVFSHelper;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class CPUBoostController {
    private DVFSHelper cpuBooster = null;

    public void logE(String message) {
        Log.m2958e("[CPUBoostController]" + message);
    }

    public void logI(String message) {
        Log.m2963i("[CPUBoostController]" + message);
    }

    public boolean acquireDVFSHelper() {
        logI("acquireDVFSHelper()");
        if (!MainApplication.mConfig.isCPUBoost()) {
            return false;
        }
        if (this.cpuBooster == null) {
            try {
                this.cpuBooster = new DVFSHelper(MainApplication.mContext, 12);
                int[] supportedCPUFreqTable = this.cpuBooster.getSupportedCPUFrequency();
                logI("supportedCPUFreqTable getApproximateCPUFrequency() : " + this.cpuBooster.getApproximateCPUFrequency(1300000));
                if (supportedCPUFreqTable != null) {
                    logI("supportedCPUFreqTable length = " + supportedCPUFreqTable.length);
                    String str = "";
                    for (int freq : supportedCPUFreqTable) {
                        str = String.valueOf(str) + freq + " ";
                    }
                    logI("supportedCPUFreqTable : " + str);
                    this.cpuBooster.addExtraOption("CPU", this.cpuBooster.getApproximateCPUFrequency(1300000));
                } else {
                    logI("cpuBooster supportedCPUFreqTable is null");
                    this.cpuBooster = null;
                }
            } catch (Exception e) {
                logI("acquireMinimumCpuLock Exception Occur : " + e.toString());
                this.cpuBooster = null;
            } catch (NoSuchMethodError e2) {
                logI("acquireMinimumCpuLock NoSuchMethodError : " + e2.toString());
                this.cpuBooster = null;
            }
        }
        if (this.cpuBooster == null) {
            return false;
        }
        this.cpuBooster.acquire();
        return true;
    }

    public void releaseDVFSHelper() {
        logI("releaseDVFSHelper()");
        if (MainApplication.mConfig.isCPUBoost() && this.cpuBooster != null) {
            this.cpuBooster.release();
            this.cpuBooster = null;
        }
    }
}
