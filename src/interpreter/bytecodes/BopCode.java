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
public class BopCode extends ByteCode {
    
    private String operation;
    private String name = "BOP ";
    
    public void ByteCode(){
        
    }
    
    @Override
    public void init(ArrayList argArrayList){
        operation = (String)argArrayList.get(0);
    }

    @Override
    public void execute(VirtualMachine vm){
        int result;
        int topLevel = vm.pop();
        int secondLevel = vm.pop();
        
        if (operation.equals("+")){
            result = secondLevel + topLevel;
        }
        else if (operation.equals("-")){
            result = secondLevel - topLevel;
        }
        else if (operation.equals("/")){
            result = secondLevel / topLevel;
        }
        else if (operation.equals("*")){
            result = secondLevel * topLevel;
        }
        else if (operation.equals("==")){
            if (secondLevel == topLevel){
                result = 1;
            }
            else result = 0;
        }
        else if (operation.equals("!=")){
            if(secondLevel != topLevel){
                result = 1;
            } else result = 0;
        }
        else if (operation.equals("<=")){
            if(secondLevel <= topLevel){
                result = 1;
            } else result = 0;
        }
        else if(operation.equals(">")){
            if (secondLevel > topLevel){
                result = 1;
            } result = 0;
        }
        else if(operation.equals(">=")){
            if(secondLevel >= topLevel){
                result = 1;
            } else result = 0;
        }
        else if(operation.equals("<")){
            if(secondLevel < topLevel){
                result = 1;
            } else result = 0;
        } else {
            result = 0;
        }
        
        vm.push(result);
        //dump
        String statement = name + operation;
        vm.dump(statement);
        
    }
    
    
    
    //***For debugging purpose only***
    
    
    @Override
    public void deBugPrint(){
        System.out.println(name + " " + operation);
    }
    
    @Override
    public void deBugPrintResolved(){
        System.out.println(name + " " + operation);
    }
}
