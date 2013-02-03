package br.com.cobregratis.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Calendar;
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
import br.com.cobregratis.exceptions.CobreGratisUnprocessibleEntityException;
import br.com.cobregratis.models.BankBillet;


public class TestCobreGratis {
	private CobreGratis cobreGratis;
	@Before
	public void setUp() throws Exception {
		cobreGratis = new CobreGratis("MDuafJUhYgQfeYKiwPocomzCFjQaPzOYOcbKBBhCdaFVdJeChNUbuiHxJfkz", "teste_api_java");
	}

	@Test
	public void testGetBankBillet() throws InterruptedException {
		try {
			BankBillet billet = cobreGratis.getBankBillet(74899);
			assertEquals("00001", billet.getOurNumber());
			assertEquals("Teste", billet.getName());
			assertEquals("00191.23454 67000.000009 00000.001214 5 54960000001000", billet.getLine());
			assertEquals(Boolean.FALSE, billet.getCreatedByApi());
			assertEquals(10.00, billet.getAmount().floatValue(), .1);
			assertEquals(new Integer(3337),billet.getBankBilletAccountId());

			Thread.sleep(1000);
			billet = cobreGratis.getBankBillet(75285);
			assertEquals("00002", billet.getOurNumber());
			assertEquals("Nome Sacado", billet.getName());
			assertEquals("00191.23454 67000.000009 00000.002212 1 55030000001245", billet.getLine());
			assertEquals(Boolean.FALSE, billet.getCreatedByApi());
			assertEquals(12.45, billet.getAmount().floatValue(), .1);
			assertEquals(new Integer(3337),billet.getBankBilletAccountId());
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
		} catch (CobreGratisNotFoundException e) {
			e.printStackTrace();
		} catch (CobreGratisTooManyRequestsException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testFailWhenGetInexistentBillet() throws InterruptedException {
		try {
			Thread.sleep(1000);
			cobreGratis.getBankBillet(2312131);
			fail();
		} catch (CobreGratisBadRequestException e) {
			fail();
		} catch (CobreGratisUnauthorizedException e) {
			fail();
		} catch (CobreGratisForbiddenException e) {
			fail();
		} catch (CobreGratisServiceUnavailableException e) {
			fail();
		} catch (CobreGratisInternalServerErrorException e) {
			fail();

		} catch (CobreGratisTooManyRequestsException e) {
				e.printStackTrace();
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
			assertEquals(new Integer(3337),billet.getBankBilletAccountId());

		} catch (CobreGratisBadRequestException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisUnauthorizedException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisForbiddenException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisNotFoundException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisServiceUnavailableException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisInternalServerErrorException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisTooManyRequestsException e) {
			e.printStackTrace();
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

		} catch (CobreGratisBadRequestException e) {
			e.printStackTrace();
		} catch (CobreGratisUnauthorizedException e) {
			e.printStackTrace();
		} catch (CobreGratisForbiddenException e) {
			e.printStackTrace();
		} catch (CobreGratisNotFoundException e) {
			e.printStackTrace();
		} catch (CobreGratisTooManyRequestsException e) {
			e.printStackTrace();
		} catch (CobreGratisServiceUnavailableException e) {
			e.printStackTrace();
		} catch (CobreGratisInternalServerErrorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() throws InterruptedException {
		try {
			BankBillet billet = cobreGratis.getBankBillet(108874);
			BigDecimal oldValue = billet.getAmount();
			billet.setAmount(billet.getAmount().add(new BigDecimal(10)));
			Thread.sleep(1000);
			cobreGratis.update(billet);
			assertEquals(oldValue.add(new BigDecimal(10)).floatValue(), billet.getAmount().floatValue(), .1);
		} catch (CobreGratisBadRequestException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisUnauthorizedException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisForbiddenException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisServiceUnavailableException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisInternalServerErrorException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisNotFoundException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisTooManyRequestsException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisUnprocessibleEntityException e) {
			e.printStackTrace();
			fail();
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
		} catch (CobreGratisBadRequestException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisUnauthorizedException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisForbiddenException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisNotFoundException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisTooManyRequestsException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisServiceUnavailableException e) {
			e.printStackTrace();
			fail();
		} catch (CobreGratisInternalServerErrorException e) {
			e.printStackTrace();
			fail();
		}
	}

}
