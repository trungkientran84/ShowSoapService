/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttkien.service;

import com.ttkien.controller.ShowsJpaController;
import com.ttkien.entity.Shows;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kimmy
 */
@WebService(serviceName = "ShowsSoapService")
@HandlerChain(file = "ShowsSoapService_handler.xml")
public class ShowsSoapService {

    @WebMethod(operationName = "createShow")
    public void createShow(String type, String title, String description, BigInteger year, BigInteger duration,
            String genres, String director, String writer, String cast, byte[] thumbnail) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Show_Persistence_Unit");
        ShowsJpaController showRepo = new ShowsJpaController(emf);
        Shows show = new Shows();
        
        show.setTitle(title);
        show.setType(type);
        show.setDescription(description);
        show.setYear(year);
        show.setDuration(duration);
        show.setGenres(genres);
        show.setDirector(director);
        show.setWriter(writer);
        show.setCast(cast);
        show.setThumbnail(thumbnail);

        showRepo.create(show);

    }

    @WebMethod(operationName = "updateShow")
    public void updateShow(BigDecimal id, String type, String title, String description, BigInteger year, BigInteger duration,
            String genres, String director, String writer, String cast, byte[] thumbnail) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Show_Persistence_Unit");
        ShowsJpaController showRepo = new ShowsJpaController(emf);

        Shows show = showRepo.findShows(id);

        show.setType(type);
        show.setTitle(title);
        show.setDescription(description);
        show.setYear(year);
        show.setDuration(duration);
        show.setGenres(genres);
        show.setDirector(director);
        show.setWriter(writer);
        show.setCast(cast);
        if (thumbnail != null) {
            show.setThumbnail(thumbnail);
        }

        showRepo.edit(show);

    }

    @WebMethod(operationName = "getShows")
    public List<Shows> getShows() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Show_Persistence_Unit");
        ShowsJpaController showRepo = new ShowsJpaController(emf);

        return showRepo.findShowsEntities();
    }
    
    @WebMethod(operationName = "getShow")
    public Shows getShow(BigDecimal id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Show_Persistence_Unit");
        ShowsJpaController showRepo = new ShowsJpaController(emf);
        return showRepo.findShows(id);
    }

    @WebMethod(operationName = "deleteShow")
    public void deleteShows(@WebParam(name = "showid") BigDecimal id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Show_Persistence_Unit");
        ShowsJpaController showRepo = new ShowsJpaController(emf);

        showRepo.destroy(id);
    }

}
