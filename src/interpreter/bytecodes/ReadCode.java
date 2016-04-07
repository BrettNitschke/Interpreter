/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecodes;
import java.util.*;
import interpreter.VirtualMachine;
import javax.swing.JOptionPane;
/**
 *
 * @author brettnitschke
 */
public class ReadCode extends ByteCode {
    
    private String name = "READ ";
    
    public void ReadCode(){
        
    }
    
    @Override
    public void init(ArrayList argArrayList){
        
    }
    
    
    @Override
    public void execute(VirtualMachine vm){
        
        //reads in an int, pushes to runtime stack
        String input = JOptionPane.showInputDialog("Enter an integer: ");
        int i = Integer.parseInt(input);
        
        vm.push(i);
        
        String statement = name;
        
        vm.dump(statement);
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
