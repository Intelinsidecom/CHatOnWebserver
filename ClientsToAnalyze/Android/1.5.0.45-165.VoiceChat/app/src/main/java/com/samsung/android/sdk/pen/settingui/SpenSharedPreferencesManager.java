package com.samsung.android.sdk.pen.settingui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.google.protobuf.CodedOutputStream;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class SpenSharedPreferencesManager {
    public static final String CURRENT_PEN = "CURRENT";
    public static final String PEN_ADVANCE = "_PEN_ADVANCE";
    public static final String PEN_COLOR = "_PEN_COLOR";
    public static final String PEN_NAME = "_PEN_NAME";
    public static final String PEN_SIZE = "_PEN_SIZE";
    public static final String PRESET_FILE_PATH = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + "/.SPenSDK30/preset";
    public static final String PRESET_IMAGE = "_PRESET_IMAGE";
    public static final String PRESET_ORDER = "PRESET";
    public static final String PRESET_PRE = "_PRESET_";
    private final SPenImageUtil mDrawableImg;
    private final String mPackageName;
    private final ArrayList<SpenPenPluginInfo> mPenPluginInfoList;
    private ArrayList<SpenPenPresetInfo> mPresetInfoList;
    private final SharedPreferences mSharedPreferences;
    private final SharedPreferences.Editor mSharedPreferencesEditor;

    SpenSharedPreferencesManager(Context context, ArrayList<SpenPenPluginInfo> penPluginInfoList, float scale) {
        this.mPackageName = context.getPackageName();
        this.mSharedPreferences = context.getSharedPreferences(this.mPackageName, 0);
        this.mSharedPreferencesEditor = this.mSharedPreferences.edit();
        this.mPenPluginInfoList = penPluginInfoList;
        this.mDrawableImg = new SPenImageUtil(context, "", scale);
    }

    private void setPenData(SpenSettingPenInfo mPenData, String key) {
        this.mSharedPreferencesEditor.putString(String.valueOf(key) + PEN_NAME, mPenData.name);
        this.mSharedPreferencesEditor.putFloat(String.valueOf(key) + PEN_SIZE, mPenData.size);
        this.mSharedPreferencesEditor.putInt(String.valueOf(key) + PEN_COLOR, mPenData.color);
        this.mSharedPreferencesEditor.putString(String.valueOf(key) + PEN_ADVANCE, mPenData.advancedSetting);
        this.mSharedPreferencesEditor.commit();
    }

    private SpenSettingPenInfo getPenData(String penName) {
        if (this.mSharedPreferences.contains(String.valueOf(penName) + PEN_NAME)) {
            SpenSettingPenInfo penData = new SpenSettingPenInfo();
            penData.name = this.mSharedPreferences.getString(String.valueOf(penName) + PEN_NAME, "");
            penData.size = this.mSharedPreferences.getFloat(String.valueOf(penName) + PEN_SIZE, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            penData.color = this.mSharedPreferences.getInt(String.valueOf(penName) + PEN_COLOR, 0);
            penData.advancedSetting = this.mSharedPreferences.getString(String.valueOf(penName) + PEN_ADVANCE, "");
            return penData;
        }
        return null;
    }

    public void clearSharedPenData() {
        this.mSharedPreferencesEditor.clear();
        this.mSharedPreferencesEditor.commit();
    }

    public void setCurrentPenName(String currentpenName) {
        this.mSharedPreferencesEditor.putString("CURRENT_PEN_NAME", currentpenName);
        this.mSharedPreferencesEditor.commit();
    }

    public void setPenDataList(ArrayList<SpenSettingPenInfo> penData) {
        for (int i = 0; i < penData.size(); i++) {
            setPenData(penData.get(i), penData.get(i).name);
        }
    }

    public ArrayList<SpenSettingPenInfo> getPenDataList() {
        ArrayList<SpenSettingPenInfo> localPenDataList = new ArrayList<>();
        Iterator<SpenPenPluginInfo> iterator = this.mPenPluginInfoList.iterator();
        while (iterator.hasNext()) {
            SpenPenPluginInfo penPluginInfo = iterator.next();
            String localPenName = penPluginInfo.getPenName();
            SpenSettingPenInfo localPenData = getPenData(localPenName);
            if (localPenData != null) {
                localPenDataList.add(localPenData);
            }
        }
        return localPenDataList;
    }

    public String getCurrentPenName() {
        if (!this.mSharedPreferences.contains("CURRENT_PEN_NAME")) {
            return null;
        }
        String penName = this.mSharedPreferences.getString("CURRENT_PEN_NAME", null);
        return penName;
    }

    public void removeCurrentPenData() {
        this.mSharedPreferencesEditor.remove("CURRENT_PEN_NAME");
        this.mSharedPreferencesEditor.commit();
    }

    public ArrayList<SpenPenPresetInfo> getPresetData() throws IOException {
        byte[] bytes;
        int size;
        try {
            FileInputStream is = new FileInputStream(new File(PRESET_FILE_PATH));
            try {
                bytes = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
                size = 0;
                try {
                    try {
                        size = is.read(bytes);
                        if (is != null) {
                            try {
                                is.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (Throwable th) {
                        if (is != null) {
                            try {
                                is.close();
                            } catch (IOException e2) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e4) {
                        }
                    }
                }
            } catch (NullPointerException e5) {
            }
        } catch (FileNotFoundException e6) {
            return null;
        } catch (NullPointerException e7) {
        }
        if (size < 0) {
            return null;
        }
        String[] buffer = new String(bytes, 0, size, Charset.forName("UTF-8")).split("\n");
        if (this.mPresetInfoList == null) {
            this.mPresetInfoList = new ArrayList<>();
        }
        for (int i = 1; i <= Integer.parseInt(buffer[0], 10); i++) {
            try {
                SpenPenPresetInfo presetInfo = new SpenPenPresetInfo();
                String[] token = buffer[i].split(" ");
                presetInfo.setPresetOrder(i - 1);
                presetInfo.setBitmapSize(this.mDrawableImg.getIntValueAppliedDensity(65.0f), this.mDrawableImg.getIntValueAppliedDensity(65.0f));
                presetInfo.setPenName(token[0]);
                presetInfo.setPenSize(Float.parseFloat(token[1]));
                presetInfo.setColor(Integer.parseInt(token[2]));
                presetInfo.setPresetImageName(token[3]);
                if (token.length >= 5) {
                    presetInfo.setAdvancedSetting(token[4]);
                }
                this.mPresetInfoList.add(presetInfo);
            } catch (ArrayIndexOutOfBoundsException e8) {
            }
        }
        return this.mPresetInfoList;
    }

    public void setPresetData(List<SpenPenPresetInfo> mList) throws IOException {
        if (mList != null) {
            try {
                String buffer = String.valueOf(mList.size());
                try {
                    FileOutputStream os = new FileOutputStream(new File(PRESET_FILE_PATH));
                    for (int i = 0; i < mList.size(); i++) {
                        try {
                            try {
                                SpenPenPresetInfo presetData = mList.get(i);
                                buffer = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(buffer) + "\n") + presetData.getPenName() + " ") + Float.toString(presetData.getPenSize()) + " ") + Integer.toString(presetData.getColor()) + " ") + presetData.getPresetImageName() + " ") + presetData.getAdvancedSetting();
                            } catch (Throwable th) {
                                if (os != null) {
                                    try {
                                        os.close();
                                    } catch (IOException e) {
                                        return;
                                    }
                                }
                                throw th;
                            }
                        } catch (NullPointerException e2) {
                            return;
                        }
                    }
                    try {
                        os.write(buffer.getBytes(Charset.forName("UTF-8")), 0, buffer.length());
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        if (os != null) {
                            try {
                                os.close();
                            } catch (IOException e4) {
                            }
                        }
                    }
                    if (os != null) {
                        try {
                            os.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (FileNotFoundException e6) {
                }
            } catch (NullPointerException e7) {
            }
        }
    }
}
