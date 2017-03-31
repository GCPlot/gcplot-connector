package com.gcplot.connector;

import com.google.common.base.Strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum SourceType {

    NONE("none"), INTERNAL("gcp"), S3("s3"), GCS("gcs");

    private static final Map<String, SourceType> VALUES;

    static {
        HashMap<String, SourceType> values = new HashMap<>();
        for (SourceType st : values()) {
            values.put(st.getUrn(), st);
        }
        VALUES = Collections.unmodifiableMap(values);
    }

    public static SourceType by(String urn) {
        return VALUES.get(Strings.nullToEmpty(urn).toLowerCase());
    }

    private String urn;
    public String getUrn() {
        return urn;
    }

    SourceType(String urn) {
        this.urn = urn;
    }
}
