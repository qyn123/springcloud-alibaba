package com.qiaoyn.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qiaoyanan
 * date:2022/07/24 16:01
 */
@Component
public class ExceptionHandlerPage implements UrlBlockHandler {


    @Override
    public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {
        ResponseData data = null;
        httpServletResponse.setContentType("application/json;charset=utf-8");
        if (e instanceof FlowException) {
            data = new ResponseData(-1, "接口被限流了...");
        } else if (e instanceof DegradeException) {
            data = new ResponseData(-2, "接口被降级了...");
        }

        httpServletResponse.getWriter().write(JSON.toJSONString(data));
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ResponseData{
    private Integer code;
    private String msg;
}
