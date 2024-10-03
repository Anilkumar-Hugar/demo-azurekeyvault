package com.getazurekeys;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@RestController
@RequestMapping("/dbDetails")
public class Controller {

    String url="https://clientsecretvalues.vault.azure.net/";
    List<String> list=new ArrayList<>();
    public DBDetails dbDetails;

    @GetMapping("/get")
    public Object getDBDetailsFromAzure(){

        // Create the SecretClient using the credential
        SecretClient secretClient = new SecretClientBuilder()
                .vaultUrl(url)
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();

        // Retrieve a secret from Azure Key Vault (replace "your-secret-name" with your actual secret name)
        String secretName = "dblocalhost";
        String secretValue = secretClient.getSecret(secretName).getValue();

        StringTokenizer stringTokenizer=new StringTokenizer(secretValue,"&");
        System.out.println("Retrieved secret: " + secretValue);

       // list=new ArrayList<>();
       while(stringTokenizer.hasMoreTokens()){
           list.add(stringTokenizer.nextToken());
       }
       buildDbDetails(list);

       return secretValue;
    }

    private DBDetails buildDbDetails(List<String> list){
         dbDetails=new DBDetails(list.get(0),list.get(1),list.get(2));
        return dbDetails;
    }

}
