package Assignment1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class FileManager implements IFileManeger{
  public ArrayList<ArrayList<String>> scanLines(){
    String fileName;
    ArrayList<ArrayList<String>> lines = new ArrayList<>();

    boolean cont = true;
    int i = 0;

    while(cont == true){
      fileName = getName(i);
      try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        lines.add(new ArrayList<>());
        String line;
        while ((line = reader.readLine()) != null) {
            lines.get(i).add(line);
        }
        reader.close();
      } catch (IOException e) {
          break;
      }
      i++;
    }
    return lines;
  }

  public void writeText(int i, String line){
    String fileName = "Assignment1/Decks/Deck" + i + ".txt";

    try (FileWriter writer = new FileWriter(fileName, true)) {
        writer.write(line + "\n");
    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
    }
  }

  public void clearFile(int i){
    String name = "";
    String fileName = getName(i);

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      name = reader.readLine();
      reader.close();
    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    }
    
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      writer.write(name);
      writer.newLine();
      writer.close();
    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }

  public void renameFile(int oldIndex, int newIndex){
    String oldFileName = getName(oldIndex);
    String newFileName = getName(newIndex);

    Path oldFilePath = Paths.get(oldFileName);
    Path newFilePath = Paths.get(newFileName);

    try {
      Files.copy(oldFilePath, newFilePath, StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      System.err.println("Error renaming the file: " + e.getMessage());
    }
  }

  public void deleteFile(int i){
    String fileName = getName(i);

    Path filePath = Paths.get(fileName);
    try{
      Files.delete(filePath);
    } catch (IOException e){
      System.err.println("Error deleting the file: " + e.getMessage());
    }
  }

  private String getName(int i){
    return "Assignment1/Decks/Deck" + i + ".txt";
  }
}
