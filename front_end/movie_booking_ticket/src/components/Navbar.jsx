import { useContext } from "react";
import { AuthContext } from "../context/AuthContext";
import { FaAngleDown, FaUser } from 'react-icons/fa';
import { Link } from "react-router-dom";

function Navbar() {
  const { isLoggedIn, name, logout } = useContext(AuthContext);

  return (
    <div className="flex justify-between">
      <Link to="/">
        <img src="./logo.jpg" alt="Logo" width={"100px"} />
      </Link>
      <ul className="flex items-center">
        <li className="p-3">
          <img src="./logo_muave.webp" alt="Netflix Logo" width={"100px"} />
        </li>
        <li className="group py-3 px-5 relative">
          <div className="inline-flex items-center">
            <span>Phim</span>
            <FaAngleDown />
          </div>
          <ul className="absolute left-0 mt-2 space-y-2 bg-white text-black p-2 rounded-md hidden group-hover:block shadow z-10">
            <li className="py-3 px-5 border-y-2"><Link to="/currentMovies">Phim đang chiếu</Link></li>
            <li className="py-3 px-5 border-y-2"><Link to="">Phim sắp chiếu</Link></li>
          </ul>
        </li>
        <li className="p-3">
          <Link to="">Rạp</Link>
        </li>
      </ul>
      <div className="flex items-center">
        { isLoggedIn ? (
          <div className="flex items-center">
            <FaUser />
            <div className="group py-3 px-5 relative">
              <div className="inline-flex items-center">
                <span>{name}</span>
                <FaAngleDown />
              </div>
              <ul className="absolute left-0 mt-2 space-y-2 bg-white text-black p-2 rounded-md hidden group-hover:block shadow z-10">
                <li className="py-3 px-5 border-y-2"><Link to="/bookingHistory">Lịch sử đặt vé</Link></li>
              </ul>
            </div>
            <button onClick={logout} className="bg-orange-400 hover:bg-orange-700 text-white py-2 px-4 rounded">
              Đăng xuất
            </button>
          </div>
        ) : (
          <button className="bg-orange-400 hover:bg-orange-700 text-white py-2 px-4 rounded">
            <Link to="/login">Đăng nhập</Link>
          </button>
        )}
      </div>
    </div>
  );
}

export default Navbar;
