package com.kittyvt.restapi.rest;

import com.kittyvt.restapi.domain.dto.AboutMeRecord;
import com.kittyvt.restapi.service.services.AboutMeService;
import com.kittyvt.restapi.utils.ResponseEntityBuilderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
            Optional<AboutMeRecord> record = aboutMeService.getAboutMe(lang);
            if (record.isPresent()) {
                return new ResponseEntityBuilderResponse<>().setStatus(HttpStatus.OK).setResponse(record).setMessage("Todo ok").build();
            } else {
                return new ResponseEntityBuilderResponse<>().setStatus(HttpStatus.BAD_REQUEST).setError("No hay").setMessage("Todo ok").build();
            }
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>().setStatus(HttpStatus.INTERNAL_SERVER_ERROR).setError("Peto el server").setMessage("Todo ok").build();
        }
    }
}