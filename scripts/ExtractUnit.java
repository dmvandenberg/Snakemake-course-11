import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.*;
import org.apache.commons.cli.*;

/**
 * Created by David on 6/5/2018.
 */

public class ExtractUnit{
    BufferedReader inFile;
    BufferedWriter bw;

    public ExtractUnit(){
        try{
            inFile = new BufferedReader(new FileReader(input));
            String line;
            FileWriter fw = new FileWriter(output , true);
            bw = new BufferedWriter(fw);
            while((line = inFile.readLine()) != null){
                if(!line.startsWith("#") && !line.startsWith("ID")){
                    bw.write(line.split("\t")[0] + " \n");
                }
            }
        }
        catch (IOException e){
        }
    }
    public static void main(String[] args) {
      Options options = new Options();

      Option input = new Option("i", "input", true, "input file path");
      input.setRequired(true);
      options.addOption(input);

      Option output = new Option("o", "output", true, "output file");
      output.setRequired(true);
      options.addOption(output);

      CommandLineParser parser = new DefaultParser();
      HelpFormatter formatter = new HelpFormatter();
      CommandLine cmd;

      try {
          cmd = parser.parse(options, args);
      } catch (ParseException e) {
          System.out.println(e.getMessage());
          formatter.printHelp("utility-name", options);

          System.exit(1);
          return;
      }

      public String input = cmd.getOptionValue("input");
      public String output = cmd.getOptionValue("output");
      ExtractUnit extract = new ExtractUnit();
    }
}
