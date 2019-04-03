package cn.edu.nju.sa2017.pipefilter;

import org.springframework.batch.item.ItemWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

/**
 * @projectName SpringBatchDemo
 * @fileName MyJsonWriter
 * @auther Qiaoyi Yin
 * @time 2019-04-02 20:00
 * @function TODO
 */

public class MyJsonWriter implements ItemWriter<Report> {

    @Override
    public void write(List<? extends Report> reportList) throws IOException {
        File jsonFile = new File("xml/outputs/report.json");
        FileWriter jsonFileWriter = new FileWriter(jsonFile);

        try {
            // Write down the head of .json file
            jsonFileWriter.write("{ \"report\": [ ");

            for (int idx=0; idx<reportList.size(); ++idx){

                // Remove the last ',' in the string
                if (idx == (reportList.size()-1)){
                    String temp = reportList.get(idx).toJson();
                    jsonFileWriter.write(temp.substring(0, temp.length()-2));
                    jsonFileWriter.flush();
                }
                else {
                    jsonFileWriter.write(reportList.get(idx).toJson());
                    jsonFileWriter.flush();
                }
            }

            jsonFileWriter.write(" ] }\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        jsonFileWriter.close();
    }
}
