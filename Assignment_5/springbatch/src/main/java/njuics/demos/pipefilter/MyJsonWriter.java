package njuics.demos.pipefilter;

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
 * @function My own json writer
 */

public class MyJsonWriter implements ItemWriter<Report> {

    @Override
    public void write(List<? extends Report> reportList) throws IOException {
        File jsonFile = new File("xml/outputs/report.json");
        FileWriter jsonFileWriter = new FileWriter(jsonFile);

        try {
            // Write down the head of .json file
            jsonFileWriter.write("{ \"report\": [ ");

            // The original method to do the job
//            for (int idx=0; idx<reportList.size(); ++idx){
//
//                // Remove the last ',' in the string
//                if (idx == (reportList.size()-1)){
//                    String temp = reportList.get(idx).toJson();
//                    jsonFileWriter.write(temp.substring(0, temp.length()-2));
//                    jsonFileWriter.flush();
//                }
//                else {
//                    jsonFileWriter.write(reportList.get(idx).toJson());
//                    jsonFileWriter.flush();
//                }
//            }

            // Use foreach(*) to do the job, however, there is an extra comma in the end.
            // Actually, in IE6 standard, the format with an extra comma in the array is not valid.
            // However, in order to facilitate the data interchange, such format is supported by almost every following standard.
//            reportList.forEach((elementUnit)->{
//                try {
//                    jsonFileWriter.write(elementUnit.toJson());
//                    jsonFileWriter.flush();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });

            // Use foreach(*) to do the job without an extra comma.
            // Actually, I think using a such verbose method to meet the requirement of some standards is unreasonable.
            final int listLength = reportList.size();
            final Increment incVal = new Increment(0);
            reportList.forEach((elementUnit)->{
                try {
                    String jsonUnit = elementUnit.toJson();
                    if (incVal.value == (listLength-1)){
                        jsonFileWriter.write(jsonUnit.substring(0, jsonUnit.length()-2));
                    }
                    else {
                        jsonFileWriter.write(jsonUnit);
                    }

                    jsonFileWriter.flush();
                    incVal.value += 1;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            jsonFileWriter.write(" ] }\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        jsonFileWriter.close();
    }

    class Increment {
        public int value;

        public Increment(int init) {
            this.value = init;
        }

    }

}
