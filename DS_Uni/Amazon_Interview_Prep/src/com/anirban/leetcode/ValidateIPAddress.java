package com.anirban.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPAddress {

  public static void main(String[] args) {
    // String ip = "172.16.254.1";
    //String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334";
    String ip = "1.0.1.";
    System.out.println(validIPAddress(ip));
  }

  public static String validIPAddress(String IP) {
    String pattern = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern v4 = Pattern.compile(pattern);
    Matcher m = v4.matcher(IP);
    if (m.matches())
      return "IPV4";
    String pattern1 = "((([0-9a-fA-F]{1,4})\\:){7}([0-9a-fA-F]{1,4}))";
    Pattern v6 = Pattern.compile(pattern1);
    Matcher m6 = v6.matcher(IP);
    if (m6.matches())
      return "IPV6";
    else
      return "Nothing";

  }
}
