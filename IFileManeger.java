package Assignment1;

import java.util.ArrayList;

public interface IFileManeger {
  ArrayList<ArrayList<String>> scanLines();
  void writeText(int i, String line);
  void clearFile(int i);
  void renameFile(int oldIndex, int newIndex);
  void deleteFile(int i);
}
