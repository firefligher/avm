package org.fir3.avm.environment.resource.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class HexLongAdapter extends XmlAdapter<String, Long> {
    @Override
    public Long unmarshal(String str) throws Exception {
        if (str.startsWith("0x")) {
            str = str.substring(2);
        }

        return Long.parseLong(str, 16);
    }

    @Override
    public String marshal(Long val) throws Exception {
        return String.format("0x%h", val);
    }
}
