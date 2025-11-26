package com.samsung.vip.engine;

import android.graphics.Point;
import android.graphics.PointF;
import com.nuance.nmsp.client.sdk.components.resource.internal.nmas.PDXTransactionImpl;
import com.samsung.vip.engine.shape.GraphPrimitive;
import com.samsung.vip.engine.shape.PrimitiveArc;
import com.samsung.vip.engine.shape.PrimitiveArrow;
import com.samsung.vip.engine.shape.PrimitiveBezier;
import com.samsung.vip.engine.shape.PrimitiveBezierList;
import com.samsung.vip.engine.shape.PrimitiveCircle;
import com.samsung.vip.engine.shape.PrimitiveCircleARC;
import com.samsung.vip.engine.shape.PrimitiveEllipse;
import com.samsung.vip.engine.shape.PrimitiveEllipseArc;
import com.samsung.vip.engine.shape.PrimitiveLine;
import com.samsung.vip.engine.shape.PrimitivePolygon;
import com.samsung.vip.engine.shape.PrimitivePolyline;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class VIShapeGenerator {

    /* renamed from: PI */
    private static final float f2157PI = 3.1415927f;
    private static final int STONE_COUNT_LARGE = 128;
    private static final int STONE_COUNT_SMALL = 64;
    private static final int STONE_COUNT_THRES = 3000;
    private static final int STONE_COUNT_XSMALL = 32;
    private static ArrayList<GraphPrimitive> mShapeList;

    public VIShapeGenerator() {
        mShapeList = new ArrayList<>();
    }

    public void addShape(GraphPrimitive shape) {
        if (mShapeList != null) {
            mShapeList.add(shape);
        }
    }

    public void generate(ArrayList<PointF[]> resultList) {
        ArrayList<PrimitiveArrow> arrowList = new ArrayList<>();
        Iterator<GraphPrimitive> it = mShapeList.iterator();
        while (it.hasNext()) {
            GraphPrimitive shape = it.next();
            short nType = shape.nType;
            short[] PrimitiveData = shape.PrimitiveData;
            switch (nType) {
                case 1:
                    PrimitiveLine line = new PrimitiveLine();
                    CopyDataToLine(line, PrimitiveData, 0);
                    makeLine(resultList, line);
                    break;
                case 2:
                    PrimitiveCircle circle = new PrimitiveCircle();
                    CopyDataToCircle(circle, PrimitiveData, 0);
                    makeCircle(resultList, circle);
                    break;
                case 5:
                    PrimitivePolygon polygon = new PrimitivePolygon();
                    CopyDataToPolygon(polygon, PrimitiveData, 0);
                    makePolygon(resultList, polygon);
                    break;
                case 6:
                    PrimitiveEllipse ellipse = new PrimitiveEllipse();
                    CopyDataToEllipse(ellipse, PrimitiveData, 0);
                    makeEllipse(resultList, ellipse);
                    break;
                case 7:
                    PrimitiveCircleARC circleArc = new PrimitiveCircleARC();
                    CopyDataToCircleArc(circleArc, PrimitiveData, 0);
                    makeCircleArc(resultList, circleArc);
                    break;
                case 8:
                    PrimitiveEllipseArc ellipseArc = new PrimitiveEllipseArc();
                    CopyDataToEllipseArc(ellipseArc, PrimitiveData, 0);
                    makeEllipseArc(resultList, ellipseArc);
                    break;
                case 9:
                    PrimitiveBezierList bezierList = new PrimitiveBezierList();
                    CopyDataToBezier(bezierList, PrimitiveData, 0);
                    makeBezier(resultList, bezierList);
                    break;
                case 10:
                    makeGroupAndObject(resultList, PrimitiveData, arrowList);
                    break;
                case 11:
                    PrimitiveArrow arrow = new PrimitiveArrow();
                    CopyDataToArrow(arrow, PrimitiveData, 0);
                    makeArrow(resultList, arrow);
                    arrowList.add(arrow);
                    break;
                case 12:
                    makeTable(resultList, PrimitiveData);
                    break;
                case 13:
                    PrimitivePolyline polyline = new PrimitivePolyline();
                    CopyDataToPolyline(polyline, PrimitiveData, 0);
                    makePolyline(resultList, polyline);
                    break;
            }
            PointF[] points = new PointF[1];
            resultList.add(points);
        }
    }

    private float getFloat(short[] s) {
        int i = 0 | (s[0] & PDXTransactionImpl.STATE_IDLE);
        return Float.intBitsToFloat(i | (s[1] << 16));
    }

    private int getInt(short[] s) {
        int i = 0 | (s[0] & PDXTransactionImpl.STATE_IDLE);
        return i | (s[1] << 16);
    }

    private float getAngle(float x, float y) {
        if (x == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            if (y == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            }
            if (y > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                return 1.5707964f;
            }
            return 4.712389f;
        }
        if (x <= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            return y == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET ? f2157PI : ((float) Math.atan(y / x)) + f2157PI;
        }
        if (y == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        if (y > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            return (float) Math.atan(y / x);
        }
        return 6.2831855f + ((float) Math.atan(y / x));
    }

    private void CopyDataToLine(PrimitiveLine line, short[] PrimitiveData, int idx) {
        Point start = new Point();
        Point end = new Point();
        int idx2 = idx + 1;
        int idx3 = idx2 + 1;
        short[] short2 = {PrimitiveData[idx], PrimitiveData[idx2]};
        start.x = getInt(short2);
        int idx4 = idx3 + 1;
        short2[0] = PrimitiveData[idx3];
        int idx5 = idx4 + 1;
        short2[1] = PrimitiveData[idx4];
        start.y = getInt(short2);
        int idx6 = idx5 + 1;
        short2[0] = PrimitiveData[idx5];
        int idx7 = idx6 + 1;
        short2[1] = PrimitiveData[idx6];
        end.x = getInt(short2);
        int idx8 = idx7 + 1;
        short2[0] = PrimitiveData[idx7];
        int i = idx8 + 1;
        short2[1] = PrimitiveData[idx8];
        end.y = getInt(short2);
        line.setStart(start);
        line.setEnd(end);
    }

    private void CopyDataToCircle(PrimitiveCircle circle, short[] PrimitiveData, int idx) {
        Point center = new Point();
        int idx2 = idx + 1;
        int idx3 = idx2 + 1;
        short[] short2 = {PrimitiveData[idx], PrimitiveData[idx2]};
        center.x = getInt(short2);
        int idx4 = idx3 + 1;
        short2[0] = PrimitiveData[idx3];
        int idx5 = idx4 + 1;
        short2[1] = PrimitiveData[idx4];
        center.y = getInt(short2);
        circle.setCenter(center);
        int i = idx5 + 1;
        circle.setRadius(PrimitiveData[idx5]);
    }

    private void CopyDataToEllipse(PrimitiveEllipse ellipse, short[] PrimitiveData, int idx) {
        Point center = new Point();
        int idx2 = idx + 1;
        int idx3 = idx2 + 1;
        short[] short2 = {PrimitiveData[idx], PrimitiveData[idx2]};
        center.x = getInt(short2);
        int idx4 = idx3 + 1;
        short2[0] = PrimitiveData[idx3];
        int idx5 = idx4 + 1;
        short2[1] = PrimitiveData[idx4];
        center.y = getInt(short2);
        ellipse.setCenter(center);
        int idx6 = idx5 + 1;
        ellipse.setLongAxis(PrimitiveData[idx5]);
        int idx7 = idx6 + 1;
        ellipse.setShortAxis(PrimitiveData[idx6]);
        int idx8 = idx7 + 1;
        short2[0] = PrimitiveData[idx7];
        int idx9 = idx8 + 1;
        short2[1] = PrimitiveData[idx8];
        ellipse.setCosTheta(getFloat(short2));
        int idx10 = idx9 + 1;
        short2[0] = PrimitiveData[idx9];
        int i = idx10 + 1;
        short2[1] = PrimitiveData[idx10];
        ellipse.setSinTheta(getFloat(short2));
    }

    private void CopyDataToCircleArc(PrimitiveCircleARC circleArc, short[] PrimitiveData, int idx) {
        short s = PrimitiveData[1];
        Point center = new Point();
        Point start = new Point();
        Point end = new Point();
        int idx2 = idx + 1;
        int idx3 = idx2 + 1;
        short[] short2 = {PrimitiveData[idx], PrimitiveData[idx2]};
        center.x = getInt(short2);
        int idx4 = idx3 + 1;
        short2[0] = PrimitiveData[idx3];
        int idx5 = idx4 + 1;
        short2[1] = PrimitiveData[idx4];
        center.y = getInt(short2);
        circleArc.setCenter(center);
        int idx6 = idx5 + 1;
        short2[0] = PrimitiveData[idx5];
        int idx7 = idx6 + 1;
        short2[1] = PrimitiveData[idx6];
        start.x = getInt(short2);
        int idx8 = idx7 + 1;
        short2[0] = PrimitiveData[idx7];
        int idx9 = idx8 + 1;
        short2[1] = PrimitiveData[idx8];
        start.y = getInt(short2);
        circleArc.setStart(start);
        int idx10 = idx9 + 1;
        short2[0] = PrimitiveData[idx9];
        int idx11 = idx10 + 1;
        short2[1] = PrimitiveData[idx10];
        end.x = getInt(short2);
        int idx12 = idx11 + 1;
        short2[0] = PrimitiveData[idx11];
        int idx13 = idx12 + 1;
        short2[1] = PrimitiveData[idx12];
        end.y = getInt(short2);
        circleArc.setEnd(end);
        int idx14 = idx13 + 1;
        circleArc.setRadius(PrimitiveData[idx13]);
        int i = idx14 + 1;
        circleArc.setDirection(PrimitiveData[idx14]);
    }

    private void CopyDataToEllipseArc(PrimitiveEllipseArc ellipseArc, short[] primitiveData, int idx) {
        Point center = new Point();
        Point start = new Point();
        Point end = new Point();
        int idx2 = idx + 1;
        int idx3 = idx2 + 1;
        short[] short2 = {primitiveData[idx], primitiveData[idx2]};
        center.x = getInt(short2);
        int idx4 = idx3 + 1;
        short2[0] = primitiveData[idx3];
        int idx5 = idx4 + 1;
        short2[1] = primitiveData[idx4];
        center.y = getInt(short2);
        ellipseArc.setCenter(center);
        int idx6 = idx5 + 1;
        short2[0] = primitiveData[idx5];
        int idx7 = idx6 + 1;
        short2[1] = primitiveData[idx6];
        start.x = getInt(short2);
        int idx8 = idx7 + 1;
        short2[0] = primitiveData[idx7];
        int idx9 = idx8 + 1;
        short2[1] = primitiveData[idx8];
        start.y = getInt(short2);
        ellipseArc.setStart(start);
        int idx10 = idx9 + 1;
        short2[0] = primitiveData[idx9];
        int idx11 = idx10 + 1;
        short2[1] = primitiveData[idx10];
        end.x = getInt(short2);
        int idx12 = idx11 + 1;
        short2[0] = primitiveData[idx11];
        int idx13 = idx12 + 1;
        short2[1] = primitiveData[idx12];
        end.y = getInt(short2);
        ellipseArc.setEnd(end);
        int idx14 = idx13 + 1;
        ellipseArc.setLongAxis(primitiveData[idx13]);
        int idx15 = idx14 + 1;
        ellipseArc.setShortAxis(primitiveData[idx14]);
        int idx16 = idx15 + 1;
        short2[0] = primitiveData[idx15];
        int idx17 = idx16 + 1;
        short2[1] = primitiveData[idx16];
        ellipseArc.setCosTheta(getFloat(short2));
        int idx18 = idx17 + 1;
        short2[0] = primitiveData[idx17];
        int idx19 = idx18 + 1;
        short2[1] = primitiveData[idx18];
        ellipseArc.setSinTheta(getFloat(short2));
        int i = idx19 + 1;
        ellipseArc.setDirection(primitiveData[idx19]);
    }

    private void CopyDataToPolygon(PrimitivePolygon polygon, short[] primitiveData, int idx) {
        ArrayList<Point> points = new ArrayList<>();
        short s = primitiveData[idx];
        for (int i = 0; i < s; i++) {
            Point point = new Point();
            point.x = primitiveData[idx + 2 + (i * 2) + 0];
            point.y = primitiveData[idx + 2 + (i * 2) + 1];
            points.add(point);
        }
        polygon.setPoints(points);
    }

    private void CopyDataToPolyline(PrimitivePolyline polyline, short[] primitiveData, int idx) {
        ArrayList<Point> points = new ArrayList<>();
        short s = primitiveData[idx];
        for (int i = 0; i < s; i++) {
            Point point = new Point();
            point.x = primitiveData[idx + 2 + (i * 2) + 0];
            point.y = primitiveData[idx + 2 + (i * 2) + 1];
            points.add(point);
        }
        polyline.setPoints(points);
    }

    private void CopyDataToArrow(PrimitiveArrow arrow, short[] primitiveData, int idx) {
        Point start = new Point();
        int idx2 = idx + 1;
        int idx3 = idx2 + 1;
        short[] short2 = {primitiveData[idx], primitiveData[idx2]};
        start.x = getInt(short2);
        int idx4 = idx3 + 1;
        short2[0] = primitiveData[idx3];
        int idx5 = idx4 + 1;
        short2[1] = primitiveData[idx4];
        start.y = getInt(short2);
        Point end = new Point();
        int idx6 = idx5 + 1;
        short2[0] = primitiveData[idx5];
        int idx7 = idx6 + 1;
        short2[1] = primitiveData[idx6];
        end.x = getInt(short2);
        int idx8 = idx7 + 1;
        short2[0] = primitiveData[idx7];
        int idx9 = idx8 + 1;
        short2[1] = primitiveData[idx8];
        end.y = getInt(short2);
        Point left = new Point();
        int idx10 = idx9 + 1;
        short2[0] = primitiveData[idx9];
        int idx11 = idx10 + 1;
        short2[1] = primitiveData[idx10];
        left.x = getInt(short2);
        int idx12 = idx11 + 1;
        short2[0] = primitiveData[idx11];
        int idx13 = idx12 + 1;
        short2[1] = primitiveData[idx12];
        left.y = getInt(short2);
        Point right = new Point();
        int idx14 = idx13 + 1;
        short2[0] = primitiveData[idx13];
        int idx15 = idx14 + 1;
        short2[1] = primitiveData[idx14];
        right.x = getInt(short2);
        int idx16 = idx15 + 1;
        short2[0] = primitiveData[idx15];
        int i = idx16 + 1;
        short2[1] = primitiveData[idx16];
        right.y = getInt(short2);
        arrow.setStart(start);
        arrow.setEnd(end);
        arrow.setLeft(left);
        arrow.setRight(right);
    }

    private void CopyDataToBezier(PrimitiveBezierList bezierList, short[] primitiveData, int idx) {
        List<PrimitiveBezier> bezierLists = new ArrayList<>();
        short s = primitiveData[idx];
        int idx2 = idx + 2;
        for (int i = 0; i < s; i++) {
            PrimitiveBezier bezier = new PrimitiveBezier();
            Point control01 = new Point();
            Point control02 = new Point();
            Point control03 = new Point();
            Point control04 = new Point();
            int idx3 = idx2 + 1;
            control01.x = primitiveData[idx2];
            int idx4 = idx3 + 1;
            control01.y = primitiveData[idx3];
            int idx5 = idx4 + 1;
            control02.x = primitiveData[idx4];
            int idx6 = idx5 + 1;
            control02.y = primitiveData[idx5];
            int idx7 = idx6 + 1;
            control03.x = primitiveData[idx6];
            int idx8 = idx7 + 1;
            control03.y = primitiveData[idx7];
            int idx9 = idx8 + 1;
            control04.x = primitiveData[idx8];
            idx2 = idx9 + 1;
            control04.y = primitiveData[idx9];
            bezier.setControl01(control01);
            bezier.setControl02(control02);
            bezier.setControl03(control03);
            bezier.setControl04(control04);
            bezierLists.add(bezier);
        }
        bezierList.setBezierList(bezierLists);
    }

    private void makeLine(ArrayList<PointF[]> resultList, PrimitiveLine data) {
        Point p1 = data.getStart();
        Point p2 = data.getEnd();
        PointF[] points = {new PointF(p1.x, p1.y), new PointF((p1.x + p2.x) / 2, (p1.y + p2.y) / 2), new PointF(p2.x, p2.y)};
        resultList.add(points);
    }

    private void makeCircle(ArrayList<PointF[]> resultList, PrimitiveCircle data) {
        makeArc(resultList, new PointF(data.getCenter()), data.getRadius(), data.getRadius(), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false, null, null, 1);
    }

    private void makeEllipse(ArrayList<PointF[]> resultList, PrimitiveEllipse data) {
        makeArc(resultList, new PointF(data.getCenter()), data.getShortAxis(), data.getLongAxis(), getAngle(data.getCosTheta(), data.getSinTheta()), false, null, null, 1);
    }

    private void makeCircleArc(ArrayList<PointF[]> resultList, PrimitiveCircleARC data) {
        makeArc(resultList, new PointF(data.getCenter()), data.getRadius(), data.getRadius(), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, true, new PointF(data.getStart()), new PointF(data.getEnd()), data.getDirection());
    }

    private void makeEllipseArc(ArrayList<PointF[]> resultList, PrimitiveEllipseArc data) {
        makeEllipseArcDirect(resultList, data);
    }

    private void makeEllipseArcDirect(ArrayList<PointF[]> resultList, PrimitiveEllipseArc ellipseArc) {
        int stoneCount;
        PointF StandardStart = Trans_PointF(POINT_2_POINT_F(ellipseArc.getStart()), ellipseArc.getCenter(), ellipseArc.getCosTheta(), ellipseArc.getSinTheta(), -1);
        PointF StandardEnd = Trans_PointF(POINT_2_POINT_F(ellipseArc.getEnd()), ellipseArc.getCenter(), ellipseArc.getCosTheta(), ellipseArc.getSinTheta(), -1);
        PointF CurStandardPoint = new PointF();
        float StartAlpha = get_rad_ellipse_f(StandardStart, ellipseArc.getLongAxis(), ellipseArc.getShortAxis());
        float EndAlpha = get_rad_ellipse_f(StandardEnd, ellipseArc.getLongAxis(), ellipseArc.getShortAxis());
        int Direction = ellipseArc.getDirection();
        if (Direction == 1) {
            if (StartAlpha > EndAlpha) {
                EndAlpha = (float) (EndAlpha + 6.283185307179586d);
            }
        } else if (StartAlpha < EndAlpha) {
            EndAlpha = (float) (EndAlpha - 6.283185307179586d);
        }
        float sweepAngle = EndAlpha - StartAlpha;
        float approximateLength = (ellipseArc.getShortAxis() + ellipseArc.getLongAxis()) * Math.abs(sweepAngle);
        if (approximateLength > 3000.0f) {
            stoneCount = 128;
        } else {
            stoneCount = 64;
        }
        float stone = sweepAngle / stoneCount;
        PointF[] points = new PointF[stoneCount + 1];
        for (int i = 0; i < stoneCount + 1; i++) {
            float CurAlpha = StartAlpha + (i * stone);
            CurStandardPoint.x = (int) (ellipseArc.getLongAxis() * Math.cos(CurAlpha));
            CurStandardPoint.y = (int) (ellipseArc.getShortAxis() * Math.sin(CurAlpha));
            PointF CurPoint = Trans_PointF(CurStandardPoint, ellipseArc.getCenter(), ellipseArc.getCosTheta(), ellipseArc.getSinTheta(), 1);
            points[i] = new PointF(CurPoint.x, CurPoint.y);
        }
        resultList.add(points);
    }

    private PointF Trans_PointF(PointF mypoint, Point Center, float cos_theta, float sin_theta, int trans_direction) {
        PointF trans_point = new PointF();
        if (trans_direction == 1) {
            trans_point.x = ((mypoint.x * cos_theta) - (mypoint.y * sin_theta)) + Center.x;
            trans_point.y = (mypoint.x * sin_theta) + (mypoint.y * cos_theta) + Center.y;
        } else {
            trans_point.x = ((mypoint.x - Center.x) * cos_theta) + ((mypoint.y - Center.y) * sin_theta);
            trans_point.y = ((-sin_theta) * (mypoint.x - Center.x)) + ((mypoint.y - Center.y) * cos_theta);
        }
        return trans_point;
    }

    private PointF POINT_2_POINT_F(Point p) {
        PointF pf = new PointF();
        pf.x = p.x;
        pf.y = p.y;
        return pf;
    }

    private float get_rad_ellipse_f(PointF mypoint, float longAxis, float shortAxis) {
        float x = mypoint.x;
        float y = mypoint.y;
        float len = (float) Math.atan2(y / shortAxis, x / longAxis);
        if (len < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            return (float) (len + 6.283185307179586d);
        }
        return len;
    }

    private void makeArc(ArrayList<PointF[]> resultList, PointF center, float minRadius, float maxRadius, float orientation, boolean bArc, PointF startPt, PointF endPt, int direction) {
        float sweepAngle;
        PrimitiveArc arc = new PrimitiveArc();
        arc.setCenter(center);
        arc.setMinRadius(minRadius);
        arc.setMaxRadius(maxRadius);
        arc.setOrientation(orientation);
        if (bArc) {
            float angle1 = getAngle(startPt.x - center.x, startPt.y - center.y);
            float angle2 = getAngle(endPt.x - center.x, endPt.y - center.y);
            arc.setStartAngle(angle1);
            if (direction > 0) {
                if (angle1 > angle2) {
                    sweepAngle = 6.2831855f - (angle1 - angle2);
                } else {
                    sweepAngle = angle2 - angle1;
                }
            } else if (angle1 > angle2) {
                sweepAngle = angle2 - angle1;
            } else {
                sweepAngle = (angle2 - angle1) - 6.2831855f;
            }
            arc.setSweepAngle(sweepAngle);
        } else {
            arc.setStartAngle(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            arc.setSweepAngle(6.2831855f);
        }
        makeArc(resultList, arc);
    }

    private void makeArc(ArrayList<PointF[]> resultList, PrimitiveArc data) {
        int stoneCount;
        PointF center = data.getCenter();
        float cx = center.x;
        float cy = center.y;
        float minR = data.getMinRadius();
        float maxR = data.getMaxRadius();
        float orientation = data.getOrientation();
        float startAngle = data.getStartAngle();
        float sweepAngle = data.getSweepAngle();
        float approximateLength = (minR + maxR) * Math.abs(sweepAngle);
        if (approximateLength > 3000.0f) {
            stoneCount = 128;
        } else {
            stoneCount = 64;
        }
        float stone = sweepAngle / stoneCount;
        PointF[] points = new PointF[stoneCount + 1];
        for (int i = 0; i < stoneCount + 1; i++) {
            float angle = startAngle + (i * stone);
            float x = (float) ((cx + ((maxR * Math.cos(angle)) * Math.cos(orientation))) - ((minR * Math.sin(angle)) * Math.sin(orientation)));
            float y = (float) (cy + (maxR * Math.cos(angle) * Math.sin(orientation)) + (minR * Math.sin(angle) * Math.cos(orientation)));
            points[i] = new PointF(x, y);
        }
        resultList.add(points);
    }

    private void makePolygon(ArrayList<PointF[]> resultList, PrimitivePolygon data) {
        ArrayList<Point> points = data.getPoints();
        if (points != null) {
            int pointSize = points.size();
            for (int i = 0; i < pointSize; i++) {
                PrimitiveLine line = new PrimitiveLine();
                line.setStart(points.get(i));
                if (i < pointSize - 1) {
                    line.setEnd(points.get(i + 1));
                } else {
                    line.setEnd(points.get(0));
                }
                makeLine(resultList, line);
            }
        }
    }

    private void makePolyline(ArrayList<PointF[]> resultList, PrimitivePolyline data) {
        ArrayList<Point> points = data.getPoints();
        if (points != null) {
            int pointSize = points.size();
            for (int i = 0; i < pointSize - 1; i++) {
                PrimitiveLine line = new PrimitiveLine();
                line.setStart(points.get(i));
                line.setEnd(points.get(i + 1));
                makeLine(resultList, line);
            }
        }
    }

    private void makeArrow(ArrayList<PointF[]> resultList, PrimitiveArrow data) {
        PrimitiveLine line = new PrimitiveLine();
        line.setStart(data.getStart());
        line.setEnd(data.getEnd());
        makeLine(resultList, line);
        line.setStart(data.getEnd());
        line.setEnd(data.getLeft());
        makeLine(resultList, line);
        line.setStart(data.getEnd());
        line.setEnd(data.getRight());
        makeLine(resultList, line);
    }

    private void makeGroupAndObject(ArrayList<PointF[]> resultList, short[] PrimitiveData, ArrayList<PrimitiveArrow> arrowList) {
        short s = PrimitiveData[0];
        int kp = 0 + 2;
        ArrayList<PrimitiveLine> lineList = new ArrayList<>();
        for (int k = 0; k < s; k++) {
            short nType = PrimitiveData[kp];
            kp += 2;
            if (nType == 1) {
                PrimitiveLine groupLine = new PrimitiveLine();
                CopyDataToLine(groupLine, PrimitiveData, kp);
                lineList.add(groupLine);
                kp += 8;
            } else if (nType == 2) {
                PrimitiveCircle groupCircle = new PrimitiveCircle();
                CopyDataToCircle(groupCircle, PrimitiveData, kp);
                makeCircle(resultList, groupCircle);
                kp += 6;
            } else if (nType == 6) {
                PrimitiveEllipse groupEllipse = new PrimitiveEllipse();
                CopyDataToEllipse(groupEllipse, PrimitiveData, kp);
                makeEllipse(resultList, groupEllipse);
                kp += 10;
            } else if (nType == 7) {
                PrimitiveCircleARC groupCircleArc = new PrimitiveCircleARC();
                CopyDataToCircleArc(groupCircleArc, PrimitiveData, kp);
                makeCircleArc(resultList, groupCircleArc);
                kp += 14;
            } else if (nType == 8) {
                PrimitiveEllipseArc groupEllipseArc = new PrimitiveEllipseArc();
                CopyDataToEllipseArc(groupEllipseArc, PrimitiveData, kp);
                makeEllipseArc(resultList, groupEllipseArc);
                kp += 20;
            } else if (nType == 5) {
                PrimitivePolygon groupPolygon = new PrimitivePolygon();
                CopyDataToPolygon(groupPolygon, PrimitiveData, kp);
                makePolygon(resultList, groupPolygon);
                kp += (groupPolygon.getPoints().size() * 4) + 2;
            } else if (nType == 13) {
                PrimitivePolyline groupPolyline = new PrimitivePolyline();
                CopyDataToPolyline(groupPolyline, PrimitiveData, kp);
                makePolyline(resultList, groupPolyline);
                kp += (groupPolyline.getPoints().size() * 4) + 2;
            } else if (nType == 9) {
                PrimitiveBezierList groupBezier = new PrimitiveBezierList();
                CopyDataToBezier(groupBezier, PrimitiveData, kp);
                makeBezier(resultList, groupBezier);
                kp += (groupBezier.getBezierList().size() * 2 * 4) + 2;
            } else if (nType == 11) {
                PrimitiveArrow groupArrow = new PrimitiveArrow();
                CopyDataToArrow(groupArrow, PrimitiveData, kp);
                makeArrow(resultList, groupArrow);
                kp += 16;
            }
        }
        if (arrowList != null && arrowList.size() > 0 && lineList.size() == 5) {
            makeExceptionalProcessForDoubleArrow(resultList, arrowList, lineList);
            return;
        }
        for (int i = 0; i < lineList.size(); i++) {
            makeLine(resultList, lineList.get(i));
        }
    }

    private void makeExceptionalProcessForDoubleArrow(ArrayList<PointF[]> resultList, ArrayList<PrimitiveArrow> arrowList, ArrayList<PrimitiveLine> lineList) {
        boolean bDoubleArrow = false;
        int i = 0;
        while (true) {
            if (i >= arrowList.size()) {
                break;
            }
            PrimitiveLine mainLine = lineList.get(0);
            PrimitiveLine line = new PrimitiveLine();
            line.setStart(arrowList.get(i).getStart());
            line.setEnd(arrowList.get(i).getEnd());
            if (!mainLine.isEqual(line, true)) {
                i++;
            } else {
                bDoubleArrow = true;
                break;
            }
        }
        if (bDoubleArrow) {
            makeLine(resultList, lineList.get(1));
            makeLine(resultList, lineList.get(2));
        } else {
            for (int i2 = 0; i2 < lineList.size(); i2++) {
                makeLine(resultList, lineList.get(i2));
            }
        }
    }

    private void makeBezier(ArrayList<PointF[]> resultList, PrimitiveBezierList bezierList) {
        int nIndex;
        int listSize = bezierList.getBezierList().size();
        int nIndex2 = 0;
        int nPointSize = listSize * 33;
        PointF[] points = new PointF[nPointSize];
        int i = 0;
        while (i < listSize) {
            PrimitiveBezier bezier = bezierList.getBezierList().get(i);
            PointF ctrlPt1 = new PointF(bezier.getControl01());
            PointF ctrlPt2 = new PointF(bezier.getControl02());
            PointF ctrlPt3 = new PointF(bezier.getControl03());
            PointF ctrlPt4 = new PointF(bezier.getControl04());
            int j = 0;
            while (true) {
                nIndex = nIndex2;
                if (j >= 33) {
                    break;
                }
                float t = j / 32;
                if (nIndex < nPointSize) {
                    if (j == 32) {
                        nIndex2 = nIndex + 1;
                        points[nIndex] = getBezierPoint(1.0f, ctrlPt1, ctrlPt2, ctrlPt3, ctrlPt4);
                    } else {
                        nIndex2 = nIndex + 1;
                        points[nIndex] = getBezierPoint(t, ctrlPt1, ctrlPt2, ctrlPt3, ctrlPt4);
                    }
                    j++;
                }
            }
            i++;
            nIndex2 = nIndex;
        }
        resultList.add(points);
    }

    private PointF getBezierPoint(float t, PointF ctrlPt1, PointF ctrlPt2, PointF ctrlPt3, PointF ctrlPt4) {
        float x = getBezierValue(t, ctrlPt1.x, ctrlPt2.x, ctrlPt3.x, ctrlPt4.x);
        float y = getBezierValue(t, ctrlPt1.y, ctrlPt2.y, ctrlPt3.y, ctrlPt4.y);
        return new PointF(x, y);
    }

    private float getBezierValue(float t, float v1, float v2, float v3, float v4) {
        return (float) ((Math.pow(1.0f - t, 3.0d) * v1) + (3.0f * t * Math.pow(1.0f - t, 2.0d) * v2) + (3.0d * Math.pow(t, 2.0d) * (1.0f - t) * v3) + (Math.pow(t, 3.0d) * v4));
    }

    private void makeTable(ArrayList<PointF[]> resultList, short[] PrimitiveData) {
        short s = PrimitiveData[PrimitiveData[1] + 2 + 1];
        short s2 = PrimitiveData[PrimitiveData[1] + 2 + 2];
        for (int i = 0; i < s; i++) {
            PrimitiveLine line = new PrimitiveLine();
            line.setStart(new Point(PrimitiveData[(i * 4) + 2 + 0], PrimitiveData[(i * 4) + 2 + 1]));
            line.setEnd(new Point(PrimitiveData[(i * 4) + 2 + 2], PrimitiveData[(i * 4) + 2 + 3]));
            makeLine(resultList, line);
        }
        for (int j = 0; j < s2; j++) {
            PrimitiveLine line2 = new PrimitiveLine();
            line2.setStart(new Point(PrimitiveData[(s * 4) + 2 + (j * 4) + 0], PrimitiveData[(s * 4) + 2 + (j * 4) + 1]));
            line2.setEnd(new Point(PrimitiveData[(s * 4) + 2 + (j * 4) + 2], PrimitiveData[(s * 4) + 2 + (j * 4) + 3]));
            makeLine(resultList, line2);
        }
    }
}
