package com.vlingo.sdk.internal;

import android.os.Handler;
import com.vlingo.sdk.VLComponent;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.recognition.VLRecognizer;
import com.vlingo.sdk.recognition.speech.VLSpeechDetector;
import com.vlingo.sdk.recognition.spotter.VLSpotter;
import com.vlingo.sdk.services.VLServices;
import com.vlingo.sdk.training.VLTrainer;
import com.vlingo.sdk.tts.VLTextToSpeech;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class VLComponentManager {
    private static Logger log = Logger.getLogger(VLComponentManager.class);
    private ConcurrentHashMap<Class<? extends VLComponentImpl>, VLComponent> mComponents = new ConcurrentHashMap<>();
    private Handler mHandler;

    public VLComponentManager(Handler handler) {
        this.mHandler = handler;
    }

    public VLRecognizer getRecognizer() {
        return (VLRecognizer) getComponent(VLRecognizerImpl.class);
    }

    public VLTrainer getTrainer() {
        return (VLTrainer) getComponent(VLTrainerImpl.class);
    }

    public VLTextToSpeech getTextToSpeech() {
        return (VLTextToSpeech) getComponent(VLTextToSpeechImpl.class);
    }

    public VLServices getVLServices() {
        return (VLServices) getComponent(VLServicesImpl.class);
    }

    public VLSpotter getSpotter() {
        return (VLSpotter) getComponent(VLSpotterImpl.class);
    }

    public VLSpeechDetector getSpeechDetector() {
        return (VLSpeechDetector) getComponent(VLSpeechDetectorImpl.class);
    }

    VLComponent getComponent(Class<? extends VLComponentImpl> componentClass) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        log.debug("getComponent() " + componentClass);
        VLComponent component = this.mComponents.get(componentClass);
        if (component == null) {
            log.debug("  no existing instance found, creating a new one...");
            try {
                Constructor<? extends VLComponentImpl> componentConst = componentClass.getConstructor(getClass(), Handler.class);
                component = componentConst.newInstance(this, this.mHandler);
                this.mComponents.put(componentClass, component);
                return component;
            } catch (Exception e) {
                log.debug("  error creating new component instance");
                e.printStackTrace();
                return component;
            }
        }
        log.debug("  existing instance found, returning it...");
        return component;
    }

    void removeComponent(Class<? extends VLComponentImpl> componentClass) {
        log.debug("removeComponent() " + componentClass);
        this.mComponents.remove(componentClass);
    }

    public void destroyAll() {
        log.debug("destroyAll()");
        for (Class<? extends VLComponentImpl> key : this.mComponents.keySet()) {
            VLComponent c = this.mComponents.remove(key);
            log.debug("  destroying: " + c);
            c.destroy();
        }
    }

    public void replaceRecognizer(VLRecognizer newRecognizer) {
        this.mComponents.put(VLRecognizerImpl.class, newRecognizer);
    }
}
