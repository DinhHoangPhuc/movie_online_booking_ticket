package com.online_booking_ticket.movie_online_booking_ticket.services;

import com.online_booking_ticket.movie_online_booking_ticket.dto.MovieRequest;
import com.online_booking_ticket.movie_online_booking_ticket.dto.MovieResponse;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Actor;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Director;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Genre;
import com.online_booking_ticket.movie_online_booking_ticket.mapper.MovieMapper;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.ActorRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.DirectorRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.GenreRepo;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.online_booking_ticket.movie_online_booking_ticket.entities.Movie;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MovieRepo movieRepo;

    @Autowired
    DirectorRepo directorRepo;

    @Autowired
    ActorRepo actorRepo;

    @Autowired
    GenreRepo genreRepo;

    @Autowired
    private MovieMapper movieMapper;

    public List<MovieResponse> getMovies() {
        List<Movie> movies = movieRepo.findAll();
        List<MovieResponse> movieResponses = movies.stream()
                .map(movieMapper::movieToMovieResponse)
                .toList();
        return movieResponses;
    }
//
//    // public ResponseEntity<Page<Movie>> getMoviesWithShowTimes(int page, int size) {
//    //     try {
//    //         Pageable pageable = PageRequest.of(page, size);
//    //         return new ResponseEntity<Page<Movie>>(movieRepo.findAllWithShowTimes(pageable), HttpStatus.OK);
//    //     } catch (Exception e) {
//    //         e.printStackTrace();
//    //         // return "Error occurred: " + e.getMessage();
//    //         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    //     }
//    // }
//
//    public ResponseEntity<List<MovieWithShowtime>> getMoviesWithShowTimes() {
//        try {
//            return new ResponseEntity<List<MovieWithShowtime>>(movieRepo.findAllWithShowTimes(), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // return "Error occurred: " + e.getMessage();
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    public ResponseEntity<List<MovieWithShowtime>> getMoviesWithoutShowtimes() {
//        try {
//            return new ResponseEntity<List<MovieWithShowtime>>(movieRepo.findAllWithoutShowtimes(), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // return "Error occurred: " + e.getMessage();
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    public ResponseEntity<MovieById> getMovieById(int id) {
//        try {
//            Movie movie = movieRepo.findById(id).get();
//            List<Actor> actors = movie.getActors()
//                    .stream()
//                    .map(actorId -> actorRepo.findById(actorId).get())
//                    .collect(Collectors.toList());
//            List<Genre> genres = movie.getGenres()
//                    .stream()
//                    .map(genreId -> genreRepo.findById(genreId).get())
//                    .collect(Collectors.toList());
//            MovieById movieById = new MovieById(
//                    movie.getId(),
//                    movie.getTitle(),
//                    movie.getDuration(),
//                    movie.getReleaseDate(),
//                    movie.getRating(),
//                    movie.getDescription(),
//                    movie.getPosterURL(),
//                    movie.getTrailerURL(),
//                    movie.getDirectorID(),
//                    movie.getCountryID(),
//                    movie.getShowtimes(),
//                    genres,
//                    actors
//            );
//            return new ResponseEntity<MovieById>(movieById, HttpStatus.OK);
////            return new ResponseEntity<Movie>(movieRepo.findById(id).get(), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // return "Error occurred: " + e.getMessage();
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    public ResponseEntity<Director> getDirectorByMovieId(int movieId) {
//        try {
//            return new ResponseEntity<Director>(directorRepo.findItemByMovieID(movieId).orElse(null), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // return "Error occurred: " + e.getMessage();
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }

    @Transactional
    public boolean deleteMovie(String id) {
        Movie movie = movieRepo.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));

        // Remove movie ID from Director
        Director director = directorRepo.findById(movie.getDirectorID()).orElseThrow(() -> new RuntimeException("Director not found"));
        director.getMovieIDs().remove(movie.getId());
        directorRepo.save(director);

        // Remove movie ID from Actors
        for (String actorID : movie.getActorIDs()) {
            Actor actor = actorRepo.findById(actorID).orElseThrow(() -> new RuntimeException("Actor not found"));
            actor.getMovieIDs().remove(movie.getId());
            actorRepo.save(actor);
        }

        // Remove movie ID from Genre
        Genre genre = genreRepo.findById(movie.getGenreID()).orElseThrow(() -> new RuntimeException("Genre not found"));
        genre.getMovieIDs().remove(movie.getId());
        genreRepo.save(genre);

        movieRepo.deleteById(id);
        return true;
    }

    @Transactional
    public MovieResponse addMovie(MovieRequest movieRequest) {
        // Convert MovieRequest to Movie entity
        Movie movie = movieMapper.movieRequestToMovie(movieRequest);

        // Save the movie entity
        Movie savedMovie = movieRepo.save(movie);

        // Add movie ID to Director
        Director director = directorRepo.findById(movie.getDirectorID()).orElseThrow(() -> new RuntimeException("Director not found"));
        director.getMovieIDs().add(savedMovie.getId());
        directorRepo.save(director);

        // Add movie ID to Actors
        for (String actorID : movie.getActorIDs()) {
            Actor actor = actorRepo.findById(actorID).orElseThrow(() -> new RuntimeException("Actor not found"));
            actor.getMovieIDs().add(savedMovie.getId());
            actorRepo.save(actor);
        }

        // Add movie ID to Genre
        Genre genre = genreRepo.findById(movie.getGenreID()).orElseThrow(() -> new RuntimeException("Genre not found"));
        genre.getMovieIDs().add(savedMovie.getId());
        genreRepo.save(genre);

        // Convert saved Movie entity to MovieResponse
        return movieMapper.movieToMovieResponse(savedMovie);
    }

    @Transactional
    public MovieResponse updateMovie(String id, MovieRequest movieRequest) {
        Movie movie = movieRepo.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));

        Movie oldMovie = new Movie();
        oldMovie.setId(movie.getId());
        oldMovie.setDirectorID(movie.getDirectorID());
        oldMovie.setActorIDs(new ArrayList<>(movie.getActorIDs()));
        oldMovie.setGenreID(movie.getGenreID());

        // Update movie properties
        movie.setTitle(movieRequest.getTitle());
        movie.setDirectorID(movieRequest.getDirectorID());
        movie.setActorIDs(movieRequest.getActorIDs());
        movie.setGenreID(movieRequest.getGenreID());
        movie.setDuration(movieRequest.getDuration());
        movie.setReleaseDate(movieRequest.getReleaseDate());
        movie.setDescription(movieRequest.getDescription());
        movie.setPosterURL(movieRequest.getPosterURL());
        movie.setTrailerURL(movieRequest.getTrailerURL());
        movie.setCountryID(movieRequest.getCountryID());

        // Save the updated movie
        Movie updatedMovie = movieRepo.save(movie);

        // Split the reference update into separate transactions
        removeOldReferences(updatedMovie, oldMovie);  // Remove old references
        addNewReferences(updatedMovie);  // Add new references

        return movieMapper.movieToMovieResponse(updatedMovie);
    }

