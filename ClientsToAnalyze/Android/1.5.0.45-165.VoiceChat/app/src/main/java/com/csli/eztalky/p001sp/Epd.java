package com.csli.eztalky.p001sp;

import com.sds.coolots.EngineInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class Epd {
    private static final int BG_WINDOW_LEN = 30;
    private static final int DDEL_WIN = 1;
    private static final int DEL_WIN = 2;
    private static final int EDGE_N = 25;
    private static final int END_MARGIN_N = 10;
    private static final int GAP = 80;
    private static final int HALF_EDGE_N = 12;
    private static final int MAX_SPEECH_DURATION = 2000;
    private static final int MAX_UTT_LEN = 2000;
    private static final int MIN_SPEECH_DURATION = 5;
    private static final int START_MARGIN_N = 30;
    private static float[] edgeFilter = {-0.03f, -0.14f, -0.29f, -0.44f, -0.59f, -0.72f, -0.8f, -0.84f, -0.81f, -0.71f, -0.54f, -0.29f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0.29f, 0.54f, 0.71f, 0.81f, 0.84f, 0.8f, 0.72f, 0.59f, 0.44f, 0.29f, 0.14f, 0.03f};
    public float m_bgEnergyLevel;
    public int m_endX;
    public float m_fgEnergySum;
    public int m_frameX;
    private float m_previousEdge;
    private int m_silenceCount;
    private int m_speechCount;
    public int m_startX;
    public volatile int m_state;
    boolean DEBUG_EPD = false;
    public float[] m_energyA = new float[2000];
    public float[] m_edgeA = new float[2000];
    public int m_DEV_BEGIN_THRESH = 250;
    public int m_DEV_RESTART_THRESH = 200;
    public int m_DEV_END_THRESH = EngineInterface.SMPUI_ERROR_NOTAVAILABLEP2PSESSION_NEED_CRITICAL_UPDATE;
    public int m_DEV_REMOVE_START_FRAME_N = 0;

    public void newUtterance() {
        this.m_startX = -1;
        this.m_endX = -1;
        this.m_state = 0;
        this.m_previousEdge = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.m_frameX = 0;
        this.m_bgEnergyLevel = -1.0f;
        this.m_fgEnergySum = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    public synchronized void stop() {
        switch (this.m_state) {
            case 0:
                this.m_startX = 0;
                this.m_endX = 0;
                break;
            case 1:
                this.m_endX = (this.m_frameX - 2) - 1;
                break;
            case 2:
                if (this.m_endX == -1) {
                    this.m_endX = this.m_frameX;
                    break;
                }
                break;
        }
        this.m_state = 3;
    }

    public synchronized int oneFrame(float energy) {
        this.m_energyA[this.m_frameX] = energy;
        float edge = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        int n = (this.m_frameX - 25) + 1;
        if (n < 0) {
            for (int i = 0; i < this.m_frameX; i++) {
                edge += this.m_energyA[i];
            }
            edge = (float) (edge / (this.m_frameX + 2.0d));
        } else {
            int i2 = 0;
            while (i2 < 25) {
                edge += edgeFilter[i2] * this.m_energyA[n];
                i2++;
                n++;
            }
        }
        if (this.m_frameX < this.m_DEV_REMOVE_START_FRAME_N) {
            edge = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        this.m_edgeA[this.m_frameX] = edge;
        switch (this.m_state) {
            case 0:
                if (edge > this.m_DEV_BEGIN_THRESH && this.m_previousEdge > edge && checkStartXEnergyDiff(this.m_frameX, 2.0f, 40.0f)) {
                    this.m_startX = (this.m_frameX - 12) - 30;
                    if (this.m_startX < 30) {
                        this.m_startX = 30;
                    }
                    this.m_speechCount = 1;
                    this.m_state = 1;
                    int centerX = this.m_frameX - 12;
                    if (centerX > this.m_DEV_REMOVE_START_FRAME_N + 12) {
                        float eLevel = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                        for (int i3 = this.m_DEV_REMOVE_START_FRAME_N; i3 < centerX; i3++) {
                            eLevel += this.m_energyA[i3];
                        }
                        this.m_bgEnergyLevel = eLevel / (centerX - this.m_DEV_REMOVE_START_FRAME_N);
                        break;
                    }
                }
                break;
            case 1:
                this.m_speechCount++;
                if (this.m_frameX > 12) {
                    this.m_fgEnergySum += this.m_energyA[this.m_frameX - 12];
                }
                if (edge < this.m_DEV_END_THRESH) {
                    this.m_state = 2;
                    this.m_silenceCount = 0;
                }
                if (this.m_speechCount > 2000) {
                    this.m_endX = this.m_frameX;
                    this.m_state = 3;
                    break;
                }
                break;
            case 2:
                if (this.m_DEV_END_THRESH >= edge || edge >= this.m_DEV_RESTART_THRESH) {
                    if (edge <= this.m_DEV_END_THRESH) {
                        if (checkEndXEnergyLevel(this.m_frameX, 1.2f, 120.0f)) {
                            this.m_silenceCount = 0;
                            this.m_endX = -1;
                            break;
                        } else {
                            this.m_silenceCount++;
                            if (this.m_silenceCount > GAP) {
                                this.m_state = 3;
                                break;
                            }
                        }
                    } else if (edge >= this.m_DEV_RESTART_THRESH) {
                        if (checkRestartXEnergyLevel(this.m_frameX)) {
                            this.m_silenceCount = 0;
                            this.m_state = 1;
                            this.m_endX = -1;
                            break;
                        } else {
                            this.m_silenceCount++;
                            if (this.m_silenceCount > GAP) {
                                this.m_state = 3;
                                break;
                            }
                        }
                    }
                } else {
                    if (this.m_endX == -1) {
                        this.m_endX = (this.m_frameX - 12) + 10;
                    }
                    this.m_silenceCount++;
                    if (this.m_silenceCount > GAP) {
                        if (this.m_speechCount < 5) {
                            this.m_state = 3;
                            break;
                        } else {
                            this.m_state = 3;
                            break;
                        }
                    }
                }
                break;
        }
        this.m_previousEdge = edge;
        this.m_frameX++;
        return this.m_state;
    }

    public boolean checkStartXEnergyDiff(int frameX, float dRate, float dRelThresh) {
        float eLside = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        float eRside = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        int centerX = frameX - 12;
        if (centerX <= 12) {
            return false;
        }
        for (int i = centerX - 12; i < centerX; i++) {
            eLside += this.m_energyA[i];
        }
        for (int i2 = centerX + 1; i2 <= frameX; i2++) {
            eRside += this.m_energyA[i2];
        }
        float eLside2 = eLside / 12.0f;
        float eRside2 = eRside / 12.0f;
        if (eLside2 * dRate >= eRside2 || eRside2 - eLside2 <= dRelThresh) {
            return false;
        }
        return true;
    }

    public boolean checkEndXEnergyLevel(int frameX, float dRate, float dAbsTresh) {
        int centerX = frameX - 12;
        if (this.m_bgEnergyLevel <= 0.0d || frameX <= 30) {
            return true;
        }
        float eLside = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        float eRside = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        for (int i = centerX - 6; i < centerX; i++) {
            eLside += this.m_energyA[i];
        }
        int RwinEndX = centerX + 6;
        for (int i2 = centerX + 1; i2 <= RwinEndX; i2++) {
            eRside += this.m_energyA[i2];
        }
        if (eLside / 6 >= (eRside / 6) * 1.5d) {
            return true;
        }
        return false;
    }

    public boolean checkRestartXEnergyLevel(int frameX) {
        boolean isStartX = true;
        int centerX = frameX - 12;
        if (centerX > 12 && this.m_bgEnergyLevel > 0.0d) {
            float eLside = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            float eRside = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            for (int i = centerX - 6; i < centerX; i++) {
                eLside += this.m_energyA[i];
            }
            int RwinEndX = centerX + 6;
            for (int i2 = centerX + 1; i2 <= RwinEndX; i2++) {
                eRside += this.m_energyA[i2];
            }
            float eLside2 = eLside / 6;
            float eRside2 = eRside / 6;
            if (eLside2 * 1.5d > eRside2) {
                isStartX = false;
            }
            if (this.DEBUG_EPD) {
                System.out.printf("SX2) fr %d, (eL %.1f, eR %.1f) => %b \n", Integer.valueOf(frameX), Float.valueOf(eLside2), Float.valueOf(eRside2), Boolean.valueOf(isStartX));
            }
        }
        return isStartX;
    }
}
