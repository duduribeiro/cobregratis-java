# Biblioteca Java para acessar a [API do Cobre Gratis](https://github.com/BielSystems/cobregratis-api)

## Dependências

* [gson-2.2.2.jar](http://google-gson.googlecode.com/files/google-gson-2.2.2-release.zip)
* [jersey-bundle-1.14.jar](https://maven.java.net/content/repositories/releases/com/sun/jersey/jersey-bundle/1.14/jersey-bundle-1.14.jar)


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