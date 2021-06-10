package com.anirban.Stack;

import java.util.Stack;

class GfG {

  int minEle;

  Stack<Integer> s = new Stack<>();

  // Stack<Integer> ss=new Stack<>();
  /*returns min element from stack*/
  int getMin() {
	  /* if(ss.size()==0)
	     return -1;
	   else return ss.peek();*/

    if (s.size() == 0)
      return -1;
    return minEle;
  }

  /*returns poped element from stack*/
  int pop() {
        /*if(s.size()==0)
          return -1;
        int x= s.peek();
        s.pop();
        if(x==ss.peek())
          ss.pop();
        return x;*/
    if (s.size() == 0)
      return -1;
    if (s.peek() < minEle) {
      minEle = 2 * minEle - s.peek();
      return s.pop();
    } else
      return s.pop();

  }

  /*push element x into the stack*/
  void push(int x) {
	  	/*if(s.size()==0){
	  	    s.push(x);
	  	    ss.push(x);
	  	}
	  	else{
	  	    s.push(x);
	  	    if(ss.peek()>=x)
	  	      ss.push(x);
	  	}*/

    if (s.size() == 0) {
      s.push(x);
      minEle = x;
    } else {
      if (x >= minEle)
        s.push(x);
      else {
        s.push(2 * x - minEle);
        minEle = x;
      }
    }

  }
}

