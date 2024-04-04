package com.camunda.bpm.camunda_bpm.delegate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class SaveContratDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // Récupérer la valeur du client du formulaire
        String client = (String) execution.getVariable("client");
    	//String client = "Manel";
        System.out.println(client);
        //Double montant = 10.2;
        Double montant = (Double) execution.getVariable("montant");
        System.out.println(montant);
        
        


        

        // Créer une connexion à la base de données
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcamunda", "root", "Bd2023@.");
        System.out.println("connection done");
        // Préparer une requête SQL pour enregistrer le contrat dans la base de données
        PreparedStatement statement = connection.prepareStatement("INSERT INTO contrat (client, montant) VALUES (?, ?)");
        System.out.println("Insert done");
        statement.setString(1, client);
        statement.setDouble(2, montant);
        statement.executeUpdate();

        // Fermer la connexion à la base de données
        statement.close();
        connection.close();
        System.out.println("Fermeture done");

    }
}
