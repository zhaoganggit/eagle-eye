package org.zhaogang.eagleeye.log;

/**
 * Created by Joy.wang on 16-5-23.
 */
import akka.actor.AbstractActor;
import akka.event.BusLogging;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.event.LoggingBus;
import akka.event.LoggingFilter;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import scala.Predef;
import scala.collection.JavaConverters;
import scala.collection.immutable.Map;

public class AkkaLogstashAdapter extends BusLogging implements LoggingAdapter {
    protected LoggingBus bus;
    protected String logSource;
    protected Class<?> logClass;
    protected static final Map emptyMdc = ((scala.collection.mutable.Map)JavaConverters.mapAsScalaMapConverter(new HashMap()).asScala()).toMap(Predef.conforms());
    protected Map mdc;

    public AkkaLogstashAdapter(LoggingBus bus, String logSource, Class<?> logClass) {
        super(bus, logSource, logClass);
        this.mdc = emptyMdc;
        this.bus = bus;
        this.logSource = logSource;
        this.logClass = logClass;
    }

    public AkkaLogstashAdapter(LoggingBus bus, String logSource, Class<?> logClass, LoggingFilter loggingFilter) {
        super(bus, logSource, logClass, loggingFilter);
        this.mdc = emptyMdc;
    }

    public void error(java.util.Map<String, Object> traceMap, Throwable cause, String message) {
        this.addTrace((x, y) -> {
            this.error((Throwable)x, (String)y);
        }, cause, message, traceMap);
    }

    public void error(java.util.Map<String, Object> traceMap, String message) {
        this.addTrace((e) -> {
            this.error(e);
        }, message, traceMap);
    }

    public void error(java.util.Map<String, Object> traceMap, String message, Object... args) {
        this.addTrace((x, y) -> {
            this.error(x, y);
        }, message, traceMap, args);
    }

    public void warning(java.util.Map<String, Object> traceMap, String message) {
        this.addTrace((e) -> {
            this.warning(e);
        }, message, traceMap);
    }

    public void warning(java.util.Map<String, Object> traceMap, String template, Object... args) {
        this.addTrace((x, y) -> {
            this.warning(x, y);
        }, template, traceMap, args);
    }

    public void info(java.util.Map<String, Object> traceMap, String message) {
        this.addTrace((e) -> {
            this.info(e);
        }, message, traceMap);
    }

    public void info(java.util.Map<String, Object> traceMap, String template, Object... args) {
        this.addTrace((x, y) -> {
            this.info(x, y);
        }, template, traceMap, args);
    }

    public void debug(java.util.Map<String, Object> traceMap, String message) {
        this.addTrace((e) -> {
            this.debug(e);
        }, message, traceMap);
    }

    public void debug(java.util.Map<String, Object> traceMap, String template, Object... args) {
        this.addTrace((x, y) -> {
            this.debug(x, y);
        }, template, traceMap, args);
    }

    public void error(String template, Object... args) {
        if(args != null) {
            switch(args.length) {
                case 1:
                    this.error((String)template, (Object)args[0]);
                    break;
                case 2:
                    this.error((String)template, (Object)args[0], (Object)args[1]);
                    break;
                case 3:
                    this.error(template, args[0], args[1], args[2]);
                    break;
                case 4:
                    this.error(template, args[0], args[1], args[2], args[3]);
                    break;
                default:
                    this.error(template);
            }
        } else {
            this.error(template);
        }

    }

    public void warning(String template, Object... args) {
        if(args != null) {
            switch(args.length) {
                case 1:
                    this.warning((String)template, (Object)args[0]);
                    break;
                case 2:
                    this.warning((String)template, (Object)args[0], (Object)args[1]);
                    break;
                case 3:
                    this.warning(template, args[0], args[1], args[2]);
                    break;
                case 4:
                    this.warning(template, args[0], args[1], args[2], args[3]);
                    break;
                default:
                    this.warning(template);
            }
        } else {
            this.warning(template);
        }

    }

    public void info(String template, Object... args) {
        if(args != null) {
            switch(args.length) {
                case 1:
                    this.info((String)template, (Object)args[0]);
                    break;
                case 2:
                    this.info((String)template, (Object)args[0], (Object)args[1]);
                    break;
                case 3:
                    this.info(template, args[0], args[1], args[2]);
                    break;
                case 4:
                    this.info(template, args[0], args[1], args[2], args[3]);
                    break;
                default:
                    this.info(template);
            }
        } else {
            this.info(template);
        }

    }

    public void debug(String template, Object... args) {
        if(args != null) {
            switch(args.length) {
                case 1:
                    this.debug((String)template, (Object)args[0]);
                    break;
                case 2:
                    this.debug((String)template, (Object)args[0], (Object)args[1]);
                    break;
                case 3:
                    this.debug(template, args[0], args[1], args[2]);
                    break;
                case 4:
                    this.debug(template, args[0], args[1], args[2], args[3]);
                    break;
                default:
                    this.debug(template);
            }
        } else {
            this.debug(template);
        }

    }

    protected void addTrace(Consumer<String> logMethod, String message, java.util.Map<String, Object> traceMap) {
        try {
            this.setMDC(traceMap);
            logMethod.accept(message);
        } finally {
            this.clearMDC();
        }

    }

    protected void addTrace(BiConsumer<Throwable, String> logMethod, Throwable cause, String message, java.util.Map<String, Object> traceMap) {
        try {
            this.setMDC(traceMap);
            logMethod.accept(cause, message);
        } finally {
            this.clearMDC();
        }

    }

    protected void addTrace(BiConsumer<String, Object[]> logMethod, String message, java.util.Map<String, Object> traceMap, Object[] args) {
        try {
            this.setMDC(traceMap);
            logMethod.accept(message, args);
        } finally {
            this.clearMDC();
        }

    }

    public void error(TraceMarker traceMarker, Throwable cause, String message) {
        this.error(traceMarker.getMap(), cause, message);
    }

    public void error(TraceMarker traceMarker, String message) {
        this.error(traceMarker.getMap(), message);
    }

    public void error(TraceMarker traceMarker, String message, Object... args) {
        this.error(traceMarker.getMap(), message, args);
    }

    public void warning(TraceMarker traceMarker, String message) {
        this.warning(traceMarker.getMap(), message);
    }

    public void warning(TraceMarker traceMarker, String message, Object... args) {
        this.warning(traceMarker.getMap(), message, args);
    }

    public void info(TraceMarker traceMarker, String message) {
        this.info(traceMarker.getMap(), message);
    }

    public void info(TraceMarker traceMarker, String message, Object... args) {
        this.info(traceMarker.getMap(), message, args);
    }

    public void debug(TraceMarker traceMarker, String message) {
        this.debug(traceMarker.getMap(), message);
    }

    public void debug(TraceMarker traceMarker, String message, Object... args) {
        this.debug(traceMarker.getMap(), message, args);
    }

    public void setMDC(java.util.Map<String, Object> jMdc) {
        this.mdc = ((scala.collection.mutable.Map)JavaConverters.mapAsScalaMapConverter(jMdc).asScala()).toMap(Predef.conforms());
    }

    public void clearMDC() {
        this.mdc = emptyMdc;
    }

    public Map<String, Object> mdc() {
        return this.mdc;
    }

    public LoggingBus bus() {
        return this.bus;
    }

    public String logSource() {
        return this.logSource;
    }

    public Class<?> logClass() {
        return this.logClass;
    }

    public static AkkaLogstashAdapter getLogger(AbstractActor logSource) {
        return new AkkaLogstashAdapter(logSource.getContext().system().eventStream(), Logging.simpleName(logSource), logSource.getClass());
    }
}
