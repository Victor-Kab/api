package io.studerd.api.web;

import io.studerd.api.entity.Cursus;
import io.studerd.api.entity.Planning;
import io.studerd.api.model.CursusModel;
import io.studerd.api.service.CursusService;
import io.studerd.api.service.PlanningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping(value = "/api")
@Api(value = "/api/cursus")
@CrossOrigin(value = "*")

public class CursusRestController {
    @Autowired
    private CursusService cursusService;
    @Autowired
    private PlanningService planningService;
    @PostMapping("/cursus/add")
    @ApiOperation(value = "creer un cursus", notes = "cette methode permet de creer un cursus",response = CursusModel.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet cursus cree avec succes"),
            @ApiResponse(code = 400, message = "L'objet cursus n'est pas valide")
    })

    void createCursus(@RequestBody CursusModel cursusModel){

        Cursus cursus = new Cursus();
        cursus.setTitle(cursusModel.getCursusTitle());
        cursus.setDescription(cursusModel.getCursusDescription());
        cursus.setPlanningList((Collection<Planning>) this.planningService.findOnePlanning(cursusModel.getCursus_id()));

        this.cursusService.createCursus(cursus);

    }
    @GetMapping("/cursus")
    @ApiOperation(value = "renvoie une liste des cursus", notes = "cette methode permet de chercher et renvoyer des cursus",response = Cursus.class)
    @ApiResponses(value= {
            @ApiResponse(code = 200, message = "La liste des cursus/ une liste vide")
    })
    List<Cursus> findAllCursus(){

        return this.cursusService.getcursus();
    }
    @GetMapping("/cursus/{uuid}")
    @ApiOperation(value = "rechercher un cursus", notes = "cette methode permet de chercher un cursus par son id",responseContainer = "List<Cursus>")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet cursus a ete trouve dans la base de donnees"),
            @ApiResponse(code=404, message = "Aucun cursus dans la BD avec l'id fourni")
    })
    Cursus getOneCursus(@PathVariable  UUID uuid){
        return this.cursusService.getOneCursus(uuid);
    }

    /*@PutMapping("/cursus/update")
    public ResponseEntity<Cursus>updateCursus(@RequestBody Cursus cursus){
        Cursus newcursus = cursusService.updateCursus(cursus);
        return new ResponseEntity<Cursus>(newcursus, HttpStatus.OK);}*/
    @PutMapping("/cursus/update")
    @ApiOperation(value = "La mise à jour d'un cursus", notes = "cette methode permet de mettre à jour  un cursus",response = CursusModel.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet cursus modifie avec succes"),
            @ApiResponse(code = 400, message = "L'objet cursus n'est pas valide")})

    void updateCursus(@RequestBody CursusModel cursusModel, @RequestBody UUID uuid){

        Cursus cursus = new Cursus();
        cursus.setTitle(cursusModel.getCursusTitle());
        cursus.setDescription(cursusModel.getCursusDescription());

        this.cursusService.updateCursus(cursus, uuid);

    }





    @DeleteMapping("cursus/delete/{uuid}")
    @ApiOperation(value = "supprimer un cursus", notes = "cette methode permet de supprimer un cursus par son id",response = Cursus.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet cursus a ete trouve dans la base de donnees")

    })
    void Delete(@PathVariable("uuid") UUID uuid) {
        this.cursusService.delete(uuid);

    }
    @GetMapping("/cursus/paging")

    public ResponseEntity<Map<String, Object>>findAllByPaging(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "2")int size){
        return new ResponseEntity<>(this.cursusService.findAllCursus(page, size), HttpStatus.OK);

    }



}
