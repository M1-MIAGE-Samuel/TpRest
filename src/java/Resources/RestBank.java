/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import Resources.ListClients;
import Resources.Client;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.core.MediaType;


@Path("Mypath")
    public class RestBank {
    
    /*
    Client c1 = new Client("Thomas", "Barbier");
    Client c2 = new Client("Maxime", "Guenego");
    Client c3 = new Client("Kervarec", "Samuel");
    Client c4 = new Client("Coco", "Rocky");*/
    private static ListClients liste = new ListClients();
    
    
    
@PUT
@Path("CreerListe")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
    public void CreerListe() {
        Client cl1 = new Client();
        cl1.setNom("Barbier");
        cl1.setPrenom("Thomas");
        Client cl2 = new Client();
        cl2.setNom("Kervarec");
        cl2.setPrenom("Samuel");
        Client cl3 = new Client();
        cl3.setNom("Guenego");
        cl3.setPrenom("Maxime");
        liste.ajouterClientDansListe(cl1);
        liste.ajouterClientDansListe(cl2);
        liste.ajouterClientDansListe(cl3);        
    }
    
    
@POST
@Path("AjoutClient")
@Consumes(MediaType.APPLICATION_XML)
    public void AjoutClient(@PathParam("nom") String nom, @PathParam("prenom") String prenom){
        Client cl = new Client();
        cl.setNom(nom);
        cl.setPrenom(prenom);
        liste.ajouterClientDansListe(cl);
    }
   
    
@POST
@Path("ModifierClient")
@Consumes(MediaType.APPLICATION_XML)
    public void modifierClient(@PathParam("nom") String nom, @PathParam("prenom") String prenom){
        Client cl = new Client();
        cl.setNom(nom);
        cl.setPrenom(prenom);
        liste.modifierClient(0, cl);
    }
    
    
@GET
@Path("ListeClients")
@Produces(MediaType.APPLICATION_XML)
    public ArrayList<Client> ListeClients(){
        return this.liste.consulterListeClient();
    }
    
@GET
@Path("/User/{id}")
@Produces(MediaType.APPLICATION_XML)
    public Client getClient(@PathParam("id") String id){
        return this.liste.consulterClient(id);
    }

    
@DELETE
@Path("Suppression")
@Consumes(MediaType.APPLICATION_XML)
    public void delete(@PathParam("id") int id){
        this.liste.supprimerClient(id);
}
}
