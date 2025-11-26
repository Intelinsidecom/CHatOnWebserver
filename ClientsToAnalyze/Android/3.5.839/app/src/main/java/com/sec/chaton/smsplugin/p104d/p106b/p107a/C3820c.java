package com.sec.chaton.smsplugin.p104d.p106b.p107a;

import android.hardware.motion.MotionRecognitionManager;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import org.p146b.p147a.p149b.InterfaceC5246f;
import org.p146b.p147a.p149b.InterfaceC5247g;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/* compiled from: SmilXmlSerializer.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.a.c */
/* loaded from: classes.dex */
public class C3820c {
    /* renamed from: a */
    public static void m14513a(InterfaceC5246f interfaceC5246f, OutputStream outputStream) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"), MotionRecognitionManager.EVENT_TILT_TO_UNLOCK);
            m14512a(bufferedWriter, interfaceC5246f.getDocumentElement());
            bufferedWriter.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m14512a(Writer writer, Element element) throws IOException {
        writer.write(60);
        writer.write(element.getTagName());
        if (element.hasAttributes()) {
            NamedNodeMap attributes = element.getAttributes();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= attributes.getLength()) {
                    break;
                }
                Attr attr = (Attr) attributes.item(i2);
                if (attr != null) {
                    writer.write(" " + attr.getName());
                    writer.write("=\"" + attr.getValue() + "\"");
                }
                i = i2 + 1;
            }
        }
        InterfaceC5247g interfaceC5247g = (InterfaceC5247g) element.getFirstChild();
        if (interfaceC5247g != null) {
            writer.write(62);
            do {
                m14512a(writer, interfaceC5247g);
                interfaceC5247g = (InterfaceC5247g) interfaceC5247g.getNextSibling();
            } while (interfaceC5247g != null);
            writer.write("</");
            writer.write(element.getTagName());
            writer.write(62);
            return;
        }
        writer.write("/>");
    }
}
