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

    public static final String TODO_OK = "Todo ok";
    private final AboutMeService aboutMeService;

    public AboutMeREST(AboutMeService aboutMeService) {
        this.aboutMeService = aboutMeService;
    }

    @GetMapping("/about/{lang}")
    public ResponseEntity<Object> getAbout(@PathVariable String lang) {

        try {
            Optional<AboutMeDTO> aboutMeRecord = aboutMeService.getAboutMe(lang);
            if (aboutMeRecord.isPresent()) {
                return new ResponseEntityBuilderResponse<>()
                        .setStatus(HttpStatus.OK)
                        .setResponse(aboutMeRecord)
                        .setMessage("Get the about me data")
                        .build();
            } else {
                return new ResponseEntityBuilderResponse<>()
                        .setStatus(HttpStatus.BAD_REQUEST)
                        .setError("No hay")
                        .setMessage(HttpStatus.OK.getReasonPhrase())
                        .build();
            }
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>()
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                    .setMessage("Server encountered an error")
                    .build();
        }
    }

    @PostMapping("/about")
    public ResponseEntity<Object> postAbout(@RequestBody AboutMeDTO aboutMeDTO) {

        try {
            aboutMeService.postAboutMe(aboutMeDTO);
            return new ResponseEntityBuilderResponse<>()
                    .setStatus(HttpStatus.OK)
                    .setMessage(TODO_OK)
                    .build();
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>()
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .setError("Error server")
                    .setMessage(TODO_OK)
                    .build();
        }
    }

    @DeleteMapping("/about")
    public ResponseEntity<Object> deleteAbout(@RequestBody AboutMeDTO aboutMeDTO) {

        try {
            aboutMeService.deleteAboutMe(aboutMeDTO);

            return new ResponseEntityBuilderResponse<>()
                    .setStatus(HttpStatus.OK)
                    .setMessage(TODO_OK)
                    .build();
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>()
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                    .setMessage(TODO_OK)
                    .build();
        }
    }

    @PutMapping("/about/{lang}")
    public ResponseEntity<Object> getAbout(@PathVariable String lang, @RequestBody AboutMeDTO aboutMeDTO) {

        try {
            aboutMeService.putAboutMe(lang, aboutMeDTO);
            return new ResponseEntityBuilderResponse<>()
                    .setStatus(HttpStatus.OK)
                    .setResponse("done")
                    .setMessage(TODO_OK)
                    .build();
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>()
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                    .setMessage(TODO_OK)
                    .build();
        }
    }
}