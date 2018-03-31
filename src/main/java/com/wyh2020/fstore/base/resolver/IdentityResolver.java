package com.wyh2020.fstore.base.resolver;

import com.wyh2020.fstore.base.annotation.Identity;
import com.wyh2020.fstore.base.bean.role.identity.IdentityUser;
import com.wyh2020.fstore.base.constants.Constants;
import com.wyh2020.fstore.base.exception.BaseException;
import com.wyh2020.fstore.base.util.ObjectMapperUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class IdentityResolver implements HandlerMethodArgumentResolver {
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Identity.class);
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {


        String json = webRequest.getHeader(Constants.JWT_JSON);
        if (StringUtils.isBlank(json)) {
            throw new BaseException("未登录");
        }
        IdentityUser identityUser =  ObjectMapperUtil.readValue(json, IdentityUser.class);
        Identity identity = parameter.getParameterAnnotation(Identity.class);
//        if (identity.shopRequire() && StringUtils.isBlank(identityUser.getShopCode())){
//            throw new BaseException("所属店铺编号不存在");
//        }
//        if (identity.shopRequire() && StringUtils.isBlank(identityUser.getMainShopCode())){
//            throw new BaseException("所属总店编号不存在");
//        }

        return identityUser;
    }
}
