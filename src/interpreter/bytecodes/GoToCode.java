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
public class GoToCode extends ByteCode implements ResolveMe {
    
    private String label;
    private int address;
    private String name = "GOTO ";
    
    public void ByteCode(){
        
    }
    
    @Override
    public void init(ArrayList argArrayList){
        label = (String)argArrayList.get(0);
    }
    
    @Override
    public void execute(VirtualMachine vm){
        vm.setPC(address);
        
        //dump
        String statement = name + label;
        vm.dump(statement);
        
    }
    
    //****** Interface implementation
    @Override
    public String getLabel(){
        return label;
    }
    
    @Override
    public void setAddress(int address){
        this.address = address;
    }
    
    
    
    

    //***For debugging purpose only***
    
    
    @Override
    public void deBugPrint(){
        System.out.println(name + " " + label);
    }
    
    @Override
    public void deBugPrintResolved(){
        System.out.println(name + " " + address);
    }
}
