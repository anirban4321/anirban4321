package com.anirban.leetcode.MayChallenge;

import java.util.HashMap;

public class RansomeNote {

  public static void main(String[] args) {
    String ransomNote = "a", magazine = "b";
    System.out.println(canConstruct(ransomNote, magazine));
  }

  public static boolean canConstruct(String ransomNote, String magazine) {
    int ransomeNoteLength = ransomNote.length();
    int magazineLength = magazine.length();

    HashMap<Character, Integer> ransomNoteMap = new HashMap<Character, Integer>();
    HashMap<Character, Integer> magazineMap = new HashMap<Character, Integer>();

    for (int i = 0; i < magazineLength; i++) {
      Character magazineCharacter = magazine.charAt(i);
      if (magazineMap.containsKey(magazineCharacter)) {
        int val = magazineMap.get(magazineCharacter);
        magazineMap.put(magazineCharacter, val + 1);
      } else {
        magazineMap.put(magazineCharacter, 1);
      }
    }

    for (int i = 0; i < ransomeNoteLength; i++) {
      Character ransomeNoteCharacter = ransomNote.charAt(i);
      if (magazineMap.containsKey(ransomeNoteCharacter)) {
        if (magazineMap.get(ransomeNoteCharacter) == 0) {
          return false;
        } else {
          int val = magazineMap.get(ransomeNoteCharacter) - 1;
          magazineMap.put(ransomeNoteCharacter, val);
        }
      } else {
        return false;
      }
    }
    return true;
  }
}
