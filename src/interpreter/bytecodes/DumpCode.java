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
public class DumpCode extends ByteCode{
    
    private String dumpStatus;
    
    public void DumpCode(){
        
    }

    @Override
    public void init(ArrayList argArrayList) {
        dumpStatus = (String)argArrayList.get(0);
        
    }

    @Override
    public void execute(VirtualMachine vm) {
        if(dumpStatus.equals("ON")){
            vm.dumpSwitch(true);
            } 
        else if (dumpStatus.equals("OFF")){
            vm.dumpSwitch(false);
        }
    }
    
    private String name = "DUMP ";
    
//*** FOR DEBUGGING ONLY
    @Override
    public void deBugPrint() {
        System.out.println(name + " " + dumpStatus);
    }

    @Override
    public void deBugPrintResolved() {
        System.out.println(name + " " + dumpStatus);
    }
    
    
}
