import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.utils.ParameterTool;


public class ReadFiles {

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception {

    // set up the execution environment
    try {
      final ParameterTool params = ParameterTool.fromArgs(args);
      final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

      env.setParallelism(1); // without this multiple files creating
      env.getConfig().setGlobalJobParameters(params);

      List<String> paths = new ArrayList<String>();
      File dir = new File(params.getRequired("input"));
      for (File f : dir.listFiles()) {
        if (f.isFile()) {
          paths.add(f.getName());
        }
      }
      DataSet<String> data = env.fromCollection(paths).rebalance();
      DataSet<Tuple1<String>> output = data.flatMap(new CSVSplitter());
      env.execute();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

