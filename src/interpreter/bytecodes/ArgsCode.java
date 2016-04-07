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
public class ArgsCode extends ByteCode {
    
    private int numberOfArgs; 
    private String name = "ARGS ";
    
    
    public void ArgsCode(){
        
    }
    
    @Override
    public void init(ArrayList argArrayList){
        numberOfArgs = Integer.parseInt((String)argArrayList.get(0));
    }
    
    @Override
    public void execute(VirtualMachine vm){
        vm.newFrameAt(numberOfArgs);
        
        //dump
        String statement = name + ((Integer)numberOfArgs).toString();
        
        vm.dump(statement);
    }
    
    
   
    //***For debugging purpose only***
    @Override
    public void deBugPrint(){
        System.out.println(name + " " + numberOfArgs);
    }
    
    @Override
    public void deBugPrintResolved(){
        System.out.println(name + " " + numberOfArgs);
    }
}
