package com.uabc.database.example.examplejpa.components;

import com.uabc.database.example.examplejpa.entity.Log;
import com.uabc.database.example.examplejpa.model.LogModel;
import org.springframework.stereotype.Component;

@Component("LogConverter")
public class LogConverter {




    public Log convertToContactModel2Contact(LogModel LogModel){
        Log log = new Log();

        log.setId(LogModel.getId());
        log.setUsername(LogModel.getUsername());
        log.setDate(LogModel.getDate());
        log.setDetails(LogModel.getDetails());
        log.setUrl(LogModel.getUrl());
        return log;
    }

    public LogModel convertContact2ContactModel(Log log){
        LogModel logModel = new LogModel();
        logModel.setId(log.getId());
        logModel.setUsername(log.getUsername());
        logModel.setDate(log.getDate());
        logModel.setDetails(log.getDetails());
        logModel.setUrl(log.getUrl());
        return logModel;
    }

}
