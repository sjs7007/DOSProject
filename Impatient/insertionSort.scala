import scala.util.Random

object insertionSort {
  def main(args: Array[String]) {
    /*print("Enter n : ")
    val n = readInt()
    printf("Enter %d numbers : ",n)
    var arrayNum: Array[Int] = new Array[Int](n)
    for(i <-0 until n) {
      arrayNum(i)=readInt()
    }
    */

    val n = 10
    var arrayNum:Array[Int] = new Array[Int](n)
    
    /* fill array with n random integers, integer range is 0-100) */
    for(i<-0 until n) {
      arrayNum(i)=Random.nextInt(100)
    }

    /* display input array  */ 
    print("Input Array is : ")
    for(i<-0 until n) print(arrayNum(i)+" ")
    println()

    /* Insertion sort procedure */
    for(j<-1 until n) {
      var key = arrayNum(j)
      var i = j-1
      while(i>=0 && arrayNum(i)>key) {
        arrayNum(i+1)=arrayNum(i)
        i=i-1
      }
      arrayNum(i+1)=key
    }

    /* display sorted array */
    print("Sorted Array is : ")
    for(i<-0 until n) print(arrayNum(i)+" ")
  }
}
