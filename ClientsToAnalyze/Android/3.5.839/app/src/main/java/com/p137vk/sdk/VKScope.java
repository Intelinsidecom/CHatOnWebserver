package com.p137vk.sdk;

import android.hardware.motion.MotionRecognitionManager;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VKScope {
    public static final String ADS = "ads";
    public static final String AUDIO = "audio";
    public static final String DOCS = "docs";
    public static final String FRIENDS = "friends";
    public static final String GROUPS = "groups";
    public static final String MESSAGES = "messages";
    public static final String NOHTTPS = "nohttps";
    public static final String NOTES = "notes";
    public static final String NOTIFICATIONS = "notifications";
    public static final String NOTIFY = "notify";
    public static final String OFFLINE = "offline";
    public static final String PAGES = "pages";
    public static final String PHOTOS = "photos";
    public static final String STATS = "stats";
    public static final String STATUS = "status";
    public static final String VIDEO = "video";
    public static final String WALL = "wall";

    public static ArrayList<String> parseVkPermissionsFromInteger(int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        if ((i & 1) > 0) {
            arrayList.add(NOTIFY);
        }
        if ((i & 2) > 0) {
            arrayList.add(FRIENDS);
        }
        if ((i & 4) > 0) {
            arrayList.add(PHOTOS);
        }
        if ((i & 8) > 0) {
            arrayList.add("audio");
        }
        if ((i & 16) > 0) {
            arrayList.add("video");
        }
        if ((i & 128) > 0) {
            arrayList.add(PAGES);
        }
        if ((i & 1024) > 0) {
            arrayList.add("status");
        }
        if ((i & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) > 0) {
            arrayList.add(NOTES);
        }
        if ((i & 4096) > 0) {
            arrayList.add(MESSAGES);
        }
        if ((i & MotionRecognitionManager.EVENT_FLAT) > 0) {
            arrayList.add(WALL);
        }
        if ((32768 & i) > 0) {
            arrayList.add(ADS);
        }
        if ((65536 & i) > 0) {
            arrayList.add(OFFLINE);
        }
        if ((131072 & i) > 0) {
            arrayList.add(DOCS);
        }
        if ((262144 & i) > 0) {
            arrayList.add(GROUPS);
        }
        if ((524288 & i) > 0) {
            arrayList.add(NOTIFICATIONS);
        }
        if ((1048576 & i) > 0) {
            arrayList.add(STATS);
        }
        return arrayList;
    }
}
