package com.qiaoyn.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qiaoyanan
 * date:2022/07/24 15:41
 */
//@Component
public class RequestOriginParserDefinition implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String name = httpServletRequest.getParameter("name");
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("name is not allowed empty");
        }
        return name;
    }
}
