
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Like;
import co.edu.sena.adsi.jpa.sessions.LikeFacade;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author bratc
 */
@Path("likes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LikesREST {
    

    @EJB
    private LikeFacade likeEJB;
    
    /**
     * Obtiene todos los likes
     * @return lista de likes
     */
    @GET
    public List<Like> findAll(){
        return likeEJB.findAll();
    }

    /**
     * Busca likes por su id
     * @param id
     * @return like
     */
    @GET
    @Path("{id}")
    public Like findById(@PathParam("id") String id){
        return likeEJB.find(id);
    }
    
    /**
     * Crear un like
     * @param like 
     */
    @POST
    public void create(Like like){
        likeEJB.create(like);
    }
    
    /**
     * Edita un like
     * @param id
     * @param like 
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, Like like){
        likeEJB.edit(like);
    }
}
