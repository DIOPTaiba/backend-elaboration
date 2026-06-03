package sn.sysbudgep.elaboration.util;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public final class OracleResult {

    private OracleResult() {
        // Empêche l'instanciation
    }

    public static BigDecimal getBigDecimal(Map<String, Object> result, String key) {
        Object value = result.get(key);

        if (value == null) {
            return BigDecimal.ZERO;
        }

        if (value instanceof BigDecimal) {
            return (BigDecimal) value;
        }

        if (value instanceof Number) {
            return BigDecimal.valueOf(((Number) value).doubleValue());
        }

        return BigDecimal.ZERO;
    }

    public static String getString(Map<String, Object> result, String key) {
        Object value = result.get(key);
        return value != null ? value.toString() : "";
    }

    public static Integer getInteger(Map<String, Object> result, String key) {
        Object value = result.get(key);

        if (value == null) {
            return 0;
        }

        return ((Number) value).intValue();
    }
}