//calculate factorial using functions

import scala.util.Random;

object factorialFunction {
  def main(args: Array[String]) {
    
    /* facotrial function  : Iterative*/
    def fac(n: Int)= {
      var r = 1
      for(i<-1 to n)
        r = r *i
      r //return r. Last expression is returned. 
    }

    /* factorial function : Recursive. Return type is needed. */
    def fac2(n: Int):Int = {
      if(n<=0) 1 else (n *fac(n-1))
    }

    val n = Random.nextInt(10) //generate random int between 0-10
    printf("Factorial of %d is %d using iterative and %d using recursive.\n",n,fac(n),fac2(n)) 
  }
}

