package org.cloud.chiron.common.util;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CommandLine implements Serializable {

    private static final long serialVersionUID = 8610513714180851399L;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("date")
    private Date date;

    @JsonProperty("command")
    private String command;

    public CommandLine() {

    }

    public CommandLine(String command) {
        super();
        this.date = new Date();
        this.command = command;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "CommandLine [date=" + date + ", command=" + command + "]";
    }

}
