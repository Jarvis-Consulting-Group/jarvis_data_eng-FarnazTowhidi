package ca.jrvs.apps.grep;



import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    while (line != null) {

      // read next line
      line = reader.readLine();
      lines.add (line);
    }

    return lines;
  }


  @Override
  public boolean containPattern(String line) {
    return false;
  }

  @Override
  public void writeToFile(List<String> lines) throws IOException {

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
