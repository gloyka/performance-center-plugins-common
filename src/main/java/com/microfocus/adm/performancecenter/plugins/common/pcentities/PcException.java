package com.microfocus.adm.performancecenter.plugins.common.pcentities;

public class PcException extends Exception {
    private static final long serialVersionUID = -4036530091360617367L;

    // Default constructor
    public PcException() {
        super();
    }

    // Constructor with message
    public PcException(String message) {
        super(message);
    }

    // Constructor with message and cause
    public PcException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with cause only
    public PcException(Throwable cause) {
        super(cause);
    }
}