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
public  abstract class ByteCode {
    
    public abstract void init(ArrayList argArrayList);
    
    
    public abstract void execute(VirtualMachine vm);
    
    //Debugging statements - used to test bytecodeloader and resolve address method
    public abstract void deBugPrint();
    public abstract void deBugPrintResolved();
 
    
}
