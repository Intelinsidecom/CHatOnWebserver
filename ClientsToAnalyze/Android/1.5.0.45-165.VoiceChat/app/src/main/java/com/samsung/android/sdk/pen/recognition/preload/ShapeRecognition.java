package com.samsung.android.sdk.pen.recognition.preload;

import android.content.Context;
import android.graphics.PointF;
import android.util.Log;
import com.samsung.vip.engine.VIShapeGenerator;
import com.samsung.vip.engine.VIShapeRecognitionLib;
import com.samsung.vip.engine.shape.GraphPrimitive;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ShapeRecognition {
    private static final String TAG = "VIShapeRecognition";
    private VIShapeRecognitionLib mShRecLib;
    private ArrayList<String> mShapeTypeList = null;
    private final ArrayList<PointF[]> mResultPointsList = new ArrayList<>();

    public boolean init(Context context) {
        this.mShRecLib = null;
        this.mShRecLib = new VIShapeRecognitionLib();
        this.mShRecLib.init();
        return true;
    }

    public void addStroke(float[] x, float[] y) {
        this.mShRecLib.addStroke(x, y);
    }

    public ArrayList<PointF[]> getResult() {
        return this.mResultPointsList;
    }

    public ArrayList<PointF[]> process() {
        this.mShRecLib.clearScene();
        GraphPrimitive[] graphPrimitives = this.mShRecLib.recog();
        if (graphPrimitives == null) {
            return this.mResultPointsList;
        }
        makeResults(graphPrimitives);
        return this.mResultPointsList;
    }

    public void dispose() {
        if (this.mShRecLib != null) {
            this.mShRecLib.close();
        }
    }

    public ArrayList<String> getShapeTypeList() {
        return this.mShapeTypeList;
    }

    private void makeResults(GraphPrimitive[] graphPrimitives) {
        VIShapeGenerator shapeGenerator = new VIShapeGenerator();
        int segmentCount = graphPrimitives.length;
        if (segmentCount > 0) {
            this.mShapeTypeList = new ArrayList<>();
        }
        this.mResultPointsList.clear();
        for (GraphPrimitive shape : graphPrimitives) {
            if (shape != null) {
                String typeName = this.mShRecLib.getPrimitiveName(shape.nType);
                Log.i(TAG, "Id: " + ((int) shape.nId) + ", Type: " + typeName);
                this.mShapeTypeList.add(typeName);
                shapeGenerator.addShape(shape);
            }
        }
        shapeGenerator.generate(this.mResultPointsList);
    }
}
