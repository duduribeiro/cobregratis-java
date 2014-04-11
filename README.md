# Biblioteca Java para acessar a [API do Cobre Gratis](https://github.com/BielSystems/cobregratis-api)

## Dependências (Incluidas também na pasta lib)

* [gson-2.2.2.jar](http://google-gson.googlecode.com/files/google-gson-2.2.2-release.zip)
* [jersey-bundle-1.14.jar](https://maven.java.net/content/repositories/releases/com/sun/jersey/jersey-bundle/1.14/jersey-bundle-1.14.jar)


## Download
[cobregratis-java-1.1.0.jar](https://github.com/duduribeiro/cobregratis-java/raw/master/dist/cobregratis-java-1.1.0.jar)

## Utilizando
### Exemplo para pegar um determinado boleto
```java
import br.com.cobregratis.CobreGratis;
import br.com.cobregratis.models.BankBillet;

  CobreGratis cobreGratis = new CobreGratis("SEU_TOKEN", "api_name");
  try{
    BankBillet billet = cobreGratis.getBankBillet(74899);
    System.out.println(billet.getName());
  } catch (Exception e) {
    e.printStackTrace();
  }
```
### Ou identificando as exceptions
```java
import br.com.cobregratis.CobreGratis;
import br.com.cobregratis.models.BankBillet;
import br.com.cobregratis.exceptions.CobreGratisBadRequestException;
import br.com.cobregratis.exceptions.CobreGratisForbiddenException;
import br.com.cobregratis.exceptions.CobreGratisInternalServerErrorException;
import br.com.cobregratis.exceptions.CobreGratisNotFoundException;
import br.com.cobregratis.exceptions.CobreGratisServiceUnavailableException;
import br.com.cobregratis.exceptions.CobreGratisTooManyRequestsException;
import br.com.cobregratis.exceptions.CobreGratisUnauthorizedException;

  CobreGratis cobreGratis = new CobreGratis("SEU_TOKEN", "api_name");
  try{
    BankBillet billet = cobreGratis.getBankBillet(74899);
    System.out.println(billet.getName());
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
    }
```

### Criando um boleto
```java
import br.com.cobregratis.CobreGratis;
import br.com.cobregratis.models.BankBillet;
import br.com.cobregratis.exceptions.CobreGratisBadRequestException;
import br.com.cobregratis.exceptions.CobreGratisForbiddenException;
import br.com.cobregratis.exceptions.CobreGratisInternalServerErrorException;
import br.com.cobregratis.exceptions.CobreGratisNotFoundException;
import br.com.cobregratis.exceptions.CobreGratisServiceUnavailableException;
import br.com.cobregratis.exceptions.CobreGratisTooManyRequestsException;
import br.com.cobregratis.exceptions.CobreGratisUnauthorizedException;

  CobreGratis cobreGratis = new CobreGratis("SEU_TOKEN", "api_name");
  try{
    BankBillet billet = new BankBillet();
    billet.setAmount(new BigDecimal(230.00));
    Calendar calExpire = Calendar.getInstance();
    calExpire.set(25, 3, 2013, 0, 0,0);
    billet.setExpireAt(calExpire.getTime());
    billet.setName("Carlos Ribeiro - sacado");

    billet = cobreGratis.save(billet);

    System.out.println(billet.getOurNumber());

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
    }
```

### Atualizar um boleto (apenas boletos em rascunho)
```java
import br.com.cobregratis.CobreGratis;
import br.com.cobregratis.models.BankBillet;
import br.com.cobregratis.exceptions.CobreGratisBadRequestException;
import br.com.cobregratis.exceptions.CobreGratisForbiddenException;
import br.com.cobregratis.exceptions.CobreGratisInternalServerErrorException;
import br.com.cobregratis.exceptions.CobreGratisNotFoundException;
import br.com.cobregratis.exceptions.CobreGratisServiceUnavailableException;
import br.com.cobregratis.exceptions.CobreGratisTooManyRequestsException;
import br.com.cobregratis.exceptions.CobreGratisUnauthorizedException;

  CobreGratis cobreGratis = new CobreGratis("SEU_TOKEN", "api_name");
  try{
    BankBillet billet = cobreGratis.getBankBillet(108874);
    billet.setAmount(billet.getAmount().add(new BigDecimal(10)));
    cobreGratis.update(billet);
    System.out.println(billet.getAmount());

  } catch (Exception e) {
      e.printStackTrace();
    }
```

### Excluir um boleto
```java
import br.com.cobregratis.CobreGratis;
import br.com.cobregratis.models.BankBillet;
import br.com.cobregratis.exceptions.CobreGratisBadRequestException;
import br.com.cobregratis.exceptions.CobreGratisForbiddenException;
import br.com.cobregratis.exceptions.CobreGratisInternalServerErrorException;
import br.com.cobregratis.exceptions.CobreGratisNotFoundException;
import br.com.cobregratis.exceptions.CobreGratisServiceUnavailableException;
import br.com.cobregratis.exceptions.CobreGratisTooManyRequestsException;
import br.com.cobregratis.exceptions.CobreGratisUnauthorizedException;

  CobreGratis cobreGratis = new CobreGratis("SEU_TOKEN", "api_name");
  try{
    BankBillet billet = cobreGratis.getBankBillet(108874);
    cobreGratis.delete(billet);

  } catch (Exception e) {
      e.printStackTrace();
    }
```

### Listar Boletos
```java
import br.com.cobregratis.CobreGratis;
import br.com.cobregratis.models.BankBillet;
import br.com.cobregratis.exceptions.CobreGratisBadRequestException;
import br.com.cobregratis.exceptions.CobreGratisForbiddenException;
import br.com.cobregratis.exceptions.CobreGratisInternalServerErrorException;
import br.com.cobregratis.exceptions.CobreGratisNotFoundException;
import br.com.cobregratis.exceptions.CobreGratisServiceUnavailableException;
import br.com.cobregratis.exceptions.CobreGratisTooManyRequestsException;
import br.com.cobregratis.exceptions.CobreGratisUnauthorizedException;

  CobreGratis cobreGratis = new CobreGratis("SEU_TOKEN", "api_name");
  try{
    List<BankBillet> list = cobreGratis.getBankBillets(2);

    System.out.println(list.get(0).getOurNumber());

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
    }
```
### Quitar um boleto
```java
CobreGratis cobreGratis = new CobreGratis("SEU_TOKEN", "api_name");
  try{
    BankBillet billet = cobreGratis.getBankBillet(108874);
    cobreGratis.pay(billet, new Date(), new BigDecimal(300.00) );

  } catch (Exception e) {
      e.printStackTrace();
  }
```
