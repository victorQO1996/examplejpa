package com.uabc.database.example.examplejpa.services.impl;


import com.uabc.database.example.examplejpa.components.LogConverter;
import com.uabc.database.example.examplejpa.entity.Log;
import com.uabc.database.example.examplejpa.model.LogModel;
import com.uabc.database.example.examplejpa.respository.LogRepository;
import com.uabc.database.example.examplejpa.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("contactServiceImpl")
public class LogServiceImpl implements LogService {

    @Autowired
    @Qualifier("logRepository")
    private LogRepository logRepository;

    @Autowired
    @Qualifier("LogConverter")
    private LogConverter logConverter;


    public LogModel addContact(LogModel logModel) {
        //Aquí nos pide una entidad, por lo tanto tenemos que transformar el contactModel a entidad
        Log temp=logConverter.convertToContactModel2Contact(logModel);
        Log log = logRepository.save(temp);
        return logConverter.convertContact2ContactModel(log);
    }

    @Override
    public LogModel addLog(LogModel logModel) {
        return null;
    }

    @Override
    public List<LogModel> listAlllogs() {
        List<Log> logs = logRepository.findAll();
        List<LogModel> logsModel = new ArrayList();
        for(Log log : logs){
            logsModel.add(logConverter.convertContact2ContactModel(log));

        }
        return logsModel;
    }




    public Log findLogById(int id) {
        return logRepository.findById(id);
    }

    public LogModel findLogByIdModel(int id){
        return logConverter.convertContact2ContactModel(findLogById(id));
    }


    public void removeLog(int id) {
        Log log  = findLogById(id);
        if(log != null){
            logRepository.delete(findLogById(id));
        }
    }


}
