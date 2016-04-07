/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;
import java.util.*;
import interpreter.bytecodes.*;
/**
 *
 * @author brettnitschke
 */
public class VirtualMachine {
    private RunTimeStack runStack;
    private int pc;
    private boolean isDumping;
    
    Stack<Integer> returnAddrs;
    boolean isRunning;
    Program program;
    
    public VirtualMachine(Program program){
        this.program = program;
    }
    
    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack();
        isRunning = true;
        
        while(isRunning){
            ByteCode code = program.getCode(pc);
            code.execute(this);
            //runStack.dump();
            pc++;
        }
    }
    
    public void dumpSwitch(boolean dump){
        isDumping = dump;
    }
    
    
    //takes in statement from the bytecode, checks to see if dumping is turned on
    //if yes, dump
    public void dump(String statement){
        
        if(isDumping){
           System.out.println(statement);
           runStack.dump();
        }
    }
    
    public void kill(){
        isRunning = false;
    }
    
    public int popReturnAddress(){
        return returnAddrs.pop();
    }
    
    public void pushReturnAddress(){
        returnAddrs.push(pc);
    }
    
    public void setPC(int i){
        pc = i;
    }
    
    public int getSize(){
        return runStack.getSize();
    }
    
    public int peek(){
        return runStack.peek();
    }
    
    public int pop(){
        return runStack.pop();
    }
    
    public int push(int i){
        return runStack.push(i);
    }
    
    public void newFrameAt(int offset){
        runStack.newFrameAt(offset);
    }
    
    public void popFrame(){
        runStack.popFrame();
    }
    
    public int store(int offset){
        return runStack.store(offset);
    }
    
    public int load(int offset){
        return runStack.load(offset);
    }
    
    public Integer push(Integer i){
        return runStack.push(i);
    }
    
    public ArrayList<Integer> functionArguments(){
        return runStack.functionArguments();
    }
    

//runTimeStack belongs to virtual machine - no one else can access or create instance of
class RunTimeStack {
    
    private Stack<Integer> framePointers;
    private ArrayList<Integer> runStack;
    
    private RunTimeStack(){
        runStack = new ArrayList<Integer>();
        framePointers = new Stack<Integer>();
        //initialize the stack
        framePointers.push(0);
    }
    
    public void dump(){
        
        //if there is only one frame, nothing fancy to be done - just toString() the array
        if (framePointers.size() == 1){
            System.out.println(runStack.toString());
        }
        else {
            int runStackCounter = 1;
        
            Iterator<Integer> runSArrayIt = runStack.iterator();
            Iterator<Integer> frameStackIt = framePointers.iterator();
        
            //the point where a new frame is created
            int frameBreakPoint = frameStackIt.next();
            //first item in stack is always 0, irrelevent here so get next
            frameBreakPoint = frameStackIt.next();
            
            System.out.print("[");
            while (runSArrayIt.hasNext()){
                //get next item in array
                int rSArrayNext = runSArrayIt.next();
                
                //checks to see if comma is needed
                if(runSArrayIt.hasNext() && runStackCounter != frameBreakPoint){
                    System.out.print(rSArrayNext + ",");
                }
                else //comma not needed
                    System.out.print(rSArrayNext);
                
                if (runStackCounter == frameBreakPoint)  //time for new frame
                {
                    System.out.print("][");
                    if (frameStackIt.hasNext()){
                        frameBreakPoint = frameStackIt.next(); //load next frame break
                    }
                }
            runStackCounter++;
        }
            
            System.out.println("]");  //no more things to print close off final frame
            
       
        }
    }
    
    public int getSize(){
        return runStack.size();
    }
    
    public int peek(){
        
        int i = runStack.get(runStack.size()-1);
        return i;
    }
    
    public int pop(){
        int i = runStack.remove(runStack.size()-1);
        return i;
    }
    
    public int push(int i){
        
        runStack.add(i);
        
        //gets last item on runStack
        return runStack.get(runStack.size()-1);
    }
    
    public void newFrameAt(int offset){
        int size = runStack.size();
        
        //start of new frame
        int newFrameAt = size - offset;
        framePointers.push(newFrameAt);
    }
    
    
    //pops framepointer stack, saves top value of that frame, deletes rest of frame
    //puts top value onto top of frame below
    //used when returning from functions
    public void popFrame(){
        //index of top value
        int high = (runStack.size()-1);
        int returnValue = runStack.get(high);
        
        //index of low value on frame to be popped
        int low = framePointers.pop();
        
        for (int i = high; i>=low; i--){
            runStack.remove(i);
        }
        
        //pushes function return value onto stack
        runStack.add(returnValue);
    }
    
    public int store(int offset){
        int value = this.pop();
        int actualOffset = framePointers.peek() + offset;
        runStack.set(actualOffset, value);
        
        return value;
        
    }
    
    public int load(int offset){
        int currentFrame = framePointers.peek();
        int actualOffset = currentFrame + offset;
        
        int value = runStack.get(actualOffset);
        runStack.add(value);
        
        return value;
    }
    
    public Integer push(Integer i){
        runStack.add(i);
        
        return i;
    }
    
    
    //returns the arguments in the top frame on the stack
    //used for the call dump method
    public ArrayList<Integer> functionArguments(){
        ArrayList<Integer> funcArgs = new ArrayList<Integer>();
        int startOfFrame = framePointers.peek();
        int endOfFrame = runStack.size()-1;
        
        for(int i = startOfFrame; i<= endOfFrame; i++){
            funcArgs.add(runStack.get(i));
        }
        
        return funcArgs;
    }
    
   
}
}