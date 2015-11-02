package com.razorthink.scala.resources

import breeze.linalg.DenseMatrix

class Print {
  
  def printDenseMatrix(data: DenseMatrix[Int]){
    var result = data.toString();
    println(result);
  }
  
  def parseInt(choice: String): Array[Int] = {
    var resultString = choice.split(" ");
    var result = new Array[Int](2);
    result(0) = resultString(0).toInt;
    result(1) = resultString(1).toInt;
    return result;
  }
}