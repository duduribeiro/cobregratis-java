package br.com.cobregratis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import br.com.cobregratis.exceptions.CobreGratisBadRequestException;
import br.com.cobregratis.exceptions.CobreGratisForbiddenException;
import br.com.cobregratis.exceptions.CobreGratisInternalServerErrorException;
import br.com.cobregratis.exceptions.CobreGratisNotFoundException;
import br.com.cobregratis.exceptions.CobreGratisServiceUnavailableException;
import br.com.cobregratis.exceptions.CobreGratisTooManyRequestsException;
import br.com.cobregratis.exceptions.CobreGratisUnauthorizedException;
import br.com.cobregratis.exceptions.CobreGratisUnprocessibleEntityException;
import br.com.cobregratis.models.BankBillet;
import br.com.cobregratis.models.BankBilletWrapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class CobreGratis {
	private String token;
	private String appId;
	private static final String BASE_URL = "https://app.cobregratis.com.br";
	private static final String PROPERTIES_FILE = "cobregratis.properties";
	private Client client;
	private Gson gson;

	public CobreGratis() throws IOException {

	    Properties prop = new Properties();

	    InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE);

	    if(resourceAsStream == null){
		throw new FileNotFoundException("Properties file " + PROPERTIES_FILE + " was not found." );
	    }

	    //load a properties file from class path, inside static method
	    prop.load(resourceAsStream);

	    this.token = prop.getProperty("token");
	    this.appId = prop.getProperty("appId");

	    client = Client.create();
	    client.addFilter(new HTTPBasicAuthFilter(this.token, "X"));
	    gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

	}

	public CobreGratis(String token, String appId) {
		this.token = token;
		this.appId = appId;
		client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter(this.token, "X"));
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	}

	private WebResource getWebResource() {
		return client.resource(getBaseURI());
	}

	public BankBillet save(BankBillet billet)
			throws CobreGratisBadRequestException,
			CobreGratisUnauthorizedException, CobreGratisForbiddenException,
			CobreGratisNotFoundException,
			CobreGratisServiceUnavailableException,
			CobreGratisInternalServerErrorException,
			CobreGratisTooManyRequestsException {
		BankBilletWrapper wrapper = new BankBilletWrapper();
		wrapper.setBankBillet(billet);
		String json = gson.toJson(wrapper);
		ClientResponse response = getWebResource().path("bank_billets")
				.type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).header("User-Agent", appId)
				.post(ClientResponse.class, json);
		switch (response.getStatus()) {
		case 201:
			String jsonNew = response.getEntity(String.class);
			wrapper = gson.fromJson(jsonNew, BankBilletWrapper.class);
			billet = wrapper.getBankBillet();
			return wrapper.getBankBillet();
		case 400:
			throw new CobreGratisBadRequestException();
		case 401:
			throw new CobreGratisUnauthorizedException();
		case 403:
			throw new CobreGratisForbiddenException();
		case 404:
			throw new CobreGratisNotFoundException();
		case 429:
			throw new CobreGratisTooManyRequestsException();
		case 503:
			throw new CobreGratisServiceUnavailableException();
		case 500:
			throw new CobreGratisInternalServerErrorException();
		default:
			break;
		}
		return null;
	}

	public void delete(BankBillet billet) throws CobreGratisBadRequestException, CobreGratisUnauthorizedException, CobreGratisForbiddenException, CobreGratisNotFoundException, CobreGratisTooManyRequestsException, CobreGratisServiceUnavailableException, CobreGratisInternalServerErrorException {
		BankBilletWrapper wrapper = new BankBilletWrapper();
		wrapper.setBankBillet(billet);
		String json = gson.toJson(wrapper);
		ClientResponse response = getWebResource().path("bank_billets").path(billet.getId().toString()).type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).header("User-Agent", appId).delete(ClientResponse.class, json);
		switch (response.getStatus()) {
		case 200:
			return;
		case 400:
			throw new CobreGratisBadRequestException();
		case 401:
			throw new CobreGratisUnauthorizedException();
		case 403:
			throw new CobreGratisForbiddenException();
		case 404:
			throw new CobreGratisNotFoundException();
		case 429:
			throw new CobreGratisTooManyRequestsException();
		case 503:
			throw new CobreGratisServiceUnavailableException();
		case 500:
			throw new CobreGratisInternalServerErrorException();
		default:
			break;
		}

	}

	public BankBillet update(BankBillet billet)
			throws CobreGratisBadRequestException,
			CobreGratisUnauthorizedException, CobreGratisForbiddenException,
			CobreGratisNotFoundException,
			CobreGratisServiceUnavailableException,
			CobreGratisInternalServerErrorException,
			CobreGratisTooManyRequestsException,
			CobreGratisUnprocessibleEntityException {
		BankBilletWrapper wrapper = new BankBilletWrapper();
		wrapper.setBankBillet(billet);
		String json = gson.toJson(wrapper);
		ClientResponse response = getWebResource().path("bank_billets")
				.path(billet.getId().toString())
				.type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).header("User-Agent", appId)
				.put(ClientResponse.class, json);
		switch (response.getStatus()) {
		case 200:
			return billet;
		case 400:
			throw new CobreGratisBadRequestException();
		case 401:
			throw new CobreGratisUnauthorizedException();
		case 403:
			throw new CobreGratisForbiddenException();
		case 404:
			throw new CobreGratisNotFoundException();
		case 422:
			throw new CobreGratisUnprocessibleEntityException();
		case 429:
			throw new CobreGratisTooManyRequestsException();
		case 503:
			throw new CobreGratisServiceUnavailableException();
		case 500:
			throw new CobreGratisInternalServerErrorException();
		default:
			break;
		}
		return null;
	}

	public BankBillet getBankBillet(Integer id)
			throws CobreGratisBadRequestException,
			CobreGratisUnauthorizedException, CobreGratisForbiddenException,
			CobreGratisServiceUnavailableException,
			CobreGratisInternalServerErrorException,
			CobreGratisNotFoundException, CobreGratisTooManyRequestsException {
		ClientResponse response = getWebResource().path("bank_billets")
				.path(id.toString()).accept(MediaType.APPLICATION_JSON)
				.header("User-Agent", appId).get(ClientResponse.class);

		switch (response.getStatus()) {
		case 200:
			String json = response.getEntity(String.class);
			BankBilletWrapper wrappedBillet = gson.fromJson(json,
					BankBilletWrapper.class);
			return wrappedBillet.getBankBillet();
		case 400:
			throw new CobreGratisBadRequestException();
		case 401:
			throw new CobreGratisUnauthorizedException();
		case 403:
			throw new CobreGratisForbiddenException();
		case 404:
			throw new CobreGratisNotFoundException();
		case 429:
			throw new CobreGratisTooManyRequestsException();
		case 503:
			throw new CobreGratisServiceUnavailableException();
		case 500:
			throw new CobreGratisInternalServerErrorException();
		default:
			break;
		}
		return null;
	}

	public List<BankBillet> getBankBillets()
			throws CobreGratisBadRequestException,
			CobreGratisUnauthorizedException, CobreGratisForbiddenException,
			CobreGratisNotFoundException, CobreGratisTooManyRequestsException,
			CobreGratisServiceUnavailableException,
			CobreGratisInternalServerErrorException {
		return getBankBillets(null);
	}

	public List<BankBillet> getBankBillets(Integer page)
			throws CobreGratisBadRequestException,
			CobreGratisUnauthorizedException, CobreGratisForbiddenException,
			CobreGratisNotFoundException, CobreGratisTooManyRequestsException,
			CobreGratisServiceUnavailableException,
			CobreGratisInternalServerErrorException {
		ClientResponse response;
		if (page != null) {
			response = getWebResource().path("bank_billets")
					.queryParam("page", page.toString())
					.accept(MediaType.APPLICATION_JSON)
					.header("User-Agent", appId).get(ClientResponse.class);
		} else {
			response = getWebResource().path("bank_billets")
					.accept(MediaType.APPLICATION_JSON)
					.header("User-Agent", appId).get(ClientResponse.class);
		}
		switch (response.getStatus()) {
		case 200:
			String json = response.getEntity(String.class);
			//FIXME ocorrendo erro ao usar typetoken, tentar corrigir para voltar a usar o typetoken
			JsonParser parser = new JsonParser();
			JsonArray jArray = parser.parse(json).getAsJsonArray();
			List<BankBillet> billets= new ArrayList<BankBillet>();
			if(jArray != null) {
				for(JsonElement element: jArray) {
					BankBillet billet = gson.fromJson(element, BankBillet.class);
					billets.add(billet);
				}
			}
			return billets;

//			List<BankBilletWrapper> wrappers = gson.fromJson(json,
//					new TypeToken<List<BankBilletWrapper>>() {
//					}.getType());
//			return wrapperListToBilletsList(wrappers);
		case 400:
			throw new CobreGratisBadRequestException();
		case 401:
			throw new CobreGratisUnauthorizedException();
		case 403:
			throw new CobreGratisForbiddenException();
		case 404:
			throw new CobreGratisNotFoundException();
		case 429:
			throw new CobreGratisTooManyRequestsException();
		case 503:
			throw new CobreGratisServiceUnavailableException();
		case 500:
			throw new CobreGratisInternalServerErrorException();
		default:
			break;
		}

		return null;
	}

    private URI getBaseURI() {
		return UriBuilder.fromUri(BASE_URL).build();
	}

	@SuppressWarnings("unused")
	private List<BankBillet> wrapperListToBilletsList(
			List<BankBilletWrapper> wrappers) {
		List<BankBillet> returnList = new ArrayList<BankBillet>();
		if (wrappers != null) {
			Iterator<BankBilletWrapper> it = wrappers.iterator();
			while (it.hasNext()) {
				returnList.add(it.next().getBankBillet());
			}
		}
		return returnList;
	}

}