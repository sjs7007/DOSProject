//calculate factorial using functions

import scala.util.Random;

object factorialFunction {
  def main(args: Array[String]) {
    
    /* facotrial function */
    def fac(n: Int)= {
      var r = 1
      for(i<-1 to n)
        r = r *i
      r //return r. Last expression is returned. 
    }

    val n = Random.nextInt(10) //generate random int between 0-10
    printf("Factorial of %d is %d.\n",n,fac(n)) 
  }
}

