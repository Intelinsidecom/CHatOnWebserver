package com.samsung.android.sdk.pen.recognition.preload;

import android.graphics.PointF;
import android.util.Log;
import java.io.File;

/* loaded from: classes.dex */
public class HSVLib {
    private static final boolean SHOW_LOG = true;
    public static final int SIGNATURE_REGISTER_ERROR_DIFFERENT = -3;
    public static final int SIGNATURE_REGISTER_ERROR_NORMAL = -1;
    public static final int SIGNATURE_REGISTER_ERROR_SHORT = -2;
    public static final int SIGNATURE_VERIFICATION_LEVEL_HIGH = 2;
    public static final int SIGNATURE_VERIFICATION_LEVEL_LOW = 0;
    public static final int SIGNATURE_VERIFICATION_LEVEL_MEDIUM = 1;
    public static final int SIGNATURE_VERIFICATION_SCORE_DEFAULT = 500;
    public static final int SIGNATURE_VERIFICATION_SCORE_HIGH = 600;
    public static final int SIGNATURE_VERIFICATION_SCORE_LOW = 400;
    public static final int SIGNATURE_VERIFICATION_SCORE_MEDIUM = 500;
    private static final String TAG = "Signature";
    private static final int USER_ID_DEFAULT = 10;
    private int[] m_nTotalPosition = null;
    private int[] m_nTotalTimeStamp = null;
    private char[] m_cTotalTag = null;
    private float[] m_nTotalPressure = null;
    private String m_szSaveDirPath = null;
    private int m_nMaxPointCount = 1024;
    private int m_nMaxNumRegistration = 3;
    private int m_nGENUINE_SCORE_THR = 500;
    private int m_nUserID = 10;
    private int m_nMinXYSize = 200;
    private HSVJniLib m_HSVJniLib = null;
    private short m_sCurrentPointCount = 0;
    private int m_nNumRegistration = 0;
    private short m_sVerificationScore = 0;
    private boolean m_bRegistered = false;

