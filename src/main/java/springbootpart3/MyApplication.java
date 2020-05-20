package springbootpart3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import springbootpart3.wsdl.*;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
@EnableCaching


public class MyApplication {

    public static void main(String[] args){

        SpringApplication.run(MyApplication.class, args);


    }


    @Bean
    CommandLineRunner lookup() throws MalformedURLException {
        URL url = new URL("http://localhost:9090/ws/countries.wsdl");


        CountriesPortService employee_Service = new CountriesPortService(url);
        CountriesPort employeeServiceProxy = employee_Service.getCountriesPortSoap11();

        GetCountryRequest request = new GetCountryRequest();
        request.setName("United Kingdom");

        GetCountryResponse response = employeeServiceProxy.getCountry(request);

        Currency currency = response.getCountry().getCurrency();
        String capital = response.getCountry().getCapital();
        int population = response.getCountry().getPopulation();


        System.out.println(""+currency);
        System.out.println(""+capital);
        System.out.println(""+population);

        return null;
    }

}

