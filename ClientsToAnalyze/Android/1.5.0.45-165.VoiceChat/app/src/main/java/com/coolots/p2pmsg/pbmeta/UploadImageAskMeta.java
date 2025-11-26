package com.coolots.p2pmsg.pbmeta;

import com.google.protobuf.ByteString;

/* loaded from: classes.dex */
public class UploadImageAskMeta extends ProtoBufMetaBase {
    public UploadImageAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ImageType", 1, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("ImageByteString", 2, true, ByteString.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ThumbnailImageByteString", 3, true, ByteString.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyGroupCode", 4, true, Long.TYPE));
    }
}
