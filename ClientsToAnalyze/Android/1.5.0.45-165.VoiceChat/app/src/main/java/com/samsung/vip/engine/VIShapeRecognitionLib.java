package com.samsung.vip.engine;

import android.util.Log;
import com.coolots.chaton.buddy.util.BuddyImageUtil;
import com.samsung.vip.engine.shape.GraphPrimitive;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class VIShapeRecognitionLib extends VIRecognitionLib {
    private static final String TAG = "VIShapeRecognitionLib";
    private LinkedList<float[]> mXstrokeList = null;
    private LinkedList<float[]> mYstrokeList = null;

    public void init() {
        this.mXstrokeList = new LinkedList<>();
        this.mYstrokeList = new LinkedList<>();
        VISH_InitSmartShapeEngine(VIRecognitionLib.VI_SH_ENGINE_RAM_SIZE);
    }

    public void close() {
        VISH_ReleaseSmartShapeEngine();
    }

    public void clearScene() {
        VISH_ClearScene();
    }

    public GraphPrimitive[] recog() {
        int nStrokeSize = this.mXstrokeList.size();
        int nTotalPointSize = 0;
        for (int i = 0; i < nStrokeSize; i++) {
            nTotalPointSize += this.mXstrokeList.get(i).length + 1;
        }
        int nPointIndex = 0;
        int[] pPointData = new int[nTotalPointSize * 2];
        int i2 = 0;
        while (i2 < nStrokeSize) {
            int nPointSize = this.mXstrokeList.get(i2).length;
            int nPointIndex2 = nPointIndex;
            for (int j = 0; j < nPointSize; j++) {
                int nPointIndex3 = nPointIndex2 + 1;
                pPointData[nPointIndex2] = (int) this.mXstrokeList.get(i2)[j];
                nPointIndex2 = nPointIndex3 + 1;
                pPointData[nPointIndex3] = (int) this.mYstrokeList.get(i2)[j];
            }
            int nPointIndex4 = nPointIndex2 + 1;
            pPointData[nPointIndex2] = 65535;
            pPointData[nPointIndex4] = 0;
            i2++;
            nPointIndex = nPointIndex4 + 1;
        }
        this.mXstrokeList.clear();
        this.mYstrokeList.clear();
        VISH_UpdateScene(pPointData);
        GraphPrimitive[] graphPrimitives = VISH_GetGraphPrimitiveArray();
        if (graphPrimitives == null) {
            return null;
        }
        Log.i(TAG, "Result group # : " + graphPrimitives.length);
        return graphPrimitives;
    }

    public void addStroke(float[] x, float[] y) {
        this.mXstrokeList.add(x);
        this.mYstrokeList.add(y);
    }

    public String getPrimitiveName(int nType) {
        switch (nType) {
            case 1:
                return "line";
            case 2:
                return "circle";
            case 3:
            case 4:
            default:
                return "";
            case 5:
                return "polygon";
            case 6:
                return "ellipse";
            case 7:
                return "circlearc";
            case 8:
                return "ellipsearc";
            case 9:
                return "bezier";
            case 10:
                return BuddyImageUtil.BUDDY_IMAGE_GROUP;
            case 11:
                return "arrow";
            case 12:
                return "table";
            case 13:
                return "polyline";
        }
    }
}
