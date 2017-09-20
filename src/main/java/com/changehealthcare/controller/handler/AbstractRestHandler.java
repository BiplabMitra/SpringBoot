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
package com.changehealthcare.controller.handler;

import com.changehealthcare.exception.DataFormatException;
import com.changehealthcare.exception.ResourceNotFoundException;
import com.changehealthcare.exception.RestErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class is meant to be extended by all REST resource "controllers".
 * It contains exception mapping and other common REST API functionality
 */
//@ControllerAdvice? <better to use controller advice for better ex ception handle>
public abstract class AbstractRestHandler implements ApplicationEventPublisherAware {

	  protected final Logger log = LoggerFactory.getLogger(this.getClass());
	    protected ApplicationEventPublisher eventPublisher;

	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(DataFormatException.class)
	    public
	    @ResponseBody
	    RestErrorInfo handleDataStoreException(DataFormatException dataFormatException, WebRequest request, 
	    		HttpServletResponse response) {
	        log.info("Converting Data Store exception to RestResponse : " + dataFormatException.getMessage());

	        return new RestErrorInfo(dataFormatException, "<get error code from CHC >.");
	    }

	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    @ExceptionHandler(ResourceNotFoundException.class)
	    public
	    @ResponseBody
	    RestErrorInfo handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, 
	    		WebRequest request, HttpServletResponse response) {
	        log.info("ResourceNotFoundException handler:" + resourceNotFoundException.getMessage());

	        return new RestErrorInfo(resourceNotFoundException, "<get error code from CHC >.");
	    }

	    
	    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
	        this.eventPublisher = applicationEventPublisher;
	    }

	    
	    public static <T> T checkResourceFound(final T resource) {
	        if (resource == null) {
	            throw new ResourceNotFoundException("resource not found");
	        }
	        return resource;
	    }

	}
