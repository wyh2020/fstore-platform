package com.wyh2020.fstore.base.annotation.validator;

import com.wyh2020.fstore.base.annotation.NotEmoji;
import com.wyh2020.fstore.base.util.EmojiUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * Created by hzh on 2018/3/31.
 */
public class NotEmojiValidator implements ConstraintValidator<NotEmoji,String> {


    @Override
    public void initialize(NotEmoji emoji) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isBlank(s)){
            return true;
        }
        if (EmojiUtil.containsEmoji(s)) {
            return false;
        }
        return true;
    }

}
