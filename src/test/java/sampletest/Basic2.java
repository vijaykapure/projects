package sampletest;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Basic2  {
  @Test
  public void basic2() throws IOException {
	  Assert.assertTrue(false);
	  System.out.println("basic 2 false");
  }
}
