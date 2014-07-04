package br.com.cobregratis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.cobregratis.CobreGratis;
import br.com.cobregratis.exceptions.CobreGratisNotFoundException;
import br.com.cobregratis.models.BankBillet;

public class TestCobreGratis {
	private CobreGratis cobreGratis;

	// private CobreGratis cobreGratisNoArgs;

	@Before
	public void setUp() throws Exception {
		cobreGratis = new CobreGratis("uiF3x9JuMFMBMasanVPo", "teste_api_java");
	}

	@After
	public void after() {
		sleep();
	}

	// @Test
	// public void testCreateByPropertiesFile(){
	// try {
	// cobreGratisNoArgs = new CobreGratis();
	// } catch (IOException e) {
	// fail();
	// }
	// }

	// @Test
	// public void testExceptionByPropertiesFile(){
	// try {
	// renameFile("cobregratis.properties", "cobregratisFake.properties");
	// cobreGratisNoArgs = new CobreGratis();
	// fail("Exception was expected");
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// finally{
	// renameFile("cobregratisFake.properties", "cobregratis.properties");
	// }
	// }

	// @Before
	// public void setNoArgs() throws Exception {
	// cobreGratisNoArgs = new CobreGratis();
	// }

	// @Test
	// public void testGetBankBilletWithNoArgs() throws InterruptedException {
	// try {
	//
	// BankBillet billet = cobreGratisNoArgs.getBankBillet(157196);
	// assertEquals("00001", billet.getOurNumber());
	// assertEquals("Quentin", billet.getName());
	// assertEquals("00190.00009 01234.567004 00000.001172 4 58630000000228",
	// billet.getLine());
	// assertEquals(Boolean.FALSE, billet.getCreatedByApi());
	// assertEquals(2.28, billet.getAmount().floatValue(), .1);
	// assertEquals(new Integer(4954),billet.getBankBilletAccountId());
	//
	// Thread.sleep(1000);
	// } catch (Exception e) {
	// fail(e.getMessage());
	// }
	//
	// }

	@Test
	public void testGetBankBillet() throws InterruptedException {
		try {
			BankBillet billet = cobreGratis.save(createBillet());
			sleep();
			BankBillet testBillet = cobreGratis.getBankBillet(billet.getId());
			assertEquals(billet.getOurNumber(), testBillet.getOurNumber());
			assertEquals(billet.getName(), testBillet.getName());
			assertEquals(billet.getAmount().floatValue(), testBillet
					.getAmount().floatValue(), .1);

		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	// @Test
	// public void testFailWhenGetInexistentBillet() throws InterruptedException
	// {
	// try {
	// Thread.sleep(1000);
	// cobreGratis.getBankBillet(0);
	// fail("don't throws CobreGratisNotFoundException");
	// } catch (CobreGratisBadRequestException e) {
	// fail(e.getMessage());
	// } catch (CobreGratisUnauthorizedException e) {
	// fail(e.getMessage());
	// } catch (CobreGratisForbiddenException e) {
	// fail(e.getMessage());
	// } catch (CobreGratisServiceUnavailableException e) {
	// fail(e.getMessage());
	// } catch (CobreGratisInternalServerErrorException e) {
	// fail(e.getMessage());
	// } catch (CobreGratisTooManyRequestsException e) {
	// fail(e.getMessage());
	// } catch (CobreGratisNotFoundException e) { }
	//
	// }

	@Test
	public void testSaveBankBillet() throws InterruptedException {
		BankBillet billet = createBillet();
		try {
			BankBillet newBillet = cobreGratis.save(billet);
			assertEquals(billet.getName(), newBillet.getName());
			assertEquals(Boolean.TRUE, newBillet.getCreatedByApi());
			assertEquals(billet.getAmount().floatValue(), newBillet.getAmount()
					.floatValue(), .1);
			assertEquals(billet.getExpireAt(), newBillet.getExpireAt());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	private BankBillet createBillet() {
		return createBillet(false);
	}

	private BankBillet createBillet(boolean draft) {
		BankBillet billet = new BankBillet();
		billet.setAmount(new BigDecimal(230.00));
		Calendar calExpire = Calendar.getInstance();
		calExpire.add(Calendar.YEAR, 2);
		calExpire.set(Calendar.HOUR_OF_DAY, 0);
		calExpire.set(Calendar.MINUTE, 0);
		calExpire.set(Calendar.SECOND, 0);
		calExpire.set(Calendar.MILLISECOND, 0);
		billet.setExpireAt(calExpire.getTime());
		billet.setName("Carlos Ribeiro - sacado");
		if (draft) {
			billet.setStatus("d");
		}
		return billet;
	}

	@Test
	public void testListBankBillets() throws InterruptedException {
		try {
			Thread.sleep(1000);
			List<BankBillet> list = cobreGratis.getBankBillets();
			if (list == null || list.isEmpty()) {
				fail();
			}
			assertEquals(Boolean.TRUE, list.size() > 1);
			assertNotNull(list.get(0));

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	// @Test
	// public void testUpdate() throws InterruptedException {
	// try {
	// BankBillet billet = cobreGratis.save(createBillet(true));
	// BigDecimal oldValue = billet.getAmount();
	// billet.setAmount(billet.getAmount().add(new BigDecimal(10)));
	// sleep();
	// cobreGratis.update(billet);
	// assertEquals(oldValue.add(new BigDecimal(10)).floatValue(),
	// billet.getAmount().floatValue(), .1);
	// } catch (Exception e) {
	// fail(e.getMessage());
	// }
	// }

	@Test
	public void testDelete() throws InterruptedException {
		BankBillet billet = null;
		try {
			billet = cobreGratis.save(createBillet());
			sleep();
			cobreGratis.delete(billet);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		} finally {
			try {
				sleep();
				cobreGratis.getBankBillet(billet.getId());
			} catch (CobreGratisNotFoundException e) {
				// ok :) not found
			} catch (Exception e) {
				fail();
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testPay() throws InterruptedException {
		try {
			BankBillet billet = cobreGratis.save(createBillet());
			Date paidDate = new Date();
			BigDecimal paidAmount = billet.getAmount();
			sleep(5); //garante que o boleto vai ser processado no cobregratis
			cobreGratis.pay(billet, paidDate, billet.getAmount());
			assertEquals(paidDate, billet.getPaidAt());
			assertEquals(paidAmount, billet.getAmount());
		} catch (Exception e) {
			System.out.println(e.getClass());
			fail(e.getMessage());
		}
	}

	private void sleep() {
		sleep(1);
	}
	private void sleep(int factor) {
		try {
			Thread.sleep(factor * 1000);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	// private void renameFile(String from, String to) {
	// try {
	//
	// URL resource = getClass().getClassLoader().getResource(from);
	// File oldFile = new File(resource.toURI());
	//
	// File newFile = new File(oldFile.getParent() + File.separatorChar
	// + to);
	//
	// oldFile.renameTo(newFile);
	// oldFile.delete();
	//
	// } catch (URISyntaxException e) {
	// e.printStackTrace();
	// }
	//
	// }

}
