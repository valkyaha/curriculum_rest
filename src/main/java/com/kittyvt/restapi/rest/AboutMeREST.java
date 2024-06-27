package com.kittyvt.restapi.rest;

import com.kittyvt.restapi.domain.dto.AboutMeDTO;
import com.kittyvt.restapi.service.services.AboutMeService;
import com.kittyvt.restapi.utils.ResponseEntityBuilderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AboutMeREST {

    private final AboutMeService aboutMeService;

    public AboutMeREST(AboutMeService aboutMeService) {
        this.aboutMeService = aboutMeService;
    }

    @GetMapping("/about/{lang}")
    public ResponseEntity<Object> getAbout(@PathVariable String lang) {

        try {
            Optional<AboutMeDTO> record = aboutMeService.getAboutMe(lang);
            if (record.isPresent()) {
                return new ResponseEntityBuilderResponse<>().setStatus(HttpStatus.OK).setResponse(record).setMessage("Todo ok").build();
            } else {
                return new ResponseEntityBuilderResponse<>().setStatus(HttpStatus.BAD_REQUEST).setError("No hay").setMessage("Todo ok").build();
            }
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>().setStatus(HttpStatus.INTERNAL_SERVER_ERROR).setError("Peto el server").setMessage("Todo ok").build();
        }
    }

    @PostMapping("/about")
    public ResponseEntity<Object> postAbout(@RequestBody AboutMeDTO record) {

        try {
            aboutMeService.postAboutMe(record);

            return new ResponseEntityBuilderResponse<>().setStatus(HttpStatus.OK).setMessage("Todo ok").build();
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>().setStatus(HttpStatus.INTERNAL_SERVER_ERROR).setError("Peto el server").setMessage("Todo ok").build();
        }
    }

    @DeleteMapping("/about")
    public ResponseEntity<Object> deleteAbout(@RequestBody AboutMeDTO record) {

        try {
            aboutMeService.deleteAboutMe(record);

            return new ResponseEntityBuilderResponse<>().setStatus(HttpStatus.OK).setMessage("Todo ok").build();
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>().setStatus(HttpStatus.INTERNAL_SERVER_ERROR).setError("Peto el server").setMessage("Todo ok").build();
        }
    }

    @PutMapping("/about/{lang}")
    public ResponseEntity<Object> getAbout(@PathVariable String lang, @RequestBody AboutMeDTO aboutMeDTO) {

        try {
            aboutMeService.putAboutMe(lang, aboutMeDTO);
            return new ResponseEntityBuilderResponse<>().setStatus(HttpStatus.OK).setResponse("done").setMessage("Todo ok").build();
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>().setStatus(HttpStatus.INTERNAL_SERVER_ERROR).setError("Peto el server").setMessage("Todo ok").build();
        }
    }
}