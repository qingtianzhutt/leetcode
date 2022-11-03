package com.example.demo.filter;

import com.example.demo.utils.TraceIdUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "traceIdFilter")
@Order(1)
public class TraceIdFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //traceId初始化
        initTraceId((HttpServletRequest) servletRequest);
        //执行后续过滤器
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     * traceId初始化
     */
    private void initTraceId(HttpServletRequest request) {
        //尝试获取http请求中的traceId
        String traceId = request.getParameter("traceId");

        //如果当前traceId为空或者为默认traceId，则生成新的traceId
        if (StringUtils.isBlank(traceId) || TraceIdUtil.defaultTraceId(traceId)){
            traceId = TraceIdUtil.genTraceId();
        }

        //设置traceId
        TraceIdUtil.setTraceId(traceId);
    }
}
