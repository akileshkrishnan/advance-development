// import React from 'react'
import { Link } from 'react-router-dom'
import img1 from '../assets/images/yogalogo.gif'
import '../assets/css/Navbar.css'

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg ftco_navbar ftco-navbar-light navbar-light bg-light sticky-top">
      <div className="container">
        <Link className="navbar-brand" to="/">
          <img
            src={img1}
            style={{ height: '50px', width: '50px' }}
            alt=""
            className="img-fluid rounded-5"
          />{' '}
           ZenVibes
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#ftco-nav"
          aria-controls="ftco-nav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="fa fa-bars" /> Menu
        </button>
        <div
          className="collapse navbar-collapse justify-content-end"
          id="ftco-nav"
        >
          <ul className="navbar-nav ml-auto mr-md-3">
            <li className="nav-item">
              <Link to="/home" className="nav-link">
                Home
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/classes" className="nav-link">
                Classes
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/poses" className="nav-link">
                Schedule
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/community" className="nav-link">
                About
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/aboutus" className="nav-link">
               Blog
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/contact" className="nav-link">
                Contact
              </Link>
            </li>&ensp;
            <li className="nav-item">
              <Link to="/login" className="btn btn-outline-success">
                Login
              </Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  )
}

export default Navbar
