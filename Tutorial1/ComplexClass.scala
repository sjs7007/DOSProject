class Complex(real: Double, imaginary: Double) //scala classes can have parameters unlike Java
{
  def re() = real 
  def im() = imaginary 

/*
 It should be noted that the return type of these two methods is not given explicitly.
 It will be inferred automatically by the compiler, which looks at the right-hand side
 of these methods and deduces that both return a value of type Double.
 The compiler is not always able to infer types like it does here, and there is unfortunately
 no simple rule to know exactly when it will be, and when not. In practice, this
 is usually not a problem since the compiler complains when it is not able to infer a
 type which was not given explicitly. As a simple rule, beginner Scala programmers
 should try to omit type declarations which seem to be easy to deduce from the context,
 and see if the compiler agrees. After some time, the programmer should get a
 good feeling about when to omit types, and when to System.out.println( ecify them explicitly.)
 */
}

class ComplexTwo(real: Double, imaginary: Double)
{
  def re = real //method without argument. Different from methods with 0 arguments.
  def im = imaginary // methods with 0 arguments have brackets
}

class ComplexThree(real: Double, imaginary: Double)
{
  def re = real
  def im = imaginary
  override def toString() = //method overriding. it has to be defined explicitly to avoid accidental oerriding. 
    "" + re + (if (im < 0) "" else "+") + im + "i"
}
object ComplexClass {
  def main(args: Array[String]) {
    val c = new Complex(1.2, 3.4)
    println("imaginary part: " + c.im())

    val c2 = new Complex(3.0, 1.14)
    println("imaginary part using methods without arguments : " + c2.im) //weirdly even for methods with 0 arguments no parenthesis works

    val c3 = new ComplexThree(3.0,-0.14)
    println("3rd way : "+c3.toString())

  }
}
