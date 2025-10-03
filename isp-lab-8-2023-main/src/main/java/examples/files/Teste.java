/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.files;

import isp.lab8.airways.FileReadUtil;
import isp.lab8.airways.FileWriteUtil;
import isp.lab8.airways.FilesAndFoldersUtil;

import java.io.IOException;

/**
 *
 * @author mihai.hulea
 */
public class Teste {
    public static void main(String[] args) throws IOException {
        FilesAndFoldersUtil.createFolder("tmp"); //pathu e in acelasi folder
        FilesAndFoldersUtil.getFilesInFolder("tmp").stream().forEach(s->System.out.println(s));
        FileWriteUtil.writeUsingFiles("Line 1", "tmp\\test1.txt");
        FileReadUtil.readAllFileLines("tmp\\test1.txt").stream().forEach(System.out::println); //method refferece
        FilesAndFoldersUtil.createFolder("c:\\_tmp2");
    }
   
}