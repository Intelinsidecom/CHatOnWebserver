package com.vlingo.sdk.internal.audio;

/* loaded from: classes.dex */
public class VLSil {
    private static final float FRAME_LENGTH = 0.02f;
    private static final float MIN_ENERGY = 0.0f;
    private static final int VLSIL_HISTO_SIZE = 100;
    private static final int VLSIL_MAX_FRAME_SIZE = 320;
    public static final int VLSIL_NO_SPEECH_DETECTED = -1;
    public static final int VLSIL_OK = 0;
    int currentSpeechIndex;
    float minVoiceDuration;
    float minVoiceLevel;
    int mostRecentSpeechSample;
    int numAboveCurrentSpeechIndex;
    int numFrames;
    int numFramesAboveSpeechThresh;
    int numSamples;
    int sampleRate;
    int samplesSoFar;
    float silenceThreshold;
    float voicePortion;
    int[] energyHisto = new int[100];
    short[] samples = new short[320];

    public VLSil(int sampleRate, float silenceThreshold, float minVoiceDuration, float voicePortion, float minVoiceLevel) {
        this.sampleRate = sampleRate;
        this.voicePortion = voicePortion;
        this.silenceThreshold = silenceThreshold;
        this.minVoiceDuration = minVoiceDuration;
        this.minVoiceLevel = minVoiceLevel;
        initForUtterance();
    }

    public void initForUtterance() {
        this.samplesSoFar = 0;
        this.mostRecentSpeechSample = -1;
        this.numSamples = 0;
        for (int i = 0; i < 100; i++) {
            this.energyHisto[i] = 0;
        }
        this.currentSpeechIndex = 0;
        this.numFrames = 0;
        this.numAboveCurrentSpeechIndex = 0;
        this.numFramesAboveSpeechThresh = 0;
    }

    public int processShortArray(short[] speechSamples, int numSpeechSamples) {
        int index;
        int sampleIndex;
        int sampleIndex2 = 0;
        int numSamplesInFrame = (int) (this.sampleRate * 0.02f);
        int minSpeechFrames = (int) (this.minVoiceDuration / 0.02f);
        int maxEnergy = 0;
        if (numSamplesInFrame > 320) {
            numSamplesInFrame = 320;
        }
        int index2 = this.numSamples;
        while (sampleIndex2 < numSpeechSamples) {
            while (true) {
                index = index2;
                sampleIndex = sampleIndex2;
                if (index >= numSamplesInFrame || sampleIndex >= numSpeechSamples) {
                    break;
                }
                index2 = index + 1;
                sampleIndex2 = sampleIndex + 1;
                this.samples[index] = speechSamples[sampleIndex];
            }
            if (index == numSamplesInFrame) {
                float energy = computeEnergy(this.samples, numSamplesInFrame);
                if (energy > maxEnergy) {
                    maxEnergy = (int) energy;
                }
                float speechThresh = updateHistoAndSpeechThresh(energy);
                if (energy >= speechThresh - this.silenceThreshold && energy >= this.minVoiceLevel) {
                    this.numFramesAboveSpeechThresh++;
                    if (this.numFramesAboveSpeechThresh >= minSpeechFrames) {
                        this.mostRecentSpeechSample = this.samplesSoFar;
                    }
                } else {
                    this.numFramesAboveSpeechThresh = 0;
                }
                this.samplesSoFar += numSamplesInFrame;
                index2 = 0;
                sampleIndex2 = sampleIndex;
            } else {
                index2 = index;
                sampleIndex2 = sampleIndex;
            }
        }
        this.numSamples = index2;
        return this.mostRecentSpeechSample;
    }

    private float computeEnergy(short[] samples, int numSamples) {
        float sumsq = 0.0f;
        int sum = 0;
        for (int i = 0; i < numSamples; i++) {
            sumsq += r2 * r2;
            sum += samples[i];
        }
        int mean = sum / numSamples;
        int total = ((int) (sumsq / numSamples)) - (mean * mean);
        if (total < 1) {
            total = 1;
        }
        return (float) (10.0d * Math.log10(total));
    }

    private float updateHistoAndSpeechThresh(float energy) {
        int newNumAbove;
        int histoIndex = (int) (energy - 0.0f);
        if (histoIndex < 0) {
            histoIndex = 0;
        }
        if (histoIndex >= 100) {
            histoIndex = 99;
        }
        this.numFrames++;
        int[] iArr = this.energyHisto;
        iArr[histoIndex] = iArr[histoIndex] + 1;
        int targetNumAboveThresh = (int) (this.numFrames * this.voicePortion);
        if (targetNumAboveThresh < 1) {
            targetNumAboveThresh = 1;
        }
        if (histoIndex > this.currentSpeechIndex) {
            this.numAboveCurrentSpeechIndex++;
        }
        if (this.numAboveCurrentSpeechIndex > targetNumAboveThresh) {
            this.currentSpeechIndex++;
            while (this.currentSpeechIndex < 100) {
                this.numAboveCurrentSpeechIndex -= this.energyHisto[this.currentSpeechIndex];
                if (this.numAboveCurrentSpeechIndex <= targetNumAboveThresh) {
                    break;
                }
                this.currentSpeechIndex++;
            }
        } else if (this.numAboveCurrentSpeechIndex < targetNumAboveThresh) {
            while (this.currentSpeechIndex >= 0 && (newNumAbove = this.numAboveCurrentSpeechIndex + this.energyHisto[this.currentSpeechIndex]) <= targetNumAboveThresh) {
                this.currentSpeechIndex--;
                this.numAboveCurrentSpeechIndex = newNumAbove;
            }
        }
        return this.currentSpeechIndex + 0.0f;
    }
}
