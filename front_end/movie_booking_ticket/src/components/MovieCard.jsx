/* eslint-disable react/prop-types */
import { useState } from "react";
import { Link } from "react-router-dom";
import TrailerModal from './TrailerModal';

function extractVideoID(url) {
  return url.split("v=")[1];
}

function MovieCard({ movie }) {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const trailerEmbedUrl = `https://www.youtube.com/embed/${extractVideoID(movie.trailerURL)}`;

  return (
    <div className="flex flex-col items-center p-4">
      <div className="relative group w-64 h-96">
        <img
          src={movie.posterURL}
          alt={movie.title}
          className="rounded-lg w-full h-full object-cover"
        />
        <div className="absolute inset-0 flex flex-col items-center justify-center bg-black bg-opacity-40 text-white opacity-0 group-hover:opacity-100 transition-opacity duration-300 rounded-lg">
          <Link to={`/movies/${movie.id}`} className="mb-2">
            <button className="bg-orange-500 hover:bg-orange-400 text-white px-4 py-2 rounded-lg">Mua vé</button>
          </Link>
          <button
            onClick={() => setIsModalOpen(true)}
            className="bg-transparent border-neutral-200 border-2 hover:bg-orange-300 text-white px-4 py-2 rounded-lg"
          >
            Xem Trailer
          </button>
        </div>
      </div>
      <h3 className="text-center mt-2">{movie.title}</h3>
      {isModalOpen && (
        <TrailerModal
          isOpen={isModalOpen}
          onRequestClose={() => setIsModalOpen(false)}
          trailerUrl={trailerEmbedUrl}
        />
      )}
    </div>
  );
}

export default MovieCard;
