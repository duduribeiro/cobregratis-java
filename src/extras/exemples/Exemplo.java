package extras.exemples;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import br.com.cobregratis.CobreGratis;
import br.com.cobregratis.exceptions.CobreGratisBadRequestException;
import br.com.cobregratis.exceptions.CobreGratisForbiddenException;
import br.com.cobregratis.exceptions.CobreGratisInternalServerErrorException;
import br.com.cobregratis.exceptions.CobreGratisNotFoundException;
import br.com.cobregratis.exceptions.CobreGratisServiceUnavailableException;
import br.com.cobregratis.exceptions.CobreGratisTooManyRequestsException;
import br.com.cobregratis.exceptions.CobreGratisUnauthorizedException;
import br.com.cobregratis.models.BankBillet;
import br.com.cobregratis.models.BankBillet.Email;

public class Exemplo {

	public static void main(String[] args) throws IOException {
		CobreGratis cobreGratis = new CobreGratis();
		try { 
			//Mostrando um boleto
			BankBillet billetsaved = cobreGratis.getBankBillet(370629); 
			System.out.println(billetsaved.getOurNumber());
			System.out.println(billetsaved.getMeta());

			//Criando um boleto
			BankBillet billet = new BankBillet(); 
			billet.setAmount(new BigDecimal(6.00)); 
			billet.setAddress("Av. Lazaro Moreira, 944"); 
			billet.setCity("Santa Vitoria"); 
			billet.setZipcode("38320-000"); 

			Email email = new Email();
			email.setName("LAYLA");
			email.setAddress("kivanio@cobregratis.com.br");
			billet.setEmail(email);

			Calendar calExpire = Calendar.getInstance(); 
			calExpire.set(2014, 06, 10); 
			billet.setExpireAt(calExpire.getTime()); 
			billet.setName("Cobre Grátis Cliente Exemplo"); 

			//Parcelado
			//billet.setKind("parceled");
			//billet.setParcels(3);

			billet = cobreGratis.save(billet);
			System.out.println(billet.getOurNumber());
			//Parcelado
			//System.out.println(billet.getAllParcelsIds());
			//System.out.println(billet.getCarnetExternalLink());



			//Lista de boletos
			List<BankBillet> list = cobreGratis.getBankBillets(); 
			for (int i = 0; i < list.size(); i++) { 
				System.out.println("================================="); 
				System.out.println("" + list.get(i).getKind()); 
				System.out.println("" + list.get(i).getOurNumberRaw());
				System.out.println("" + list.get(i).getDocumentNumber()); 
				System.out.println("" + list.get(i).getOurNumber()); 
				System.out.println("" + list.get(i).getAmount()); 
				System.out.println("" + list.get(i).getId()); 
			} 

		} catch (CobreGratisBadRequestException e) { 
			e.printStackTrace(); 
		} catch (CobreGratisUnauthorizedException e) { 
			e.printStackTrace(); 
		} catch (CobreGratisForbiddenException e) { 
			e.printStackTrace(); 
		} catch (CobreGratisServiceUnavailableException e) { 
			e.printStackTrace(); 
		} catch (CobreGratisInternalServerErrorException e) { 
			e.printStackTrace(); 
		} catch (CobreGratisNotFoundException e) { 
			e.printStackTrace(); 
		} catch (CobreGratisTooManyRequestsException e) { 
			e.printStackTrace(); 
		} catch (Exception e){
			e.printStackTrace();
		}
	} 
}	
