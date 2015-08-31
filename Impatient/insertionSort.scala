object insertionSort {
  def main(args: Array[String]) {
    print("Enter n : ")
    val n = readInt()
    printf("Enter %d numbers : ",n)
    var arrayNum: Array[Int] = new Array[Int](n)
    for(i <-0 until n) {
      arrayNum(i)=readInt()
    }
    for(j<-1 until n) {
      var key = arrayNum(j)
      var i = j-1
      while(i>=0 && arrayNum(i)>key) {
        arrayNum(i+1)=arrayNum(i)
        i=i-1
      }
      arrayNum(i+1)=key
    }

    print("Sorted Array is : ")
    for(i<-0 until n) print(arrayNum(i)+" ")
  }
}
