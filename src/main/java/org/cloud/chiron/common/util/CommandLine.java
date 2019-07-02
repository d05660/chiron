package org.cloud.chiron.common.util;

import java.io.Serializable;
import java.util.Date;

public class CommandLine implements Serializable {

    private static final long serialVersionUID = 8610513714180851399L;
    private Date dateTimeDate;
    private String commandString;

    public CommandLine() {

    }

    public CommandLine(String commandString) {
        super();
        this.dateTimeDate = new Date();
        this.commandString = commandString;
    }

    public Date getDateTimeDate() {
        return dateTimeDate;
    }

    public void setDateTimeDate(Date dateTimeDate) {
        this.dateTimeDate = dateTimeDate;
    }

    public String getCommandString() {
        return commandString;
    }

    public void setCommandString(String commandString) {
        this.commandString = commandString;
    }

    @Override
    public String toString() {
        return "CommandLine [dateTimeDate=" + dateTimeDate + ", commandString=" + commandString + "]";
    }

}
