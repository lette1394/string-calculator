package com.github.lette1394;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
  private static long romanNumberSum = 0;
  private static long decimalNumberSum = 0;
  private static long octalNumberSum = 0;
  private static long binaryNumberSum = 0;
  private static long totalSum = 0;

  public static void main(String[] args) {

    final Scanner get = new Scanner(System.in);
    String getOperator = null;
    String commendGetNotation = null;
    String format = null;
    String getNotation = "10";

    for (int i = 1; i < 4; i++) {
      String startCalculator = get.next();

      if (startCalculator.contains("formula")) {
        System.out.print("formula=");
        getOperator = get.next();

      } else if (startCalculator.contains("numeral-system") || startCalculator.contains("ns")) {

        commendGetNotation = startCalculator;
        System.out.print(commendGetNotation + "=");
        getNotation = get.next();

      } else if (startCalculator.contains("format")) {
        System.out.print("format=");
        format = get.next();
      }
    }

    final List<String> expression = new ArrayList<>(Arrays.asList(getOperator.split("\\+")));

    for (int i = 0; i < expression.size(); i++) {

      if (expression.get(i).contains("I") || expression.get(i).contains("V") || expression.get(i).contains("X") || expression.get(i).contains("L") || expression.get(i).contains("C") || expression.get(i).contains("D") || expression.get(i).contains("M")) {
        romanNumberOperate(expression.get(i));
      } else if (expression.get(i).contains("(8)")) {
        octalNumberOperate(expression.get(i));
      } else if (expression.get(i).contains("(10)")) {
        decimalNumberSumOperate(expression.get(i));
      } else if (expression.get(i).contains("(2)")) {
        binaryNumberOperate(expression.get(i));
      } else {
        numberSumOperate(expression.get(i));
      }
    }
    if (format.equals("short")) {
      totalSum = permuteNotation(getNotation, romanNumberSum + decimalNumberSum + octalNumberSum + binaryNumberSum);
      System.out.println(totalSum + "(" + getNotation + ")");
    }
    if (format.equals("long")) {
      totalSum = permuteNotation(getNotation, romanNumberSum + decimalNumberSum + octalNumberSum + binaryNumberSum);
      System.out.println("result: " + totalSum);
      System.out.println(commendGetNotation + ": " + getNotation);
    }
  }

  private static long permuteNotation(String getNotation, long totalSumNumber) {

    if (getNotation.equals("8")) {

      long totalOctalLongNumberSum = Long.parseLong(Long.toOctalString(totalSumNumber));

      return totalOctalLongNumberSum;

    }

    return totalSumNumber;
  }

  private static void numberSumOperate(String number) {

    long longNumber = Long.parseLong(number);
    binaryNumberSum += longNumber;
  }

  private static void binaryNumberOperate(String binaryNumber) {

    String number = binaryNumber.replace("(2)", "");
    long binaryLongNumber = Integer.valueOf(number, 2);
    binaryNumberSum += binaryLongNumber;
  }

  private static void decimalNumberSumOperate(String decimalNumber) {

    String number = decimalNumber.replace("(10)", "");
    decimalNumberSum += Long.parseLong(number);

  }

  private static void octalNumberOperate(String octalNumber) {

    String number = octalNumber.replace("(8)", "");
    long octalLongNumber = Integer.valueOf(number, 8);
    octalNumberSum += octalLongNumber;
  }

  private static void romanNumberOperate(String romanNum) {

    if (romanNum.equals("I")) {
      romanNumberSum += 1L;
    }
    if (romanNum.equals("V")) {
      romanNumberSum += 5L;
    }
    if (romanNum.equals("X")) {
      romanNumberSum += 10L;
    }
    if (romanNum.equals("L")) {
      romanNumberSum += 50L;
    }
    if (romanNum.equals("C")) {
      romanNumberSum += 100L;
    }
    if (romanNum.equals("D")) {
      romanNumberSum += 500L;
    }
    if (romanNum.equals("M")) {
      romanNumberSum += 1000L;
    }
  }
}

