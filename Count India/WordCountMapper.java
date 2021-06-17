import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable,  Text, Text, IntWritable>

{

	@Override
	protected void map(LongWritable key, Text value,
			org.apache.hadoop.mapreduce.Mapper.Context context)
			throws IOException, InterruptedException {
				String inputstring = value.toString();
				for(String x : inputstring.split(" "))
				{	
					if(x.contains("India")==true){
			            if(x.length()>5){ //if length greator that 5
			                if(x.charAt(5)<='a' || x.charAt(5)>='z'){ //it should not be "Indian", "India." should be fine
			                	context.write(new Text("India"),new IntWritable(1));  
			                }
			            }
			            else{
			            	context.write(new Text(x),new IntWritable(1));
			            }
			        }
				}
			}
}
