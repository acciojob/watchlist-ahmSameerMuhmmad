package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String,Movie>movieMap;
    private HashMap<String,Director>directorMap;
    private HashMap<String, List<String>>directorMovieMap;

    public MovieRepository() {
        this.movieMap=new HashMap<String,Movie>();
        this.directorMap=new HashMap<String,Director>();
        this.directorMovieMap=new HashMap<String,List<String>>();
    }

    public String addMovie(Movie movie){
        movieMap.put(movie.getName(),movie);
        return "successfully added movie";
    }
    public String addDirector(Director director){
        directorMap.put(director.getName(), director);
        return "successfully added director";
    }
    public String addMovieDirectorPair(String movieName,String directorName){
        if(!movieMap.containsKey(movieName)|| !directorMap.containsKey(directorName)){
            return "Movie or Director is not found in database";
        }
        if(directorMovieMap.containsKey(directorName)){
            directorMovieMap.get(directorName).add(movieName);
        }
        else{
            List<String>ans=new ArrayList<>();
            ans.add(movieName);
            directorMovieMap.put(directorName,ans);
        }
        return "Movie-Director Pair Added successfully.";

    }

    public Movie getMovieByName(String name){
        if(!movieMap.containsKey(name)) return null;
        return movieMap.get(name);
    }

    public Director getDirectorByName(String name){
        if(!directorMap.containsKey(name)) return null;
        return directorMap.get(name);
    }

    public List<String> getMovieByDirectorName(String directorName){
        return directorMovieMap.get(directorName);
    }

    public List<String> findAllMovies(){
        List<String>ans=new ArrayList<>();
        for(String movieName:movieMap.keySet()){
            ans.add(movieName);
        }
        return ans;
    }

    // 8 Delete a director and its Movie from the records
    public String deleteDirectorByName(String directorName){
        List<String>movies=directorMovieMap.get(directorName);
        for(int i=0; i<movies.size(); i++){
            if(movieMap.containsKey(movies.get(i))){
                movieMap.remove(movies.get(i));
            }
        }
        directorMovieMap.remove(directorName);
        if(directorMap.containsKey(directorName)){
            directorMap.remove(directorName);
        }
        return "Director and its movies removed successfully";

    }

    public String deleteAllDirectors(){
        for(String dir:directorMovieMap.keySet()){
            List<String>list=directorMovieMap.get(dir);
            for(String name:list){
                if(movieMap.containsKey(name)){
                    movieMap.remove(name);
                }
            }
            directorMap.remove(dir);
        }

        for(String d: directorMap.keySet()){
            directorMap.remove(d);
        }
        return "All directors and all of their movies removed successfully";


    }
}

