package com.otmoc.ubain.controller.converter;


import com.otmoc.ubain.common.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    private static Logger LOG = LoggerFactory.getLogger(DateConverter.class);

    @Override
    public Date convert(String s) {
        try {
            Date date = DateUtils.toSTDDateTime(s);
            return date;
        } catch (Exception e) {
            LOG.error("string to date convert error: {} can't format to 'yyyy-MM-dd HH:mm:ss'", s);
            return null;
        }
    }
}
