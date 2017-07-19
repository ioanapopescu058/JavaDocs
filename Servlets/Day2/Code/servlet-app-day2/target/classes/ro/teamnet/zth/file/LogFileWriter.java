/**
 * LogFileWriter.java
 *
 * Copyright (c) 2014 Teamnet. All Rights Reserved.
 *
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet.
 **/
package ro.teamnet.zth.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

public class LogFileWriter {
    //public static final String TOMCAT_PATH=System.getenv("M2_HOME").replace(";","");

    /**
     * This method log headers to %M2_HOME%\logs\headers.log
     * @param headerName - Header name
     * @param headerValue - Header value
     */
    public static void logHeader(String headerName,String headerValue){

        //try(RandomAccessFile randomAccessFile=new RandomAccessFile(TOMCAT_PATH+ File.separator+"logs"+File.separator+"headers.log","rw")) {
        try(RandomAccessFile randomAccessFile=new RandomAccessFile("C:\\Users\\ioana.popescu\\Downloads\\apache-maven-3.5.0-bin\\apache-maven-3.5.0\\logs\\headers.log", "rw")) {
            randomAccessFile.writeBytes(String.valueOf(new Date()) + ":" + headerName + ":" + headerValue + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
