package life;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

public class LifeInputFormat extends FileInputFormat<Text,Text> {


    @Override
    public RecordReader<Text, Text> createRecordReader(InputSplit arg0,
            TaskAttemptContext arg1) throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        return new LifeRecordReader();
    }
    
}
