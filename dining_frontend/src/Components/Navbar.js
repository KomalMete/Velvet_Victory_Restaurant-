import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from 'axios';
import { url } from "./URL/constant";
import "./Navbar.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSearch } from "@fortawesome/free-solid-svg-icons";

const Navbar =() =>{

    return(
        <div className="navbar-container">
            
            <div className="search-container">
                    <FontAwesomeIcon icon={faSearch} className="search-icon" />
                    <input className="search-box" placeholder = "Search for restaurant, cuisine, or a dish"></input>
            </div>
        </div>
        
    )
}
export default Navbar;