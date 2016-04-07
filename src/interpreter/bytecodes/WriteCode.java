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
public class WriteCode extends ByteCode {
    
    
    private String name = "WRITE ";
    
    public void WriteCode(){
        
    }
    
    @Override
    public void init(ArrayList argArrayList){
        
    }
    
    @Override
    public void execute(VirtualMachine vm){
        int i = vm.peek();
        System.out.println(i);
        
        //dump
        String statement = name;
        vm.dump(name);
    }
    
    
    
    
    //***For debugging purpose only***
    
    
    @Override
    public void deBugPrint(){
        System.out.println(name);
    }
    
    @Override
    public void deBugPrintResolved(){
        System.out.println(name);
    }
}
