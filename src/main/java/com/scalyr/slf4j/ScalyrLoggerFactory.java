package com.scalyr.slf4j;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class ScalyrLoggerFactory implements ILoggerFactory {
    private Map<String, ScalyrLogger> loggerCache;

    public ScalyrLoggerFactory() {
        this.loggerCache = new ConcurrentSkipListMap<>();
    }

    @Override
    public Logger getLogger(String name) {
        name = (name != null) ? name.trim() : name;
        if(name == null || "".equals(name)) {
            throw new IllegalArgumentException("The Logger name must not be null or blank");
        }
        if (!this.loggerCache.containsKey(name)) {
            ScalyrLogger newLogger = new ScalyrLogger(name);
            this.loggerCache.put(name, newLogger);
        }
        return this.loggerCache.get(name);
    }
}
