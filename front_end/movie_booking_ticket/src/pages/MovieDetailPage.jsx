import { useEffect, useState } from 'react';
import { useParams } from 'react-router';
import axios from 'axios';
import MovieCard from '../components/MovieCard';
import Showtimes from '../components/Showtime';

function MovieDetailPage() {
  const { id } = useParams();
  const [movie, setMovie] = useState();
  const [currentMovies, setCurrentMovies] = useState([]);

  useEffect(() => {
    axios.get(`/movies/${id}`)
      .then(response => setMovie(response.data))
      .catch(error => console.error(error));

    axios.get('/movies/movies-with-showtimes')
      .then(response => setCurrentMovies(response.data))
      .catch(error => console.error(error));
  }, [id]);

 
  if (!movie) {
    return <div className="flex justify-center items-center h-screen">Loading...</div>;
  }

  return (
    <div className="container mx-auto mt-10 p-6">
      <div className="grid sm:grid-cols-12 gap-12">
        <div className="sm:col-span-10">
          <div className="flex flex-col lg:flex-row items-start gap-8">
            <img 
              src={movie.posterURL} 
              alt={movie.title} 
              className="rounded-lg w-3/4 lg:w-1/3 h-auto object-cover mb-4" 
            />
            <div className="flex flex-col p-3 justify-start">
              <h1 className="text-start text-4xl font-bold mb-4">{movie.title}</h1>
              <h5 className="text-start text-xl mb-2"><strong>Năm:</strong> {new Date(movie.releaseDate).toLocaleDateString()}</h5>
              <div className="mb-4 flex">
                <h5 className="text-start text-xl mr-2"><strong>Thể loại:</strong></h5>
                {movie.genres.map((genre, index) => (
                  <span key={index} className="inline-block bg-orange-300 text-white text-sm font-semibold mr-2 mb-2 px-2 py-1 rounded">
                    {genre.name}
                  </span>
                ))}
              </div>
              <h5 className="text-start text-2xl font-semibold mb-4">Diễn viên</h5>
              <div className="grid grid-cols-2 sm:grid-cols-3 gap-4 mb-6">
                {movie.actors.map((actor, index) => (
                  <div key={index} className="flex flex-col items-center">
                    <img 
                      src={actor.picture} 
                      alt={actor.name} 
                      className="rounded-full w-24 h-24 object-cover mb-2" 
                    />
                    <p className="text-center text-gray-700">{actor.name}</p>
                  </div>
                ))}
              </div>
            </div>
          </div>

          <div>
            <p className="mt-5 mb-2 text-start text-2xl border-l-4 border-orange-300 pl-2">Nội dung</p>
            <p>{movie.description}</p>
            <p className="mt-5 mb-2 text-start text-2xl border-l-4 border-orange-300 pl-2">Lịch chiếu</p>
            <Showtimes movie={movie} />
          </div>
        </div>
        {/* Right Section: Current Movies */}
        <div className="sm:col-span-2">
          <h2 className="text-2xl font-bold mb-4">Phim đang chiếu</h2>
          <div className="grid grid-cols-1 gap-4">
            {currentMovies.map((movie, index) => (
              <MovieCard key={index} movie={movie} />
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}

export default MovieDetailPage;
