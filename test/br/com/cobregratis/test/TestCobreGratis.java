package br.com.cobregratis.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.cobregratis.CobreGratis;
import br.com.cobregratis.exceptions.CobreGratisBadRequestException;
import br.com.cobregratis.exceptions.CobreGratisForbiddenException;
import br.com.cobregratis.exceptions.CobreGratisInternalServerErrorException;
import br.com.cobregratis.exceptions.CobreGratisNotFoundException;
import br.com.cobregratis.exceptions.CobreGratisServiceUnavailableException;
import br.com.cobregratis.exceptions.CobreGratisTooManyRequestsException;
import br.com.cobregratis.exceptions.CobreGratisUnauthorizedException;
import br.com.cobregratis.models.BankBillet;


public class TestCobreGratis {
    private CobreGratis cobreGratis;
    private CobreGratis cobreGratisNoArgs;

    @Before
    public void setUp() throws Exception {
    	cobreGratis = new CobreGratis("qerpPazrNx95U8Lox35r", "teste_api_java");
    }

    @Test
    public void testCreateByPropertiesFile(){
		try {
		    cobreGratisNoArgs = new CobreGratis();
		} catch (IOException e) {
		    fail();
		}
    }

    @Test
    public void testExceptionByPropertiesFile(){
		try {
		    renameFile("cobregratis.properties", "cobregratisFake.properties");
		    cobreGratisNoArgs = new CobreGratis();
		    fail();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		finally{
		    renameFile("cobregratisFake.properties", "cobregratis.properties");
		}
    }

    @Before
    public void setNoArgs() throws Exception {
    	cobreGratisNoArgs = new CobreGratis();
    }

    @Test
    public void testGetBankBilletWithNoArgs() throws InterruptedException {
		try {

		    BankBillet billet = cobreGratisNoArgs.getBankBillet(157196);
		    assertEquals("00001", billet.getOurNumber());
		    assertEquals("Quentin", billet.getName());
		    assertEquals("00190.00009 01234.567004 00000.001172 4 58630000000228", billet.getLine());
		    assertEquals(Boolean.FALSE, billet.getCreatedByApi());
		    assertEquals(2.28, billet.getAmount().floatValue(), .1);
		    assertEquals(new Integer(4954),billet.getBankBilletAccountId());

		    Thread.sleep(1000);
		} catch (Exception e) {
		    fail(e.getMessage());
		}

    }

    @Test
    public void testGetBankBillet() throws InterruptedException {
		try {
		    BankBillet billet = cobreGratis.getBankBillet(165270);
		    assertEquals("00027", billet.getOurNumber());
		    assertEquals("Teste - sacado", billet.getName());
		    assertEquals("00190.00009 01234.567004 00000.027177 3 57400000023000", billet.getLine());
		    assertEquals(230.00, billet.getAmount().floatValue(), .1);

		} catch (Exception e) {
		    fail(e.getMessage());
		}

    }

    @Test
    public void testFailWhenGetInexistentBillet() throws InterruptedException {
		try {
		    Thread.sleep(1000);
		    cobreGratis.getBankBillet(2312131);
		    fail("don't throws CobreGratisNotFoundException");
		} catch (CobreGratisBadRequestException e) {
			fail(e.getMessage());
		} catch (CobreGratisUnauthorizedException e) {
			fail(e.getMessage());
		} catch (CobreGratisForbiddenException e) {
			fail(e.getMessage());
		} catch (CobreGratisServiceUnavailableException e) {
			fail(e.getMessage());
		} catch (CobreGratisInternalServerErrorException e) {
			fail(e.getMessage());
		} catch (CobreGratisTooManyRequestsException e) {
		    fail(e.getMessage());
		} catch (CobreGratisNotFoundException e) { }

    }

    @Test
    public void testSaveBankBillet() throws InterruptedException {
		BankBillet billet = new BankBillet();
		billet.setAmount(new BigDecimal(230.00));
		Calendar calExpire = Calendar.getInstance();
		calExpire.set(25, 3, 2013, 0, 0,0);
		billet.setExpireAt(calExpire.getTime());
		billet.setName("Carlos Ribeiro - sacado");
		try {
		    Thread.sleep(1000);
		    billet = cobreGratis.save(billet);
		    assertEquals("Carlos Ribeiro - sacado", billet.getName());
		    assertEquals(Boolean.TRUE, billet.getCreatedByApi());
		    assertEquals(230.00, billet.getAmount().floatValue(), .1);
		    assertEquals(new Integer(4954),billet.getBankBilletAccountId());

		} catch (Exception e) {
		    e.printStackTrace();
		    fail();
		}
    }

    @Test
    public void testListBankBillets() throws InterruptedException {
		try {
		    Thread.sleep(1000);
		    List<BankBillet> list = cobreGratis.getBankBillets();
		    if(list == null || list.isEmpty()) {
		    	fail();
		    }
		    assertEquals(Boolean.TRUE, list.size() > 1);

		} catch (Exception e) {
		    fail(e.getMessage());
		}
    }

    @Test
    public void testUpdate() throws InterruptedException {
		try {
		    BankBillet billet = cobreGratis.getBankBillet(160616);
		    BigDecimal oldValue = billet.getAmount();
		    billet.setAmount(billet.getAmount().add(new BigDecimal(10)));
		    Thread.sleep(1000);
		    cobreGratis.update(billet);
		    assertEquals(oldValue.add(new BigDecimal(10)).floatValue(), billet.getAmount().floatValue(), .1);
		} catch (Exception e) {
		    fail(e.getMessage());
		}
    }

    @Test
    public void testDelete() throws InterruptedException {
		BankBillet billet = new BankBillet();
		billet.setAmount(new BigDecimal(230.00));
		Calendar calExpire = Calendar.getInstance();
		calExpire.set(25, 3, 2013, 0, 0,0);
		billet.setExpireAt(calExpire.getTime());
		billet.setName("Carlos Ribeiro - sacado");
		try {
		    Thread.sleep(1000);
		    billet = cobreGratis.save(billet);
		    Thread.sleep(1000);
		    cobreGratis.delete(billet);
		} catch (Exception e) {
		    e.printStackTrace();
		    fail();
		}
    }

    @Test
    public void testPay() throws InterruptedException {
    	Thread.sleep(1000);
		BankBillet billet = new BankBillet();
		billet.setAmount(new BigDecimal(300.00));
		Calendar calExpire = Calendar.getInstance();
		calExpire.add(Calendar.DAY_OF_MONTH, 10);
		billet.setExpireAt(calExpire.getTime());
		billet.setName("Carlos Ribeiro - sacado");
		try {
			billet = cobreGratis.save(billet);
			Thread.sleep(1000);
			Date paidDate = new Date();
			BigDecimal paidAmount = billet.getAmount();
			cobreGratis.pay(billet, paidDate , billet.getAmount());
			assertEquals(paidDate, billet.getPaidAt() );
			assertEquals(paidAmount, billet.getAmount());
		} catch (Exception e) {
			fail(e.getMessage());
		}
    }

    private void renameFile(String from, String to){
	try {

	    URL resource = getClass().getClassLoader().getResource(from);
	    File oldFile = new File(resource.toURI());

	    File newFile = new File(oldFile.getParent() + File.separatorChar + to);

	    oldFile.renameTo(newFile);

	} catch (URISyntaxException e) {
	    e.printStackTrace();
	}

    }

}
