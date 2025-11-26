package com.samsung.vip.engine;

import android.util.Log;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class VIEquationRecognitionLib extends VIRecognitionLib {
    private static final String TAG = "VIEquationRecognitionLib";
    private LinkedList<float[]> mXstrokeList = null;
    private LinkedList<float[]> mYstrokeList = null;
    private static final String[] EQ_FRAC = {"#", "\\frac"};
    private static final String[] EQ_DIV = {"%", "\\div"};
    private static final String[] EQ_TIMES = {"*", "\\times"};
    private static final String[] EQ_PI = {"pi", "\\pi"};
    private static final String[] EQ_SIN = {"sin", "\\sin"};
    private static final String[] EQ_COS = {"cos", "\\cos"};
    private static final String[] EQ_TAN = {"tan", "\\tan"};
    private static final String[] EQ_ASIN = {"asin", "\\arcsin"};
    private static final String[] EQ_ACOS = {"acos", "\\arccos"};
    private static final String[] EQ_ATAN = {"atan", "\\arctan"};
    private static final String[] EQ_SINH = {"sinh", "\\sinh"};
    private static final String[] EQ_COSH = {"cosh", "\\cosh"};
    private static final String[] EQ_TANH = {"tanh", "\\tanh"};
    private static final String[] EQ_LOG = {"log", "\\log"};
    private static final String[] EQ_LN = {"ln", "\\ln"};
    private static final String[] EQ_SQRT = {"sqrt", "\\sqrt"};
    private static final String[] EQ_EXP = {"^", "^"};

    public int init(String dataPath) {
        this.mXstrokeList = new LinkedList<>();
        this.mYstrokeList = new LinkedList<>();
        return VIEQ_Init(dataPath, VIRecognitionLib.VI_EQ_ENGINE_RAM_SIZE, 1600, 1200);
    }

    public void close() {
        VIEQ_Close();
    }

    public String recog() {
        int nStrokeSize = this.mXstrokeList.size();
        int nTotalPointSize = 0;
        for (int i = 0; i < nStrokeSize; i++) {
            int nPointSize = this.mXstrokeList.get(i).length;
            int nEstimatePointSize = nTotalPointSize + nPointSize + 2;
            if (nEstimatePointSize > 2000) {
                Log.e(TAG, "Too many input points! : " + nEstimatePointSize);
                return null;
            }
            nTotalPointSize += nPointSize + 1;
        }
        int nTotalPointSize2 = nTotalPointSize + 1;
        int[] pPointData = new int[nTotalPointSize2 * 2];
        int nPointIndex = 0;
        for (int i2 = 0; i2 < nStrokeSize; i2++) {
            int nPointSize2 = this.mXstrokeList.get(i2).length;
            for (int j = 0; j < nPointSize2; j++) {
                int nPointIndex2 = nPointIndex + 1;
                pPointData[nPointIndex] = (int) this.mXstrokeList.get(i2)[j];
                nPointIndex = nPointIndex2 + 1;
                pPointData[nPointIndex2] = (int) this.mYstrokeList.get(i2)[j];
            }
            int nPointIndex3 = nPointIndex + 1;
            pPointData[nPointIndex] = 65535;
            nPointIndex = nPointIndex3 + 1;
            pPointData[nPointIndex3] = 0;
        }
        int nPointIndex4 = nPointIndex + 1;
        pPointData[nPointIndex] = 65535;
        int i3 = nPointIndex4 + 1;
        pPointData[nPointIndex4] = 65535;
        this.mXstrokeList.clear();
        this.mYstrokeList.clear();
        String result = VIEQ_Recog(pPointData, nTotalPointSize2);
        if (result == null) {
            Log.e(TAG, "Output result is null!");
            return null;
        }
        return result;
    }

    public void addStroke(float[] x, float[] y) {
        this.mXstrokeList.add(x);
        this.mYstrokeList.add(y);
    }

    private String convertLatexForm(String input) {
        return parseForReplacement(parseForReplacement(parseForReplacement(parseForFunctions(parseForFunctions(parseForFunctions(parseForFunctions(parseForFunctions(parseForFunctions(parseForFunctions(parseForFunctions(parseForFunctions(parseForFunctions(parseForFunctions(parseForFunctions(parseForFunctions(parseForFraction(input, EQ_FRAC[0], EQ_FRAC[1]), EQ_ASIN[0], EQ_ASIN[1]), EQ_ACOS[0], EQ_ACOS[1]), EQ_ATAN[0], EQ_ATAN[1]), EQ_SINH[0], EQ_SINH[1]), EQ_COSH[0], EQ_COSH[1]), EQ_TANH[0], EQ_TANH[1]), EQ_SIN[0], EQ_SIN[1]), EQ_COS[0], EQ_COS[1]), EQ_TAN[0], EQ_TAN[1]), EQ_LOG[0], EQ_LOG[1]), EQ_LN[0], EQ_LN[1]), EQ_SQRT[0], EQ_SQRT[1]), EQ_EXP[0], EQ_EXP[1]), EQ_DIV[0], EQ_DIV[1]), EQ_TIMES[0], EQ_TIMES[1]), EQ_PI[0], EQ_PI[1]);
    }

    private String parseForFraction(String input, String src, String dst) {
        int srcLen = src.length();
        int ii = 0;
        while (ii < input.length() - srcLen) {
            if (input.substring(ii, ii + srcLen).equals(src)) {
                StringBuilder head = new StringBuilder(input.substring(0, ii));
                StringBuilder tail = new StringBuilder(input.substring(ii + srcLen, input.length()));
                int sumBrk = 0;
                int i = head.length() - 1;
                while (true) {
                    if (i < 0) {
                        break;
                    }
                    if (head.charAt(i) == ')') {
                        sumBrk--;
                        if (i == head.length() - 1) {
                            head.setCharAt(i, '}');
                        }
                    } else if (head.charAt(i) == '(' && (sumBrk = sumBrk + 1) == 0) {
                        head.setCharAt(i, '{');
                        break;
                    }
                    i--;
                }
                head.insert(i, dst);
                int sumBrk2 = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= tail.length()) {
                        break;
                    }
                    if (tail.charAt(i2) == '(') {
                        sumBrk2++;
                        if (i2 == 0) {
                            tail.setCharAt(i2, '{');
                        }
                    } else if (tail.charAt(i2) == ')' && sumBrk2 - 1 == 0) {
                        tail.setCharAt(i2, '}');
                        break;
                    }
                    i2++;
                }
                input = head.append(tail.toString()).toString();
                ii += dst.length();
            }
            ii++;
        }
        return input;
    }

    private String parseForFunctions(String input, String src, String dst) {
        int srcLen = src.length();
        int ii = 0;
        while (ii < input.length() - srcLen) {
            if (input.substring(ii, ii + srcLen).equals(src)) {
                if (ii > 0 && ((src.equals(EQ_SIN[0]) || src.equals(EQ_COS[0]) || src.equals(EQ_TAN[0])) && (input.charAt(ii - 1) == 'c' || input.charAt(ii + srcLen) == 'h'))) {
                    ii += srcLen;
                } else {
                    StringBuilder head = new StringBuilder(input.substring(0, ii));
                    StringBuilder tail = new StringBuilder(input.substring(ii + srcLen, input.length()));
                    int sumBrk = 0;
                    int i = 0;
                    while (true) {
                        if (i >= tail.length()) {
                            break;
                        }
                        if (tail.charAt(i) == '(') {
                            sumBrk++;
                            if (i == 0) {
                                tail.setCharAt(i, '{');
                            }
                        } else if (tail.charAt(i) == ')' && sumBrk - 1 == 0) {
                            tail.setCharAt(i, '}');
                            break;
                        }
                        i++;
                    }
                    input = head.append(dst).append(tail.toString()).toString();
                    ii += dst.length();
                }
            }
            ii++;
        }
        return input;
    }

    private String parseForReplacement(String input, String src, String dst) {
        int srcLen = src.length();
        int ii = 0;
        while (ii < input.length() - srcLen) {
            if (input.substring(ii, ii + srcLen).equals(src)) {
                StringBuilder head = new StringBuilder(input.substring(0, ii));
                StringBuilder tail = new StringBuilder(input.substring(ii + srcLen, input.length()));
                if (src.equals(EQ_DIV[0]) || src.equals(EQ_TIMES[0])) {
                    input = head.append(dst).append(" ").append(tail.toString()).toString();
                } else {
                    input = head.append(dst).append(tail.toString()).toString();
                }
                ii += dst.length();
            }
            ii++;
        }
        return input;
    }
}
