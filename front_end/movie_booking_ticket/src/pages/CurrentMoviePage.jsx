import { useLocation } from 'react-router-dom';
import MovieCard from '../components/MovieCard';

function CurrentMoviePage() {
  const location = useLocation();
  const {movies, title} = location.state;

  return (
    <div className='mt-10'>
      <h1 className='text-2xl text-center mb-4'>Phim đang chiếu</h1>
      <div className='grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-4'>
        {movies.map((movie, index) => (
          <MovieCard key={index} movie={movie} />
        ))}
      </div>
    </div>
  );
}

export default CurrentMoviePage;
