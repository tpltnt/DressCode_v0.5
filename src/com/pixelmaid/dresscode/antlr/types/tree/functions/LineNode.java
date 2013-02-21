package com.pixelmaid.dresscode.antlr.types.tree.functions;

import java.util.ArrayList;
import java.util.List;

import com.pixelmaid.dresscode.antlr.types.VarType;
import com.pixelmaid.dresscode.antlr.types.tree.DCNode;
import com.pixelmaid.dresscode.drawing.primitive2d.Drawable;
import com.pixelmaid.dresscode.drawing.primitive2d.Line;
import com.pixelmaid.dresscode.app.Manager;

public class LineNode extends DrawableNode implements DCNode {

    public LineNode(List<DCNode> ps, int l) {
       super(ps,l);
    	
    }

    @Override
    public VarType evaluate() {
    	Line e = null;
    	if(params.get(0).evaluate().isNumber()){
    	try{
    		ArrayList<Double> values = new ArrayList<Double>();
    	
    	for(int i=0;i<params.size();i++){
    		VarType value = params.get(i).evaluate();
    		if(value.isNumber()){
               values.add(value.asDouble());
            }
    	}
    	
    		e = new Line(values);
    	}
    	catch (ClassCastException err){
			Manager.output.setText("incorrect parameters for line call at line:"+line);

    		System.err.println("incorrect parameters for line call at line:"+line);
    		
    		}
    	}
    	else if(params.get(0).evaluate().isDrawable()){
    		try{
    		
    		
    			if(params.get(0).evaluate().isLine()&&params.get(0).evaluate().isLine()){
    				Line d1 = params.get(0).evaluate().asLine();
        			Line d2 = params.get(1).evaluate().asLine();
        			e = new Line(d1.getEnd(),d2.getStart());
    			}
    		else{
    			Drawable d1 = params.get(0).evaluate().asDrawable();
    			Drawable d2 = params.get(1).evaluate().asDrawable();
    			e = new Line(d1.getOrigin(),d2.getOrigin());
    		}
        		
        	}
        	catch (ClassCastException err){
    			Manager.output.setText("incorrect parameters for line call at line:"+line);

        		System.err.println("incorrect parameters for line call at line:"+line);
        		
        	}
    	}
    	else{
			Manager.output.setText("incorrect parameters for line call at line:"+line);

    		System.err.println("incorrect parameters for line call at line:"+line);
    	}
    	Manager.canvas.addDrawable("line",line,e);
    	return new VarType(e);	
        //throw new RuntimeException("Illegal function call: " + this);
    }

   
}