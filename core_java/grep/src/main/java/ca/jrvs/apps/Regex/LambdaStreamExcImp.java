package ca.jrvs.apps.Regex;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaStreamExcImp implements LambdaStreamExc{

  public static  void main(String[] args) {
    LambdaStreamExc lamda = new LambdaStreamExcImp();
    Stream<String> strStream = lamda.createStrStream("Jarvis", "General Assembly", "IBM");
    Stream<String> strUpper = lamda.toUpperCase("Jarvis", "General Assembly", "IBM");
    Stream<String> strFilter = lamda.filter(lamda.createStrStream("Jarvis", "General Assembly", "IBM"), "IBM");
    IntStream intStream = lamda.createIntStream(new int[]{10, 2, 3,4});

    strStream.forEach(System.out::println);
    strUpper.forEach(System.out::println);
    strFilter.forEach(System.out::println);
    IntStream.rangeClosed(1, (int) intStream.count()).forEach(System.out::println);
  }

  @Override
  public Stream<String> createStrStream(String... strings) {
    return (Stream.of(strings));
  }

  @Override
  public Stream<String> toUpperCase(String... strings) {
    return (Stream.of(strings).map(String::toUpperCase));
  }

  @Override
  public Stream<String> filter(Stream<String> stringStream, String pattern) {
    return (stringStream.filter(s->s.matches(pattern)));
  }

  @Override
  public IntStream createIntStream(int[] arr) {
    return (IntStream.of(arr));
  }

  @Override
  public <E> List<E> toList(Stream<E> stream) {
    return null;
  }

  @Override
  public List<Integer> toList(IntStream intStream) {
    return null;
  }

  @Override
  public IntStream createIntStream(int start, int end) {
    return null;
  }

  @Override
  public DoubleStream squareRootIntStream(IntStream intStream) {
    return null;
  }

  @Override
  public IntStream getOdd(IntStream intStream) {
    return null;
  }

  @Override
  public Consumer<String> getLambdaPrinter(String prefix, String suffix) {
    return null;
  }

  @Override
  public void printMessage(String[] messages, Consumer<String> printer) {

  }

  @Override
  public void printOdd(IntStream intStream, Consumer<String> printer) {

  }

  @Override
  public Stream<Integer> flatNestedInt(Stream<List<Integer>> ints) {
    return null;
  }
}
