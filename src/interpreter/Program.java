/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;
import java.util.*;
import interpreter.bytecodes.*;

/**
 *
 * @author brettnitschke
 */
public class Program {
    private ArrayList<ByteCode> byteCodeArray;
    
    private HashMap<String, Integer> labelAddresses;
    
    public Program(){
         byteCodeArray = new ArrayList<ByteCode>();
         labelAddresses = new HashMap<String, Integer>();
         
    }
    
    public void add(ByteCode newCode){
        byteCodeArray.add(newCode);
        int address = byteCodeArray.size() - 1;
        
        
        //reflection - checks class at runtime to see if it is label class
        //if so, hashmaps the label and dress for ease of finding during address resolution
        if (newCode instanceof LabelCode){
            String hashKey = ((LabelCode)newCode).getLabel();
            labelAddresses.put(hashKey, address);
        }
       
    }
    
    
    //run through loop, checking to see if bytecode follows resolve me interface
    //if so, resolve address
    public void resolveAddresses() {
        
        for (int i = 0; i< byteCodeArray.size(); i++) {
            ByteCode thisCode = byteCodeArray.get(i);
            if (thisCode instanceof ResolveMe){
                ResolveMe resCode = (ResolveMe)thisCode;
                //labelAddresses.get(resCode.getLabel());
                
                resCode.setAddress(labelAddresses.get(resCode.getLabel()));
            }
        }
    
    }
    
    public ByteCode getCode(int i){
        return byteCodeArray.get(i);
    }
    
    
    //**DEBUG PURPOSES ONLY
    
    public void debugPrint(){
        
        for (int i = 0; i<byteCodeArray.size(); i++){
            System.out.print(i + ". ");
            byteCodeArray.get(i).deBugPrint();
            
        }
        
    }
    
    public void debugPrintResolved(){
        
        for (int i = 0; i<byteCodeArray.size(); i++){
            System.out.print(i + ". ");
            byteCodeArray.get(i).deBugPrintResolved();
            
        }
        
    }
}
