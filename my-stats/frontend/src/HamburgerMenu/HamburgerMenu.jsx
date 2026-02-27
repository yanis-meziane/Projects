import { useState, useRef, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "./HamburgerMenu.css";

export default function HamburgerMenu() {
  const [isOpen, setIsOpen] = useState(false);
  const menuRef = useRef(null);
  const navigate = useNavigate();


  // Ferme le menu si on clique en dehors
  useEffect(() => {
    const handleClickOutside = (e) => {
      if (menuRef.current && !menuRef.current.contains(e.target)) {
        setIsOpen(false);
      }
    };
    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, []);

  const handleLogout = () => {
    localStorage.removeItem("type");
    localStorage.removeItem("userId");
    localStorage.removeItem("firstname");
    setIsOpen(false);
    navigate("/login");
  };

  return (
    <div ref={menuRef} className="hamburgerWrapper">
      {/* Bouton Hamburger */}
      <button
        onClick={() => setIsOpen((prev) => !prev)}
        aria-label="Menu"
        aria-expanded={isOpen}
        className="hamburgerBtn"
      >
        <span className="bar" />
        <span className="bar" />
        <span className="bar" />
      </button>

      {/* Menu déroulant */}
      {isOpen && (
        <div className="hamburgerDropdown">
          <button onClick={handleLogout} className="logoutBtn">
             Déconnexion
          </button>
        </div>
      )}
    </div>
  );
}