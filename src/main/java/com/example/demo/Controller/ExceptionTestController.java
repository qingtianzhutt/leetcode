package com.example.demo.Controller;


import com.example.utils.BusinessException;
import com.example.utils.ErrorEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class ExceptionTestController{

    @RequestMapping("query")
    @ResponseBody
    public Object query(){
        throw new BusinessException(ErrorEnum.NO_PERMISSION.getErrorCode(), ErrorEnum.NO_PERMISSION.getErrorMsg());
    }
}
