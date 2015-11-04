package com.razorthink.scala.resources

import com.sun.corba.se.impl.orbutil.DenseIntMapImpl
import breeze.linalg.DenseMatrix
import org.apache.commons.lang3.builder.HashCodeBuilder
import org.apache.commons.lang3.builder.EqualsBuilder


case class BoardState (state: String, action: String, reward: Int){
  
   override def hashCode() : Int =  {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
            // if deriving: appendSuper(super.hashCode()).
            append(state).
            append(action).
            append(reward).
            toHashCode();
    }
   
   override def equals(obj: Any) : Boolean =  {
     var boardState =  obj.asInstanceOf[BoardState];
        return new EqualsBuilder().
            append(state, boardState.state).
            append(action, boardState.action).
            append(reward, boardState.reward).
            isEquals();
    }
}