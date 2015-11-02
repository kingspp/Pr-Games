package com.razorthink.scala.resources

import com.sun.corba.se.impl.orbutil.DenseIntMapImpl
import breeze.linalg.DenseMatrix


case class BoardState (state: String, action: String, reward: Int);