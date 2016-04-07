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
public class LitCode extends ByteCode {
    
    private int value; //literal value
    //initialize id to "" to make checking isEmpty() posiible
    private String id = ""; //variable name
    private String name = "LIT ";
    
    public void LitCode(){
        
    }
    
    @Override
    public void init(ArrayList argArrayList){
        //sets literal value
        value = Integer.parseInt((String)argArrayList.get(0));
        //checks to see if there is a variable name
        if (argArrayList.size() > 1 )
        {
            id = (String)argArrayList.get(1);
        }
    }
    
    
    
    @Override
    public void execute(VirtualMachine vm){
        vm.push(value);
        
        //dump
        String statement;
        if (id.isEmpty()){
            statement = name + ((Integer)value).toString();
        }
        else {
            statement = name + ((Integer)value).toString() + " " + id + "   " + "int " + id;
        }
        
        vm.dump(statement);
    }
    
    
    
    
    //***For debugging purpose only***
    
    
    @Override
    public void deBugPrint(){
        System.out.println(name + " " + value + " " + id);
    }
    
    @Override
    public void deBugPrintResolved(){
        System.out.println(name + " " + value +" " + id);
    }
}
