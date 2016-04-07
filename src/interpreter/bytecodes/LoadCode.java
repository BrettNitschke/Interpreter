/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecodes;
import java.util.*;
import interpreter.VirtualMachine;
/**
 *
 * @author brettnitschke
 */
public class LoadCode extends ByteCode {
    
    private int offset;
    private String id = ""; // variable name from which data is loaded
    private String name = "LOAD ";
    
    public void LoadCode(){
        
    }
    
    @Override
    public void init(ArrayList argArrayList){
        //Load always has two arguments, so take first two from argArrayList
        offset = Integer.parseInt((String)argArrayList.get(0));
        id = (String)argArrayList.get(1);
        
        
    }
    @Override
    public void execute(VirtualMachine vm){
        vm.load(offset);
        
        //dump 
        String statement;
        if (id.isEmpty()){
            statement = name + offset;
        }
        else {
            statement = name + offset + " " + id + "   " + "<load " + id + ">";
        }
        vm.dump(statement);
        
    }
    
    


//***For debugging purpose only***
    
    
    @Override
    public void deBugPrint(){
        System.out.println(name + " " + offset + " " + id);
    }
    
    @Override
    public void deBugPrintResolved(){
        System.out.println(name + " " + offset + " " + id);
    }
    
}
