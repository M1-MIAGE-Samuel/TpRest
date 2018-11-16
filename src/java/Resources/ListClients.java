/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author samue
 */
@XmlRootElement(name = "ListClients")
public class ListClients {
    
   
    private ArrayList<Client> liste = new ArrayList();
    
    public ListClients(){}

    public ArrayList<Client> getListe() {
        return liste;
    }

    public void setListe(ArrayList<Client> liste) {
        this.liste = liste;
    }

    
    public void ajouterClientDansListe(Client c){
        liste.add(c);
    }
    
    public void modifierClient(int indice, Client c){
        liste.set(indice, c);
    }
    
    public Client consulterClient(String index){
        int id = Integer.parseInt(index);
        return liste.get(id);
    }
    
    public ArrayList<Client> consulterListeClient(){
           return liste;
    }
    
    public void supprimerClient(int indice){
        liste.remove(indice);
    }
}
