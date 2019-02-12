package com.microservices.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ZuulFilterPre extends ZuulFilter {

	@Override
	public Object run() throws ZuulException {
		System.out.println("Pre filter has been executed");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		//RequestContext.getCurrentContext().;
		// if the filter is enable or not
		return true;
	}

	@Override
	public int filterOrder() {
		// order according to the all Zuul filters
		return 1;
	}

	@Override
	public String filterType() {
		// should be pre/rouding/post
		return "pre";
	}

}
