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
public class HaltCode  extends ByteCode{
    
    public void HaltCode(){
        
    }
    
    @Override
    public void init(ArrayList argArrayList){
        
    }
    
    @Override
    public void execute(VirtualMachine vm){
        vm.kill();
    }
    
    
    private String name = "HALT ";
    
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
