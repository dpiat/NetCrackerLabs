package com.nc.project.JAXB;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdapterDateXml extends XmlAdapter<String, Date> {

    @Override
    public Date unmarshal(String s) throws Exception {
        return new SimpleDateFormat("dd.MM.yyyy").parse(s);
    }

    @Override
    public String marshal(Date date) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }
}
