package org.zhaogang.eagleeye.log;

import net.logstash.logback.marker.MapEntriesAppendingMarker;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joy.wang on 16-5-23.
 */
public class TraceMarker extends MapEntriesAppendingMarker {
    protected Map<String, Object> tmap = new HashMap();

    public TraceMarker(Map<String, Object> map) {
        super(map);
        this.tmap = map;
    }

    public Map<String, Object> getMap() {
        return this.tmap;
    }
}