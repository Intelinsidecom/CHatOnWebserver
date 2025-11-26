package com.vlingo.sdk.recognition;

import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.PackageUtil;
import java.util.HashMap;

/* loaded from: classes.dex */
public class VLActionEvaluator {
    private static Logger log = Logger.getLogger(VLActionEvaluator.class);
    protected HashMap<String, String> variables = new HashMap<>();

    private enum Operator {
        OR,
        AND;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Operator[] valuesCustom() {
            Operator[] operatorArrValuesCustom = values();
            int length = operatorArrValuesCustom.length;
            Operator[] operatorArr = new Operator[length];
            System.arraycopy(operatorArrValuesCustom, 0, operatorArr, 0, length);
            return operatorArr;
        }
    }

    public boolean evaluateAction(VLAction action) throws NumberFormatException {
        String[] exprList;
        if (!action.isConditional()) {
            return true;
        }
        log.debug("Evaluating Action: " + action.getName());
        Operator operator = Operator.OR;
        if (action.getIfCondition().contains("&&")) {
            exprList = action.getIfCondition().split("&&");
            operator = Operator.AND;
        } else if (action.getIfCondition().contains("||")) {
            exprList = action.getIfCondition().split("||");
        } else {
            exprList = new String[]{action.getIfCondition()};
        }
        boolean result = true;
        if (operator == Operator.OR) {
            result = false;
        }
        for (String str : exprList) {
            boolean exprResult = evaluateExpression(str);
            if (operator == Operator.AND) {
                result = result && exprResult;
                if (!result) {
                    break;
                }
            } else if (operator == Operator.OR) {
                result = result || exprResult;
            }
        }
        if (!result && action.getElseStatement() != null && action.getElseStatement().length() > 0) {
            evaluateExpression(action.getElseStatement());
        }
        return result;
    }

    protected boolean evaluateExpression(String expression) throws NumberFormatException {
        String[] params;
        log.debug("Evaluating expression: " + expression);
        int parmStart = expression.indexOf(40);
        int parmEnd = expression.length() - 1;
        String parameters = expression.substring(parmStart + 1, parmEnd);
        String expression2 = expression.substring(0, parmStart);
        if (parameters.contains(",")) {
            params = parameters.split(",");
        } else {
            params = new String[]{parameters};
        }
        boolean invert = false;
        if (expression2.startsWith("!")) {
            expression2 = expression2.substring(1);
            invert = true;
        }
        log.debug("   expr: " + expression2);
        log.debug("   invt: " + invert);
        for (int i = 0; i < params.length; i++) {
            log.debug("   par" + i + ": " + params[i]);
        }
        boolean exprResult = evaluateExpression(expression2, params);
        if (invert) {
            exprResult = !exprResult;
        }
        log.debug("  RESULT: " + exprResult);
        return exprResult;
    }

    protected boolean evaluateExpression(String expression, String[] parameters) throws NumberFormatException {
        if ("is-installed".equalsIgnoreCase(expression)) {
            String packageName = parameters[0];
            int minVersionCode = 0;
            if (parameters.length > 1) {
                try {
                    minVersionCode = Integer.parseInt(parameters[1]);
                } catch (Exception e) {
                    return false;
                }
            }
            return PackageUtil.isAppInstalled(packageName, minVersionCode);
        }
        if ("can-handle".equalsIgnoreCase(expression)) {
            String category = "";
            String uri = "";
            String packageName2 = "";
            if (parameters.length > 1) {
                category = parameters[1];
                if (parameters.length > 2) {
                    uri = parameters[2];
                }
                if (parameters.length > 3) {
                    packageName2 = parameters[3];
                }
            }
            return PackageUtil.canHandleIntent(ApplicationAdapter.getInstance().getApplicationContext(), parameters[0], category, uri, packageName2);
        }
        if ("is-true".equalsIgnoreCase(expression)) {
            return getBooleanVariable(parameters[0]);
        }
        if ("is-false".equalsIgnoreCase(expression)) {
            return !getBooleanVariable(parameters[0]);
        }
        if ("equals".equalsIgnoreCase(expression)) {
            String varName = parameters[0];
            String varVal = parameters[1];
            return varVal.equalsIgnoreCase(getVariable(varName));
        }
        if ("set".equalsIgnoreCase(expression)) {
            setVariable(parameters[0], parameters[1]);
            return true;
        }
        log.error("EVE", "Unhandled expression: " + expression);
        return true;
    }

    protected static boolean isBoolean(String value) {
        return "true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value);
    }

    private String getVariable(String varName) {
        String val = this.variables.get(varName);
        if (val == null) {
            return "";
        }
        return val;
    }

    private void setVariable(String varName, String varValue) {
        this.variables.put(varName, varValue);
    }

    private boolean getBooleanVariable(String varName) {
        String val = getVariable(varName);
        return "true".equalsIgnoreCase(val);
    }
}
