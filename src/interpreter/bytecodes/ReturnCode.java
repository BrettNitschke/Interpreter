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
public class ReturnCode extends ByteCode{
    String funcName; //current func to return from
    
    private String name = "RETURN ";
    
    public void ReturnCode(){
        
    }
    
    @Override
    public void init(ArrayList argArrayList){
        //check to see if has an arg
        if (!argArrayList.isEmpty()){
            funcName = (String)argArrayList.get(0);
        } else {
            funcName = "";
        }
    }
    
    
    
    @Override
    public void execute(VirtualMachine vm){
        //pops top frame off of stack
        vm.popFrame();
        //gets return address, sets PC to return address
        int pc = vm.popReturnAddress();
        vm.setPC(pc);
        
        //dump
        String statement;
        if (funcName.isEmpty()){
            statement = name;
        }
        else {
            String strippedFuncName = stripBrackets(funcName);
            int returnValue = vm.peek();
            statement = name + funcName + "  " + "exit " + strippedFuncName + ": " + ((Integer)returnValue).toString();
        }
        
        vm.dump(statement);
    }
    
    
    public String stripBrackets(String label){
        
        String delimiters = "<>";
        StringTokenizer st = new StringTokenizer(label, delimiters, true);
       
        String strippedLabel = st.nextToken();
        
        return strippedLabel;
    }
    
    //***For debugging purpose only***
    
    
    @Override
    public void deBugPrint(){
        System.out.println(name + " " + funcName);
    }
    
    @Override
    public void deBugPrintResolved(){
        System.out.println(name + " " + funcName);
    }
    
}