    public boolean initHSV(String i_szSaveDirPath, int i_nMaxPointCount, int i_nMaxNumRegistration, int i_nUserID, int i_nMinXYSize) {
        Log.i(TAG, "InitHSV");
        if (i_szSaveDirPath == null) {
            Log.e(TAG, "save directory path is null");
            return false;
        }
        this.m_szSaveDirPath = i_szSaveDirPath;
        this.m_nMaxPointCount = i_nMaxPointCount;
        this.m_nMaxNumRegistration = i_nMaxNumRegistration;
        this.m_nGENUINE_SCORE_THR = 500;
        this.m_nUserID = i_nUserID;
        this.m_nMinXYSize = i_nMinXYSize;
        if (makeFolder(this.m_szSaveDirPath)) {
            Log.i(TAG, "make folder success");
            try {
                this.m_HSVJniLib = new HSVJniLib();
                this.m_HSVJniLib.jni_HSVInit(this.m_szSaveDirPath);
                this.m_nTotalPosition = new int[this.m_nMaxPointCount * 2];
                this.m_nTotalTimeStamp = new int[this.m_nMaxPointCount];
                this.m_cTotalTag = new char[this.m_nMaxPointCount];
                this.m_nTotalPressure = new float[this.m_nMaxPointCount];
                if (this.m_HSVJniLib.jni_HSVDelUser(this.m_nUserID) < 0) {
                    Log.e(TAG, "delete user failure");
                    return false;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                this.m_HSVJniLib = null;
                Log.e(TAG, "create HSVJniLib failure");
                return false;
            }
        }
        Log.e(TAG, "make folder failure");
        return false;
    }

    public void setMaxNumRegistration(int i_nMaxNumRegistration) {
        this.m_nMaxNumRegistration = i_nMaxNumRegistration;
    }

    public void setGenuineScoreThr(int i_nGenuineScoreThr) {
        this.m_nGENUINE_SCORE_THR = i_nGenuineScoreThr;
    }

    public void setUserID(int i_nUserID) {
        this.m_nUserID = i_nUserID;
    }

    public void setMinXYSize(int i_nMinXYSize) {
        this.m_nMinXYSize = i_nMinXYSize;
    }

    private boolean makeFolder(String i_szPath) {
        File tFile = new File(i_szPath);
        return tFile.exists() || tFile.mkdirs();
    }

    private boolean deleteFolder(String i_szPath) {
        File tFile0 = new File(String.valueOf(i_szPath) + "SPenHSVreg00.dat");
        File tFile1 = new File(String.valueOf(i_szPath) + "SPenHSVreg01.dat");
        File tFile2 = new File(String.valueOf(i_szPath) + "SPenHSVreg02.dat");
        if (tFile0.exists() && !tFile0.delete()) {
            return false;
        }
        if (!tFile1.exists() || tFile1.delete()) {
            return !tFile2.exists() || tFile2.delete();
        }
        return false;
    }

    private boolean checkTrainingData(String i_szPath) {
        File tFile0 = new File(String.valueOf(i_szPath) + "SPenHSVreg00.dat");
        File tFile1 = new File(String.valueOf(i_szPath) + "SPenHSVreg01.dat");
        File tFile2 = new File(String.valueOf(i_szPath) + "SPenHSVreg02.dat");
        return tFile0.exists() && tFile1.exists() && tFile2.exists();
    }

    public boolean checkRegistration(int i_nUserID) {
        return i_nUserID == 10 && checkTrainingData(this.m_szSaveDirPath);
    }

    public int getRegisteredDataCount(int i_nUserID) {
        int count = 0;
        if (i_nUserID != 10) {
            return 0;
        }
        File tFile0 = new File(String.valueOf(this.m_szSaveDirPath) + "SPenHSVreg00.dat");
        File tFile1 = new File(String.valueOf(this.m_szSaveDirPath) + "SPenHSVreg01.dat");
        File tFile2 = new File(String.valueOf(this.m_szSaveDirPath) + "SPenHSVreg02.dat");
        if (tFile0.exists()) {
            count = 0 + 1;
        }
        if (tFile1.exists()) {
            count++;
        }
        if (tFile2.exists()) {
            return count + 1;
        }
        return count;
    }

    public boolean deleteRegistration(int i_nUserID) {
        return i_nUserID == 10 && deleteFolder(this.m_szSaveDirPath);
    }

    public void setDrawData(PointF[] i_Points, int[] i_Time, float[] i_Pressure) {
        if (this.m_sCurrentPointCount + i_Time.length >= this.m_nMaxPointCount) {
            this.m_sCurrentPointCount = (short) this.m_nMaxPointCount;
            return;
        }
        for (int i = 0; i < i_Time.length; i++) {
            this.m_nTotalPosition[(this.m_sCurrentPointCount * 2) + (i * 2)] = (int) (i_Points[i].x + 0.5f);
            this.m_nTotalPosition[(this.m_sCurrentPointCount * 2) + (i * 2) + 1] = (int) (i_Points[i].y + 0.5f);
            this.m_nTotalTimeStamp[this.m_sCurrentPointCount + i] = i_Time[i];
            this.m_nTotalPressure[this.m_sCurrentPointCount + i] = i_Pressure[i];
            if (i == 0) {
                this.m_cTotalTag[this.m_sCurrentPointCount + i] = 0;
            } else {
                this.m_cTotalTag[this.m_sCurrentPointCount + i] = 1;
            }
        }
        this.m_sCurrentPointCount = (short) (this.m_sCurrentPointCount + i_Time.length);
    }

    public int signatureTraining(int i_nUserID) {
        if (this.m_nNumRegistration == 0) {
            this.m_HSVJniLib.jni_HSVDelUser(this.m_nUserID);
        }
        short nCheckSign = this.m_HSVJniLib.jni_HSVCheckSignature(this.m_nTotalPosition, this.m_nTotalTimeStamp, this.m_cTotalTag, this.m_nTotalPressure, this.m_sCurrentPointCount, this.m_nNumRegistration, this.m_nUserID, this.m_nMinXYSize);
        if (nCheckSign != 0) {
            clearSignatureScreen();
            return -1;
        }
        if (this.m_nNumRegistration == this.m_nMaxNumRegistration - 1) {
            this.m_HSVJniLib.jni_HSVAddSignatureModel(this.m_nTotalPosition, this.m_nTotalTimeStamp, this.m_cTotalTag, this.m_nTotalPressure, this.m_sCurrentPointCount, this.m_nNumRegistration, this.m_nUserID);
            this.m_bRegistered = true;
            this.m_nNumRegistration = 0;
            clearSignatureScreen();
            Log.i(TAG, "m_bRegistered = " + this.m_bRegistered);
            Log.i(TAG, "m_nNumRegistration = " + this.m_nNumRegistration);
            return this.m_nMaxNumRegistration;
        }
        if (this.m_nNumRegistration == 0) {
            if (!deleteFolder(this.m_szSaveDirPath)) {
                return -1;
            }
            if (makeFolder(this.m_szSaveDirPath)) {
                Log.i(TAG, "make folder success");
            } else {
                Log.i(TAG, "make folder failure or existed");
            }
            this.m_HSVJniLib.jni_HSVAddSignatureModel(this.m_nTotalPosition, this.m_nTotalTimeStamp, this.m_cTotalTag, this.m_nTotalPressure, this.m_sCurrentPointCount, this.m_nNumRegistration, this.m_nUserID);
            this.m_bRegistered = false;
            this.m_nNumRegistration++;
            clearSignatureScreen();
            Log.i(TAG, "m_bRegistered = " + this.m_bRegistered);
            Log.i(TAG, "m_nNumRegistration = " + this.m_nNumRegistration);
            return this.m_nNumRegistration;
        }
        this.m_HSVJniLib.jni_HSVAddSignatureModel(this.m_nTotalPosition, this.m_nTotalTimeStamp, this.m_cTotalTag, this.m_nTotalPressure, this.m_sCurrentPointCount, this.m_nNumRegistration, this.m_nUserID);
        this.m_bRegistered = false;
        this.m_nNumRegistration++;
        clearSignatureScreen();
        Log.i(TAG, "m_bRegistered = " + this.m_bRegistered);
        Log.i(TAG, "m_nNumRegistration = " + this.m_nNumRegistration);
        return this.m_nNumRegistration;
    }

    public boolean verification(int i_nUserID, int verificationLevel) {
        int thresholdScore;
        if (checkRegistration(i_nUserID)) {
            Log.i(TAG, "StartVerification");
            this.m_HSVJniLib.jni_HSVDelUser(this.m_nUserID);
            this.m_HSVJniLib.jni_HSVLoadSignatureModel();
            this.m_sVerificationScore = this.m_HSVJniLib.jni_HSVVerify(this.m_nTotalPosition, this.m_nTotalTimeStamp, this.m_cTotalTag, this.m_nTotalPressure, this.m_sCurrentPointCount, this.m_nUserID, this.m_nGENUINE_SCORE_THR);
            switch (verificationLevel) {
                case 0:
                    thresholdScore = 400;
                    break;
                case 1:
                    thresholdScore = 500;
                    break;
                case 2:
                    thresholdScore = 600;
                    break;
                default:
                    thresholdScore = 500;
                    break;
            }
            if (this.m_sVerificationScore >= thresholdScore) {
                Log.i(TAG, "Verification : Success");
                cancel(i_nUserID);
                return true;
            }
            Log.i(TAG, "Verification : Failure");
            cancel(i_nUserID);
            return false;
        }
        cancel(i_nUserID);
        return false;
    }

    public boolean clearSignatureScreen() {
        this.m_sCurrentPointCount = (short) 0;
        Log.i(TAG, "Retry");
        return true;
    }

    public boolean cancel(int i_nUserID) {
        clearSignatureScreen();
        if (this.m_HSVJniLib != null) {
            if (!checkRegistration(i_nUserID)) {
                clearSignatureScreen();
                this.m_HSVJniLib.jni_HSVDelUser(this.m_nUserID);
                this.m_HSVJniLib.jni_HSVClose();
                this.m_HSVJniLib = null;
                this.m_nNumRegistration = 0;
                if (!deleteFolder(this.m_szSaveDirPath)) {
                    return false;
                }
            }
            Log.i(TAG, "Cencel");
            Log.i(TAG, "m_bRegistered = " + this.m_bRegistered);
            Log.i(TAG, "m_nNumRegistration = " + this.m_nNumRegistration);
            return true;
        }
        Log.i(TAG, "Cencel false");
        Log.i(TAG, "m_bRegistered = " + this.m_bRegistered);
        Log.i(TAG, "m_nNumRegistration = " + this.m_nNumRegistration);
        return false;
    }
}
