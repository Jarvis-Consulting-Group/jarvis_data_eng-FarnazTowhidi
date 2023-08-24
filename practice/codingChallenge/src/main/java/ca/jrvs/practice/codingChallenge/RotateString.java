package ca.jrvs.practice.codingChallenge;

public class RotateString {


    public String Rotate (String str, int rotate){
      //String rotateStr;
      String leftStr = str.substring(0,rotate);
      String rightStr = str.substring (rotate);
      return rightStr + leftStr;
    }

  public static void main(String[] args) {
      RotateString rotate = new RotateString();
      System.out.println(rotate.Rotate ("This",2));
  }
}
