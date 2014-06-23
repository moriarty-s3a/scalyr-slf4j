package com.scalyr.slf4j;

import com.scalyr.api.logs.EventAttributes;
import com.scalyr.api.logs.Events;
import org.slf4j.Logger;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

public final class ScalyrLogger extends MarkerIgnoringBase {
    public static final String MESSAGE_ATTR_NAME = "message";
    public static final String EXCEPTION_ATTR_NAME = "exception";

    public ScalyrLogger(String name) {
        this.name = name;
    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void trace(String msg) {
        if (isTraceEnabled()) {
            Events.finest(new EventAttributes(MESSAGE_ATTR_NAME, msg));
        }
    }

    @Override
    public void trace(String format, Object arg) {
        if (isTraceEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            Events.finest(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        if (isTraceEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            Events.finest(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void trace(String format, Object... arguments) {
        if (isTraceEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arguments);
            Events.finest(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void trace(String msg, Throwable t) {
        if (isTraceEnabled()) {
            Events.finest(new EventAttributes(MESSAGE_ATTR_NAME, msg, EXCEPTION_ATTR_NAME, getStackTraceAsString(t)));
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public void debug(String msg) {
        if (isDebugEnabled()) {
            Events.fine(new EventAttributes(MESSAGE_ATTR_NAME, msg));
        }
    }

    @Override
    public void debug(String format, Object arg) {
        if (isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            Events.fine(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        if (isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            Events.fine(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void debug(String format, Object... arguments) {
        if (isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arguments);
            Events.fine(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void debug(String msg, Throwable t) {
        if (isDebugEnabled()) {
            Events.fine(new EventAttributes(MESSAGE_ATTR_NAME, msg, EXCEPTION_ATTR_NAME, getStackTraceAsString(t)));
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public void info(String msg) {
        if (isInfoEnabled()) {
            Events.info(new EventAttributes(MESSAGE_ATTR_NAME, msg));
        }
    }

    @Override
    public void info(String format, Object arg) {
        if (isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            Events.info(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        if (isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            Events.info(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void info(String format, Object... arguments) {
        if (isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arguments);
            Events.info(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void info(String msg, Throwable t) {
        if (isInfoEnabled()) {
            Events.info(new EventAttributes(MESSAGE_ATTR_NAME, msg, EXCEPTION_ATTR_NAME, getStackTraceAsString(t)));
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return false;
    }

    @Override
    public void warn(String msg) {
        if (isWarnEnabled()) {
            Events.warning(new EventAttributes(MESSAGE_ATTR_NAME, msg));
        }
    }

    @Override
    public void warn(String format, Object arg) {
        if (isWarnEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            Events.warning(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void warn(String format, Object... arguments) {
        if (isWarnEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arguments);
            Events.warning(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        if (isWarnEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            Events.warning(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void warn(String msg, Throwable t) {
        if (isWarnEnabled()) {
            Events.warning(new EventAttributes(MESSAGE_ATTR_NAME, msg, EXCEPTION_ATTR_NAME, getStackTraceAsString(t)));
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public void error(String msg) {
        if (isErrorEnabled()) {
            Events.error(new EventAttributes(MESSAGE_ATTR_NAME, msg));
        }
    }

    @Override
    public void error(String format, Object arg) {
        if (isErrorEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            Events.error(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        if (isErrorEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            Events.error(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void error(String format, Object... arguments) {
        if (isErrorEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arguments);
            Events.error(new EventAttributes(MESSAGE_ATTR_NAME, ft.getMessage()));
        }
    }

    @Override
    public void error(String msg, Throwable t) {
        if (isErrorEnabled()) {
            Events.error(new EventAttributes(MESSAGE_ATTR_NAME, msg, EXCEPTION_ATTR_NAME, getStackTraceAsString(t)));
        }
    }

    private String getStackTraceAsString(Throwable t) {
        if(t == null) {
            return "";
        } else if(t.getStackTrace() == null) {
            return t.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : t.getStackTrace()) {
            if(element != null) {
                sb.append(element.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