//    @Transactional
    public void removeOldReferences(Movie newMovie, Movie oldMovie) {
        if (oldMovie != null) {
            // Remove old Director reference
            if (!newMovie.getDirectorID().equals(oldMovie.getDirectorID())) {
                Query oldDirectorQuery = new Query(Criteria.where("_id").is(oldMovie.getDirectorID()));
                Update removeOldDirectorUpdate = new Update().pull("MovieIDs", oldMovie.getId());
                mongoTemplate.updateFirst(oldDirectorQuery, removeOldDirectorUpdate, Director.class);
            }

            // Remove old Actor references
            for (String oldActorID : oldMovie.getActorIDs()) {
                if (!newMovie.getActorIDs().contains(oldActorID)) {
                    Query oldActorQuery = new Query(Criteria.where("_id").is(oldActorID));
                    Update removeOldActorUpdate = new Update().pull("MovieIDs", oldMovie.getId());
                    mongoTemplate.updateFirst(oldActorQuery, removeOldActorUpdate, Actor.class);
                }
            }

            // Remove old Genre reference
            if (!newMovie.getGenreID().equals(oldMovie.getGenreID())) {
                Query oldGenreQuery = new Query(Criteria.where("_id").is(oldMovie.getGenreID()));
                Update removeOldGenreUpdate = new Update().pull("MovieIDs", oldMovie.getId());
                mongoTemplate.updateFirst(oldGenreQuery, removeOldGenreUpdate, Genre.class);
            }
        }
    }

