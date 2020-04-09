package com.zc.jaxb.Utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-04-09 15:11
 */
public class DateAdapter extends XmlAdapter<String, Date> {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date unmarshal(String date) throws Exception {
        return SDF.parse(date);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return SDF.format(date);
    }

}
