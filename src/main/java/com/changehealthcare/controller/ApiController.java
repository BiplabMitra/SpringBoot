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
package com.changehealthcare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the controller class for API
 */
@RestController
@RequestMapping(value = "/api/v1/sample")
@Api(value = "sample")
public class ApiController {

	/**
	 * sample service .
	 * @param null
	 * @return String
	 * @throws Exception
	 */
	@ApiOperation(value = "sample use of swagger.", notes = "Returns the URL of the new resource in the Location header.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "RestService1", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	
	public String createSampleOne(HttpServletRequest request, HttpServletResponse response) {
		return "sampe response";
		
	}

	/**
	 * sample service 2 .
	 * @param String
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "RestService2/{param}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "sample use of swagger.", notes = "Returns the URL of the new resource in the Location header.")
	
	public String createSampleTwo(@ApiParam(value = "param", required = false) @PathVariable("param") String param,
			HttpServletRequest request, HttpServletResponse response) {
		return "sampe response 2:" + param;
		
	}
}
