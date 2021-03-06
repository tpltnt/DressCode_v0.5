package com.pixelmaid.dresscode.antlr.types.tree.properties;

import java.util.List;



import com.pixelmaid.dresscode.antlr.types.VarType;
import com.pixelmaid.dresscode.antlr.types.tree.DCNode;
import com.pixelmaid.dresscode.antlr.types.tree.PropertyNode;
import com.pixelmaid.dresscode.drawing.datatype.Point;
import com.pixelmaid.dresscode.drawing.primitive2d.Curve;
import com.pixelmaid.dresscode.drawing.primitive2d.DrawablePoint;

import com.pixelmaid.dresscode.drawing.primitive2d.Line;



public class StartPropertyNode extends PropertyNode {

    public StartPropertyNode() {
        
     }

     @Override
     public VarType evaluate() {
     	if(!(value.isLine() ||value.isCurve())){
     		  throw new RuntimeException("Illegal end property access: " + this);
     	}
     	DrawablePoint s;
     	if(value.isLine()){
     		
     		Line d = value.asLine();
     		s = d.getEnd().copy().toDrawable();
     	}
     	else{
     		Curve d = value.asCurve();
     		s = d.getEnd().toDrawable();
     	}
     	
     	return new VarType(s);	
     	
       
       
     }

   
}
