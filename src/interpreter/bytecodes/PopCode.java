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
public class PopCode extends ByteCode{
    
    private int n; // n levels of runtime stack to pop
    private String name = "POP ";
    
    @Override
    public void execute(VirtualMachine vm){
        
        //pops n levels off the runtime stack
        for(int i =1;i<= n; i++ ){
            vm.pop();
        }
        
        //dump
        String statement = name + ((Integer)n).toString();
        vm.dump(statement);
       
    }
    
    public void PopCode(){
        
        
    }
    
    @Override
    public void init(ArrayList argArrayList){
        n = Integer.parseInt((String)argArrayList.get(0));
       
    }
    
    
    
    

//***For debugging purpose only***
   
    
    @Override
    public void deBugPrint(){
        System.out.println(name + " " + n);
    }
    
    @Override
    public void deBugPrintResolved(){
        System.out.println(name + " " + n);
    }
    
}
