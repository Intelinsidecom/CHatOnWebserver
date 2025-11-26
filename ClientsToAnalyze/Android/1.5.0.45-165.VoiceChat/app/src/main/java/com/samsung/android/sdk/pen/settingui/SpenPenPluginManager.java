package com.samsung.android.sdk.pen.settingui;

import android.content.Context;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginInfo;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
class SpenPenPluginManager {
    private int mPenNumber;
    private final ArrayList<SpenPenPluginInfo> mPenPluginInfoList = new ArrayList<>();
    private SpenPluginManager mPluginManager;

    public SpenPenPluginManager(SpenPluginManager pluginManager) {
        this.mPluginManager = null;
        this.mPluginManager = pluginManager;
        initPenPlugin();
    }

    private void initPenPlugin() {
        if (this.mPluginManager != null) {
            List<SpenPluginInfo> list = this.mPluginManager.getPluginList("Pen");
            this.mPenNumber = 0;
            for (SpenPluginInfo pluginInfo : list) {
                SpenPenPluginInfo penPluginInfo = new SpenPenPluginInfo(pluginInfo);
                if (penPluginInfo != null) {
                    penPluginInfo.setName(pluginInfo);
                    this.mPenPluginInfoList.add(penPluginInfo);
                    this.mPenNumber++;
                }
            }
        }
    }

    public int getPenCount() {
        return this.mPenNumber;
    }

    public int getPenPluginIndexByPenName(String penName) {
        if (this.mPenPluginInfoList == null) {
            return -1;
        }
        Iterator<SpenPenPluginInfo> iterator = this.mPenPluginInfoList.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            SpenPenPluginInfo penPluginInfo = iterator.next();
            if (penPluginInfo != null) {
                String localPenName = new String(penPluginInfo.getPenName());
                if (!localPenName.equals(penName)) {
                    index++;
                } else {
                    return index;
                }
            }
        }
        return -1;
    }

    public int getPenPluginIndexByPackageName(String packageName) {
        if (this.mPenPluginInfoList == null) {
            return -1;
        }
        Iterator<SpenPenPluginInfo> iterator = this.mPenPluginInfoList.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            SpenPenPluginInfo penPluginInfo = iterator.next();
            if (penPluginInfo != null) {
                String localPenName = new String(penPluginInfo.getPackageName());
                if (!localPenName.equals(packageName)) {
                    index++;
                } else {
                    return index;
                }
            }
        }
        return -1;
    }

    public ArrayList<SpenPenPluginInfo> getPenPluginInfoList() {
        return this.mPenPluginInfoList;
    }

    public void setPluginManager(SpenPluginManager pluginManager) {
        this.mPluginManager = pluginManager;
    }

    public void loadPenPlugin(Context context, String penName) {
        if (this.mPenPluginInfoList != null && this.mPluginManager != null) {
            Iterator<SpenPenPluginInfo> iterator = this.mPenPluginInfoList.iterator();
            while (iterator.hasNext()) {
                SpenPenPluginInfo penPluginInfo = iterator.next();
                if (penPluginInfo != null) {
                    String localPenName = new String(penPluginInfo.getPenName());
                    if (localPenName.equals(penName)) {
                        if (penPluginInfo.getPenPluginObject() == null) {
                            try {
                                penPluginInfo.setPenPluginObject((SpenPenInterface) this.mPluginManager.loadPlugin(context, penPluginInfo.getPluginInfo(), ""));
                                return;
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                                return;
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                                return;
                            } catch (InstantiationException e3) {
                                e3.printStackTrace();
                                return;
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    public void installPenPlugin(String packageName) {
        if (this.mPluginManager != null && packageName != null) {
            LinkedList<SpenPluginInfo> list = (LinkedList) this.mPluginManager.getPluginList("Pen");
            Iterator<SpenPluginInfo> iterator = list.iterator();
            while (iterator.hasNext()) {
                SpenPluginInfo pluginInfo = iterator.next();
                if (pluginInfo != null) {
                    String localPackageName = new String(pluginInfo.packageName);
                    if (localPackageName.equals(packageName)) {
                        SpenPenPluginInfo penPluginInfo = new SpenPenPluginInfo(pluginInfo);
                        penPluginInfo.setName(pluginInfo);
                        this.mPenPluginInfoList.add(penPluginInfo);
                        this.mPenNumber++;
                        return;
                    }
                }
            }
        }
    }

    public void uninstallPenPlugin(String packageName) {
        if (this.mPenPluginInfoList != null && packageName != null) {
            Iterator<SpenPenPluginInfo> iterator = this.mPenPluginInfoList.iterator();
            while (iterator.hasNext()) {
                SpenPenPluginInfo localPenPluginInfo = iterator.next();
                if (localPenPluginInfo != null) {
                    String localPackageName = new String(localPenPluginInfo.getPackageName());
                    if (localPackageName.equals(packageName)) {
                        this.mPenPluginInfoList.remove(localPenPluginInfo);
                        this.mPenNumber--;
                        return;
                    }
                }
            }
        }
    }
}
