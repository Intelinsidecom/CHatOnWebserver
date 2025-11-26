package com.p137vk.sdk.api.model;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class VKUser extends VKApiModel {
    public String bdate;
    public long can_post;
    public long can_see_all_posts;
    public long can_see_audio;
    public long can_write_private_message;
    public long city;
    public long common_count;
    public String connections;
    public Map<String, String> contacts;
    public Map<String, String> counters;
    public long country;
    public String domain;
    public Map<String, String> education;
    public String first_name;
    public long has_mobile;

    /* renamed from: id */
    public long f18976id;
    public String last_name;
    public Map<String, String> last_seen;
    public String lists;
    public long online;
    public long online_mobile;
    public String photo_100;
    public String photo_200;
    public String photo_200_orig;
    public String photo_400_orig;
    public String photo_50;
    public String photo_max;
    public String photo_max_orig;
    public long relation;
    public List<Map<String, String>> relatives;
    public List<Map<String, String>> schools;
    public String screen_name;
    public long sex;
    public String site;
    public String status;
    public List<Map<String, String>> universities;

    public String getApproProfileUrl() {
        if (this.photo_max_orig != null) {
            return this.photo_max_orig;
        }
        if (this.photo_max != null) {
            return this.photo_max;
        }
        if (this.photo_400_orig != null) {
            return this.photo_400_orig;
        }
        if (this.photo_200_orig != null) {
            return this.photo_200_orig;
        }
        if (this.photo_200 != null) {
            return this.photo_200;
        }
        if (this.photo_100 != null) {
            return this.photo_100;
        }
        if (this.photo_50 != null) {
            return this.photo_50;
        }
        return "http://vk.com/images/camera_b.gif";
    }
}