//    @Transactional
    public void addNewReferences(Movie newMovie) {
        // Add new Director reference
        Query newDirectorQuery = new Query(Criteria.where("_id").is(newMovie.getDirectorID()));
        Update addNewDirectorUpdate = new Update().addToSet("MovieIDs", newMovie.getId());
        mongoTemplate.updateFirst(newDirectorQuery, addNewDirectorUpdate, Director.class);

        // Add new Actor references
        for (String newActorID : newMovie.getActorIDs()) {
            Query newActorQuery = new Query(Criteria.where("_id").is(newActorID));
            Update addNewActorUpdate = new Update().addToSet("MovieIDs", newMovie.getId());
            mongoTemplate.updateFirst(newActorQuery, addNewActorUpdate, Actor.class);
        }

        // Add new Genre reference
        Query newGenreQuery = new Query(Criteria.where("_id").is(newMovie.getGenreID()));
        Update addNewGenreUpdate = new Update().addToSet("MovieIDs", newMovie.getId());
        mongoTemplate.updateFirst(newGenreQuery, addNewGenreUpdate, Genre.class);
    }


//    public void updateReferences(Movie newMovie, Movie oldMovie) {
//        if (oldMovie != null) {
//            // Remove old references
//            Director oldDirector = directorRepo.findById(oldMovie.getDirectorID()).orElseThrow(() -> new RuntimeException("Old Director not found"));
//            oldDirector.getMovieIDs().remove(oldMovie.getId());
//            directorRepo.save(oldDirector);
//
//            for (String actorID : oldMovie.getActorIDs()) {
//                Actor oldActor = actorRepo.findById(actorID).orElseThrow(() -> new RuntimeException("Old Actor not found"));
//                oldActor.getMovieIDs().remove(oldMovie.getId());
//                actorRepo.save(oldActor);
//            }
//
//            Genre oldGenre = genreRepo.findById(oldMovie.getGenreID()).orElseThrow(() -> new RuntimeException("Old Genre not found"));
//            oldGenre.getMovieIDs().remove(oldMovie.getId());
//            genreRepo.save(oldGenre);
//        }
//
//        // Add new references
//        Director newDirector = directorRepo.findById(newMovie.getDirectorID()).orElseThrow(() -> new RuntimeException("New Director not found"));
//        newDirector.getMovieIDs().add(newMovie.getId());
//        directorRepo.save(newDirector);
//
//        for (String actorID : newMovie.getActorIDs()) {
//            Actor newActor = actorRepo.findById(actorID).orElseThrow(() -> new RuntimeException("New Actor not found"));
//            newActor.getMovieIDs().add(newMovie.getId());
//            actorRepo.save(newActor);
//        }
//
//        Genre newGenre = genreRepo.findById(newMovie.getGenreID()).orElseThrow(() -> new RuntimeException("New Genre not found"));
//        newGenre.getMovieIDs().add(newMovie.getId());
//        genreRepo.save(newGenre);
//    }


//    public ResponseEntity<Movie> updateMovie(Movie movie) {
//        try {
//            return new ResponseEntity<Movie>(movieRepo.save(movie), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // return "Error occurred: " + e.getMessage();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    public ResponseEntity<String> deleteMovie(int id) {
//        try {
//            movieRepo.deleteById(id);
//            return new ResponseEntity<String>("Movie deleted successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // return "Error occurred: " + e.getMessage();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
