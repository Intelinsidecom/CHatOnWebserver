package com.samsung.android.sdk.pen.recognition;

import android.content.Context;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginInfo;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognitionInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class SpenRecognitionManager {
    private static final int INPUT_TYPE_INDEX = 0;
    private static final int OUTPUT_TYPE_INDEX = 1;
    private ArrayList<SpenPluginInfo> mPluginList = null;
    private SpenPluginManager mPluginManager;

    protected SpenRecognitionManager(Context context) {
        this.mPluginManager = null;
        if (context == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
        }
        this.mPluginManager = SpenPluginManager.getInstance(context);
    }

    protected List<SpenRecognitionInfo> getInfoList(String type) {
        List<SpenPluginInfo> typeMatchedList = this.mPluginManager.getPluginList(type);
        if (typeMatchedList == null) {
            return null;
        }
        ArrayList<SpenPluginInfo> tempList = new ArrayList<>();
        ArrayList<SpenRecognitionInfo> outputList = new ArrayList<>();
        for (SpenPluginInfo pluginInfo : typeMatchedList) {
            if (pluginInfo.interfaceName.equals("SpenRecognitionInterface")) {
                String[] extraInfoArray = pluginInfo.extraInfo.split("/");
                if (extraInfoArray.length >= 2) {
                    tempList.add(pluginInfo);
                    SpenRecognitionInfo recognitionInfo = new SpenRecognitionInfo();
                    recognitionInfo.name = pluginInfo.pluginNameUri;
                    recognitionInfo.version = pluginInfo.version;
                    recognitionInfo.className = String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName;
                    recognitionInfo.hasPrivateKey = pluginInfo.hasPrivateKey;
                    recognitionInfo.iconImageUri = pluginInfo.iconImageUri;
                    recognitionInfo.inputType = Integer.parseInt(extraInfoArray[0]);
                    recognitionInfo.outputType = Integer.parseInt(extraInfoArray[1]);
                    outputList.add(recognitionInfo);
                }
            }
        }
        if (this.mPluginList != null && !this.mPluginList.isEmpty()) {
            this.mPluginList.clear();
        }
        this.mPluginList = tempList;
        return outputList;
    }

    protected List<SpenRecognitionInfo> getInfoList(String type, int inputType, int outputType) throws NumberFormatException {
        List<SpenPluginInfo> typeMatchedList = this.mPluginManager.getPluginList(type);
        if (typeMatchedList == null) {
            return null;
        }
        ArrayList<SpenPluginInfo> tempList = new ArrayList<>();
        ArrayList<SpenRecognitionInfo> outputList = new ArrayList<>();
        for (SpenPluginInfo pluginInfo : typeMatchedList) {
            String[] extraInfoArray = pluginInfo.extraInfo.split("/");
            if (extraInfoArray.length >= 2) {
                int pluginInputType = Integer.parseInt(extraInfoArray[0]);
                int pluginOutputType = Integer.parseInt(extraInfoArray[1]);
                if (inputType == pluginInputType && outputType == pluginOutputType && pluginInfo.interfaceName.equals("SpenRecognitionInterface")) {
                    tempList.add(pluginInfo);
                    SpenRecognitionInfo recognitionInfo = new SpenRecognitionInfo();
                    recognitionInfo.name = pluginInfo.pluginNameUri;
                    recognitionInfo.version = pluginInfo.version;
                    recognitionInfo.className = String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName;
                    recognitionInfo.inputType = pluginInputType;
                    recognitionInfo.outputType = pluginOutputType;
                    recognitionInfo.hasPrivateKey = pluginInfo.hasPrivateKey;
                    recognitionInfo.iconImageUri = pluginInfo.iconImageUri;
                    outputList.add(recognitionInfo);
                }
            }
        }
        if (this.mPluginList != null && !this.mPluginList.isEmpty()) {
            this.mPluginList.clear();
        }
        this.mPluginList = tempList;
        return outputList;
    }

    protected List<SpenRecognitionInfo> getInfoList(String type, String interfaceName) {
        List<SpenPluginInfo> typeMatchedList = this.mPluginManager.getPluginList(type);
        if (typeMatchedList == null) {
            return null;
        }
        ArrayList<SpenPluginInfo> tempList = new ArrayList<>();
        ArrayList<SpenRecognitionInfo> outputList = new ArrayList<>();
        for (SpenPluginInfo pluginInfo : typeMatchedList) {
            if (pluginInfo.interfaceName.equals(interfaceName)) {
                String[] extraInfoArray = pluginInfo.extraInfo.split("/");
                if (extraInfoArray.length >= 2) {
                    tempList.add(pluginInfo);
                    SpenRecognitionInfo recognitionInfo = new SpenRecognitionInfo();
                    recognitionInfo.name = pluginInfo.pluginNameUri;
                    recognitionInfo.version = pluginInfo.version;
                    recognitionInfo.className = String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName;
                    recognitionInfo.hasPrivateKey = pluginInfo.hasPrivateKey;
                    recognitionInfo.iconImageUri = pluginInfo.iconImageUri;
                    recognitionInfo.inputType = Integer.parseInt(extraInfoArray[0]);
                    recognitionInfo.outputType = Integer.parseInt(extraInfoArray[1]);
                    outputList.add(recognitionInfo);
                }
            }
        }
        if (this.mPluginList != null && !this.mPluginList.isEmpty()) {
            this.mPluginList.clear();
        }
        this.mPluginList = tempList;
        return outputList;
    }

    protected List<SpenRecognitionInfo> getInfoList(String type, int inputType, int outputType, String interfaceName) throws NumberFormatException {
        List<SpenPluginInfo> typeMatchedList = this.mPluginManager.getPluginList(type);
        if (typeMatchedList == null) {
            return null;
        }
        ArrayList<SpenPluginInfo> tempList = new ArrayList<>();
        ArrayList<SpenRecognitionInfo> outputList = new ArrayList<>();
        for (SpenPluginInfo pluginInfo : typeMatchedList) {
            String[] extraInfoArray = pluginInfo.extraInfo.split("/");
            if (extraInfoArray.length >= 2) {
                int pluginInputType = Integer.parseInt(extraInfoArray[0]);
                int pluginOutputType = Integer.parseInt(extraInfoArray[1]);
                if (inputType == pluginInputType && outputType == pluginOutputType && pluginInfo.interfaceName.equals(interfaceName)) {
                    tempList.add(pluginInfo);
                    SpenRecognitionInfo recognitionInfo = new SpenRecognitionInfo();
                    recognitionInfo.name = pluginInfo.pluginNameUri;
                    recognitionInfo.version = pluginInfo.version;
                    recognitionInfo.className = String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName;
                    recognitionInfo.inputType = pluginInputType;
                    recognitionInfo.outputType = pluginOutputType;
                    recognitionInfo.hasPrivateKey = pluginInfo.hasPrivateKey;
                    recognitionInfo.iconImageUri = pluginInfo.iconImageUri;
                    outputList.add(recognitionInfo);
                }
            }
        }
        if (this.mPluginList != null && !this.mPluginList.isEmpty()) {
            this.mPluginList.clear();
        }
        this.mPluginList = tempList;
        return outputList;
    }

    protected String getPrivateKeyHint(SpenRecognitionInfo info) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        if (this.mPluginList == null) {
            throw new IllegalStateException("E_INVALID_STATE : candidateList is not made yet");
        }
        Iterator<SpenPluginInfo> iterator = this.mPluginList.iterator();
        while (iterator.hasNext()) {
            SpenPluginInfo pluginInfo = iterator.next();
            if (info.className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName) && info.name.equals(pluginInfo.pluginNameUri) && info.version == pluginInfo.version) {
                return this.mPluginManager.getPrivateKeyHint(pluginInfo);
            }
        }
        throw new ClassNotFoundException("Can not find " + info.name + " Recognition");
    }

    protected SpenRecognitionInterface createPluginObject(Context context, SpenRecognitionInfo info, String key) throws Exception {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        if (this.mPluginList == null) {
            throw new IllegalStateException("E_INVALID_STATE : candidateList is not made yet");
        }
        Iterator<SpenPluginInfo> iterator = this.mPluginList.iterator();
        while (iterator.hasNext()) {
            SpenPluginInfo pluginInfo = iterator.next();
            if (info.className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName) && info.name.equals(pluginInfo.pluginNameUri) && info.version == pluginInfo.version) {
                return (SpenRecognitionInterface) this.mPluginManager.loadPlugin(context, pluginInfo, key);
            }
        }
        throw new ClassNotFoundException("Can not find " + info.name + " Recognition");
    }

    protected void destroyPluginObject(SpenRecognitionInterface pluginObject) {
        this.mPluginManager.unloadPlugin(pluginObject);
    }

    protected void close() {
        this.mPluginManager = null;
        if (this.mPluginList != null) {
            if (!this.mPluginList.isEmpty()) {
                this.mPluginList.clear();
            }
            this.mPluginList = null;
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        this.mPluginManager = null;
        if (this.mPluginList != null) {
            if (!this.mPluginList.isEmpty()) {
                this.mPluginList.clear();
            }
            this.mPluginList = null;
        }
    }
}
