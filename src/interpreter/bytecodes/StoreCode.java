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
public class StoreCode extends ByteCode{
    
    private int offset;
    private String id; //variable name for value popped
    private String name = "STORE ";
    
    
    @Override
    public void init(ArrayList argArrayList){
        offset = Integer.parseInt((String)argArrayList.get(0));
        id = (String)argArrayList.get(1);
        
    }
    
    @Override
    public void execute(VirtualMachine vm){
        vm.store(offset);
        
        //dump
        int topOfStack = vm.peek();
        String statement = name + ((Integer)offset).toString() + " " + id + "   " + id + " = " + ((Integer)topOfStack).toString();
        
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
