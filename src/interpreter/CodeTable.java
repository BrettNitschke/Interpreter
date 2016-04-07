/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;
import java.util.*;
/**
 *
 * @author brettnitschke
 */
public  class CodeTable {
    
    private static final HashMap<String, String> codeTable = new HashMap<String, String>();
    
    
    public static String get(String code){
        String codeClass = codeTable.get(code);
        
        return codeClass;
       
    }
    
    public static void init() {
        codeTable.put("HALT", "HaltCode");
        codeTable.put("FALSEBRANCH", "FalseBranchCode");
        codeTable.put("GOTO", "GoToCode");
        codeTable.put("STORE", "StoreCode");
        codeTable.put("LOAD", "LoadCode");
        codeTable.put("LIT", "LitCode");
        codeTable.put("ARGS", "ArgsCode");
        codeTable.put("CALL", "CallCode");
        codeTable.put("RETURN", "ReturnCode");
        codeTable.put("BOP", "BopCode");
        codeTable.put("READ", "ReadCode");
        codeTable.put("WRITE", "WriteCode");
        codeTable.put("LABEL", "LabelCode");
        codeTable.put("DUMP", "DumpCode");
        codeTable.put("POP", "PopCode");
    }
}
