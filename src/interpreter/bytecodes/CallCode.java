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
public class CallCode extends ByteCode implements ResolveMe{
    
    public String funcName;
    public int address;
    private String name = "CALL ";
    
    public void CallCode(){
        
    }
    
    @Override
    public void init(ArrayList argArrayList){
        funcName = (String)argArrayList.get(0);
    }
    
    @Override
    public void execute(VirtualMachine vm){
        vm.pushReturnAddress();
        vm.setPC(address);
        
        
        //dump
        String strippedLabel = stripBrackets(funcName);
        String args = prepArguments(vm.functionArguments());
        
        String statement = name + funcName + "   " + strippedLabel + args;
        vm.dump(statement);
    }
    
    //Interface implementation
    @Override
    public String getLabel(){
        return funcName;
    }
    
    @Override
    public void setAddress(int address){
        this.address = address;
    }
    
    //strips <<>> off of function name for dump
    public String stripBrackets(String label){
        
        String delimiters = "<>";
        StringTokenizer st = new StringTokenizer(label, delimiters, true);
       
        String strippedLabel = st.nextToken();
        
        return strippedLabel;
    }
    
    //takes in arraylist of args and preps them as a string to be dumped
    //in form of (a,b,c,d,e) or () if no args
    public String prepArguments(ArrayList args){
        String argString;
        
        if (args.isEmpty()){
            argString = "()";
        }
        else {
            Iterator<Integer> argIt = args.iterator();
            argString = "(";
            while(argIt.hasNext()){
                Integer nextArg = argIt.next();
                if(argIt.hasNext()){
                    argString += nextArg.toString();
                    argString += ",";
                }
                else {
                    argString += nextArg.toString();
                }
            }
            argString += ")";
        }
        
        return argString;
    }

      //***For debugging purpose only***
    
    
    @Override
    public void deBugPrint(){
        System.out.println(name + " " + funcName);
    }
    
    @Override
    public void deBugPrintResolved(){
        System.out.println(name + " " + address);
    }
    
}
