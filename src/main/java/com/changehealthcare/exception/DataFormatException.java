/*
 * -------------------------------------------------------------------------
 
 * PROPRIETARY INFORMATION.  Not for use or disclosure outside Change
 
 * Healthcare,  and its affiliates except under written agreement.
 
 * This is an unpublished, proprietary work of Change Healthcare,
 
 * that is protected by United States copyright laws.  Disclosure,
 
 * copying, reproduction, merger, translation, modification, enhancement,
 
 * or use by anyone other than authorized employees or licensees of
 
 * Change Healthcare, Inc. without the prior written consent of
 
 * Change Healthcare, Inc. is prohibited.
 
 * Copyright (c) 2016 Change Healthcare, Inc.  All rights reserved.
 
 * -------------------------------------------------------------------------
 
 */
package com.changehealthcare.exception;

public final class DataFormatException extends RuntimeException {
    public DataFormatException() {
        super();
    }

    public DataFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFormatException(String message) {
        super(message);
    }

    public DataFormatException(Throwable cause) {
        super(cause);
    }
}
