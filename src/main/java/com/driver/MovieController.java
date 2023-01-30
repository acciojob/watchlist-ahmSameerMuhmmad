package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String response=movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String response=movieService.addDirector(director);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie,@RequestParam("director") String director){
        String response=movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie>getMovieByName(@PathVariable("name") String name){
        Movie movie=movieService.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }



    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director>getDirectorByName(@PathVariable String name){
        Director director=movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMovieByDirectorName(@PathVariable String director){
        List<String>movies=movieService.getMovieByDirectorName(director);
        return new ResponseEntity<>(movies,HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies=movieService.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.FOUND);
    }


    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        String response=movieService.deleteDirectorByName(director);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String response=movieService.deleteAllDirectors();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
