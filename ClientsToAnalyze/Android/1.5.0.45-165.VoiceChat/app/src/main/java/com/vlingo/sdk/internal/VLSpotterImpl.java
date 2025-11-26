package com.vlingo.sdk.internal;

import android.content.Context;
import android.os.Handler;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.phrasespotter.SensoryJNI;
import com.vlingo.sdk.internal.settings.Settings;
import com.vlingo.sdk.recognition.spotter.VLSpotter;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.File;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class VLSpotterImpl extends VLComponentImpl implements VLSpotter {
    private static Logger log = Logger.getLogger(VLSpotterImpl.class);
    private boolean mIsStarted;
    private SensoryJNI mSensoryJNI;
    private VLSpotterContext mSpotterContext;

    @Override // com.vlingo.sdk.internal.VLComponentImpl, com.vlingo.sdk.VLComponent
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.vlingo.sdk.internal.VLComponentImpl, com.vlingo.sdk.VLComponent
    public /* bridge */ /* synthetic */ boolean isValid() {
        return super.isValid();
    }

    public VLSpotterImpl(VLComponentManager manager, Handler handler) {
        super(manager, handler);
        log.debug("VLSpotterImpl()");
        SensoryJNI.init();
        this.mSensoryJNI = new SensoryJNI();
    }

    @Override // com.vlingo.sdk.internal.VLComponentImpl
    void onDestroy() {
        log.debug("onDestroy()");
        this.mSensoryJNI.Deinitialize();
        this.mSensoryJNI = null;
        this.mSpotterContext = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0034 A[Catch: all -> 0x0016, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000e, B:7:0x0015, B:11:0x0019, B:13:0x001d, B:14:0x0024, B:15:0x0025, B:17:0x0029, B:22:0x0034), top: B:24:0x0002 }] */
    @Override // com.vlingo.sdk.recognition.spotter.VLSpotter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean startSpotter(com.vlingo.sdk.recognition.spotter.VLSpotterContext r5) {
        /*
            r4 = this;
            r1 = 1
            monitor-enter(r4)
            com.vlingo.sdk.internal.logging.Logger r2 = com.vlingo.sdk.internal.VLSpotterImpl.log     // Catch: java.lang.Throwable -> L16
            java.lang.String r3 = "startSpotter()"
            r2.debug(r3)     // Catch: java.lang.Throwable -> L16
            r4.validateInstance()     // Catch: java.lang.Throwable -> L16
            if (r5 != 0) goto L19
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L16
            java.lang.String r2 = "context must be specified"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L16
            throw r1     // Catch: java.lang.Throwable -> L16
        L16:
            r1 = move-exception
            monitor-exit(r4)
            throw r1
        L19:
            boolean r2 = r4.mIsStarted     // Catch: java.lang.Throwable -> L16
            if (r2 == 0) goto L25
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L16
            java.lang.String r2 = "Spotter already started"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L16
            throw r1     // Catch: java.lang.Throwable -> L16
        L25:
            com.vlingo.sdk.recognition.spotter.VLSpotterContext r2 = r4.mSpotterContext     // Catch: java.lang.Throwable -> L16
            if (r2 == r5) goto L34
            r4.mSpotterContext = r5     // Catch: java.lang.Throwable -> L16
            boolean r0 = r4.reinitSpotter()     // Catch: java.lang.Throwable -> L16
            if (r0 != 0) goto L34
            r1 = 0
        L32:
            monitor-exit(r4)
            return r1
        L34:
            com.vlingo.sdk.internal.phrasespotter.SensoryJNI r2 = r4.mSensoryJNI     // Catch: java.lang.Throwable -> L16
            r2.MakeReady()     // Catch: java.lang.Throwable -> L16
            r2 = 1
            r4.mIsStarted = r2     // Catch: java.lang.Throwable -> L16
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlingo.sdk.internal.VLSpotterImpl.startSpotter(com.vlingo.sdk.recognition.spotter.VLSpotterContext):boolean");
    }

    @Override // com.vlingo.sdk.recognition.spotter.VLSpotter
    public synchronized void stopSpotter() {
        log.debug("stopSpotter()");
        validateInstance();
        if (this.mIsStarted) {
            this.mSensoryJNI.MakeReady();
            this.mIsStarted = false;
        }
    }

    @Override // com.vlingo.sdk.recognition.spotter.VLSpotter
    public synchronized String processShortArray(short[] audioData, int offsetInShorts, int sizeInShorts) {
        String spottedString;
        validateInstance();
        if (!this.mIsStarted) {
            throw new IllegalStateException("Cannot call processShortArray when Spotter is not started.");
        }
        if (offsetInShorts > 0) {
            audioData = Arrays.copyOfRange(audioData, offsetInShorts, sizeInShorts);
        }
        spottedString = this.mSensoryJNI.ProcessShortArray(audioData, sizeInShorts);
        if (spottedString == null || spottedString.length() <= 0) {
            spottedString = null;
        }
        return spottedString;
    }

    @Override // com.vlingo.sdk.recognition.spotter.VLSpotter
    public synchronized float getLastScore() {
        validateInstance();
        if (!this.mIsStarted) {
            throw new IllegalStateException("Cannot call getLastScore when Spotter is not started.");
        }
        return this.mSensoryJNI.GetLastScore();
    }

    @Override // com.vlingo.sdk.recognition.spotter.VLSpotter
    public synchronized String[] getSupportedLanguageList() {
        validateInstance();
        return Settings.SUPPORTED_LANGUAGES;
    }

    private boolean reinitSpotter() {
        log.debug("reinitSpotter");
        this.mSensoryJNI.Deinitialize();
        Context context = ApplicationAdapter.getInstance().getApplicationContext();
        File rawDir = context.getDir(Settings.RAW_PATH, 0);
        String acousticModelFilename = Settings.SPOTTER_ACOUSTIC_MODEL_FILENAME.get(this.mSpotterContext.getLanguage());
        if (acousticModelFilename == null) {
            log.debug("acousticModelFilename == null return false");
            return false;
        }
        String acousticModelPathname = String.valueOf(rawDir.getAbsolutePath()) + File.separator + acousticModelFilename;
        File file = new File(acousticModelPathname);
        if (!file.exists()) {
            log.debug("Could not find acoustic model file: " + acousticModelPathname);
            return false;
        }
        if (this.mSpotterContext.getGrammarSource().isCompiledFileSource()) {
            boolean ret = this.mSensoryJNI.Initialize(acousticModelPathname, this.mSpotterContext.getGrammarSource().getCompiledFilepath(), SensoryJNI.GRAMMAR_FORMALITY_DEFAULT, this.mSpotterContext.getBeam(), this.mSpotterContext.getAbsBeam(), this.mSpotterContext.getAoffset(), this.mSpotterContext.getDelay(), null, 0);
            if (!ret) {
                log.debug("mSensoryJNI.Initialize failed");
                return ret;
            }
            return ret;
        }
        String pronunModelFilename = Settings.SPOTTER_PRONUN_MODEL_FILENAME.get(this.mSpotterContext.getLanguage());
        if (pronunModelFilename == null) {
            log.debug("No pronun model filename defined for language: " + this.mSpotterContext.getLanguage());
            return false;
        }
        String pronunModelPathname = String.valueOf(rawDir.getAbsolutePath()) + File.separator + pronunModelFilename;
        File file2 = new File(pronunModelPathname);
        if (!file2.exists()) {
            log.debug("Could not find pronun model file: " + pronunModelPathname);
            return false;
        }
        boolean ret2 = this.mSensoryJNI.InitializePhrases(acousticModelPathname, pronunModelPathname, this.mSpotterContext.getGrammarSource().getGrammarSpec(), this.mSpotterContext.getGrammarSource().getWordList(), this.mSpotterContext.getGrammarSource().getPronunciationList(), SensoryJNI.GRAMMAR_FORMALITY_DEFAULT, this.mSpotterContext.getBeam(), this.mSpotterContext.getAbsBeam(), this.mSpotterContext.getAoffset(), this.mSpotterContext.getDelay(), null, 0);
        if (!ret2) {
            log.debug("InitializePhrases failed");
            return ret2;
        }
        return ret2;
    }
}
