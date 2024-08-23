import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import MovieCard from './MovieCard';
import { Link } from 'react-router-dom';

function MoviesHomePage() {
  const [selectedTab, setSelectedTab] = useState('tab1');

  //fetch data from API
    const [movies, setMovies] = useState([]);
    useEffect(() => {
        axios.get('/movies/movies-with-showtimes')
      .then(response => setMovies(response.data))
      .catch(error => console.error(error));
    }, []);

    const [movies2, setMovies2] = useState([]);
    useEffect(() => {
        axios.get('/movies/movies-without-showtimes')
      .then(response => setMovies2(response.data))
      .catch(error => console.error(error));
    }, []);

  return (
    <div className='mt-10 '>
      <div className="flex items-center justify-center gap-4">
        <span className='text-2xl border-l-4 border-orange-300 pl-2 uppercase'>
            Phim
        </span>
        <button 
          className={`p-4 ${selectedTab === 'tab1' ? 'bg-orange-400 text-white rounded-lg' : ''}`} 
          onClick={() => setSelectedTab('tab1')}
        >
          Đang chiếu
        </button>
        <button 
          className={`p-4 ${selectedTab === 'tab2' ? 'bg-orange-400 text-white rounded-lg' : ''}`} 
          onClick={() => setSelectedTab('tab2')}
        >
          Sắp chiếu
        </button>
      </div>
      {selectedTab === 'tab1' && <div className='grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4'>
        {movies.slice(0, 8).map((movie, index) => <MovieCard key={index} movie={movie} />)}
        </div>}
      {selectedTab === 'tab2' && <div className='grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4'>
        {movies2.slice(0, 8).map((movie, index) => <MovieCard key={index} movie={movie} />)}
        </div>}
      <div className="flex justify-center mt-4">
        <Link to={`/currentMovies`} state={{movies: selectedTab === 'tab1' ? movies : movies2, title: selectedTab === 'tab1' ? 'Phim đang chiếu' : 'Phim sắp chiếu'}} className="mb-2">
            <button className="bg-orange-400 text-white px-4 py-2 rounded-lg">Xem tất cả</button>
        </Link>
      </div>
    </div>
  );
}

export default MoviesHomePage;