package com.servehttp.bytecom.commons;

import org.junit.Assert;
import org.junit.Test;


public class StringUtilTest {

  @Test
  public void testGerarSenha() {
    String senha = StringUtil.gerarSenha(8);
    Assert.assertNotNull(senha);
    Assert.assertTrue(senha.length() == 8);
  }

  @Test
  public void testFormatCurrenceRoundUpware() throws Exception {
    String actual = StringUtil.formatCurrence(1234.9384);
    Assert.assertEquals("1.234,94", actual);
  }
  
  @Test
  public void testFormatCurrence() throws Exception {
	  String actual = StringUtil.formatCurrence(1234.9314);
	  Assert.assertEquals("1.234,93", actual);
  }


}
