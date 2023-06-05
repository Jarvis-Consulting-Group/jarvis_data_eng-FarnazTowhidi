package ca.jrvs.apps.Regex;

import ca.jrvs.apps.grep.JavaGrepImp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExcImp implements RegexExc {

  public static void main(String[] args) {

    RegexExcImp regexExcImp = new RegexExcImp();
    System.out.println(regexExcImp.matchJpeg("file.jgpg"));
    System.out.println("Image Regex");
    System.out.println(regexExcImp.matchIp("12.34.123.45"));
    System.out.println("IP Regex");
  }

  @Override
  public boolean matchJpeg(String filename) {
    Pattern pattern = Pattern.compile("^\\w+\\.(jpg|jpeg)$");
    Matcher matcher = pattern.matcher(filename);
    return matcher.find();
  }

  @Override
  public boolean matchIp(String ip) {
    Pattern pattern = Pattern.compile("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$");
    Matcher matcher = pattern.matcher(ip);
    return matcher.find();
  }

  @Override
  public boolean isEmptyLine(String line) {

    Pattern pattern = Pattern.compile("^$");
    Matcher matcher = pattern.matcher(line);
    return matcher.find();
  }
}
