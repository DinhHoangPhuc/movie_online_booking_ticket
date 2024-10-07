//package com.online_booking_ticket.movie_online_booking_ticket.mapper;
//
//import com.online_booking_ticket.movie_online_booking_ticket.dto.*;
//import com.online_booking_ticket.movie_online_booking_ticket.entities.*;
//import com.online_booking_ticket.movie_online_booking_ticket.repositories.ActorRepo;
//import com.online_booking_ticket.movie_online_booking_ticket.repositories.CountryRepo;
//import com.online_booking_ticket.movie_online_booking_ticket.repositories.DirectorRepo;
//import com.online_booking_ticket.movie_online_booking_ticket.repositories.GenreRepo;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mapstruct.factory.Mappers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//class MovieMapperTest {
//
//    @Mock
//    private DirectorRepo directorRepo;
//
//    @Mock
//    private ActorRepo actorRepo;
//
//    @Mock
//    private CountryRepo countryRepo;
//
//    @Mock
//    private GenreRepo genreRepo;
//
//    @Mock
//    private DirectorMapper directorMapper;
//
//    @Mock
//    private ActorMapper actorMapper;
//
//    @Mock
//    private CountryCountryRequestMapper countryMapper;
//
//    @Mock
//    private GenreGenreResponseMapper genreMapper;
//
//    @InjectMocks
//    private MovieMapper movieMapper = new MovieMapper();
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void movieRequestToMovie() {
//        // given
//        MovieRequest movieRequest = new MovieRequest();
//        movieRequest.setTitle("The Avengers");
//        movieRequest.setGenreID("Action");
//        movieRequest.setCountryID("USA");
//        movieRequest.setDescription("Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.");
//        movieRequest.setDuration(180);
//        movieRequest.setReleaseDate(LocalDate.of(2012, 5, 4));
//        movieRequest.setDirectorID("Joss Whedon");
//        movieRequest.setActorIDs(new ArrayList<>(Arrays.asList("Robert Downey Jr.", "Chris Evans", "Mark Ruffalo", "Chris Hemsworth", "Scarlett Johansson", "Jeremy Renner")));
//        movieRequest.setPosterURL("https://www.imdb.com/title/tt0848228/mediaviewer/rm10105600");
//        movieRequest.setTrailerURL("https://www.youtube.com/watch?v=eOrNdBpGMv8");
//
//        // when
//        Movie movie = movieMapper.movieRequestToMovie(movieRequest);
//
//        // then
//        assertNotNull(movie);
//        assertEquals(movieRequest.getTitle(), movie.getTitle());
//        assertEquals(movieRequest.getGenreID(), movie.getGenreID());
//        assertEquals(movieRequest.getCountryID(), movie.getCountryID());
//        assertEquals(movieRequest.getDescription(), movie.getDescription());
//        assertEquals(movieRequest.getDuration(), movie.getDuration());
//        assertEquals(movieRequest.getReleaseDate(), movie.getReleaseDate());
//        assertEquals(movieRequest.getDirectorID(), movie.getDirectorID());
//        assertEquals(movieRequest.getActorIDs(), movie.getActorIDs());
//        assertEquals(movieRequest.getPosterURL(), movie.getPosterURL());
//        assertEquals(movieRequest.getTrailerURL(), movie.getTrailerURL());
//    }
//
//    @Test
//    public void testMovieToMovieResponse() {
//        // given
//        Movie movie = new Movie();
//        movie.setId("1");
//        movie.setTitle("The Avengers");
//        movie.setGenreID("Action");
//        movie.setCountryID("USA");
//        movie.setDescription("Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.");
//        movie.setDuration(180);
//        movie.setReleaseDate(LocalDate.of(2012, 5, 4));
//        movie.setDirectorID("Joss Whedon");
//        movie.setActorIDs(new ArrayList<>(Arrays.asList("Robert Downey Jr.", "Chris Evans", "Mark Ruffalo", "Chris Hemsworth", "Scarlett Johansson", "Jeremy Renner")));
//        movie.setPosterURL("https://www.imdb.com/title/tt0848228/mediaviewer/rm10105600");
//        movie.setTrailerURL("https://www.youtube.com/watch?v=eOrNdBpGMv8");
//
//        Director director = new Director();
//        director.setId("Joss Whedon");
//        director.setName("Joss Whedon");
//
//        Actor actor1 = new Actor();
//        actor1.setId("Robert Downey Jr.");
//        actor1.setName("Robert Downey Jr.");
//
//        Actor actor2 = new Actor();
//        actor2.setId("Chris Evans");
//        actor2.setName("Chris Evans");
//
//        Country country = new Country();
//        country.setId("USA");
//        country.setName("USA");
//
//        Genre genre = new Genre();
//        genre.setId("Action");
//        genre.setName("Action");
//
//        DirectorResponse directorResponse = new DirectorResponse();
//        directorResponse.setId("Joss Whedon");
//        directorResponse.setName("Joss Whedon");
//
//        ActorResponse actorResponse1 = new ActorResponse();
//        actorResponse1.setId("Robert Downey Jr.");
//        actorResponse1.setName("Robert Downey Jr.");
//
//        ActorResponse actorResponse2 = new ActorResponse();
//        actorResponse2.setId("Chris Evans");
//        actorResponse2.setName("Chris Evans");
//
//        CountryResponse countryResponse = new CountryResponse();
//        countryResponse.setId("USA");
//        countryResponse.setName("USA");
//
//        GenreResponse genreResponse = new GenreResponse();
//        genreResponse.setId("Action");
//        genreResponse.setName("Action");
//
//        when(directorRepo.findById("Joss Whedon")).thenReturn(Optional.of(director));
//        when(directorMapper.directorToDirectorResponse(director)).thenReturn(directorResponse);
//
//        when(actorRepo.findById("Robert Downey Jr.")).thenReturn(Optional.of(actor1));
//        when(actorRepo.findById("Chris Evans")).thenReturn(Optional.of(actor2));
//        when(actorMapper.actorToActorResponse(actor1)).thenReturn(actorResponse1);
//        when(actorMapper.actorToActorResponse(actor2)).thenReturn(actorResponse2);
//
//        when(countryRepo.findById("USA")).thenReturn(Optional.of(country));
//        when(countryMapper.countryToCountryResponse(country)).thenReturn(countryResponse);
//
//        when(genreRepo.findById("Action")).thenReturn(Optional.of(genre));
//        when(genreMapper.genreToGenreResponse(genre)).thenReturn(genreResponse);
//
//        // when
//        MovieResponse movieResponse = movieMapper.movieToMovieResponse(movie);
//
//        // then
//        assertNotNull(movieResponse);
//        assertEquals(movie.getId(), movieResponse.getId());
//        assertEquals(movie.getTitle(), movieResponse.getTitle());
//        assertEquals(movie.getDescription(), movieResponse.getDescription());
//        assertEquals(movie.getDuration(), movieResponse.getDuration());
//        assertEquals(movie.getReleaseDate(), movieResponse.getReleaseDate());
//        assertEquals(movie.getPosterURL(), movieResponse.getPosterURL());
//        assertEquals(movie.getTrailerURL(), movieResponse.getTrailerURL());
//        assertEquals(directorResponse, movieResponse.getDirector());
//        assertEquals(Arrays.asList(actorResponse1, actorResponse2), movieResponse.getActors());
//        assertEquals(countryResponse, movieResponse.getCountry());
//        assertEquals(genreResponse, movieResponse.getGenre());
//    }
//
//}