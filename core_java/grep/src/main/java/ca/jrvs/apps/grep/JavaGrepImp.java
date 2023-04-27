package ca.jrvs.apps.grep;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.BasicConfigurator;


public class JavaGrepImp implements JavaGrep  {
  private String regex;
  private String rootPath;
  private String outFile;


  public static void main(String[] args) {
    if (args.length != 3){
      throw new IllegalArgumentException("USAGE: JavaGrep regex rootPath outFile");
    }

    BasicConfigurator.configure();
    JavaGrepImp javaGrepImp = new JavaGrepImp();
    javaGrepImp.setRegex(args[0]);
    javaGrepImp.setRootPath(args[1]);
    javaGrepImp.setOutFile(args[2]);

    final Logger logger = LoggerFactory.getLogger(JavaGrep.class);

    try{
      javaGrepImp.process();
    }catch (Exception ex){
      logger.error(ex.getMessage(), ex);
    }
  }


  @Override
  public void process() throws IOException {
    List<String> matchedLines = new ArrayList<String>();

    for (File file : this.listFiles(this.getRootPath())) {
      for (String string : this.readLines(file)) {
        System.out.println(string);
        if (this.containPattern(string)) {
        matchedLines.add(string) ;
        }
      }
    }
    this.writeToFile(matchedLines);


  }


  @Override
  public List<File> listFiles(String rootDir) {
    /**
     * List the files in the directory
     */
    //File directory = new File(rootDir);
    List<File> files = new ArrayList<>();
    File directory = new File(rootDir);

    if (directory.listFiles()!= null) {
      for (File file: (directory.listFiles())) {

        if (file.isFile()) {
          files.add(file);
        }
        else  {
          this.listFiles(file.toString());
        }
      }
    }
    return files;
  }


  @Override
  public List<String> readLines(File inputFile) throws IOException {

    List<String> lines = new ArrayList<>();
    System.out.println(inputFile);
    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    String line = reader.readLine();

    while (!line.isEmpty()) {
      System.out.println(line);
      line = reader.readLine();
      lines.add (line);
    }

    return lines;
  }


  @Override
  public boolean containPattern(String line) {
    Pattern pattern = Pattern.compile(this.getRegex(), Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(line);
    boolean matchFound = matcher.find();
    return matchFound;
  }

  @Override
  public void writeToFile(List<String> lines) throws IOException {
    FileWriter writer = new FileWriter(this.getOutFile());
    for(String str: lines) {
      writer.write(str + System.lineSeparator());
    }
    writer.close();
  }

  @Override
  public void setRegex(String regex) {
    this.regex = regex;
  }

  public String getRegex() {
    return regex;
  }

  public String getRootPath() {
    return rootPath;
  }

  public void setRootPath(String rootPath) {
    this.rootPath = rootPath;
  }

  public String getOutFile() {
    return outFile;
  }

  public void setOutFile(String outFile) {
    this.outFile = outFile;
  }
}
