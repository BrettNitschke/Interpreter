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
public class LabelCode extends ByteCode{
    
    private String label;
    private String name = "LABEL ";
    
    public String getLabel(){
        return label;
    }
    public void LabelCode(){
        
    }
    
    @Override
    public void init(ArrayList argArrayList){
        label = (String)argArrayList.get(0);
    }
    
    @Override
    public void execute(VirtualMachine vm){
        //dump
        String statement = name + label;
        vm.dump(statement);
    }
    
    
   
    

//***For debugging purpose only***
    
    
    @Override
    public void deBugPrint(){
        System.out.println(name + " " + label);
    }
    
    @Override
    public void deBugPrintResolved(){
        System.out.println(name + " " + label);
    }
    
}
