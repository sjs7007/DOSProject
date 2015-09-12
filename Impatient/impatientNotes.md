### Chapter 1 : The Basics.

- Value declared with val is constant. var is for variable.

- Semicolons are required only if you have multiple statements on the same line. 

- Everything is an object in scala. Even numbers like 1,2,3.14.

- There is no ++ or -- in scala. Instead use +=1 or -=1.

- The usual mathematical operators can be used with BigInt and BigDecimal objects since the operators themselves represent function calls anyway. So you can directly do x * x instead of x.multiply(x)

- Math functions such as pow(), min() in scala.math

 Can be used as sqrt(2),pow(2,4) etc.

The prefix scala. can be omitted.

import scala.math._ == import math._

- Scala has singleton objects instead of static methods.  

- Look into RichInt,RichDouble and StringOps in Scala docs.

- Method tagged as implicit is an automatic conversion. Example the BigInt object has automatic conversions from int and long to BigInt.

e.g 

scala> var x=4
x: Int = 4

scala> var y:BigInt = 5
y: scala.math.BigInt = 5

scala> x+y
res15: scala.math.BigInt = 9

Chapter 1 ends here. Solutions : https://gist.github.com/parambirs/9932268.

----

### Chapter 2 : Control Structures and Functions.

+ Semicolons are optional.
+ void type is Unit.
+ Avoid using return in a function... why?

If Else
+ Syntax is same as Java. Except if/else has a value = the expression value which follows if or else.

Example : if(x>0) 1 else -1 will have value 1 or -1 depending on if x>0 or not.

+ Type of a mixed type expression is common supertype of both branches. 

Example : if (x>0) "pos" else -1 will have type expression which is common supertype of Int and java.lang.String which is Any.

Look up any..

+ Use :paste mode to type out/copy a bunch of code in REPL without it getting evaluated directly.
+ Use semicolons to have more than 1 stmt in a single line. 
+ The vale of a block containing multiple expressions is the value of the last expression in the block.
+ Assignments have no value or "Unit" type in scala.
+ Print Options : print or println or printf(c style).
+ Input Options : readLine,readInt,readDouble,readByte etc

```
scala> var x = readInt()
warning: there was one deprecation warning; re-run with -deprecation for details
x: Int = 567
```

Note that this doesnt seem to echo the user input. Look for how to echo user input....
+ Power mode doesnt solve this problem. 

+ Loop Options : while and do. Same as Java.

Example : 

var x = 5
var y = while(x>1)
{
    x=x*x-1
}

This above code will not return factorial in y, because as mentioned earlier assignments have Unit type in Scala. Also, that is wrong code for factorial.

scala> while(x>1){
     | y=y*x
     | x=x-1
     | }
     
scala> y
res2: Int = 120

+ For Loop 

Example : 

for(i <- 1 to 5)
{
    print(i)
}

Output : 12345

+ to is a method from the RichInt class which returns a range of numbers from 1 to n(inclusive).
+ To get range from 0 to n-1 use until instead of to. 

Output if until was used instead of to in above example : 1234

+ BREAK/CONTINUE : Scala has no such statements to break out of a loop.
How to break then : http://stackoverflow.com/questions/2742719/how-do-i-break-out-of-a-loop-in-scala

Tail recursion in Scala? :  http://oldfashionedsoftware.com/2008/09/27/tail-recursion-basics-in-scala/

Book methods : 

    + Use a Boolean control variable instead.... What does this mean? [look-up-later]
    + Use nested functions. You can return from middle of a function. 
        i.e. put the loop inside a method and use return when you want to break out.
    + Use the break method in the Breaks object... 
        This method works by throwing and catching an exception. Should be ideally avoided. 


#### Advanced for Loops and Comprehensions

for(i <- 1 to 3 ; j <- 1 to 3) println(i+" "+j)

Output : 11
         12 
         .
         .
         33

+ Each <- thing is called a generator and it can have a guard. A guard is a boolean condition preceded by if. 

Example if, if i!=j is added at end of j <-1 to 3 output will have all combos except where i=j.

+ When the body of the for loop starts with yield, then the loop constructs a collection of values, one for each iteration. 

#### Functions

+ Functions are different from methods. Scala supports both. Method operates on object but function doesnt. 
+ To define a function, you specify the functions name,parameters, and body like this :

def abs(x:Double) = if (x>=0)x else -x

+ You must specify the types of all parameters. Return type needed only if function is recursive. 
+ The last expression in the function is the return value. 
+ If the function has more than one statements, use a block. 

Example : 

```
def fac(n:Int) = {
    var r=1
    for(i<-1 to n)
    {
        r=r*i
    }
    r
}

+ Recursive Def : 

```
def fac(n: Int): Int = {
    if(n<=0) 1
    else n*fac(n-1)
}
```

--- 

http://stackoverflow.com/questions/11667630/difference-between-using-app-trait-and-main-method-in-scala
http://alvinalexander.com/scala/scala-implicit-method-arguments-fields-example

