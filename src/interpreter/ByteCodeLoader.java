/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;
import java.util.*;
import java.io.*;
import interpreter.bytecodes.*;
/**
 *
 * @author brettnitschke
 */
public class ByteCodeLoader {
    
    private BufferedReader input;
    
    
    public  ByteCodeLoader(String codeFile) throws IOException {
        
        input = new BufferedReader(new FileReader(codeFile));
    }
    
    public Program loadCodes(){
        
        StringTokenizer tokenizer;
        ArrayList<String> argArrayList = new ArrayList<String>(); //array of args passed into bytecode via init method
        String nextLine;  //line read from codeFile
        ByteCode nextCode;  //byteCode to be created from each line
        String arg;
        
        //used to look up and create bytecode object
        String codeTableKey;  
        String codeTableValue;
        
        Program thisProgram = new Program();
        
        try {
        nextLine = input.readLine();
        
        while (nextLine != null){
            
            tokenizer = new StringTokenizer(nextLine);  //tokenizes the line read from codeFile
            
            //looks up bytecode to get name to create instance
            codeTableKey = tokenizer.nextToken();
            codeTableValue = CodeTable.get(codeTableKey);
            
            //creates instance
            nextCode = (ByteCode)(Class.forName("interpreter.bytecodes."+codeTableValue).newInstance());
            
           
            
            //collects remaining tokens from string (the potential args) adds to array to send to bytecode
            while (tokenizer.hasMoreTokens()){
                arg = tokenizer.nextToken();
                argArrayList.add(arg);
            }
            //initializes new created byteCode with args
            nextCode.init(argArrayList);
            thisProgram.add(nextCode);
            
            //clears argArray for next bytecode
            argArrayList.clear();
            
            nextLine = input.readLine();
            }
        
        }
    
        catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        System.out.println("***Error***");
    }
        
        
        //once all bytecodes collected, resolve the addresses
        thisProgram.resolveAddresses();
        
        return thisProgram;
    }
}
